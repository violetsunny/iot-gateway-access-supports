package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "ennwiot.connector-ali-mq")
public class AliMqConfig extends ConnectorConfig {

    List<AliMQConsumerConfig> configuration;

}
