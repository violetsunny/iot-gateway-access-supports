package cn.enncloud.iot.gateway.protocol.std.core.responses;


public class ReadCoilStatusResponse<T> extends BaseModbusReadResponse<T> {
    public ReadCoilStatusResponse(int flag,int uid,int code, int length, T data) {
        super(flag,uid,code, length, data);
    }
}
