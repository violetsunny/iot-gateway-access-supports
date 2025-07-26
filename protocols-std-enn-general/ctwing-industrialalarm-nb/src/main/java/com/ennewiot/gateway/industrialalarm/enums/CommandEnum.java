package com.ennewiot.gateway.industrialalarm.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CommandEnum {
    ALARM_DATA_UPLOAD_WITH_TYPE("01H", "按数据类型报警数据上报"),
    ALARM_DATA_UPLOAD("02H", "按数据类型报警数据上报"),
    HISTORY_DATA_UPLOAD("12H", "按数据类型历史数据上报"),
    HISTORY_DATA_UPLOAD_WITH_TYPE("22H", "按数据类型历史数据上报"),
    CALL_HISTORY_DATA_UPLOAD_WITH_TYPE("23H", "按数据类型补调数据上报"),
    READ_SIM_ICCID("09H", "读取远传终端SIM卡的ICCID号"),
    SET_IP_PARAM("56H", "设置网络IP参数"),
    SET_NETWORK_DOMAIN("57H", "设置网络域名参数"),
    SET_REPORT_COLLECTION_CYCLE("49H", "设置上报周期"),
    SET_COLLECTION_CYCLE("50H", "设置采集周期"),
    SET_COLLECTION_ALARM_THRESHOLD("51H", "设置采集报警阈值"),
    PROOFREADING_CLOCK("05H", "校对时钟"),
    CALL_HISTORY("13H", "历史数据补调"),
    SECRET_DOWN("08H", "密钥下发"),
    SET_ALARM_PARAM("58H", "配置报警参数"),
    SET_METER_CONFIG("SET_METER_CONFIG", "设置温度采集器参数"),
    ALARM_SILENCE("75H", "调整报警音量"),
    SET_CONTROL_OUT("78H", "设置控制输出模块"),
    UPDATE("59H", "硬件版本升级"),
    GET_REPORT_COLLECTION_CYCLE("4AH", "读取采集上报周期"),
    UPDATE_NB("5AH", "硬件版本升级-设备主动模式"),
    READ_ALARM_PARAM("6AH", "读取报警浓度值"),
    SET_HANWEI_ANKEXIN_CONFIG("SET_HANWEI_ANKEXIN_CONFIG", "汉威安可信设置"),
    SET_3040_ALARM_CONFIG("SET_3040_ALARM_CONFIG", "3040下发采集上传间隔指令"),
    SET_3040_COLLECTION_CYCLE("SET_3040_COLLECTION_CYCLE", "3040双口下发报警参数"),
    SET_3040_CLOCK("SET_3040_CLOCK", "3040下发授时指令"),
    SET_HANWEI_PID_ALARMCONFIG("T", "汉威压力计报警设置指令"),
    MODBUS_CMD("MODBUS_CMD", "modbus指令"),
    SET_WIRELESS_ADDRESS("0010", "设置阀门无线地址"),
    SET_LOCK_UNLOCK_VALVE("0A10", "锁定解锁阀门"),
    SET_OPEN_CLOSE_UNLOCK_VALVE("0B10", "打开关闭未锁定阀门"),
    SET_OPEN_CLOSE_LOCKED_VALVE("0C10", "打开关闭锁定阀门"),
    SET_RRSET("0E10", "单片机复位"),
    SET_OPEN_CLOSE_ALL_VALVE("1010", "打开关闭所有阀门"),
    SET_CLEAR_EXCEPTION("1610", "清除电机异常次数、阀门重试次数"),
    SET_BASE_APERTURE("3810", "基本开度设定"),
    SET_SPECIAL_APERTURE("3510", "开度调节指令"),
    HRV_READMETER("READ", "抄表指令"),
    SET_FANGJIN_ALARM_CONFIG("SET_FANGJIN_ALARM_CONFIG", "压力上下限设置"),
    SET_FANGJIN_COLLECTION_CYCLE("SET_FANGJIN_COLLECTION_CYCLE", "采集频率设置"),
    SET_CHENAN_VALVEWELL_QUERY_CONFIG("SET_CHENAN_VALVEWELL_QUERY_CONFIG", "查询参数"),
    SET_CHENAN_VALVEWELL_SET_CONFIG("SET_CHENAN_VALVEWELL_SET_CONFIG", "设置参数"),
    SET_FANGJIN_ADDRESS("SET_FANGJIN_ADDRESS", "设置ip地址"),
    SET_DAY_COLLECTION_CONFIG("161", "设置每日采样请求"),
    GET_DAY_COLLECTION_CONFIG("162", "获取每日采样请求"),
    SET_AUTO_ALARM_CONFIG("186", "设置自动报警参数请求"),
    SDK_SEND("SDK", "SDK模式下发指令"),
    SET_VALVE_TIME("0610", "设置阀门时间"),
    SET_CIM_DATA("SET_CIM_DATA", "采集点配置指令下发"),
    SET_REGULATINGVALVE_SEND_DOWN("LoRaRegulatingValve#01#5B", "Lora调节阀下发"),
    SET_REGULATINGVALVE_TIMING("LoRaRegulatingValve#01#5D", "Lora调节阀校时"),
    SET_REGULATINGVALVE_OTHER("LoRaRegulatingValve#01#6B", "回水温度控制/学习阀/自清洁功能指令下发");

    private String commandCode;
    private String commandDesc;

    public static CommandEnum getDesc(String commandCode) {
        Optional<CommandEnum> first = Arrays.stream(values()).filter((t) -> {
            return t.commandCode.equals(commandCode);
        }).findFirst();
        return first.isPresent() ? (CommandEnum)first.get() : null;
    }

    public String getCommandCode() {
        return this.commandCode;
    }

    public String getCommandDesc() {
        return this.commandDesc;
    }

    private CommandEnum(final String commandCode, final String commandDesc) {
        this.commandCode = commandCode;
        this.commandDesc = commandDesc;
    }
}
