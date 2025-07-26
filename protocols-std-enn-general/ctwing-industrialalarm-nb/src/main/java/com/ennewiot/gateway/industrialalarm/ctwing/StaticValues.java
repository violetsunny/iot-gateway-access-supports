package com.ennewiot.gateway.industrialalarm.ctwing;

/**
* @Description: 静态值
* @Author: tang yong
* @Date: 2021/4/15 9:49
*/
public class StaticValues {

    /**
     * 过期时间
     */
    public final static long NBIOT_COMMAND_EXPIRE_TIME = 0;

    /**
     * 消息发送前停顿时间（服务器响应时间短表反应不过来，导致接收不到下行消息）
     */
    public final static long MSG_SLEEP_TIME_NB = 3000;
    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_HW_SERVICEID=   "serviceId";
    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_DEVICEID = "deviceId";
    /**
     * 报文对象
     */
    public final static String IOT_SERVICE = "payload";
    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_HW_ENNCOMMAND1 = "ennCommand";

    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_HW_ENNCOMMAND = "EnnCommand";
    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_DATA = "APPdata";

    /**
    * @Description: 产品ID
    * @Param:
    * @returns:
    * @Author: tang yong
    * @Date: 2021/4/29 13:36
    */
    public final static String IOT_PRODUCTID = "productId";


    /**
     * 电信iot平台报文常量
     */
    public final static String IOT_HW_ONE = "aa";

    public static final String SUCCESS_RETURN="00";
    public static final String ERROR_RETURN="01";
    public static final String ERROR_DIANXIN="IOT->电信IOT平台HTTPS下发指令失败";
    public static final String REPORT_41H="41H";
    public static final String REPORT_38H="38H";
    public static final String REPORT_37H="37H";
    public static final String FIXED_FOLWID="0";

    /**
     * 上报类型：触发上报
     */
    public static final String REPORT_TYPE = "02";


}
