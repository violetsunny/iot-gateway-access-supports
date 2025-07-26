package cn.enncloud.iot.gateway.protocol.loader;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.enums.ProtocolTypeEnum;

public interface ProtocolInitializer {

    /**
     * 协议类型
     *
     * @return 协议类型枚举
     */
    ProtocolTypeEnum type();


    /**
     * 初始化协议
     *
     * @param protocolConfig 协议配置
     * @return 协议实例
     * @throws Exception 初始化异常
     */
    Protocol init(ProtocolConfig protocolConfig) throws Exception;
}
