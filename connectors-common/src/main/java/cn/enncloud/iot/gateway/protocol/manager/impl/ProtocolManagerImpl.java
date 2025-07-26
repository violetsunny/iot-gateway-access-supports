package cn.enncloud.iot.gateway.protocol.manager.impl;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.exception.BizException;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.cache.ProtocolCache;
import cn.enncloud.iot.gateway.protocol.enums.ProtocolTypeEnum;
import cn.enncloud.iot.gateway.protocol.loader.ProtocolInitializer;
import cn.enncloud.iot.gateway.protocol.manager.ProtocolManager;
import cn.enncloud.iot.gateway.protocol.supports.ProtocolActionListener;
import cn.enncloud.iot.gateway.protocol.supports.ProtocolProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ProtocolManagerImpl implements ProtocolManager {

    private static final ConcurrentHashMap<String, Protocol> PROTOCOL_INSTANCES = new ConcurrentHashMap<>();

    private final Map<String, ProtocolInitializer> initializerProviders = new HashMap<>();

    private final ProtocolCache protocolCache;


    public final ProtocolActionListener protocolActionListener;


    public final Executor executor;


    public ProtocolManagerImpl(ProtocolCache protocolCache) {
        this(protocolCache, null, null);
    }


    public ProtocolManagerImpl(ProtocolCache protocolCache, ProtocolActionListener protocolActionListener, Executor executor) {
        this.protocolCache = protocolCache;
        this.protocolActionListener = protocolActionListener;
        this.executor = executor;
    }


    @Override
    public boolean isSupported(String name) {
        return PROTOCOL_INSTANCES.containsKey(name);
    }

    @Override
    public Protocol get(String id) {
        return PROTOCOL_INSTANCES.get(id);
    }

    @Override
    public Collection<Protocol> getAll() {
        return PROTOCOL_INSTANCES.values();
    }

    @Override
    public Protocol register(ProtocolConfig protocolConfig) {
        Assert.notNull(protocolConfig, "protocolConfig must not null");
        Assert.notNull(protocolConfig.getName(), "protocolConfig.name must not null");
        ProtocolInitializer initializer = initializerProviders.get(protocolConfig.getType());
        try {
            Protocol protocol = initializer.init(protocolConfig);
            if (protocolConfig.isActionListenerEnabled() && protocolActionListener != null) {
                protocol = new ProtocolProxy(protocolConfig, protocol, protocolActionListener, executor);
            }
            if(protocol!=null){
                log.info("{} {} 协议加载成功！",protocolConfig.getName(),protocolConfig.getType());
                PROTOCOL_INSTANCES.put(protocolConfig.getName(), protocol);
            }
            return protocol;
        } catch (Exception e) {
            throw new BizException("协议加载异常，" + e.getMessage());
        }
    }

    @Override
    public Protocol register(String id, String mainClass, String path, Map<String, Object> params, boolean flag) {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setType(ProtocolTypeEnum.JAR.getName());
        protocolConfig.setMainClass(mainClass);
        protocolConfig.setPath(path);
        protocolConfig.setName(id);
        protocolConfig.setParams(params);
        return register(protocolConfig);
    }

    @Override
    public Protocol register(ProtocolConfig protocolConfig, Executor executor, long timeout) {
        CompletableFuture<Protocol> future = CompletableFuture.supplyAsync(() -> register(protocolConfig), executor);
        try {
            return future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error("register protocol " + protocolConfig.getPath() + " timeout,{}", e.getMessage());
        }
        return null;
    }

    @Override
    public Protocol register(Protocol protocol) {
        Assert.notNull(protocol, "protocol is null, make sure protocol init success");
        PROTOCOL_INSTANCES.put(protocol.getId(), protocol);
        return protocol;
    }

    @Override
    public void deregister(String id) {
        PROTOCOL_INSTANCES.remove(id);
        protocolCache.remove(id);
    }

    @Override
    public void addProtocolInitializer(String type, ProtocolInitializer initializer) {
        this.initializerProviders.put(type, initializer);
    }
}
