package cn.enncloud.iot.gateway.datacenter.dto;

import lombok.Data;

@Data
public class Operation {

    private String operation;

    private String sequence;
    private String md5;
    private String time;
}
