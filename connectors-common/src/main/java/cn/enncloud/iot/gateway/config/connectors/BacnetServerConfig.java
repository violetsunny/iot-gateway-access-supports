package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class BacnetServerConfig {

    String localBindAddress;

    String subnetAddress;

    int port;

    String remoteAddress;

    int remotePort;

    int networkPrefixLength;

    int retry;

    int timeout;

    int intervalMinute;

    int deviceNumber;

    int baId;

    String cron;

    String version;

    String description;

    ProtocolConfig protocol;

    String tablePath;
}