package cn.enncloud.iot.gateway.datacenter.dto;

@lombok.Data
public class Data {

    private String operation;

    private String sequence;

    private String parse;

    private String time;
    private String total;
    private String current;

    private String meter;
}
