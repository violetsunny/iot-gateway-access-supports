package cn.enncloud.iot.gateway.protocol.std.energy.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DongLi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadICCID implements Serializable {
    @JsonProperty("ICCID")
    @JSONField(name = "ICCID")
    private String ICCID;
}
