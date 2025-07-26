package com.ennewiot.gateway.industrialalarm.protocol;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.utils.JsonUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ennewiot.gateway.industrialalarm.dto.DecodeMsg;
import com.ennewiot.gateway.industrialalarm.dto.ReceiveInfoDTO;
import com.ennewiot.gateway.industrialalarm.enums.AlarmDeviceTypeEnum;
import com.ennewiot.gateway.industrialalarm.enums.CommandEnum;
import com.ennewiot.gateway.industrialalarm.model.ModelInfoDto;
import com.ennewiot.gateway.industrialalarm.model.ModelPhyAttributeDto;
import com.ennewiot.gateway.industrialalarm.model.ProtocolDataField;
import com.ennewiot.gateway.industrialalarm.msg.base.DataPacket;
import com.ennewiot.gateway.industrialalarm.msg.base.UpPacket;
import com.ennewiot.gateway.industrialalarm.msg.down.CommonResp;
import com.ennewiot.gateway.industrialalarm.utils.*;
import com.ennewiot.gateway.industrialalarm.utils.crypt.DataType;
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

import static com.ennewiot.gateway.industrialalarm.enums.AlarmDeviceTypeEnum.getAlarmDeviceTypeEnum;


@Slf4j
public class NbAlarmDevMessageCodec implements Protocol {


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


    /**
     * 解析上报数据
     *
     * @param messageBytes
     * @return
     */
    private MetricReportRequest decodeReportRequest(byte[] messageBytes) {
        ReceiveInfoDTO reportRequest = JsonUtil.jsonBytes2Object(messageBytes, ReceiveInfoDTO.class);
        if (Objects.isNull(reportRequest)) {
            log.warn("数据上报格式异常，info：{}", JsonUtil.jsonBytes2Object(messageBytes, JSONObject.class));
            throw new RuntimeException("数据上报格式异常");
        }

        MetricReportRequest metricReportRequest = null;
        try {
            DecodeMsg decodeMsg = decoderMsg(reportRequest);

            metricReportRequest = transReceiveInfoDTOToMessage(reportRequest, decodeMsg);

        } catch (Exception e) {
            log.warn("数据上报协议解析异常，info：{}", e.getMessage());
            throw new RuntimeException(e);
        }
        return metricReportRequest;
    }

    private MetricReportRequest transReceiveInfoDTOToMessage(ReceiveInfoDTO receiveInfoDTO, DecodeMsg decodeMsg) {

        MetricReportRequest metricReportRequest = new MetricReportRequest();
        metricReportRequest.setDeviceId(receiveInfoDTO.getDeviceId());
        DeviceContext deviceContext = getDeviceContext();
        if (deviceContext != null) {
            String ceshi = deviceContext.getDeviceIdBySn("ceshi", receiveInfoDTO.getDeviceId());
        }

        metricReportRequest.setTimeStamp(receiveInfoDTO.getTimestamp());

        Map<String, Object> data = decodeMsg.getData();
        if (Objects.nonNull(data)) {

            List<Metric> metrics = new ArrayList<>();
            Set<Map.Entry<String, Object>> entries = data.entrySet();
            entries.forEach(stringObjectEntry -> metrics.add(new Metric(receiveInfoDTO.getTimestamp(), stringObjectEntry.getKey(), stringObjectEntry.getValue())));

            metricReportRequest.setMetrics(metrics);
        }
        if (Objects.nonNull(decodeMsg.getResponse())) {
            metricReportRequest.setResponse(JSON.toJSONString(decodeMsg.getResponse()));
        }
        return metricReportRequest;
    }


    @Override
    public String getId() {
        return "ctwing-industrialalarm-nb";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        Message msg = null;
//        if (msg.getMessageType() == MessageType.DEVICE_LOGIN_REQ) {
//            msg = JsonUtil.jsonBytes2Object(messageBytes, LoginRequest.class);
//            return msg;
//        } else if (msg.getMessageType() == MessageType.DEVICE_REPORT_REQ) {
            msg = decodeReportRequest(messageBytes);
            return msg;
//        } else if (msg.getMessageType() == MessageType.CLOUD_OPERATION_RSP) {
//            msg = JsonUtil.jsonBytes2Object(messageBytes, OperationResponse.class);
//            return msg;
//        }
//        return msg;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {

        return Collections.singletonList(decodeReportRequest(messageBytes));
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        return JsonUtil.object2JsonBytes(message);
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }

