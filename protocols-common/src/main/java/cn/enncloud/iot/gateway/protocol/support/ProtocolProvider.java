package cn.enncloud.iot.gateway.protocol.support;

import cn.enncloud.iot.gateway.protocol.Protocol;

public interface ProtocolProvider {

    String getName();
    Protocol getProtocol(byte[] bytes, Object params);

}
