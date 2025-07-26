package cn.enncloud.iot.gateway.protocol.std.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;


@Data
public class EdgeStatusData implements Serializable {

    /**
     * 版本
     */
    @JsonProperty(value = "ver")
    private String ver;

    /**
     * 供应商产品系列编号
     */
    @JsonProperty(value = "pKey")
    private String pKey;

    /**
     * 物联网关编号
     */
    private String sn;

    private String deviceId;

    private String type;

    private Long seq;

    /**
     * 数据包上报时间
     */
    private Long ts;

    /**
     * 数据列表
     */
    private Map<String,Object> data;

}
