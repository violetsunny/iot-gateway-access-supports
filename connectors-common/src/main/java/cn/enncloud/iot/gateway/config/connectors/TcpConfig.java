package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@ConfigurationProperties(prefix = "ennwiot.connector-tcp")
@Data
public class TcpConfig {


    private TcpServerConnectorConfig server;

    private TcpClientConnectorConfig client;



    @Getter
    @Setter
    public static class TcpServerConnectorConfig extends ConnectorConfig {
        private List<TcpServerConfig> configuration;

    }

    @Getter
    @Setter
    public static class TcpClientConnectorConfig extends ConnectorConfig {
        private List<TcpClientConfig> configuration;
    }
}
