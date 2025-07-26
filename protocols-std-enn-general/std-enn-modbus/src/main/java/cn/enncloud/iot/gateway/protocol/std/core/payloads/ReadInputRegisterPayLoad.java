package cn.enncloud.iot.gateway.protocol.std.core.payloads;


import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;

public class ReadInputRegisterPayLoad  extends BaseModbusPayLoad{
    public ReadInputRegisterPayLoad( int address, int amount) {
        super(ModbusFCode.READ_INPUT_REGISTER, address, amount);
    }
}
