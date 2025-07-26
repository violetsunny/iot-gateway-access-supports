package cn.enncloud.iot.gateway.protocol.std.core.payloads;


import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;

public class ReadHoldingRegisterPayLoad extends BaseModbusPayLoad{
    public ReadHoldingRegisterPayLoad( int address, int amount) {
        super(ModbusFCode.READ_HOLDING_REGISTER, address, amount);
    }
}
