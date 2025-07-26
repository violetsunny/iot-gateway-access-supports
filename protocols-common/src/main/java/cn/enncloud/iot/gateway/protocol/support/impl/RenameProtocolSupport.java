package cn.enncloud.iot.gateway.protocol.support.impl;

import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.support.ProtocolSupport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
public class RenameProtocolSupport implements ProtocolSupport {

    @Getter
    private final String id;

    @Getter
    private final String name;

    @Getter
    private final String description;

    private final ProtocolSupport target;

    @Override
    @SneakyThrows
    public void close() {
        target.close();
    }


    @Override
    public Protocol getMessageCodec(String protocolId) {
        return target.getMessageCodec(protocolId);
    }
}
