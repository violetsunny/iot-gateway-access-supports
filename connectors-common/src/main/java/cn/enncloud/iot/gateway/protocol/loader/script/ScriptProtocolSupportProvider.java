//package cn.enncloud.iot.gateway.protocol.loader.script;
//
//import cn.enncloud.iot.gateway.context.DeviceContext;
//import cn.enncloud.iot.gateway.exception.DecodeMessageException;
//import cn.enncloud.iot.gateway.exception.EncodeMessageException;
//import cn.enncloud.iot.gateway.message.LoginRequest;
//import cn.enncloud.iot.gateway.message.Message;
//import cn.enncloud.iot.gateway.message.MetricReportRequest;
//import cn.enncloud.iot.gateway.message.OperationResponse;
//import cn.enncloud.iot.gateway.message.enums.MessageType;
//import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
//import cn.enncloud.iot.gateway.protocol.ProtocolSupportProvider;
//import cn.enncloud.iot.gateway.protocol.dto.ProtocolSupportDefinition;
//import cn.enncloud.iot.gateway.protocol.support.ProtocolSupport;
//import cn.enncloud.iot.gateway.protocol.support.impl.CompositeProtocolSupport;
//import cn.enncloud.iot.gateway.utils.SpringContextUtil;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Maps;
//import lombok.SneakyThrows;
//import org.apache.commons.lang3.StringUtils;
//import org.hswebframework.expands.script.engine.DynamicScriptEngine;
//import org.hswebframework.expands.script.engine.DynamicScriptEngineFactory;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.function.BiFunction;
//
//public class ScriptProtocolSupportProvider implements ProtocolSupportProvider {
//
//    private ProtocolSupportDefinition definition;
//
//    private BiFunction<String,Object[], String>  decodeFunc;
//    private BiFunction<Message,Object[], String> encodeFunc;
//    private BiFunction<String,Object[], String>  decodeFuncMulti;
//
//    public ScriptProtocolSupportProvider(ProtocolSupportDefinition definition) {
//        this.definition = definition;
//    }
//
//    @Override
//    @SneakyThrows
//    public ProtocolSupport create(SpringContextUtil context) {
//        CompositeProtocolSupport support = new CompositeProtocolSupport();
//        support.setId(definition.getId());
//        support.setName(definition.getName());
//        support.setDescription(definition.getDescription());
//
//        Map<String, Object> configs = definition.getConfiguration();
//        String scriptContent = (String) configs.get("script");
//        String lang = (String) configs.get("lang");
//        if (StringUtils.isBlank(lang)) {
//            lang = "js";
//        }
//        DynamicScriptEngine engine = DynamicScriptEngineFactory.getEngine(lang);
//        engine.compile("handle", scriptContent);
//        Map<String, Object> ctx = Maps.newHashMap();
//        ctx.put("codec", this);
//        ctx.put("logger", LoggerFactory.getLogger("message.handler"));
//        DeviceContext deviceContext = context.getBean("deviceContext");
//
//        ctx.put("deviceContext", deviceContext);
//        ctx.put("$log", LoggerFactory.getLogger("message.handler"));
//        ctx.put("$ctx", deviceContext);
//
//
//        engine.execute("handle", ctx).getIfSuccess();
//
//        {
//            AbstractProtocol codec = new AbstractProtocol() {
//
//                @Override
//                public String getId() {
//                    return "Script";
//                }
//
//                @Override
//                public String getName() {
//                    return "Script解析";
//                }
//
//                @Override
//                public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
//                    String message  = new String(messageBytes);
//                    String msg = decodeFunc.apply(message,params);
//                    MessageType messageType = MessageType.valueOf(JSONObject.parseObject(msg).get("messageType").toString());
//                    switch (messageType) {
//                        case DEVICE_LOGIN_REQ:
//                            return JSONObject.parseObject(msg, LoginRequest.class);
//                        case DEVICE_REPORT_REQ:
//                            return JSONObject.parseObject(msg, MetricReportRequest.class);
//                        case CLOUD_OPERATION_RSP:
//                            return JSONObject.parseObject(msg, OperationResponse.class);
//                    }
//                    return null;
//                }
//
//                @Override
//                public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
//                    String message  = new String(messageBytes);
//                    String msgs = decodeFuncMulti.apply(message,params);
//                    if(StringUtils.isBlank(msgs) || !msgs.startsWith("[")){
//                        return null;
//                    }
//                    List<Message> messages = new ArrayList<>();
//                    JSONArray jsonArray = JSONObject.parseArray(msgs);
//                    for(Object obj:jsonArray){
//                        String msg = JSONObject.toJSONString(obj);
//                        MessageType messageType = MessageType.valueOf(JSONObject.parseObject(msg).get("messageType").toString());
//                        switch (messageType) {
//                            case DEVICE_LOGIN_REQ:
//                                messages.add(JSONObject.parseObject(msg, LoginRequest.class));
//                                break;
//                            case DEVICE_REPORT_REQ:
//                                messages.add(JSONObject.parseObject(msg, MetricReportRequest.class));
//                                break;
//                            case CLOUD_OPERATION_RSP:
//                                messages.add(JSONObject.parseObject(msg, OperationResponse.class));
//                                break;
//                        }
//                    }
//                    return messages;
//                }
//
//                @Override
//                public byte[] encode(Message message, Object... params) throws EncodeMessageException {
////                    String sn = getDeviceContext().getSnByDeviceId(message.getDeviceId());
////                    if(StringUtils.isBlank(sn)){
////                        throw new BizException("没有对应的设备");
////                    }
////                    message.setDeviceId(sn);
////                    message.setMessageType(MessageType.CLOUD_OPERATION_REQ);
////                    return JSONObject.toJSONBytes(message);
//                    String msg = encodeFunc.apply(message,params);
//                    return msg.getBytes();
//                }
//
//                @Override
//                public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
//                    return new byte[0];
//                }
//
//                @Override
//                public boolean login(LoginRequest loginRequest) {
//                    return true;
//                }
//
//
//            };
//
//            codec.setDeviceContext(deviceContext);
//
//            support.addMessageCodecSupport(codec);
//        }
//
//        return support;
//    }
//
//    @Override
//    public void close() throws IOException {
//
//    }
//
//    public void decode(BiFunction<String,Object[], String> decodeFunc) {
//        this.decodeFunc = decodeFunc;
//    }
//
//    public void encode(BiFunction<Message,Object[], String> encodeFunc) {
//        this.encodeFunc = encodeFunc;
//    }
//
//    public void decodeMulti(BiFunction<String,Object[], String> decodeFuncMulti) {
//        this.decodeFuncMulti = decodeFuncMulti;
//    }
//
//}
//
