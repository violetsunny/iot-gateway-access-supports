package cn.enncloud.iot.gateway.protocol.std.core.responses;

public class ReadInputRegisterResponse <T> extends BaseModbusReadResponse<T> {
    public ReadInputRegisterResponse(int flag, int uid, int code, int length, T data) {
        super(flag, uid, code, length, data);
    }
}
