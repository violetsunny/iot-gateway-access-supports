package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

/**
 * @author hanyilong@enn.cn
 */
@Data
public class HttpRequestServerAuth {
    String type;
    String url;
    String username;
    String password;
    String appid;
    String token;
    String method;
}