    @Override
    public void setDeviceContext(DeviceContext deviceContext) {

    }

    @Override
    public DeviceContext getDeviceContext() {
        return null;
    }

    @Override
    public Map getParams() {
        return null;
    }

    @Override
    public void setParams(Map params) {

    }


    private DecodeMsg decoderMsg(ReceiveInfoDTO input) throws Exception {

        DecodeMsg decodeMsg = new DecodeMsg();

//
        ReceiveInfoDTO.Payload payload = input.getPayload();
        if (payload == null) {//电信平台无相关数据,不做处理
            return null;
        }


        String oData = payload.getAPPdata();
        String upProtocolStr = Base64Util.decryptBASE64(oData);

        //处理解析逻辑
        byte[] bytes = HexUtils.str2hex(upProtocolStr);
        ByteBuf in = Unpooled.buffer(bytes.length);
        in.writeBytes(bytes);
        Object dataPacket = getByteBufToDataService().byteBufToDataPacket(in);
        UpPacket upPacket = null;
        if (dataPacket instanceof UpPacket) {
            upPacket = (UpPacket) dataPacket;
        } else {
            throw new RuntimeException("非上报数据" + JSON.toJSONString(dataPacket));
        }


        Map<String, Object> resultMap;
        resultMap = this.sendData(upPacket);
        decodeMsg.setData(resultMap);

        // 构建回复消息
        CommonResp resp = CommonResp.success(upPacket);
        ByteBuf buffer = Unpooled.buffer();
        this.encodeResp(resp, buffer);
        String deviceId = Util.getDeviceId(buffer);
        String downCmdType = Util.getDownCmdType(buffer);
        String command = ByteBufUtil.hexDump(buffer);
        JSONObject respInfo = new JSONObject();
        respInfo.put("deviceId", deviceId);
        respInfo.put("downCmdType", downCmdType);
        respInfo.put("command", command);

        decodeMsg.setResponse(respInfo);

        return decodeMsg;
    }


    private final static String REGEX_FF = "^(F{2,})$";
    private final static String METRIC_U_BAT = "Ubat";
    private final static String METRIC_U_BAT_VALUE = "ffff";

    private final static String SEPARATOR = "-";


    private static final ConcurrentHashMap<Short, ModelInfoDto> MODEL_INFO_MAP = new ConcurrentHashMap<>();


