package cn.enncloud.iot.gateway.protocol.std;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.message.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.parser.JsonMessagePayloadParser;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class EnnStandardMqttProtocol extends AbstractProtocol {

    private static final String ACK_REQUIRED_VAL = "1";

    @Override
    public String getId() {
        return "enn-standard-mqtt";
    }

    @Override
    public String getName() {
        return "enn-standard-mqtt";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        if (params[0] == null) {
            return null;
        }
        //去除空格
        String filterMsg = new String(messageBytes, StandardCharsets.UTF_8).replaceAll(" +", "");
        String topic = String.valueOf(params[0]);
        log.info("{} {} enn-standard-mqtt上报数据", topic, filterMsg);
        JSONObject data = JSONObject.parseObject(filterMsg);
        TopicEnum topicEnum = TopicEnum.parse(topic).orElseThrow(() -> new DecodeMessageException(DecodeMessageException.UNSUPPORTED_METHOD, "不支持的topic"));
        TopicParams topicParams = new TopicParams(topic);
        switch (topicEnum) {
            case EDGE_REALTIME_DATA_REPORT:
                return rtgDataReport(topicParams, data);
            case EDGE_DATA_EVENT_REPORT:
                return eventDataReport(topicParams, data);
            case EDGE_INFO_REPORT:
                return infoDataReport(topicParams, data);
            case EDGE_DATA_STATUS_REPORT:
                return statusDataReport(topicParams, data);
            case EDGE_DATA_HISTORY_REPORT:
                return historyDataReport(topicParams, data);
            default:
                break;
        }

        return null;
    }

    private List<? extends Message> historyDataReport(TopicParams topicParams, JSONObject data) {
        List<MetricReportRequest> requests = new ArrayList<>();
        JSONArray devs = data.getJSONArray("devs");
        boolean changeRpt = data.getBoolean("changeRpt") != null && data.getBoolean("changeRpt");
        for (Object device : devs) {
            JSONObject deviceData = JSONObject.parseObject(JSONObject.toJSONString(device));
            String deviceId = deviceData.getString("dev");
            String resume = "Y";
            String ack = Optional.ofNullable(deviceData.getString("ack")).orElse("0");
            Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(deviceData.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
            long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
            List<Metric> metrics = deviceData.getJSONArray("d").stream()
                    .map(d -> JSONObject.parseObject(JSONObject.toJSONString(d)))
                    .filter(d -> d.getIntValue("dq") == 0)
                    .filter(d -> d.get("m") != null && d.get("v") != null)
                    .map(d -> new Metric(d.getLong("ts") == null ? time : d.getLong("ts"), d.getString("m"), d.get("v")))
                    .collect(Collectors.toList());
            String messageId = String.format("%s%s", deviceId, CommonUtils.getUUID());
            MetricReportRequest metricReportRequest = buildMetricReportRequest(deviceId, resume, changeRpt, messageId, time, metrics);
            this.deviceContext.putDeviceProtocol(metricReportRequest.getDeviceId(), "MQTT-STANDARD");
            if (isAckRequired(ack)) {
                JSONObject cloudAck = new JSONObject();
                cloudAck.put("dev", metricReportRequest.getDeviceId());
                cloudAck.put("seq", metricReportRequest.getMessageId());
                metricReportRequest.setResponse(JSON.toJSONString(cloudAck));
            }

            requests.add(metricReportRequest);
        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(data.getString("sn"), "MQTT-STANDARD");
        return requests;
    }

    private List<? extends Message> statusDataReport(TopicParams topicParams, JSONObject data) {
        List<MetricReportRequest> requests = new ArrayList<>();
        String deviceId = data.getString("deviceId") != null ? data.getString("deviceId") : topicParams.sn;
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        Long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        List<Metric> metrics = data.getJSONObject("data").entrySet().stream()
                .map(d -> new Metric(time, d.getKey(), d.getValue()))
                .collect(Collectors.toList());
        String messageId = String.format("%s%s", deviceId, CommonUtils.getUUID());
        MetricReportRequest metricReportRequest = buildStatusReportRequest(deviceId, messageId, time, metrics);
        this.deviceContext.putDeviceProtocol(metricReportRequest.getDeviceId(), "MQTT-STANDARD");
        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("dev", metricReportRequest.getDeviceId());
            cloudAck.put("seq", metricReportRequest.getMessageId());
            metricReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }

        requests.add(metricReportRequest);
        return requests;
    }

    private List<? extends Message> infoDataReport(TopicParams topicParams, JSONObject data) {
        List<InfoReportRequest> requests = new ArrayList<>();
        String deviceId = data.getString("deviceId") != null ? data.getString("deviceId") : topicParams.sn;
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        Long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        String messageId = String.format("%s%s", deviceId, CommonUtils.getUUID());
        JSONObject parameter = data;
        InfoReportRequest infoReportRequest = buildInfoReportRequest(deviceId, parameter, messageId, time);
        this.deviceContext.putDeviceProtocol(infoReportRequest.getDeviceId(), "MQTT-STANDARD");
        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("dev", infoReportRequest.getDeviceId());
            cloudAck.put("seq", infoReportRequest.getMessageId());
            infoReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }

        requests.add(infoReportRequest);

        return requests;
    }

    private List<? extends Message> eventDataReport(TopicParams topicParams, JSONObject data) {
        List<EventReportRequest> requests = new ArrayList<>();
        JSONArray devs = data.getJSONArray("devs");
        for (Object device : devs) {
            JSONObject deviceData = JSONObject.parseObject(JSONObject.toJSONString(device));
            String deviceId = deviceData.getString("dev");
            String ack = Optional.ofNullable(deviceData.getString("ack")).orElse("0");
            Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(deviceData.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
            long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
            List<Metric> metrics = deviceData.getJSONObject("value").entrySet().stream()
                    .filter(d -> d.getKey() != null && d.getValue() != null)
                    .map(d -> new Metric(time, d.getKey(), d.getValue()))
                    .collect(Collectors.toList());
            String messageId = String.format("%s%s", deviceId, CommonUtils.getUUID());
            EventReportRequest eventReportRequest = buildEventReportRequest(deviceId, deviceData, messageId, time, metrics);
            this.deviceContext.putDeviceProtocol(eventReportRequest.getDeviceId(), "MQTT-STANDARD");
            if (isAckRequired(ack)) {
                JSONObject cloudAck = new JSONObject();
                cloudAck.put("dev", eventReportRequest.getDeviceId());
                cloudAck.put("seq", eventReportRequest.getMessageId());
                eventReportRequest.setResponse(JSON.toJSONString(cloudAck));
            }

            requests.add(eventReportRequest);


        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(data.getString("sn"), "MQTT-STANDARD");
        return requests;
    }

    /**
     * {
     * "ver": "2.2.12",
     * "pKey": "1845721743839019009",
     * "sn": "5728867848",
     * "ts": 1730194953,
     * "changeRpt": true,
     * "devs": [
     * {
     * "sysId": "",
     * "dev": "3201676650",
     * "ts": 1730194953,
     * "d": [
     * {
     * "m": "DURrunHrD",
     * "v": 66,
     * "ts": 1730194953,
     * "dq": 0
     * }
     * ]
     * }
     * ]
     * }
     */
    private List<? extends Message> rtgDataReport(TopicParams topicParams, JSONObject data) {
        List<Message> messages = new ArrayList<>();

        boolean changeRpt = data.getBoolean("changeRpt") != null && data.getBoolean("changeRpt");
        JSONArray devs = data.getJSONArray("devs");
        for (Object device : devs) {
            JSONObject deviceData = JSONObject.parseObject(JSONObject.toJSONString(device));
            String deviceId = Optional.ofNullable(deviceData.getString("dev")).orElse(topicParams.sn);
            String resume = "N";
            String ack = Optional.ofNullable(deviceData.getString("ack")).orElse("0");
            Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(deviceData.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
            long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
            List<Metric> metrics = deviceData.getJSONArray("d").stream()
                    .map(d -> JSONObject.parseObject(JSONObject.toJSONString(d)))
                    .filter(d -> d.getIntValue("dq") == 0)
                    .filter(d -> d.get("m") != null && d.get("v") != null)
                    .map(d -> new Metric(d.getLong("ts") == null ? time : d.getLong("ts"), d.getString("m"), d.get("v")))
                    .collect(Collectors.toList());
            String messageId = String.format("%s%s", deviceId, CommonUtils.getUUID());
            MetricReportRequest metricReportRequest = buildMetricReportRequest(deviceId, resume, changeRpt, messageId, time, metrics);
            this.deviceContext.putDeviceProtocol(metricReportRequest.getDeviceId(), "MQTT-STANDARD");
            if (isAckRequired(ack)) {
                JSONObject cloudAck = new JSONObject();
                cloudAck.put("dev", metricReportRequest.getDeviceId());
                cloudAck.put("seq", metricReportRequest.getMessageId());
                metricReportRequest.setResponse(JSON.toJSONString(cloudAck));
            }

            messages.add(metricReportRequest);
        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(data.getString("sn"), "MQTT-STANDARD");
        return messages;
    }

    private MetricReportRequest buildMetricReportRequest(String deviceId, String resume, boolean changeRpt, String messageId, long time, List<Metric> metrics) {
        MetricReportRequest metricReportRequest = new MetricReportRequest();
        metricReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("std", deviceId));
        metricReportRequest.setMetrics(metrics);
        metricReportRequest.setTimeStamp(time);
        metricReportRequest.setIngestionTime(System.currentTimeMillis());
        metricReportRequest.setMessageId(messageId);
        metricReportRequest.setChangeRpt(changeRpt);
        metricReportRequest.setResume(resume);
        return metricReportRequest;
    }

    private InfoReportRequest buildInfoReportRequest(String deviceId, JSONObject data, String messageId, long time) {
        InfoReportRequest infoReportRequest = new InfoReportRequest();
        infoReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("std", deviceId));
        infoReportRequest.setData(data);
        infoReportRequest.setTimeStamp(time);
        infoReportRequest.setIngestionTime(System.currentTimeMillis());
        infoReportRequest.setMessageId(messageId);
        return infoReportRequest;
    }

    private EventReportRequest buildEventReportRequest(String deviceId, JSONObject data, String messageId, long time, List<Metric> metrics) {
        EventReportRequest reportRequest = new EventReportRequest();
        reportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("std", deviceId));
        reportRequest.setMessageId(messageId);
        reportRequest.setTimeStamp(time);
        reportRequest.setIngestionTime(System.currentTimeMillis());
        reportRequest.setIdentifier(data.getString("identifier"));
        reportRequest.setType(data.getString("eventType"));
        reportRequest.setVersion(data.getString("ver"));
        reportRequest.setMetrics(metrics);
        return reportRequest;
    }

    private MetricReportRequest buildStatusReportRequest(String deviceId, String messageId, long time, List<Metric> metrics) {
        MetricReportRequest metricReportRequest = new MetricReportRequest();
        metricReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("std", deviceId));
        metricReportRequest.setMetrics(metrics);
        metricReportRequest.setTimeStamp(time);
        metricReportRequest.setIngestionTime(System.currentTimeMillis());
        metricReportRequest.setMessageId(messageId);
        return metricReportRequest;
    }

    private boolean isAckRequired(String ack) {
        return ACK_REQUIRED_VAL.equals(ack);
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }

    static class TopicParams {
        public TopicParams(String topic) {
            this.topic = topic;
            String[] strings = topic.split("/");
            if (strings.length >= 5) {
                this.pKey = strings[3];
                this.sn = strings[4];
            }
        }

        String topic;
        String pKey;
        String sn;
    }

    @Getter
    private enum TopicEnum {
        /**
         * 设备端上报主题
         **/
        EDGE_INFO_REPORT(Pattern.compile("/edge/.+/.+/info")),

        EDGE_REALTIME_DATA_REPORT(Pattern.compile("/edge/.+/.+/rtg")),

        EDGE_DATA_STATUS_REPORT(Pattern.compile("/edge/.+/.+/status")),

        EDGE_DATA_EVENT_REPORT(Pattern.compile("/edge/.+/.+/event")),

        EDGE_DATA_HISTORY_REPORT(Pattern.compile("/edge/.+/.+/history")),

        EDGE_DATA_CALL_REPORT(Pattern.compile("/edge/.+/.+/history/cack")),

        EDGE_DATA_NTP_REPORT(Pattern.compile("/edge/.+/.+/ntp/request")),

        EDGE_DATA_NTP_CACK_REPORT(Pattern.compile("/edge/.+/.+/ntp/set/ack")),

        EDGE_CMD_SET_CACK(Pattern.compile("/edge/.+/.+/cmd/set/cack")),

        /** 服务端下行主题 **/

        CLOUD_DATA_CALL_REQUEST(Pattern.compile("/cloud/.+/.+/history/call")),// /cloud/single/.+/.+/call 或者 /cloud/.+/.+/history/call 云端请求设备上报数据(召读)

        CLOUD_CMD_REQUEST(Pattern.compile("/cloud/.+/.+/cmd/set")),// /cloud/single/.+/.+/.+/set 或者 /cloud/.+/.+/cmd/set 云端下发到设备的控制指令

        CLOUD_DATA_NTP_SET_REQUEST(Pattern.compile("/cloud/.+/.+/ntp/set")),//示例：/cloud/.+/.+/ntp/set 云端发送校时指令请求

        CLOUD_DATA_NTP_RESPONSE(Pattern.compile("/cloud/.+/.+/ntp/request/ack")),//示例：/cloud/.+/.+/ntp/request/ack 云端响应设备端同步时间
        ;


        private final Pattern pattern;

        TopicEnum(Pattern pattern) {
            this.pattern = pattern;
        }

        public static Optional<TopicEnum> parse(String topic) {
            return Arrays.stream(TopicEnum.values())
                    .filter(e -> e.pattern.matcher(topic).matches())
                    .findFirst();
        }

    }
}
