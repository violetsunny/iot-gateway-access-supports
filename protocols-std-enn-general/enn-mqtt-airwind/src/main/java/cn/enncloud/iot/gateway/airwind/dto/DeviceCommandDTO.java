package cn.enncloud.iot.gateway.airwind.dto;

import java.util.Map;

public class DeviceCommandDTO {


    private long ts;



    private Map<String,Object> values;


    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}
