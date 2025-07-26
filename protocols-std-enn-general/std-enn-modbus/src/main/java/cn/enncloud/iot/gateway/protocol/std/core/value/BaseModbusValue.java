package cn.enncloud.iot.gateway.protocol.std.core.value;


public abstract class BaseModbusValue<T> implements ModbusValue<T> {
    T value;

    int len;


    @Override
    public T value() {
        return this.value;
    }

    @Override
    public int len() {
        return this.len;
    }
}
