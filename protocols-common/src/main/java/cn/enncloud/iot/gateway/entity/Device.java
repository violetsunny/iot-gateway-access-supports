package cn.enncloud.iot.gateway.entity;

import lombok.Data;

import java.util.Map;

@Data
public class Device {

    private String deviceId;

    private String sn;

    private String name;

    private String vehicleImei;

    private String productId;

    private Map<String,Object> extend;

    private String tenantId;

    private String deptId;

}
