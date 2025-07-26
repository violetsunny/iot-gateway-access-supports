package cn.enncloud.iot.gateway.protocol;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.entity.tsl.ProductTsl;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractProtocol implements Protocol{
    protected  ProductTsl productTsl;
    protected DeviceContext deviceContext;
    protected Map params = new HashMap();

    public DeviceContext getDeviceContext() {
        return deviceContext;
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        return null;
    }

    public void setDeviceContext(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
