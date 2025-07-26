package cn.enncloud.iot.gateway.protocol.std.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by gaoyann on 2020/7/18.
 */
@Data
public class CollectionData implements Serializable {

    /**
     * 指标名称
     */
    private String m;

    /**
     * 采集值
     */
    private Object v;

    /**
     * 单一测点采集时间
     */
    private Long ts;

    /**
     * 数据质量码
     */
    private int dq;


}
