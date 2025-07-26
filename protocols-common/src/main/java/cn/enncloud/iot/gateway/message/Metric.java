package cn.enncloud.iot.gateway.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metric {
    long ts;
    String code;
    Object value;
}
