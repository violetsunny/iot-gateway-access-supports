package cn.enncloud.iot.gateway.datacenter.enums;

import java.util.Arrays;
import java.util.Optional;

public enum FunctionMetricEnum {

    POWER_ALL("1","正向有功总",""),
    POWER_ALL_01("101","正向有功总","Eptp"),
    POWER_ALL_02("102","反向有功总","Eptn"),
    POWER_ALL_03("103","正向无功总","Eqtp"),
    POWER_ALL_04("104","反向无功总","Eqtn"),

    WATER_FLOW("2","水累计流量",""),
    WATER_FLOW_01("201","水累计流量","FInt"),
    WATER_FLOW_02("202","水瞬时流量",""),

    GAS_FLOW("3","燃气累计流量","FstdCCFA"),

    HEAT_FLOW("4","热累计流量","PWheatInt"),

    VOLTAGE("5","电压",""),
    VOLTAGE_01("501","A相","Ua"),
    VOLTAGE_02("502","B相","Ub"),
    VOLTAGE_03("503","C相","Uc"),


    CURRENT("6","电流",""),
    CURRENT_01("601","A相","Ia"),
    CURRENT_02("602","B相","Ib"),
    CURRENT_03("603","C相","Ic"),
    CURRENT_04("604","总",""),

    ACTIVE_POWER("7","有功功率","P"),
    ACTIVE_POWER_01("701","A相","Pa"),
    ACTIVE_POWER_02("702","B相","Pb"),
    ACTIVE_POWER_03("703","C相","Pc"),
    ACTIVE_POWER_04("704","总",""),


    REACTIVE_POWER("8","无功功率","Q"),
    REACTIVE_POWER_01("801","A相","Qa"),
    REACTIVE_POWER_02("802","B相","Qb"),
    REACTIVE_POWER_03("803","C相","Qc"),
    REACTIVE_POWER_04("804","总",""),

    POWER_FACTOR("9","功率因数","COS"),
    POWER_FACTOR_01("901","A相","COSa"),
    POWER_FACTOR_02("902","B相","COSb"),
    POWER_FACTOR_03("903","C相","COSc"),
    POWER_FACTOR_04("904","总",""),

    TIP_CHARGE_POWER("10","尖电量正向有功",""),
    TIP_CHARGE_POWER_01("1001","尖电量正向有功","Epsp"),
    TIP_CHARGE_POWER_02("1002","尖电量反向有功","Epsn"),
    TIP_CHARGE_POWER_03("1003","尖电量正向无功","Eqsp"),
    TIP_CHARGE_POWER_04("1004","尖电量反向无功","Eqsn"),

    PEAK_CHARGE_POWER("11","尖电量正向有功",""),
    PEAK_CHARGE_POWER_01("1101","峰电量正向有功","Eppp"),
    PEAK_CHARGE_POWER_02("1102","峰电量反向有功","Eppn"),
    PEAK_CHARGE_POWER_03("1103","峰电量正向无功","Eqpp"),
    PEAK_CHARGE_POWER_04("1104","峰电量反向无功","Eqpn"),

    FLAT_CHARGE_POWER("12","正向有功总",""),
    FLAT_CHARGE_POWER_01("1201","平电量正向有功","Epfp"),
    FLAT_CHARGE_POWER_02("1202","平电量反向有功","Epfn"),
    FLAT_CHARGE_POWER_03("1203","平电量正向无功","Eqfp"),
    FLAT_CHARGE_POWER_04("1204","平电量反向无功","Eqfn"),

    VALLEY_CHARGE_POWER("13","谷电量正向有功",""),
    VALLEY_CHARGE_POWER_01("1301","谷电量正向有功","Epbp"),
    VALLEY_CHARGE_POWER_02("1302","谷电量反向有功","Epbn"),
    VALLEY_CHARGE_POWER_03("1303","谷电量正向无功","Eqbp"),
    VALLEY_CHARGE_POWER_04("1304","谷电量反向无功","Eqbn"),

    TOTAL_CHARGE_POWER("14","总电量正向有功最大值",""),
    TOTAL_CHARGE_POWER_01("1401","总电量正向有功最大值",""),
    TOTAL_CHARGE_POWER_02("1402","总电量正向有功最大值发生时间",""),
    TOTAL_CHARGE_POWER_03("1403","总电量反向有功最大值",""),
    TOTAL_CHARGE_POWER_04("1404","总电量反向有功最大值发生时间",""),
    TOTAL_CHARGE_POWER_05("1405","总电量正向无功最大值",""),
    TOTAL_CHARGE_POWER_06("1406","总电量正向无功最大值发生时间",""),
    TOTAL_CHARGE_POWER_07("1407","总电量反向无功最大值",""),
    TOTAL_CHARGE_POWER_08("1408","总电量反向无功最大值发生时间",""),

    METER_EVENT("16","表计事件",""),
    METER_EVENT_01("1601","事件ID号",""),
    METER_EVENT_02("1602","最近一次事件发生时间","");


    private final String code;

    private final String name;

    private final String metric;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getMetric() {
        return metric;
    }

    FunctionMetricEnum(String code, String name, String metric) {
        this.code = code;
        this.name = name;
        this.metric = metric;
    }


    public static FunctionMetricEnum getFunctionMetricEnum(String code) {

        Optional<FunctionMetricEnum> first = Arrays.stream(FunctionMetricEnum.values()).filter(metricEnum -> metricEnum.code.equals(code)).findFirst();
        return first.orElse(null);
    }

}
