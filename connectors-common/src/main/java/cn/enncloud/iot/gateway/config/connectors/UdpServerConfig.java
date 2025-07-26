package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class UdpServerConfig {
    int port;
    String description;
    String logLevel = "warn";
    ProtocolConfig protocol;
}