package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class SnmpServerConfig {
    String address;
    String port;
    int retry;
    int timeout;
    int intervalMinute;
    String version;
    String description;
    ProtocolConfig protocol;

}