package cn.enncloud.iot.gateway.config;

import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.List;

@ConfigurationProperties(prefix = "ennwiot")
@Data
public class ConnectorProperties {

    private String serverId;

    @PostConstruct
    @SneakyThrows
    public void init() {
        if (serverId == null) {
            serverId = InetAddress.getLocalHost().getHostName();
        }
    }
}