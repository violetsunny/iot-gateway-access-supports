package cn.enncloud.iot.gateway.protocol.support;


import cn.enncloud.iot.gateway.protocol.Protocol;

import java.io.Closeable;

public interface ProtocolSupport extends Closeable {

    String getId();

    String getName();

    String getDescription();

    Protocol getMessageCodec(String protocolId);
}
