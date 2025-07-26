package cn.enncloud.iot.gateway.protocol.std.energy.model;


import cn.enncloud.iot.gateway.protocol.std.energy.utils.crypt.DataType;

public class ProtocolDataField {

    private String metric;
    private DataType type;
    private int length;//字段长度或数组单元长度,字节数

    public ProtocolDataField(String metric, DataType type, int len) {
        this.metric = metric;
        this.type = type;
        this.length = len;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
