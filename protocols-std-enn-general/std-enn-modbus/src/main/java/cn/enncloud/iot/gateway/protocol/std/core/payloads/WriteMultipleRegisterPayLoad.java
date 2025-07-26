package cn.enncloud.iot.gateway.protocol.std.core.payloads;


import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;
import cn.enncloud.iot.gateway.protocol.std.core.value.ModbusValue;

public class WriteMultipleRegisterPayLoad extends BaseModbusPayLoad{
    public WriteMultipleRegisterPayLoad( int address, ModbusValue<short[]> value) {
        super(ModbusFCode.WRITE_MULTIPLE_REGISTER, address, value.len(), value.value());
    }
}
