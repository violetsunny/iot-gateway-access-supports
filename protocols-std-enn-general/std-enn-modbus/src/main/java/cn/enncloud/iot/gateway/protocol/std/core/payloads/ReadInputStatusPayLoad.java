package cn.enncloud.iot.gateway.protocol.std.core.payloads;


import cn.enncloud.iot.gateway.protocol.std.core.typed.ModbusFCode;

public class ReadInputStatusPayLoad extends BaseModbusPayLoad {
    public ReadInputStatusPayLoad(int address, int amount) {
        super( ModbusFCode.READ_INPUT_STATUS, address, amount);
    }
}
