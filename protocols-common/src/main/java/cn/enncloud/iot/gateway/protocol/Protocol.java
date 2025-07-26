package cn.enncloud.iot.gateway.protocol;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;

import java.util.List;
import java.util.Map;

public interface Protocol {

    String getId();

    String getName();

    Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException;
    List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException;

    byte[] encode(Message message, Object... params) throws EncodeMessageException;

    byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException;

    boolean login(LoginRequest loginRequest) throws AuthException;

    void setDeviceContext(DeviceContext deviceContext);
    DeviceContext getDeviceContext();

    Map<String, Object> getParams();
    void setParams(Map<String, Object> params);
}
