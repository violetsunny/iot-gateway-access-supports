package cn.enncloud.iot.gateway.protocol.std.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gaoyann
 * @date 2020/7/18
 */
@Data
public class EdgeRtgData implements Serializable {

    /**
     * 版本
     */
    private String ver;

    /**
     * 供应商产品系列编号
     */
    private String pKey;

    /**
     * 物联网关编号
     */
    private String sn;

    private Boolean changeRpt;

    private String type;

    /**
     * 数据包上报时间
     */
    private Long ts;

    /**
     * 设备列表
     */
    private List<DeviceData> devs;

}
