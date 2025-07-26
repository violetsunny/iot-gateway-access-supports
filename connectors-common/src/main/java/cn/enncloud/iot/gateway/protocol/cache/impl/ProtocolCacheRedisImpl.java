package cn.enncloud.iot.gateway.protocol.cache.impl;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.protocol.cache.ProtocolCache;
import cn.enncloud.iot.gateway.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProtocolCacheRedisImpl implements ProtocolCache {

    public static final String CACHEKEY = "ennew__protocol_supports_std";
    public static final String PROTOCOL_TOPIC = "ennew_protocol_changed";

    @Autowired
    private RedisService redisService;

    @Override
    public void save(ProtocolConfig protocolConfig) {
        redisService.putHash(CACHEKEY, protocolConfig.getName(), protocolConfig);
        redisService.publish(PROTOCOL_TOPIC, protocolConfig);
    }

    @Override
    public void remove(String id) {
        redisService.deleteHash(CACHEKEY, id);
    }

    @Override
    public List<Object> getAll() {
        return new ArrayList<>(redisService.getHashEntries(CACHEKEY).values());
    }
}
