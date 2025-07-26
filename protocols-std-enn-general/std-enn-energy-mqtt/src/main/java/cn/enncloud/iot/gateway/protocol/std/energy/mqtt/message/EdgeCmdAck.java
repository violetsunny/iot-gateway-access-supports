package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

@Data
public class EdgeCmdAck extends MessageHeader {


    private String code;

}
