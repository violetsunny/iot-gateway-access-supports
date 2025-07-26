package cn.enncloud.iot.gateway.config.connectors;

import cn.enncloud.iot.gateway.config.ConnectorConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "ennwiot.connector-modbus")
@Data
public class ModbusConfig extends ConnectorConfig {
    List<ModbusServerConfig> configuration;
}
