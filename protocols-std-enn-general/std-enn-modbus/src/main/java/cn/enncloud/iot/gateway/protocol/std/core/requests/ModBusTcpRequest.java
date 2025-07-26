package cn.enncloud.iot.gateway.protocol.std.core.requests;


import cn.enncloud.iot.gateway.protocol.std.core.payloads.ModbusPayLoad;

public class ModBusTcpRequest extends BaseModbusRequest {
    public ModBusTcpRequest(ModbusPayLoad payLoad) {
        super(payLoad);
    }

    public ModBusTcpRequest(Short uid,ModbusPayLoad payLoad) {
        super(uid,payLoad);
    }

}
