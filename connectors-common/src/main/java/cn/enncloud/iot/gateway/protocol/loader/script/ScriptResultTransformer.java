package cn.enncloud.iot.gateway.protocol.loader.script;

import cn.enncloud.iot.gateway.exception.BizException;
import cn.enncloud.iot.gateway.message.DeviceNtpRequest;
import cn.enncloud.iot.gateway.message.EventReportRequest;
import cn.enncloud.iot.gateway.message.InfoReportRequest;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.message.StatusReportRequest;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class ScriptResultTransformer {


    /**
     * 转换JS脚本调用结果为Message，支持返回JSON字符串，JS对象，JS数组
     *
     * @param obj 脚本调用结果
     * @return Message集合
     */
    public static List<Message> transform(Object obj) {
        if(obj == null){
            return Collections.emptyList();
        }
        if (obj instanceof String) {
            return transformJson((String) obj);
        } else if (obj instanceof ScriptObjectMirror) {
            return transformScriptResult((ScriptObjectMirror) obj);
        } else {
            log.warn("unsupported script result type, " + obj.getClass().getName());
            throw new BizException("unsupported script result type, " + obj.getClass().getName());
        }
    }


    private static List<Message> transformScriptResult(ScriptObjectMirror scriptObj) {
        if (scriptObj.isArray()) {
            return scriptObj.values()
                    .stream()
                    .map(item -> (ScriptObjectMirror) item)
                    .map(ScriptResultTransformer::transformScriptObject)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(transformScriptObject(scriptObj));
    }


    private static Message transformScriptObject(ScriptObjectMirror scriptObject) {
        String messageTypeName = (String) scriptObject.get("messageType");
        MessageType messageType = MessageType.valueOf(messageTypeName);
        scriptObject.remove("messageType");
        switch (messageType) {
            case DEVICE_LOGIN_REQ:
                return scriptObjectMirrorTo(scriptObject, LoginRequest.class);
            case DEVICE_REPORT_REQ:
                ScriptObjectMirror metrics = (ScriptObjectMirror) scriptObject.remove("metrics");
                List<Metric> metricList = metrics.values().stream()
                        .map(m -> scriptObjectMirrorTo((ScriptObjectMirror) m, Metric.class))
                        .collect(Collectors.toList());
                MetricReportRequest metricReportRequest = scriptObjectMirrorTo(scriptObject, MetricReportRequest.class);
                metricReportRequest.setMetrics(metricList);
                return metricReportRequest;
            case DEVICE_STATUS_REQ:
                return scriptObjectMirrorTo(scriptObject, StatusReportRequest.class);
            case DEVICE_INFO_REQ:
                return scriptObjectMirrorTo(scriptObject, InfoReportRequest.class);
            case DEVICE_EVENT_REQ:
                return scriptObjectMirrorTo(scriptObject, EventReportRequest.class);
            case DEVICE_NTP_REQ:
                return scriptObjectMirrorTo(scriptObject, DeviceNtpRequest.class);
            case HEARTBEAT:
            case DEVICE_LOGIN_RSP:
            case DEVICE_REPORT_RSP:
            case DEVICE_NTP_RSP:
            case CLOUD_OPERATION_REQ:
            case CLOUD_OPERATION_RSP:
            case CLOUD_HISTORY_REQ:
            case CLOUD_NTP_REQ:
            case CLOUD_NTP_RSP:
            default:
                log.warn("unsupported transform message type: " + messageTypeName);
                throw new BizException("unsupported transform message type: " + messageTypeName);
        }
    }

    private static <T> T scriptObjectMirrorTo(ScriptObjectMirror mirror, Class<T> clazz) {
        // scriptObject.to(MetricReportRequest.class)方法JDK8部分版本存在BUG
        try {
            T t = clazz.newInstance();
            BeanUtils.populate(t, mirror);
            return t;
        } catch (Exception e) {
            throw new BizException("transform ScriptObject error, " + e.getMessage());
        }
    }


    private static List<Message> transformJson(String json) {
        Object obj = JSON.parse(json);
        if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray.stream()
                    .map(item -> (JSONObject) item)
                    .map(ScriptResultTransformer::transformJsonObject)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else {
            return Collections.singletonList(transformJsonObject((JSONObject) obj));
        }
    }


    private static Message transformJsonObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        String messageTypeVal = jsonObject.getString("messageType");
        MessageType messageType = MessageType.valueOf(messageTypeVal);
        switch (messageType) {
            case DEVICE_LOGIN_REQ:
                return jsonObject.toJavaObject(LoginRequest.class);
            case DEVICE_REPORT_REQ:
                return jsonObject.toJavaObject(MetricReportRequest.class);
            case DEVICE_STATUS_REQ:
                return jsonObject.toJavaObject(StatusReportRequest.class);
            case DEVICE_INFO_REQ:
                return jsonObject.toJavaObject(InfoReportRequest.class);
            case DEVICE_EVENT_REQ:
                return jsonObject.toJavaObject(EventReportRequest.class);
            case DEVICE_NTP_REQ:
                return jsonObject.toJavaObject(DeviceNtpRequest.class);
            case HEARTBEAT:
            case DEVICE_LOGIN_RSP:
            case DEVICE_REPORT_RSP:
            case DEVICE_NTP_RSP:
            case CLOUD_OPERATION_REQ:
            case CLOUD_OPERATION_RSP:
            case CLOUD_HISTORY_REQ:
            case CLOUD_NTP_REQ:
            case CLOUD_NTP_RSP:
            default:
                log.warn("unsupported messageType=" + messageTypeVal);
                throw new BizException("unsupported transform message type: " + messageType);
        }
    }


}
