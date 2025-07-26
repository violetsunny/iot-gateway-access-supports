package cn.enncloud.iot.gateway.protocol.std;

import cn.enncloud.iot.gateway.entity.cloud.ModbusPointMapping;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.protocol.std.core.payloads.*;
import cn.enncloud.iot.gateway.protocol.std.core.requests.ModBusTcpRequest;
import cn.enncloud.iot.gateway.protocol.std.core.requests.ModbusRequest;
import cn.enncloud.iot.gateway.protocol.std.core.responses.*;
import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;
import cn.enncloud.iot.gateway.protocol.std.enums.ByteOrderEnum;
import cn.enncloud.iot.gateway.protocol.std.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.protocol.std.utils.IotByteUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class EnnStdModbusProtocol extends AbstractProtocol {


    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return "modbus-protocol-map";
    }

    private HashMap<Integer, ModbusPointMapping> devicePointMap;
    private HashMap<String, Integer> devicePointToModbusMap;


    public void setDevicePointMap(HashMap<Integer, ModbusPointMapping> devicePointMap) {
        this.devicePointMap = devicePointMap;
    }


    public void setDevicePointToModbusMap(HashMap<String, Integer> devicePointToModbusMap) {
        this.devicePointToModbusMap = devicePointToModbusMap;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        log.info("协议解析 >>> " + ByteBufUtil.hexDump(messageBytes));
        ByteBuf byteBuf = Unpooled.wrappedBuffer(messageBytes);
        int bytesLen = byteBuf.readableBytes();
        if (bytesLen < 10) {
            byteBuf.skipBytes(bytesLen);
            return null;
        }

        byteBuf.markReaderIndex();
        int flag = byteBuf.readUnsignedShort();
        int pool = byteBuf.readUnsignedShort();
        int dtLen = byteBuf.readUnsignedShort();

        // 数据域长度判断
        int lastSize = byteBuf.readableBytes();
        if (lastSize < dtLen) {
            byteBuf.resetReaderIndex();
            return null;
        }

        int uid = byteBuf.readUnsignedByte();
        if (pool != 0) {
            int i = dtLen - 1;
            if (i > 0) {
                byteBuf.skipBytes(i);
            }
            return null;
        }
        int code = byteBuf.readByte();
        int btLen = byteBuf.readUnsignedByte();
        byte[] data = new byte[btLen];
        int index = byteBuf.readerIndex();
        byteBuf.getBytes(index, data, 0, btLen);

        List<ModbusResponse> list = new ArrayList<>();
        if (code == ModbusFCode.READ_COIL_STATUS) {
            list.add(new ReadCoilStatusResponse(flag, uid, code, btLen, data));
        }
        if (code == ModbusFCode.READ_INPUT_STATUS) {
            list.add(new ReadInputStatusResponse(flag, uid, code, btLen, data));
        }
        if (code == ModbusFCode.READ_HOLDING_REGISTER) {

            list.add(new ReadHoldingRegisterResponse(flag, uid, code, btLen, data));
        }
        if (code == ModbusFCode.READ_INPUT_REGISTER) {
            list.add(new ReadInputRegisterResponse(flag, uid, code, btLen, data));
        }
        byteBuf.readBytes(btLen);

        Map<Integer, String> REQUEST_CACHE = (ConcurrentHashMap<Integer, String>) params[0];
        Map<String, ModbusPointMapping> POINT_CACHE = (ConcurrentHashMap<String, ModbusPointMapping>) params[1];
        List<MetricReportRequest> requests = new ArrayList<>();
        list.forEach(value -> {
            int flaga = value.flag();
            String pointKey = REQUEST_CACHE.remove(flaga);
            ModbusPointMapping modbusPointDTO = POINT_CACHE.get(pointKey);
            // 获取参数值
            Number number = respHandler(value, modbusPointDTO);

//            if (Objects.isNull(devicePointMap)) {
//                initMappingInfo();
//            }
//            ModbusPointMapping devicePointMapDTO = devicePointMap.get(modbusPointDTO.getPointId());
//            if (Objects.isNull(devicePointMapDTO)) {
//                log.warn("设备测点物模型映射配置缺失，modbus point：{}", modbusPointDTO);
//                return;
//            }

            long timeMillis = System.currentTimeMillis();
            MetricReportRequest metricReportRequest = new MetricReportRequest();
            metricReportRequest.setTimeStamp(timeMillis);
            metricReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("std",modbusPointDTO.getDeviceId()));

            String dataType = modbusPointDTO.getDataType();

            Metric metric = new Metric(timeMillis, modbusPointDTO.getMetric(), number);
            metricReportRequest.setMetrics(Collections.singletonList(metric));

            requests.add(metricReportRequest);
        });


        return requests;
    }


    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        ModbusPointMapping modbusPointDTO = (ModbusPointMapping) params[0];
        ModbusRequest request = buildReadReq(modbusPointDTO);
        ByteBuf buf = Unpooled.buffer();
        try {
            //TODO 转ByteBuf
            int sIndex = buf.writerIndex();
            buf.writeZero(7);
            int rIndex = buf.writerIndex();
            payload(request, buf);
            header(sIndex, rIndex, request.getFlag(), request.getPool(), request.getUid(), buf);
            // 将 ByteBuf 转换为 byte[]
            byte[] bytes = new byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(), bytes);
            return bytes;
        } finally {
            buf.release();
        }

    }

    private void header(int sIndex, int rIndex, int flag, short pool, short uid, ByteBuf buf) {
        int layLen = buf.writerIndex() - rIndex;
        int nIndex = buf.writerIndex();
        buf.writerIndex(sIndex);
        // 事务号
        buf.writeShort(flag);
        // 协议
        buf.writeShort(pool);
        // 数据长度
        buf.writeShort(layLen + 1);
        // 站点地址
        buf.writeByte(uid);
        buf.writerIndex(nIndex);
    }

    private void payload(ModbusRequest request, ByteBuf buf) {
        int code = request.getPayLoad().getCode();
        buf.writeByte(code);
        switch (code) {
            case ModbusFCode.READ_COIL_STATUS:
            case ModbusFCode.READ_INPUT_STATUS:
            case ModbusFCode.READ_HOLDING_REGISTER:
            case ModbusFCode.READ_INPUT_REGISTER:
                currency(request.getPayLoad(), buf);
                break;
            case ModbusFCode.WRITE_SINGLE_COIL:
                writeSingleCoil(request.getPayLoad(), buf);
                break;
            case ModbusFCode.WRITE_SINGLE_REGISTER:
                writeSingleRegister(request.getPayLoad(), buf);
                break;
            case ModbusFCode.WRITE_MULTIPLE_COIL:
                writeMultipleCoil(request.getPayLoad(), buf);
                break;
            case ModbusFCode.WRITE_MULTIPLE_REGISTER:
                writeMultipleRegister(request.getPayLoad(), buf);
                break;
            default:
                throw new RuntimeException(String.format("%s is an unsupported method", code));

        }
    }

    private void currency(ModbusPayLoad payload, ByteBuf buf) {
        buf.writeShort(payload.getAddress());
        buf.writeShort(payload.getAmount());
    }

    private void writeSingleCoil(ModbusPayLoad<Integer> payload, ByteBuf buf) {
        buf.writeShort(payload.getAddress());
        buf.writeShortLE(payload.val());
        //  buf.writeByte(payload.value());
    }

    private void writeSingleRegister(ModbusPayLoad<Short> payload, ByteBuf buf) {
        buf.writeShort(payload.getAddress());
        buf.writeShort(payload.val());
    }

    private void writeMultipleCoil(ModbusPayLoad<Integer> payload, ByteBuf buf) {
        currency(payload, buf);
        int count = (payload.getAmount() + 7) / 8;
        buf.writeByte(count);
        ByteBuf temp = Unpooled.buffer();
        temp.writeShortLE(payload.val());
        buf.writeBytes(temp, count);
    }

    private void writeMultipleRegister(ModbusPayLoad<short[]> payload, ByteBuf buf) {
        currency(payload, buf);
        int count = payload.getAmount() * 2;
        buf.writeByte(count);
        ByteBuf temp = Unpooled.buffer();
        for (int i = 0; i < payload.val().length; i++) {
            temp.writeShort(payload.val()[i]);
        }
        buf.writeBytes(temp, count);
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
//        //TODO: 根据测点映射转化modbus写指令
//        ConcurrentHashMap<String, ModbusPointDTO> POINT_CACHE = (ConcurrentHashMap<String, ModbusPointDTO>) params[0];
//        if (Objects.isNull(devicePointToModbusMap)) {
//            initModbusMappingInfo();
//        }
//
//        List<ByteBuf> cmds = new ArrayList<>();
//        messages.forEach(message -> {
//            OperationRequest cmd = (OperationRequest) message;
//            String deviceId = cmd.getDeviceId();
//            Map<String, Object> param = cmd.getParam();
//            param.forEach((key, value) -> {
//                Integer pointId = devicePointToModbusMap.get(deviceId + key);
//                ModbusPointWriteDTO modbusPointWriteDTO = new ModbusPointWriteDTO(pointId, value);
//                ModbusPointDTO modbusPointDTO = POINT_CACHE.get(modbusPointWriteDTO.getPointId());
//                ModbusRequest request = buildWriteReq(modbusPointWriteDTO, modbusPointDTO);
//                ByteBuf buf = Unpooled.buffer();
//                //TODO 转ByteBuf
//                int sIndex = buf.writerIndex();
//                buf.writeZero(7);
//                int rIndex = buf.writerIndex();
//                payload(request, buf);
//                header(sIndex, rIndex, request.getFlag(), request.getPool(), request.getUid(), buf);
//                cmds.add(buf);
//
//            });
//        });
//
//
//        byte[] cmd =  JsonUtil.object2JsonBytes(cmds);
//        cmds.forEach(ByteBuf::release);
        return new byte[0];
    }

