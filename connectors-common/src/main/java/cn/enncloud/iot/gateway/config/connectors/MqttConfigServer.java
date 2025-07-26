package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.List;

@Data
public class MqttConfigServer {
    String clientId;
    String host;
    int port;
    String password;
    String username;
    String tls;
    String tlsCert;
    String tlsKey;
    int qos;
    List<String> topics;
    ProtocolConfig protocol;


    long reconnectDelay = 10;

    boolean reconnectEnabled = true;

    int messageMaxBytes = 110000;

    String runMode = "common";

    public String uuid() {
        return clientId+host+port;
    }
}
