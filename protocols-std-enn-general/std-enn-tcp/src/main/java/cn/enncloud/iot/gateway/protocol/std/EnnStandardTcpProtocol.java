package cn.enncloud.iot.gateway.protocol.std;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.protocol.std.energy.enums.AlarmDeviceTypeEnum;
import cn.enncloud.iot.gateway.protocol.std.energy.enums.CommandEnum;
import cn.enncloud.iot.gateway.protocol.std.energy.model.ModelInfoDto;
import cn.enncloud.iot.gateway.protocol.std.energy.model.ModelPhyAttributeDto;
import cn.enncloud.iot.gateway.protocol.std.energy.model.ProtocolDataField;
import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.UpPacket;
import cn.enncloud.iot.gateway.protocol.std.energy.msg.down.CommonResp;
import cn.enncloud.iot.gateway.protocol.std.energy.protocol.ByteBufToDataService;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.AESUtils;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.AnalysicUtils;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.Util;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.crypt.DataType;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class EnnStandardTcpProtocol extends AbstractProtocol {
    private final static String REGEX_FF = "^(F{2,})$";
    private final static String METRIC_U_BAT = "Ubat";
    private final static String METRIC_U_BAT_VALUE = "ffff";

    private final static String SEPARATOR = "-";

    private static volatile ByteBufToDataService byteBufToDataService;


    private static ByteBufToDataService getByteBufToDataService() {

        if (Objects.isNull(byteBufToDataService)) {
            synchronized (ByteBufToDataService.class) {
                if (Objects.isNull(byteBufToDataService)) {
                    byteBufToDataService = new ByteBufToDataService();
                }
            }
        }
        return byteBufToDataService;

    }

    @Override
    public String getId() {
        return "enn-standard-tcp";
    }

    @Override
    public String getName() {
        return "enn-standard-tcp";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        log.info("协议解析 >>> " + ByteBufUtil.hexDump(messageBytes));
        Message msg = parse(messageBytes);
        log.info("解析结果 <<< " + JSON.toJSONString(msg));
        return msg;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        log.info("协议解析 >>> " + ByteBufUtil.hexDump(messageBytes));
        Message msg = parse(messageBytes);
        log.info("解析结果 <<< " + JSON.toJSONString(msg));
        return Collections.singletonList(msg);
    }


    private Message parse(byte[] bytes) {
        Object dataPacket = null;
        try {
            dataPacket = getByteBufToDataService().byteBufToDataPacket(Unpooled.wrappedBuffer(bytes));
        } catch (Exception e) {
            throw new RuntimeException("数据解析异常", e);
        }
        UpPacket upPacket = null;
        if (dataPacket instanceof UpPacket) {
            upPacket = (UpPacket) dataPacket;
        } else {
            throw new RuntimeException("非上报数据" + JSON.toJSONString(dataPacket));
        }

        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap = this.sendData(upPacket);
        } catch (ParseException e) {
            throw new RuntimeException("上报数据解析异常", e);
        }

        List<Metric> metrics = new ArrayList<>();

        resultMap.forEach((k, v) -> {
            metrics.add(new Metric(System.currentTimeMillis(), k, v));
        });

        MetricReportRequest msg = new MetricReportRequest();
        msg.setMessageType(MessageType.DEVICE_REPORT_REQ);
        msg.setMetrics(metrics);
        msg.setTimeStamp(System.currentTimeMillis());

        CommonResp resp = CommonResp.success(upPacket);

//        String snPrefix = (String) getParams().get("snPrefix");
        String snPrefix = "ENN02DEV";
        String sn = snPrefix + resp.getHeader().getDeviceId();

        String deviceId = getDeviceContext().getDeviceIdBySn(null, sn);


        if (deviceId == null || deviceId.isEmpty()) {
            log.error("设备不存在,SN:{}", sn);
        }
        msg.setDeviceId(deviceId);
        ByteBuf buffer = Unpooled.buffer();
        try {
            this.encodeResp(resp, buffer);
        } catch (Exception e) {
            throw new RuntimeException("回复指令生成失败", e);
        }
        msg.setResponse(ByteBufUtil.hexDump(buffer));
        return msg;
    }


    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        if (message.getMessageType().equals(MessageType.DEVICE_REPORT_RSP)) {
            String response = message.getResponse();
            return ByteBufUtil.decodeHexDump(response);
        }
        return new byte[0];
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }


    public Map<String, Object> sendData(UpPacket dataPacket) throws ParseException {
        log.info("数据解析UpPacket:{}", dataPacket);
        Map<String, List<ModelPhyAttributeDto>> map = new HashMap<>();

        String dtuCode = dataPacket.getHeader().getDeviceId();
        log.info("dtuCode: {}", dtuCode);
        ModelInfoDto modelInfoDto;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            modelInfoDto = getModelInfoDto(dataPacket.getHeader().getDeviceType());
            if (null != modelInfoDto) {
                map = modelInfoDto.getModelMap();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        //根据 命令码 获取指定的指令字段
        if (!CollectionUtils.isEmpty(map)) {
            Optional<String> first = map.keySet().stream().filter(
                    t -> {
//                        log.debug("map key: {}", t);
                        //命名规则为 设备类型-指令码 例如: PWM-02H。如果指令为22H、23H 那么命名规则为 设备类型-指令码-数据类型 例如： YBZ-22H-01
                        if (t.contains(SEPARATOR)) {
                            String[] keySplit = t.split(SEPARATOR);
                            String cmdType = keySplit[1];
                            if (dataPacket.getHeader().getCmdType().equals(CommandEnum.HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || dataPacket.getHeader().getCmdType().equals(CommandEnum.CALL_HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode())) {
                                if (keySplit.length >= 3) {
                                    String dataType = keySplit[2];
                                    log.info("--> deviceId:{}, cmdType: {},dataPacket.getHeader().getCmdType():{}, dataType:{}, dataPacket.getData().substring(4, 6):{} ",
                                            dataPacket.getHeader().getDeviceId(), cmdType, dataPacket.getHeader().getCmdType(), dataType, dataPacket.getData().substring(4, 6));
                                    return cmdType.startsWith(dataPacket.getHeader().getCmdType()) && dataType.equals(dataPacket.getData().substring(4, 6));
                                }
                                return false;
                            } else if (CommandEnum.ALARM_DATA_UPLOAD_WITH_TYPE.getCommandCode().equals(dataPacket.getHeader().getCmdType())) {
                                if (keySplit.length >= 3) {
                                    String alarmType = keySplit[2];
                                    log.info("cmdType: IOT->{},上报报文->{} \r\n alarmType: IOT->{},上报报文->{}", cmdType, dataPacket.getHeader().getCmdType(), alarmType, dataPacket.getData().substring(18, 20));
                                    return cmdType.startsWith(dataPacket.getHeader().getCmdType()) && alarmType.equals(dataPacket.getData().substring(18, 20));
                                }
                            } else {
                                return cmdType.startsWith(dataPacket.getHeader().getCmdType());
                            }
                        }
                        return false;
                    }
            ).findFirst();

            if (first.isPresent()) {
                log.info("指令模型编码:{}", first.get());
                //根据页面配置的字段解析
                List<LinkedHashMap<String, Object>> mapList = getMap(map, dataPacket.getData(), dataPacket.getHeader().getCmdType(), first.get());
                log.info("设备ID:{},上报内容:{}", dtuCode, mapList);
                if (mapList != null) {
                    for (LinkedHashMap<String, Object> map1 : mapList) {
                        //                    String deviceId = AttributyKeyUtil.getDeviceIdForXinao(ctx);
                        String deviceId = dataPacket.getHeader().getDeviceId();
                        log.info("解析数据：deviceId:{},map:{},data:{}", deviceId, JSON.toJSONString(map1), dataPacket);
                        resultMap.putAll(map1);
                        //                    for (Map.Entry<String, Object> entry : map1.entrySet()) {
                        //                        log.debug("Key = " + entry.getKey() + ",value=" + entry.getValue());
                        //                    }
                        //                    if (!sendDataService.execute(() -> {
                        //                        kafkaSendService.sendKafka(dataPacket, ctx, map1, deviceId);
                        //                    })) {
                        //                        log.error("kafka发送数据任务执行失败，deviceId:{}", deviceId);
                        //                    }
                    }
                }
            } else {
                log.info("查询不到指令模型,dtu:{}", dataPacket.getHeader().getDeviceId());
            }

        }
        return resultMap;
    }

    private List<LinkedHashMap<String, Object>> getMap(Map<String, List<ModelPhyAttributeDto>> modelMap, String data, String cmdType, String modelName) throws ParseException {

        List<ModelPhyAttributeDto> list = modelMap.get(modelName);

        //根据序列排序
        list.sort(Comparator.comparingInt(ModelPhyAttributeDto::getIndex));

        List<LinkedHashMap<String, Object>> resultList = new ArrayList<>();
        int i = 1;
        if (cmdType.equals(CommandEnum.HISTORY_DATA_UPLOAD.getCommandCode()) || cmdType.equals(CommandEnum.ALARM_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || cmdType.equals(CommandEnum.HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || cmdType.equals(CommandEnum.CALL_HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || cmdType.equals(CommandEnum.CALL_HISTORY.getCommandCode())) {
            //12H历史上报中本次条数字段，模型中不配置
            i = Integer.parseInt(data.substring(0, 2), 16);
            data = data.substring(2);
        }
        //上报类型字段,模型中不配置
        data = data.substring(2);

        if (cmdType.equals(CommandEnum.HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || cmdType.equals(CommandEnum.CALL_HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode())) {
            data = data.substring(2);
        }
        for (int j = 0; j < i; j++) {
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();

            //01H专有逻辑。01H可能存在多条数据且报警代码可能不一样。如此，所匹配的模型就不一样。所以，根据报警代码来动态匹配模型
            if (j > 1 && cmdType.equals(CommandEnum.ALARM_DATA_UPLOAD_WITH_TYPE.getCommandCode())) {
                String finalData = data;
                Optional<String> first = modelMap.keySet().stream().filter(
                        t ->
                        {
                            //命名规则为 设备类型-指令码 例如: PWM-02H。如果指令为22H、23H 那么命名规则为 设备类型-指令码-数据类型 例如： YBZ-22H-01
                            if (t.contains(SEPARATOR)) {
                                String[] keySplit = t.split(SEPARATOR);
                                String modelCommandType = keySplit[1];
                                String alarmType = keySplit[2];
                                return modelCommandType.startsWith(cmdType) && alarmType.equals(finalData.substring(14, 16));
                            }
                            return false;
                        }
                ).findFirst();
                if (first.isPresent()) {
                    log.info("01H第{}条,模型编码:{}", j, first.get());
                    list = modelMap.get(first.get());
                    list.sort(Comparator.comparingInt(ModelPhyAttributeDto::getIndex));
                } else {
//                    throw new CommandException("01H，该报警类型不存在相对应的模型！报警代码:{0}", data.substring(12, 16));
                    log.warn("01H，该报警类型不存在相对应的模型！报警代码:{0},{}", data.substring(12, 16));
                }
            }

            for (int i1 = 0; i1 < list.size(); i1++) {
                String protocolDataType = list.get(i1).getProtocolDataType().getCode();
                if (StringUtils.isEmpty(protocolDataType)) {
//                    throw new DecodeException("protocolDataType 为空");
                    log.warn("protocolDataType 为空");
                    return null;
                }
                DataType dataType;
                try {
                    dataType = DataType.valueOf(protocolDataType);
                } catch (IllegalArgumentException e) {
//                    throw new DecodeException("ProtocolDataType不合法. 当前protocolDataType为: " + protocolDataType);
                    log.warn("ProtocolDataType不合法. 当前protocolDataType为: {}", protocolDataType);
                    return null;
                }
                ProtocolDataField protocolDataField = new ProtocolDataField(list.get(i1).getTargetPath(), dataType, list.get(i1).getByteLen());
                if (!DataType.valueOf(protocolDataType).equals(DataType.BIT)) {
                    log.info("{} {}", protocolDataField.getMetric(), protocolDataField.getLength());
                    data = putValue2DataMap(map, data, "BIG_ENDIAN".equals(list.get(i1).getByteOrder()) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN, protocolDataField);
                } else {
                    //取出一个字节
                    byte statusByte = Byte.parseByte(data.substring(0, 2), 16);
                    data = data.substring(2);
                    //循环取出8个采集点，分别与一个字节中的八位
                    for (int k = 0; k < 8; k++, i1++) {
                        if (!DataType.valueOf(list.get(i1).getProtocolDataType().getCode()).equals(DataType.BIT)) {
//                            throw new DecodeException("模型中采集点中有BIT位没有配置预留" + list.get(i1).getTargetPath() + "," + list.get(i1).getDepict());

                            log.warn("模型中采集点中有BIT位没有配置预留{},{}", list.get(i1).getTargetPath(), list.get(i1).getDepict());
                            return null;
                        }
                        map.put(list.get(i1).getTargetPath(), (statusByte & (int) Math.pow(2, k)) == (int) Math.pow(2, k) ? 1 : 0);
                    }
                    i1--;
                }
            }
            resultList.add(map);
        }
        return resultList;
    }

    public String putValue2DataMap(Map<String, Object> map, String data, ByteOrder bo, ProtocolDataField protocolDataField) throws ParseException {
//        log.debug("剩余:{}", data);
        int endIndex = protocolDataField.getLength();
        if (data.length() < endIndex * 2) {
//            throw new EnnException("数据报文解析长度错误，请检查模型配置！data=" + data + ", endIndex=" + protocolDataField.getLength() + "字节");
            log.warn("数据报文解析长度错误，请检查模型配置！data={}, endIndex={}字节", data, protocolDataField.getLength());
            return null;
        }
        String fieldData = data.substring(0, endIndex * 2);
        log.info("fieldData:{}", fieldData);
        if (METRIC_U_BAT.equals(protocolDataField.getMetric()) && METRIC_U_BAT_VALUE.equals(fieldData)) {
            map.put(protocolDataField.getMetric(), 220);
        } else {
            //填充FF的(极大值)处理
            if (!fieldData.matches(REGEX_FF)) {
                log.info("metric:{},data:{}", protocolDataField.getMetric(), fieldData);
                DataType.putValue2map(map, protocolDataField.getMetric(), protocolDataField.getType(), fieldData, bo);
            } else {
                map.put(protocolDataField.getMetric(), null);
            }
        }

        return data.substring(endIndex * 2);
    }


    private static final ConcurrentHashMap<Short, ModelInfoDto> MODEL_INFO_MAP = new ConcurrentHashMap<>();


    public ModelInfoDto getModelInfoDto(Short deviceType) {

        ModelInfoDto modelInfoDto = MODEL_INFO_MAP.get(deviceType);
        if (modelInfoDto == null) {

            ClassLoader classLoader = this.getClass().getClassLoader();

            AlarmDeviceTypeEnum alarmDeviceTypeEnum = AlarmDeviceTypeEnum.getAlarmDeviceTypeEnum(deviceType);
            if (Objects.isNull(alarmDeviceTypeEnum)) {
                log.warn("不支持的设备类型,默认为工商业报警器,deviceType：{}", deviceType);
                alarmDeviceTypeEnum = AlarmDeviceTypeEnum.GSY_ALARM;
            }
            String resourcePath = alarmDeviceTypeEnum.getModelFileName();
            InputStream inputStream = classLoader.getResourceAsStream(resourcePath);
            String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
            // log.info("模型获取：{},preData:{}", StringUtils.isNotBlank(read), read.substring(0, 100));
            modelInfoDto = JSONUtil.toBean(JSONUtil.parseObj(read), ModelInfoDto.class);


            MODEL_INFO_MAP.put(alarmDeviceTypeEnum.getDeviceType(), modelInfoDto);

        }

        return modelInfoDto;
    }


    protected void encodeResp(DataPacket msg, ByteBuf out) throws Exception {
        ByteBuf bb = msg.toByteBufMsg();
        try {
            //标记一下，先到前面去写覆盖的，然后回到标记替换加密数据域和校验码还有尾部
            bb.markWriterIndex();
            //覆盖占用的1个字节
            bb.writerIndex(11);
            int keyNum;
            if (msg.getHeader().getKeyNum() == 1 || msg.getHeader().getKeyNum() == 0) {
//                keyNum = 1;
                keyNum = msg.getHeader().getKeyNum();
            } else {
                keyNum = AESUtils.getKeyNum();
            }
            bb.writeByte(keyNum);
            bb.resetWriterIndex();
            //如果密钥号非0则加密数据域，替换数据域
            if (keyNum != 0) {
                ByteBufToDataService.getEncryptServiceInstance().encrypt(Util.getDeviceId(bb), keyNum, bb);
            }
            String cs = AnalysicUtils.getCs(ByteBufUtil.hexDump(bb).substring(2));
            bb.writeShort(Integer.parseInt(cs, 16));
            bb.writeByte(0xED);
            log.info("指令回复>>>>> hex:{}, cmd:{}, meterCode:{}, keyNum:{}\n",
                    ByteBufUtil.hexDump(bb),
                    Util.getDownCmdType(bb),
                    msg.getHeader().getDeviceId(),
                    msg.getHeader().getKeyNum());
            out.writeBytes(bb);
        } finally {
            ReferenceCountUtil.safeRelease(bb);
        }
    }


    public static void main(String[] args) {

        // String hex = "67400201420220100000410102100076aa215615d05e23dcdbc81e5eade8211eaaed";

//         String hex = "6740020142022010000041010180001c9ef387d74149d95527431188976b833f614312c62eae65f10be99ca744b9bc78efa007bd579013be8fbaaba9f83509cbcae1fd4bf66772467f8bb4b5f21f0355ddd31abe6d17717282fb7aecb0d72bd287394f8b66a3098de2b0cb7eae8b0a821a238d073d534a593fd77bf87dc2d353db164f07ad47b1851f42cba4c3291a31aced";

//        String hex = "674002014202201000004101125000e5850d671f41b584c4f3001d281e991868cb7d185416bee9eabdae2c254edee81eac89a1daf0ffd07f71f7647118122d6d9f1fd061678a595bfad79575a49aa870e5c57ad1b8515ccaa9221f28550de5a70ced";
        String hex = "674002014202201000004101122000b76a49d86c26ad5f9f8118518837bb35a41fd84d32f5a28a45e77cb658be19794d48ed";

        Message parse = new EnnStandardTcpProtocol().parse(HexUtil.decodeHex(hex));

        log.info(JSON.toJSONString(parse, true));


    }
}
