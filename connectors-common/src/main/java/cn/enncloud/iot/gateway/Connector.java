package cn.enncloud.iot.gateway;

import cn.enncloud.iot.gateway.protocol.Protocol;

import java.util.Map;

/**
 * @author hanyilong@enn.cn
 */
public interface Connector {
    void init() throws Exception ;
    void setupProtocol(Protocol protocol, Map<String, Object> params);
    Map<String, Object> getStatus();
    default void stop(){};
}
