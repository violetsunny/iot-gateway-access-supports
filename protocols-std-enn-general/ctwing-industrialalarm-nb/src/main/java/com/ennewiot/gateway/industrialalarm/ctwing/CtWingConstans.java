package com.ennewiot.gateway.industrialalarm.ctwing;

/**
 * @Auther: xinao-663
 * @Date: 2021/8/16 15:07
 * @Description:
 */
public interface CtWingConstans {

    String operator="iot-standard";
    /**
     * ttl: 设备指令缓存时长，选填。单位：秒，取值范围：0-864000。
     *      不携带则默认值：7200。如不需缓存请填0。
     */
    Integer ttl=720;

    /**
     * level:指令级别，1或2为设备级别,3为设备组级别，选填。不填默认设备级
     */
    interface level{
        Integer one=1;
        Integer tow=2;
        Integer three=3;
    }

    /**
     * dataType:数据类型：1字符串，2十六进制
     */
    interface  dataType{
        Integer str=1;
        Integer hex=2;
    }
}
