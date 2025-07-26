package cn.enncloud.iot.gateway.datacenter.dto;

import lombok.Data;

@Data
public class Function {

    private int id;

    private String coding;

    private int error;

    private String sample_time;
    private Object content;
}
