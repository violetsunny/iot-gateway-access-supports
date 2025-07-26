package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

/**
 * @author hanyilong@enn.cn
 */

@Data
public class CtwingServerConfig {
    String server;
    String tenantId;
    String token;
    String topic;
    String description;
    ProtocolConfig protocol;
}
