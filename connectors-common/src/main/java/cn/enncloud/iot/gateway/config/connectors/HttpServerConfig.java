package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.List;

@Data
public class HttpServerConfig {
    String appid;
    String server;
    String description;
    String productId;
//    int intervalMinute;
    String cron;
//    HttpRequestServerAuth security;
//    List<HttpRequestMapping> mapping;
    ProtocolConfig protocol;
    String jobType;
}