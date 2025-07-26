package com.ennewiot.gateway.industrialalarm.protocol;

import cn.enncloud.iot.gateway.protocol.ProtocolSupportProvider;
import cn.enncloud.iot.gateway.protocol.support.ProtocolSupport;
import cn.enncloud.iot.gateway.protocol.support.impl.CompositeProtocolSupport;
import cn.enncloud.iot.gateway.utils.SpringContextUtil;

//@Slf4j
public class NbAlarmProtocolProvider implements ProtocolSupportProvider {
    @Override
    public ProtocolSupport create(SpringContextUtil context) {
        CompositeProtocolSupport support = new CompositeProtocolSupport();
        support.setId("demo.v1.0");
        support.setName("Demo V1.0");
        support.setDescription("Demo Protocol Version 1.0");
        support.addMessageCodecSupport(new NbAlarmDevMessageCodec());
        return support;
    }

    @Override
    public void close() {

    }
}
