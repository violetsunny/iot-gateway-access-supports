package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "ennwiot.connector-opcua-asyncio")
@Data
public class OpcuaAsyncioConfig extends ConnectorConfig {
    String type;
    String name;
    private List<OpcuaServerConfig> configuration;


}
