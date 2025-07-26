package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

import java.util.Map;

@Data
public class CloudDownCmd {

    private String devtype;

    private String seq;


    private String ts;


    private Map<String, String> parameter;


    private Map<String, String> payload;



}
