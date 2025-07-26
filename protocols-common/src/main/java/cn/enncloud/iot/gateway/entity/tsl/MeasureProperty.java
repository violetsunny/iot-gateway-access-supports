package cn.enncloud.iot.gateway.entity.tsl;

import lombok.Data;

@Data
public class MeasureProperty {
    String code;
    String unit;
    DataType type;

    Long min;
    Long max;

    boolean required;
}
