package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.Map;

@Data
public class TcpServerConfig {
    /**
     * 地址
     */
    String address = "0.0.0.0";

    /**
     * 端口
     */
    int port;

    /**
     * 缓冲区
     */
    int bufferSize;

    /**
     * 描述信息
     */
    String description;

    /**
     * 协议
     */
    ProtocolConfig protocol;

    /**
     * boss线程池线程数
     */
    private int bossGroupThread = 1;

    /**
     * worker线程池线程数
     */
    private int workerGroupThread = 0;

    /**
     * 解码器类型
     */
    private String parserType;

    /**
     * 解码器参数
     */
    private Map<String, Object> parserParams;

    /**
     * 心跳间隔，单位：秒，设置为0时，不检测。
     */
    private int heartbeatInterval = 120;

    /**
     * 日志级别
     */
    private String logLevel = "warn";
}