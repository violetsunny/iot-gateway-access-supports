package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class HttpConfigProtocol {
    String requestPath;
    ProtocolConfig protocol;
}
