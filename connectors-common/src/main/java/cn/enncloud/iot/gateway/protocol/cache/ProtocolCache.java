package cn.enncloud.iot.gateway.protocol.cache;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;

import java.util.List;

public interface ProtocolCache {

    void save(ProtocolConfig protocolConfig);

    void remove(String id);

    List<Object> getAll();
}
