package cn.enncloud.iot.gateway.protocol.std.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaoyann on 2020/7/18.
 */
@Data
public class DeviceData implements Serializable {

    /**
     * 可缺省，当一个网关传送多个站（系统）时才填写
     */
    private String sysId;

    /**
     * 设备id
     */
    private String dev;

    /**
     * 设备所有测点采集时间
     */
    private Long ts;

    /**
     * 采集数据
     */
    private List<CollectionData> d;

}
