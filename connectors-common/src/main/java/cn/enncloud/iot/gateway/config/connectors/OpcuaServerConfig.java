package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class OpcuaServerConfig {
    String endpointUrl;
    String username;
    String password;
    String description;
    int intervalMinute;
    ProtocolConfig protocol;
}