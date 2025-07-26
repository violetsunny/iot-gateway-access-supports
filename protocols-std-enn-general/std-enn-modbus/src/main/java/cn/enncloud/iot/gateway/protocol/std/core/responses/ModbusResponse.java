package cn.enncloud.iot.gateway.protocol.std.core.responses;

public interface ModbusResponse<T> {
    int length();

    int flag();

    int code();

    int uid();

    T data();

    String toString();


}
