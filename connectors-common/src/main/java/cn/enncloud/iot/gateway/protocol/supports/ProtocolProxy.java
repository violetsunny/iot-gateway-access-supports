package cn.enncloud.iot.gateway.protocol.supports;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.protocol.Protocol;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Slf4j
public class ProtocolProxy implements Protocol {

    private final ProtocolConfig protocolConfig;
    private final Protocol protocol;
    private final ProtocolActionListener listener;
    private final Executor executor;
    private final boolean proxyEnabled;
    private final boolean asyncEnabled;


    public ProtocolProxy(ProtocolConfig config, Protocol protocol, ProtocolActionListener listener, Executor executor) {
        this.protocolConfig = config;
        this.protocol = protocol;
        this.listener = listener;
        this.executor = executor;
        this.proxyEnabled = listener != null;
        this.asyncEnabled = executor != null;
    }


    @Override
    public String getId() {
        return protocol.getId();
    }

    @Override
    public String getName() {
        return protocol.getName();
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        Message decode = null;
        try {
             decode = protocol.decode(messageBytes, params);
        }catch (Throwable t){
            listener.onException(t);
            throw t;
        }
        afterDecode(protocolConfig.getBinaryLogType(), messageBytes, Collections.singletonList(decode));
        return decode;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        List<? extends Message> messages = null;
        try {
            messages = protocol.decodeMulti(messageBytes, params);
        }catch (Throwable t){
            listener.onException(t);
            throw t;
        }
        afterDecode(protocolConfig.getBinaryLogType(), messageBytes, messages);
        return messages;
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        byte[] encode = null;
        try {
            encode = protocol.encode(message);
        }catch (Throwable t){
            listener.onException(t);
            throw t;
        }
        afterEncode(protocolConfig.getBinaryLogType(), Collections.singletonList(message), encode);
        return encode;
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        byte[] encode = null;
        try {
            encode = protocol.encodeMulti(messages);
        }catch (Throwable t){
            listener.onException(t);
            throw t;
        }
        afterEncode(protocolConfig.getBinaryLogType(), messages, encode);
        return encode;
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return protocol.login(loginRequest);
    }

    @Override
    public void setDeviceContext(DeviceContext deviceContext) {
        protocol.setDeviceContext(deviceContext);
    }

    @Override
    public DeviceContext getDeviceContext() {
        return protocol.getDeviceContext();
    }

    @Override
    public Map<String, Object> getParams() {
        return protocol.getParams();
    }

    @Override
    public void setParams(Map<String, Object> params) {
        protocol.setParams(params);
    }


    private void afterDecode(String binaryType, byte[] bs, List<? extends  Message> messages){
        if(!proxyEnabled){
            return;
        }
        if(asyncEnabled){
            executor.execute(() -> executeAfterDecode(binaryType, bs, messages));
            return;
        }
        executeAfterDecode(binaryType, bs, messages);
    }


    private void afterEncode(String binaryType, List<? extends  Message> messages, byte[] bytes){
        if(!proxyEnabled){
            return;
        }
        if(asyncEnabled){
            executor.execute(() -> executeAfterEncode(binaryType, messages, bytes));
        }
        executeAfterEncode(binaryType, messages, bytes);
    }



    private void executeAfterDecode(String binaryType, byte[] bs, List<? extends  Message> messages){
        try {
            listener.afterDecode(binaryType, bs, messages);
        }catch (Exception e){
            log.error("protocolActionListener afterDecode method execute error", e);
        }
    }


    private void executeAfterEncode(String binaryType, List<? extends  Message> messages, byte[] bytes){
        try {
            listener.afterEncode(binaryType, messages, bytes);
        }catch (Exception e){
            log.error("protocolActionListener afterEncode method execute error", e);
        }
    }
}
