package cn.enncloud.iot.gateway.entity.tsl;

import lombok.Data;

import java.util.List;

@Data
public class ProductTsl {
    String tslCode;
    List<BasicProperty> basicProperties;
    List<MeasureProperty> measureProperties;
    List<Event> events;
    List<Function> functions;
}
