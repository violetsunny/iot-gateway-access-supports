package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.Map;

@Data
public class TcpClientConfig {

    /**
     * 远端地址
     */
    private String remoteAddress;

    /**
     * 远端端口
     */
    private int remotePort;

    /**
     * 解码器类型
     */
    private String parserType;

    /**
     * 解码器参数
     */
    private Map<String, Object> parserParams;

    /**
     * 是否重连
     */
    private boolean reconnectEnabled = true;

    /**
     * 重连间隔，单位：秒
     */
    private long reconnectInterval = 5;


    /**
     * worker线程池默认线程数
     */
    private int workerGroupThread = 0;

    /**
     * 日志级别
     */
    private String logLevel = "warn";

    /**
     * 协议
     */
    ProtocolConfig protocol;

    /**
     * 心跳间隔，单位：秒，设置为0时，不发送
     */
    private int heartbeatInterval = 120;
}
