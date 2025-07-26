package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

@Data
public class ModbusServerConfig {

    private String clientId;
    private String gatewayCode;
    private String pointDTOSPath;
    private String pointMapDTOSPath;

    private String host;

    private Integer port;


    /**
     * 读取间隔 秒
     */
    private Integer readDiff;

    /**
     * 最大重试次数
     */
    private Integer maxRetries;
    /**
     * 重连间隔 秒
     */
    private Integer retryDelay;

    /**
     * 连接超时时间
     */
    private Integer connectTimeout;
}
