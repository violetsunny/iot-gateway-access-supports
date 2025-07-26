package cn.enncloud.iot.gateway.protocol.std.core.payloads;


import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;

public class WriteSingleRegisterPayLoad extends BaseModbusPayLoad{
    public WriteSingleRegisterPayLoad(int address, short value) {
        super(ModbusFCode.WRITE_SINGLE_REGISTER, address, 0,value);
    }
}
