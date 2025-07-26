package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.Map;

/**
 * @author hanyilong@enn.cn
 */
@Data
public class HttpRequestMapping {
    String upordown;
    String url;
    String method;
    String productId;
    String serverId;
    float timeout;
    float scanPeriod;
    Map<String, String> httpHeaders;
    Map<String, String> content;
}
