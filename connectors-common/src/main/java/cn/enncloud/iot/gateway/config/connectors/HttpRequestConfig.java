package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "ennwiot.connector-request")
@Data
public class HttpRequestConfig extends ConnectorConfig {
    String type;
    String name;
    String jobType;
    List<HttpServerConfig> configuration;
}
