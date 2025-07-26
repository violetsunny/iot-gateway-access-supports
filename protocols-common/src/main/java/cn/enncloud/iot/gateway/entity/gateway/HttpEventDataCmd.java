/**
 * llkang.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.entity.gateway;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 事件上报
 * @author kanglele
 * @version $Id: EdgeEventDataDTO, v 0.1 2022/11/21 14:42 kanglele Exp $
 */
@NoArgsConstructor
@Data
@Schema(description = "事件上报")
public class HttpEventDataCmd implements Serializable {
    /**
     * 版本
     */
    @Schema(description = "版本")
    private String version;
    /**
     * pKey
     */
    @Schema(description = "pKey 可以是产品id")
    @JsonProperty(value = "pKey")
    private String pKey;
    /**
     * sn
     */
    @Schema(description = "设备序列号")
    private String sn;
    /**
     * 时间戳
     */
    @Schema(description = "时间戳")
    private Long ts;
    /**
     * 设备信息
     */
    @Valid
    @NotNull(message = "devs 不能为空")
    @Schema(description = "设备信息")
    private List<DevsVo> devs;

    @NoArgsConstructor
    @Data
    @Schema(description = "设备")
    public static class DevsVo {
        /**
         * sysId
         */
        @Schema(description = "sysId")
        private String sysId;
        /**
         * 设备ID
         */
        @NotBlank(message = "devs.dev 不能为空")
        @Schema(description = "设备编号")
        private String dev;
        /**
         * 事件标识
         */
        @Schema(description = "事件标识")
        @NotBlank(message = "devs.identifier 不能为空")
        private String identifier;
        /**
         * 时间戳
         */
        @Schema(description = "上报时间戳")
        @NotNull(message = "devs.ts 不能为空")
        private Long ts;
        /**
         * 事件类型，物模型定义；（info-信息，alarm-告警，fault–故障）
         */
        @Schema(description = "事件类型，物模型定义；（info-信息，alarm-告警，fault–故障）")
        @NotBlank(message = "devs.eventType 不能为空")
        private String eventType;
        /**
         * 参数信息
         */
        @Schema(description = "参数信息")
        private Map<String,Object> value;
    }

}