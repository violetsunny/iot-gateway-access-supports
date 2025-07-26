package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

@Data
public class MessageHeader {

    private String devtype;


    private String sysId;


    private String seq;


    private String ack;


    private String ts;
}
