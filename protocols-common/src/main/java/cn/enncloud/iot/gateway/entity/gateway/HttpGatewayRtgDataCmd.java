package cn.enncloud.iot.gateway.entity.gateway;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 数据上报报文
 * @Author: alec
 * Description:
 * @date: 上午10:02 2023/4/19
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "数据上报报文")
public class HttpGatewayRtgDataCmd {

    /**
     * sysId
     */
    @Schema(description = "sysId")
    private String sysId;

    /**
     * 设备编号
     */
    @Schema(description = "设备编号")
    @NotEmpty(message = "dev is not null")
    private String dev;

    /**
     * 时间戳
     */
    @Schema(description = "时间戳")
    @NotNull(message = "ts is not null")
    private Long ts;

    /**
     * 上报报文
     */
    @Schema(description = "上报报文")
    @NotNull(message = "d is not null")
    @Valid
    private List<RtgData> d;

    /**
     * 续传
     */
    @Schema(description = "Y-续传，N-非续传 默认N")
    private String resume = "N"; //Y-续传，N-非续传

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class RtgData {

        /**
         * 测点
         */
        @NotEmpty
        @Schema(description = "测点")
        private String m;

        /**
         * 测点值
         */
        @Schema(description = "测点值")
        private Object v;

        /**
         * 测点时间
         */
        @Schema(description = "测点时间")
        private Long ts;
    }

}
