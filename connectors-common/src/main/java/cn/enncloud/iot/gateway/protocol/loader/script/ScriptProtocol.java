package cn.enncloud.iot.gateway.protocol.loader.script;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.BizException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.protocol.Protocol;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONValidator;
import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class ScriptProtocol implements Protocol {

    /**
     * JDK内置JavaScript引擎
     */
    private static final String ENGINE_NAME = "Nashorn";
    private static final String DEFAULT_ID_NAME_PREFIX = "script-";

    private static final String JS_LOGGER = "$log";

    private static final String JS_DEVICE_CONTEXT = "$ctx";

    private static final String JS_PROTOCOL_PARAMS = "$params";

    private final ScriptEngine scriptEngine;
    private final String defaultIdName;
    private DeviceContext deviceContext;
    private Map<String, Object> params;

    private Function<Object, String> decodeFunction;

    private Function<Object, byte[]> encodeFunction;

    private ScriptFunction<Object, Object, String> decodeMultiFunction;

    private ScriptFunction<Object, Object, Object> encodeMultiFunction;


    public ScriptProtocol(String script) throws ScriptException {
        this(script, true);
    }

    public ScriptProtocol(String script, boolean jsonSerializableEnabled) throws ScriptException {
        scriptEngine = new ScriptEngineManager().getEngineByName(ENGINE_NAME);
        log.debug("load script: \n{}", script);
        scriptEngine.put(JS_LOGGER, log);
        scriptEngine.put("codec", this);
        scriptEngine.eval(script);
        defaultIdName = DEFAULT_ID_NAME_PREFIX + UUID.randomUUID();
    }


    @Override
    public String getId() {
        return defaultIdName;
    }

    @Override
    public String getName() {
        return defaultIdName;
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        if(decodeFunction == null){
            throw new DecodeMessageException(DecodeMessageException.SCRIPT_INVOKE_ERROR, "脚本中未实现codec.decode(function(msg,params){})函数");
        }
        try {
            String text = new String(messageBytes);
            String result = decodeFunction.apply(text);
            List<Message> messageList = ScriptResultTransformer.transform(result);
            if (messageList != null && messageList.size() > 0) {
                return messageList.get(0);
            }
            return null;
        } catch (Throwable e) {
            throw new DecodeMessageException(DecodeMessageException.SCRIPT_INVOKE_ERROR, e.getMessage());
        }
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        if(decodeMultiFunction == null){
            throw new DecodeMessageException(DecodeMessageException.SCRIPT_INVOKE_ERROR, "脚本中未实现codec.decodeMulti(function(msg,params){})函数");
        }
        try {
            String text = new String(messageBytes);
            Object result = decodeMultiFunction.execute(text, params);
            return ScriptResultTransformer.transform(result);
        } catch (Throwable e) {
            throw new DecodeMessageException(DecodeMessageException.SCRIPT_INVOKE_ERROR, e.getMessage());
        }
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        if(encodeFunction == null){
            throw new EncodeMessageException("脚本中未实现codec.encode(function(msg,params){})函数");
        }
        try {
            return encodeFunction.apply(message);
        } catch (Throwable e) {
            throw new EncodeMessageException(e.getMessage());
        }
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        if(encodeMultiFunction == null){
            throw new EncodeMessageException("脚本中未实现codec.encodeMulti(function(msg,params){})函数");
        }
        try {
            String execute = (String) encodeMultiFunction.execute(JSON.toJSONString(messages), null);
            return execute.getBytes(StandardCharsets.UTF_8);
        } catch (Throwable e) {
            throw new EncodeMessageException(e.getMessage());
        }
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        throw new BizException("unsupported method");
    }

    @Override
    public void setDeviceContext(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
        scriptEngine.put(JS_DEVICE_CONTEXT, deviceContext);
    }

    @Override
    public DeviceContext getDeviceContext() {
        return this.deviceContext;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
        scriptEngine.put(JS_PROTOCOL_PARAMS, params);
    }


    public void decoder(Function<Object, String> func) {
        this.decodeFunction = func;
    }


    public void encoder(Function<Object, byte[]> func) {
        this.encodeFunction = func;
    }

    public void decodeMulti(ScriptFunction<Object, Object, String> func) {
        this.decodeMultiFunction = func;
    }

    public void encodeMulti(ScriptFunction<Object, Object, Object> func) {
        this.encodeMultiFunction = func;
    }

}
