package cn.enncloud.iot.gateway.protocol.std.core.payloads;

public interface ModbusPayLoad<T> {
    int getCode();
    int getAddress();
    int getAmount();
    T val();
}
