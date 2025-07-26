package com.ennewiot.gateway.industrialalarm.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AlarmDeviceTypeEnum {

    GSY_ALARM(15, "model_gsy.json"),
    JY_ALARM(5, "model_jy.json");
    private Short deviceType;
    private String modelFileName;


    AlarmDeviceTypeEnum(int deviceType, String modelFileName) {
        this.deviceType = (short) deviceType;
        this.modelFileName = modelFileName;
    }


    public Short getDeviceType() {
        return deviceType;
    }

    public String getModelFileName() {
        return modelFileName;
    }

    public static AlarmDeviceTypeEnum getAlarmDeviceTypeEnum(short deviceType){
        Optional<AlarmDeviceTypeEnum> first = Arrays.stream(values()).filter(t -> t.getDeviceType() == deviceType).findFirst();
        return first.orElse(null);
    }
}
