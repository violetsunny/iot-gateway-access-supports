package cn.enncloud.iot.gateway.entity.gateway;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 数据上报
 * @Author: alec
 * Description: http 接入参数
 * @date: 上午9:40 2023/4/19
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "数据上报")
public class HttpGatewayRtgCmd {

    /**
     * 版本
     */
    @Schema(description = "版本")
    private String ver = "0.0.1";

    /**
     * pKey
     */
    @Schema(description = "pKey 可以是产品id")
    private String pKey;

    /**
     * 设备序列号
     */
    @Schema(description = "设备序列号")
    private String sn;

    /**
     * 时间戳
     */
    @Schema(description = "设备时间戳")
    private Long ts;

    /**
     * 报文
     */
    @NotNull(message = "devs is not null")
    @Valid
    @Schema(description = "设备报文")
    private List<HttpGatewayRtgDataCmd> devs;

}
