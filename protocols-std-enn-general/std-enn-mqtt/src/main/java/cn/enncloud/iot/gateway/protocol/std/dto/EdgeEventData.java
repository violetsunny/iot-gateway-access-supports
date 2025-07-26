/**
 * llkang.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author kanglele
 * @version $Id: EdgeEventDataDTO, v 0.1 2022/11/21 14:42 kanglele Exp $
 */
@NoArgsConstructor
@Data
public class EdgeEventData implements Serializable {

    @JsonProperty("ver")
    private String ver;
    @JsonProperty("pKey")
    private String pKey;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("ts")
    private Long ts;
    @JsonProperty("type")
    private String type;
    @JsonProperty("devs")
    private List<DevsDTO> devs;

    @NoArgsConstructor
    @Data
    public static class DevsDTO {
        @JsonProperty("sysId")
        private String sysId;
        @JsonProperty("dev")
        private String dev;
        @JsonProperty("identifier")
        private String identifier;
        @JsonProperty("ts")
        private Long ts;
        @JsonProperty("eventType")
        private String eventType;
        @JsonProperty("value")
        private Map<String,Object> value;
    }
}
