package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ennwiot.connector-coap")
@Data
public class CoapConfig extends ConnectorConfig {
    int port;

}
