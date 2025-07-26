package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

import java.util.Map;

@Data
public class EdgeInfoReport extends MessageHeader {


    private Map<String, String> parameter;


}
