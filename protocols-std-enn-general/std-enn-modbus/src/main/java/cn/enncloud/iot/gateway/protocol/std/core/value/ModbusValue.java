package cn.enncloud.iot.gateway.protocol.std.core.value;

public interface ModbusValue<T> {
    T value();

    int len();

}
