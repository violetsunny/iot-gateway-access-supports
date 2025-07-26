package cn.enncloud.iot.gateway.protocol;


import cn.enncloud.iot.gateway.protocol.support.ProtocolSupport;
import cn.enncloud.iot.gateway.utils.SpringContextUtil;

import java.io.Closeable;

public interface ProtocolSupportProvider extends Closeable {
    ProtocolSupport create(SpringContextUtil context);
}