//    private synchronized void initMappingInfo() {
//        Map params1 = getParams();
//        setDevicePointMap((HashMap<Integer, ModbusPointMapping>) params1);
//    }

//    private synchronized void initModbusMappingInfo() {
//        HashMap<Integer, ModbusPointMapping> params1 = (HashMap<Integer, ModbusPointMapping>) getParams();
//
//        HashMap<String, Integer> modbusPointMap = new HashMap<>();
//        params1.forEach((pointId, value) -> {
//
//            String key = value.getDeviceId() + value.getMetric();
//
//            if (StringUtils.equals("w", value.getRw())) {
//                modbusPointMap.put(key, pointId);
//            }
//        });
//
//        setDevicePointToModbusMap(modbusPointMap);
//    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }

    public Number respHandler(ModbusResponse resp, ModbusPointMapping modbusPointDTO) {
        byte[] bts = (byte[]) resp.data();
        Number value = null;
        log.info("功能码：{}，接收数据：{}", modbusPointDTO.getFunctionCode(), resp);
        if (resp.code() == 1) {
            value = getBooleanValue(modbusPointDTO, bts);
        } else if (resp.code() == 2) {
            value = getBooleanValue(modbusPointDTO, bts);
        } else if (resp.code() == 3) {
            value = getValue(modbusPointDTO, bts);

        } else if (resp.code() == 4) {
            value = getValue(modbusPointDTO, bts);
        } else {
            log.warn("功能码暂不支持，code：{}，info：{}", resp.code(), resp.toString());
        }

        if (Objects.nonNull(value)) {
            log.info("功能码：{}，解析数据：{}", modbusPointDTO.getFunctionCode(), value.longValue());

            return value;
        }
        return null;
    }

    public static Number getBooleanValue(ModbusPointMapping modbusPointDTO, byte[] bts) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(bts);

        DataTypeEnum dataType = DataTypeEnum.getInstance(modbusPointDTO.getDataType());

        String name = dataType.getValue();
        Integer bit = Integer.valueOf(name.replace("bit", ""));
        Number value = IotByteUtils.getBooleanFromStatusRegion(buffer, 0, bit);
        return value;
    }

    private static Number getValue(ModbusPointMapping modbusPointDTO, byte[] bts) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeBytes(bts);

        ByteOrderEnum byteOrder = ByteOrderEnum.getInstance(modbusPointDTO.getByteOrder());
        DataTypeEnum dataType = DataTypeEnum.getInstance(modbusPointDTO.getDataType());
        Number value = IotByteUtils.getNumberFromRegisterRegion(buffer, 0,
                byteOrder, dataType);
        return value;
    }


    /**
     * 构建
     *
     * @param pointDTOS
     * @return
     */
    public ModbusRequest buildReadReq(ModbusPointMapping pointDTOS) {

        BaseModbusPayLoad baseModbusPayLoad = null;
        Integer amount = transAmount(pointDTOS.getDataType());
        if (Objects.isNull(amount)) {
            return null;
        }
        if (pointDTOS.getFunctionCode().equals(ModbusFCode.READ_HOLDING_REGISTER)) {
            baseModbusPayLoad = new ReadHoldingRegisterPayLoad(pointDTOS.getRegisterAddress(), amount);
        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.READ_INPUT_REGISTER)) {
            baseModbusPayLoad = new ReadInputRegisterPayLoad(pointDTOS.getRegisterAddress(), amount);
        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.READ_COIL_STATUS)) {
            baseModbusPayLoad = new ReadCoilStatusPayLoad(pointDTOS.getRegisterAddress(), amount);
        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.READ_INPUT_STATUS)) {
            baseModbusPayLoad = new ReadInputStatusPayLoad(pointDTOS.getRegisterAddress(), amount);
        }
        ModBusTcpRequest modBusTcpRequest = new ModBusTcpRequest(pointDTOS.getSlaveAddr().shortValue(), baseModbusPayLoad);
        return modBusTcpRequest;


    }

