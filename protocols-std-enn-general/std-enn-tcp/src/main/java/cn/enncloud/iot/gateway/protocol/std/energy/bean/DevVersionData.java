package cn.enncloud.iot.gateway.protocol.std.energy.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: xinao-663
 * @Date: 2021/12/9 09:03
 * @Description:
 */
@Data
public class DevVersionData implements Serializable {

    /**
     * 协议版本
     */
    private short version;

    /**
     * 设备类型
     */
    private short deviceType;

}
