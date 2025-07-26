package cn.enncloud.iot.gateway.airwind.dto;

import java.util.List;

public class DeviceReportDTO {

    private String ts;
    private List<MetricDTO> d;

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public List<MetricDTO> getValues() {
        return d;
    }

    public void setValues(List<MetricDTO> values) {
        this.d = values;
    }
}