//    public ModbusRequest buildWriteReq(ModbusPointWriteDTO modbusPointWriteDTO, ModbusPointMapping pointDTOS) {
//
//        Object value = modbusPointWriteDTO.getValue();
//        //TODO: 后续完善数据写入逻辑
//        ByteBuf buffer = Unpooled.buffer();
//        ByteBuf byteBuf = IotByteUtils.setNumberFromRegisterRegion(buffer, (Number) value, DataTypeEnum.getInstance(pointDTOS.getDataType()), ByteOrderEnum.getInstance(pointDTOS.getByteOrder()));
//
//        BaseModbusPayLoad baseModbusPayLoad = null;
//        if (pointDTOS.getFunctionCode().equals(ModbusFCode.WRITE_SINGLE_COIL)) {
//            byte b = byteBuf.readByte();
//            baseModbusPayLoad = new WriteSingleCoilPayLoad(0, true);
//        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.WRITE_SINGLE_REGISTER)) {
//            baseModbusPayLoad = new WriteSingleRegisterPayLoad(1, (short) 199);
//        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.WRITE_MULTIPLE_COIL)) {
//            baseModbusPayLoad = new WriteMultipleCoilPayLoad(0, new BinaryValue(1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1));
//        } else if (pointDTOS.getFunctionCode().equals(ModbusFCode.WRITE_MULTIPLE_REGISTER)) {
//            baseModbusPayLoad = new WriteMultipleRegisterPayLoad(0, new MultipleValue((short) 199, (short) 299, (short) 399, (short) 499, (short) 599, (short) 699, (short) 799, (short) 899));
//        }
//        ModBusTcpRequest modBusTcpRequest = new ModBusTcpRequest(baseModbusPayLoad);
//        return modBusTcpRequest;
////        //            写入单个线圈 三种方式
////        new ModBusTcpRequest(new WriteSingleCoilPayLoad(0, true));
////        new ModBusTcpRequest(new WriteSingleCoilPayLoad(0, 1));
////        new ModBusTcpRequest(new WriteSingleCoilPayLoad(0, (short) 1));
//////           =============================================================================
//////            写入多个线圈
////        new ModBusTcpRequest(new WriteMultipleCoilPayLoad(0, new BinaryValue(1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1)));
////        new ModBusTcpRequest(new WriteMultipleCoilPayLoad(0, new BinaryValue((short) 1, (short) 1, (short) 1, (short) 1, (short) 0, (short) 0, (short) 0, (short) 1)));
//////           =============================================================================
//////            写入单个寄存器
////        new ModBusTcpRequest(new WriteSingleRegisterPayLoad(1, (short) 199));
//////           =============================================================================
//////            写入多个寄存器
////        new ModBusTcpRequest(new WriteMultipleRegisterPayLoad(0, new MultipleValue((short) 199, (short) 299, (short) 399, (short) 499, (short) 599, (short) 699, (short) 799, (short) 899)));
//    }

    /**
     * 数据类型转换byte数量
     *
     * @param dataType
     * @return
     */
    private Integer transAmount(String dataType) {

        DataTypeEnum instance = DataTypeEnum.getInstance(dataType);

        if (Objects.isNull(instance)) {
            log.warn("点表数据类型异常，{}", dataType);
            return null;
        }
        return instance.getByteNum();
    }
}
