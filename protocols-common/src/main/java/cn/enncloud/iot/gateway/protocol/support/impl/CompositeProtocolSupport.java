package cn.enncloud.iot.gateway.protocol.support.impl;

import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.support.ProtocolSupport;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Setter
@Getter
public class CompositeProtocolSupport implements ProtocolSupport {

    private String id;

    private String name;

    private String description;

    @Getter(AccessLevel.PRIVATE)
    private final Map<String, Protocol> messageCodecSupports = new ConcurrentHashMap<>();


    public void addMessageCodecSupport(Protocol protocolCodec) {
        messageCodecSupports.put(Optional.ofNullable(protocolCodec.getId()).orElse("defaultId"), protocolCodec);
    }

    @Override
    public void close() {
        messageCodecSupports.clear();
    }

    @Override
    public Protocol getMessageCodec(String protocolId) {

        Protocol protocol = messageCodecSupports.get(protocolId);
        if (Objects.isNull(protocol)) {

            String first = messageCodecSupports.keySet().stream().findFirst().orElse("");
            protocol = messageCodecSupports.get(first);
        }
        return protocol;
    }
}
