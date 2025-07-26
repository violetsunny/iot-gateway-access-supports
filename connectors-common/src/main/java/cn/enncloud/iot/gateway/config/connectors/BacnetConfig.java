package cn.enncloud.iot.gateway.config.connectors;


import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
@ConfigurationProperties(prefix = "ennwiot.connector-bacnet")
@Data
public class BacnetConfig extends ConnectorConfig {
    private List<BacnetServerConfig> configuration;

}