    public ModelInfoDto getModelInfoDto(Short deviceType) {

        ModelInfoDto modelInfoDto = MODEL_INFO_MAP.get(deviceType);
        if (modelInfoDto == null) {

            ClassLoader classLoader = this.getClass().getClassLoader();

            AlarmDeviceTypeEnum alarmDeviceTypeEnum = getAlarmDeviceTypeEnum(deviceType);
            if (Objects.isNull(alarmDeviceTypeEnum)) {
                log.warn("不支持的设备类型,默认为工商业报警器,deviceType：{}", deviceType);
                alarmDeviceTypeEnum = AlarmDeviceTypeEnum.GSY_ALARM;
            }
            String resourcePath = alarmDeviceTypeEnum.getModelFileName();
            InputStream inputStream = classLoader.getResourceAsStream(resourcePath);
            String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
            log.info("模型获取：{},preData:{}", StringUtils.isNotBlank(read), read.substring(0, 100));
            modelInfoDto = JSONUtil.toBean(JSONUtil.parseObj(read), ModelInfoDto.class);
            MODEL_INFO_MAP.put(alarmDeviceTypeEnum.getDeviceType(), modelInfoDto);

        }

        return modelInfoDto;
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
                    t ->
                    {
//                        log.debug("map key: {}", t);
                        //命名规则为 设备类型-指令码 例如: PWM-02H。如果指令为22H、23H 那么命名规则为 设备类型-指令码-数据类型 例如： YBZ-22H-01
                        if (t.contains(SEPARATOR)) {
                            String[] keySplit = t.split(SEPARATOR);
                            String cmdType = keySplit[1];
                            if (dataPacket.getHeader().getCmdType().equals(CommandEnum.HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode()) || dataPacket.getHeader().getCmdType().equals(CommandEnum.CALL_HISTORY_DATA_UPLOAD_WITH_TYPE.getCommandCode())) {
                                if (keySplit.length >= 3) {
                                    String dataType = keySplit[2];
                                    log.debug("--> deviceId:{}, cmdType: {},dataPacket.getHeader().getCmdType():{}, dataType:{}, dataPacket.getData().substring(4, 6):{} ",
                                            dataPacket.getHeader().getDeviceId(), cmdType, dataPacket.getHeader().getCmdType(), dataType, dataPacket.getData().substring(4, 6));
                                    return cmdType.startsWith(dataPacket.getHeader().getCmdType()) && dataType.equals(dataPacket.getData().substring(4, 6));
                                }
                                return false;
                            } else if (CommandEnum.ALARM_DATA_UPLOAD_WITH_TYPE.getCommandCode().equals(dataPacket.getHeader().getCmdType())) {
                                if (keySplit.length >= 3) {
                                    String alarmType = keySplit[2];
                                    log.info("cmdType: IOT->{},上报报文->{}\r\n" +
                                            "alarmType: IOT->{},上报报文->{}", cmdType, dataPacket.getHeader().getCmdType(), alarmType, dataPacket.getData().substring(18, 20));
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
                log.debug("指令模型编码:{}", first.get());
                //根据页面配置的字段解析
                List<LinkedHashMap<String, Object>> mapList = getMap(map, dataPacket.getData(), dataPacket.getHeader().getCmdType(), first.get());
                log.info("设备ID:{},上报内容:{}", dtuCode, mapList);
                if (mapList != null) {
                    for (LinkedHashMap<String, Object> map1 : mapList) {
                        //                    String deviceId = AttributyKeyUtil.getDeviceIdForXinao(ctx);
                        String deviceId = dataPacket.getHeader().getDeviceId();
                        log.debug("kafka deviceId: {}", deviceId);
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
                    log.debug("01H第" + j + "条,模型编码:{}", first.get());
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
                    log.warn("ProtocolDataType不合法. 当前protocolDataType为: " + protocolDataType);
                    return null;
                }
                ProtocolDataField protocolDataField = new ProtocolDataField(list.get(i1).getTargetPath(), dataType, list.get(i1).getByteLen());
                if (!DataType.valueOf(protocolDataType).equals(DataType.BIT)) {
                    data = putValue2DataMap(map, data, "BIG_ENDIAN".equals(list.get(i1).getByteOrder()) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN, protocolDataField);
                } else {
                    //取出一个字节
                    byte statusByte = Byte.parseByte(data.substring(0, 2), 16);
                    data = data.substring(2);
                    //循环取出8个采集点，分别与一个字节中的八位
                    for (int k = 0; k < 8; k++, i1++) {
                        if (!DataType.valueOf(list.get(i1).getProtocolDataType().getCode()).equals(DataType.BIT)) {
//                            throw new DecodeException("模型中采集点中有BIT位没有配置预留" + list.get(i1).getTargetPath() + "," + list.get(i1).getDepict());

                            log.warn("模型中采集点中有BIT位没有配置预留" + list.get(i1).getTargetPath() + "," + list.get(i1).getDepict());
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
            log.warn("数据报文解析长度错误，请检查模型配置！data=" + data + ", endIndex=" + protocolDataField.getLength() + "字节");
            return null;
        }
        String fieldData = data.substring(0, endIndex * 2);

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

    /**
     * 编码回复消息
     *
     * @param msg
     * @param out
     * @throws Exception
     */
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


}
