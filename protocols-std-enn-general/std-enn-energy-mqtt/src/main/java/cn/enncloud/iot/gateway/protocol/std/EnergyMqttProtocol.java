package cn.enncloud.iot.gateway.protocol.std;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.message.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.parser.JsonMessagePayloadParser;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
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

import static cn.enncloud.iot.gateway.exception.DecodeMessageException.UNSUPPORTED_METHOD;

@Slf4j
public class EnergyMqttProtocol extends AbstractProtocol {

    private static final String ACK_REQUIRED_VAL = "1";

    @Override
    public String getId() {
        return "ENERGY_MQTT";
    }

    @Override
    public String getName() {
        return "ENERGY_MQTT协议解析";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        throw new DecodeMessageException(UNSUPPORTED_METHOD, "unsupported method decode()");
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        if (params == null || params.length == 0) {
            return null;
        }
        String topic = (String) params[0];
        String filterMsg = new String(messageBytes, StandardCharsets.UTF_8).replaceAll(" +", "");
        log.info("{} {} energy-standard-mqtt上报数据", topic, filterMsg);
        JSONObject data = JSONObject.parseObject(filterMsg);
        TopicEnum topicEnum = TopicEnum.parse(topic).orElseThrow(() -> new DecodeMessageException(UNSUPPORTED_METHOD, "不支持的topic"));
        TopicParams topicParams = new TopicParams(topic);
        switch (topicEnum) {
            case EDGE_REALTIME_DATA_REPORT:
                return rtgDataReport(topicParams, data);
            case EDGE_DATA_CALL_REPORT:
                return callDataReport(topicParams, data);
            case EDGE_INFO_REPORT:
                return infoDataReport(topicParams, data);
            case EDGE_PARAM_UPDATE_REPORT:
                return changeDataReport(topicParams, data);
            default:
                break;
        }
        return null;
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        if (message == null) {
            return new byte[0];
        }
        if (message.getMessageType() == MessageType.CLOUD_SET_REQ) {
            return cmdDataRequest((CloudSetRequest) message);
        }
        if (message.getMessageType() == MessageType.CLOUD_CALL_REQ) {
            return callDataRequest((MetricCloudCallRequest) message);
        }
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

    /**
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"A3889",
     * "parameter": {
     * "dc": "1800",
     * "ct": "1661843863006"
     * }
     * "payload": {
     * "ch4_alm_high": "3.0"
     * }
     * "ts": "1661843863006"
     * }
     * {
     * "devtype": "ch4_alarmer",
     * "sysId":"ecej",
     * "seq":"A3889",
     * "ts": "1661843892006",
     * "code":"200"
     * }
     *
     * @return
     */
    private byte[] cmdDataRequest(CloudSetRequest cloudSetRequest) {
        JSONObject payload = new JSONObject();
        payload.put("devtype", Optional.ofNullable(cloudSetRequest.getEntityTypeCode()).orElse("ch4_alarmer"));
        payload.put("ts", String.valueOf(System.currentTimeMillis()));
        payload.put("seq", cloudSetRequest.getMessageId());
        payload.put("parameter", cloudSetRequest.getParam());
        payload.put("payload", cloudSetRequest.getPayload());

        // 获取 pkey 和 sn
        String pkey = cloudSetRequest.getPKey();
        String sn = Optional.ofNullable(getDeviceContext().getSnByDeviceId(cloudSetRequest.getDeviceId())).orElse(cloudSetRequest.getDeviceId());

        // 获取原始的正则表达式字符串
        String originalPattern = TopicEnum.CLOUD_CMD_REQUEST.pattern.pattern();
        // 替换第一个 .+ 为 pkey
        String firstReplaced = originalPattern.replaceFirst("\\.\\+", pkey);
        // 替换第二个 .+ 为 sn
        String finalTopic = firstReplaced.replaceFirst("\\.\\+", sn);

        cloudSetRequest.setTopic(finalTopic);
        return payload.toJSONString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"3884",
     * "ts": "1661843863006"
     * }
     * {
     * "devtype": "ch4_alarmer",
     * " sysId":"ecej",
     * "seq":"3884",
     * "parameter": {
     * "sVer": "2.0.3",
     * "hVer": "2.0.0",
     * "meId ": "89860419151871872499",
     * "connType":"G",
     * "mac": "B0-60-88-81-1F-3C",
     * "power":"0",
     * "dc": "3600",
     * 8
     * "ct": "1661843863006"
     * },
     * "payload": {
     * "ch4_value": "0.856",
     * "ch4_alm_high": "2.0",
     * "ch4_alm": "0",
     * "temperature": "27.455"
     * }，
     * "ts": "1661843863006",
     * "code":"200"
     * }
     *
     * @return
     */
    private byte[] callDataRequest(MetricCloudCallRequest metricCloudCallRequest) {
        JSONObject payload = new JSONObject();
        payload.put("devtype", Optional.ofNullable(metricCloudCallRequest.getEntityTypeCode()).orElse("ch4_alarmer"));
        payload.put("ts", String.valueOf(System.currentTimeMillis()));
        payload.put("seq", metricCloudCallRequest.getMessageId());

        // 获取 pkey 和 sn
        String pkey = metricCloudCallRequest.getPKey();
        String sn = Optional.ofNullable(getDeviceContext().getSnByDeviceId(metricCloudCallRequest.getDeviceId())).orElse(metricCloudCallRequest.getDeviceId());

        // 获取原始的正则表达式字符串
        String originalPattern = TopicEnum.CLOUD_DATA_CALL_REQUEST.pattern.pattern();
        // 替换第一个 .+ 为 pkey
        String firstReplaced = originalPattern.replaceFirst("\\.\\+", pkey);
        // 替换第二个 .+ 为 sn
        String finalTopic = firstReplaced.replaceFirst("\\.\\+", sn);

        metricCloudCallRequest.setTopic(finalTopic);
        return payload.toJSONString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"3884",
     * "ts": "1661843863006"
     * }
     * ack:
     * {
     * "devtype": "ch4_alarmer",
     * " sysId":"ecej",
     * "seq":"3884",
     * "parameter": {
     * "sVer": "2.0.3",
     * "hVer": "2.0.0",
     * "meId ": "89860419151871872499",
     * "connType":"G",
     * "mac": "B0-60-88-81-1F-3C",
     * "power":"0",
     * "dc": "3600",
     * "ct": "1661843863006"
     * },
     * "payload": {
     * "ch4_value": "0.856",
     * "ch4_alm_high": "2.0",
     * "ch4_alm": "0",
     * "temperature": "27.455"
     * }，
     * "ts": "1661843863006",
     * "code":"200"
     * }
     */
    private List<? extends Message> callDataReport(TopicParams topicParams, JSONObject data) {
        List<Message> messages = new ArrayList<>();
        String deviceId = topicParams.sn;
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        List<Metric> metrics = data.getJSONObject("payload").entrySet().stream()
                .map(e -> new Metric(time, e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        String resume = "N";
        boolean changeRpt = data.getBoolean("changeRpt") != null && data.getBoolean("changeRpt");
        String messageId = Optional.ofNullable(data.getString("seq")).orElse(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        MetricReportRequest metricReportRequest = buildMetricReportRequest(deviceId, resume, changeRpt, messageId, time, metrics);
        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("devtype", data.getString("devtype"));
            cloudAck.put("seq", data.getString("seq"));
            cloudAck.put("ts", String.valueOf(System.currentTimeMillis()));
            cloudAck.put("code", "200");
            metricReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }
        messages.add(metricReportRequest);

        JSONObject parameter = data.getJSONObject("parameter");
        InfoReportRequest infoReportRequest = buildInfoReportRequest(deviceId, parameter, messageId, time);
        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("devtype", data.getString("devtype"));
            cloudAck.put("seq", data.getString("seq"));
            cloudAck.put("ts", String.valueOf(System.currentTimeMillis()));
            cloudAck.put("code", "200");
            infoReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }
        messages.add(infoReportRequest);
        return messages;
    }


    /**
     * 设备信息上报
     * {
     * "devtype": "ch4_alarmer",
     * " sysId":"ecej",
     * "seq":"A3880",
     * "ack":"1",
     * "parameter": {
     * "sVer": "2.0.3",
     * "hVer": "2.0.0",
     * "meId ": "89860419151871872499",
     * "connType":"G",
     * "mac": "B0-60-88-81-1F-3C",
     * "power":"0",
     * "dc": "3600",
     * "ct": "1661843863006"
     * }
     * "ts": "1661843863006"
     * }
     * ack:
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"A3880",
     * "ts": "1661843868078",
     * "code":"200"
     * }
     */
    private List<? extends Message> infoDataReport(TopicParams topicParams, JSONObject data) {
        List<Message> messages = new ArrayList<>();
        String deviceId = topicParams.sn;
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        JSONObject parameter = data.getJSONObject("parameter");//设备参数
        String messageId = Optional.ofNullable(data.getString("seq")).orElse(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        InfoReportRequest infoReportRequest = buildInfoReportRequest(deviceId, parameter, messageId, time);

        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("devtype", data.getString("devtype"));
            cloudAck.put("seq", data.getString("seq"));
            cloudAck.put("ts", String.valueOf(System.currentTimeMillis()));
            cloudAck.put("code", "200");
            infoReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }
        messages.add(infoReportRequest);
        return messages;
    }

    /**
     * 数据事实数据上报
     * {
     * "devtype": "ch4_alarmer",
     * "sysId":"ecej",
     * "seq":"3881",
     * "ack":"1",
     * "payload": {
     * "ch4_value": "0.856",
     * "ch4_alm_high": "2.0",
     * "ch4_alm": "0",
     * "temperature": "27.455"
     * }
     * "ts": "1661843863006"
     * }
     * ack:
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"3881",
     * "ts": "1661843868078",
     * "code":"200"
     * }
     */
    private List<? extends Message> rtgDataReport(TopicParams topicParams, JSONObject data) {
        List<Message> messages = new ArrayList<>();
        boolean changeRpt = data.getBoolean("changeRpt") != null && data.getBoolean("changeRpt");
        String deviceId = topicParams.sn;
        String resume = "N";
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        List<Metric> metrics = data.getJSONObject("payload").entrySet().stream()
                .map(e -> new Metric(time, e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        String messageId = Optional.ofNullable(data.getString("seq")).orElse(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        MetricReportRequest metricReportRequest = buildMetricReportRequest(deviceId, resume, changeRpt, messageId, time, metrics);

        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("devtype", data.getString("devtype"));
            cloudAck.put("seq", data.getString("seq"));
            cloudAck.put("ts", String.valueOf(System.currentTimeMillis()));
            cloudAck.put("code", "200");
            metricReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }

        messages.add(metricReportRequest);
        return messages;
    }

    /**
     * {
     * "devtype": "ch4_alarmer",
     * "sysId":"ecej",
     * "seq":"3896",
     * "ack":"1",
     * "parameter": {
     * "dc": "1800",
     * "ct": "1661843863006"
     * }
     * "payload": {
     * "ch4_alm_high": "3.0",
     * }
     * "ts": "1661843863006"
     * }
     * {
     * "devtype": "ch4_alarmer",
     * "seq":"3896",
     * "ts": "1661843892006",
     * "code":"200"
     * }
     */
    private List<? extends Message> changeDataReport(TopicParams topicParams, JSONObject data) {
        List<Message> messages = new ArrayList<>();
        String deviceId = topicParams.sn;
        String ack = Optional.ofNullable(data.getString("ack")).orElse("0");
        Long deviceTime = Optional.ofNullable((Long) JsonMessagePayloadParser.typeOf(data.get("ts"), DataTypeEnum.DATE)).orElse(System.currentTimeMillis());
        long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        List<Metric> metrics = data.getJSONObject("payload").entrySet().stream()
                .map(e -> new Metric(time, e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        JSONObject parameter = data.getJSONObject("parameter");//设备参数
        String messageId = Optional.ofNullable(data.getString("seq")).orElse(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        ChangeDataReportRequest changeDataReportRequest = buildChangeDataReportRequest(deviceId, parameter,metrics, messageId, time);

        if (isAckRequired(ack)) {
            JSONObject cloudAck = new JSONObject();
            cloudAck.put("devtype", data.getString("devtype"));
            cloudAck.put("seq", data.getString("seq"));
            cloudAck.put("ts", String.valueOf(System.currentTimeMillis()));
            cloudAck.put("code", "200");
            changeDataReportRequest.setResponse(JSON.toJSONString(cloudAck));
        }
        messages.add(changeDataReportRequest);
        return messages;
    }

    /**
     * 构建测点上报消息对象
     * <p>
     * deviceType 设备类型
     * deviceId   设备ID
     * ts         时间戳
     * seq        消息序列号
     * ack        是否响应
     * payload    测点键值对
     *
     * @return 测点消息对象
     */
    private MetricReportRequest buildMetricReportRequest(String deviceId, String resume, boolean changeRpt, String messageId, long time, List<Metric> metrics) {
        MetricReportRequest metricReportRequest = new MetricReportRequest();
        metricReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("energy", deviceId));
        metricReportRequest.setMetrics(metrics);
        metricReportRequest.setTimeStamp(time);
        metricReportRequest.setIngestionTime(System.currentTimeMillis());
        metricReportRequest.setMessageId(messageId);
        metricReportRequest.setChangeRpt(changeRpt);
        metricReportRequest.setResume(resume);
        return metricReportRequest;
    }


    /**
     * 构建设备信息上报消息对象
     * <p>
     * deviceType 设备类型
     * deviceId   设备ID
     * ts         时间戳
     * seq        消息序列号
     * ack        是否响应
     * parameter  设备信息键值对
     *
     * @return 设备信息上报对象
     */
    private InfoReportRequest buildInfoReportRequest(String deviceId, JSONObject data, String messageId, long time) {
        InfoReportRequest infoReportRequest = new InfoReportRequest();
        infoReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("energy", deviceId));
        infoReportRequest.setData(data);
        infoReportRequest.setTimeStamp(time);
        infoReportRequest.setIngestionTime(System.currentTimeMillis());
        infoReportRequest.setMessageId(messageId);
        return infoReportRequest;
    }

    private ChangeDataReportRequest buildChangeDataReportRequest(String deviceId, JSONObject data, List<Metric> metrics, String messageId, long time) {
        ChangeDataReportRequest changeDataReportRequest = new ChangeDataReportRequest();
        changeDataReportRequest.setDeviceId(getDeviceContext().getDeviceIdBySn("energy", deviceId));
        changeDataReportRequest.setParam(data);
        changeDataReportRequest.setTimeStamp(time);
        changeDataReportRequest.setIngestionTime(System.currentTimeMillis());
        changeDataReportRequest.setMessageId(messageId);
        changeDataReportRequest.setMetrics(metrics);
        return changeDataReportRequest;
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

    private boolean isAckRequired(String ack) {
        return ACK_REQUIRED_VAL.equals(ack);
    }

    @Getter
    public enum TopicEnum {
        /**
         * 设备端上报主题
         **/
        EDGE_INFO_REPORT(Pattern.compile("/edge/single/.+/.+/info")),

        EDGE_REALTIME_DATA_REPORT(Pattern.compile("/edge/single/.+/.+/rtg")),

        EDGE_DATA_CALL_REPORT(Pattern.compile("/edge/single/.+/.+/call")),

        EDGE_CMD_RESPONSE(Pattern.compile("/edge/single/.+/.+/set")),

        EDGE_PARAM_UPDATE_REPORT(Pattern.compile("/edge/single/.+/.+/change")),

        /**
         * 服务端下行主题
         **/
        CLOUD_INFO_RESPONSE(Pattern.compile("/cloud/single/.+/.+/info")),

        CLOUD_REALTIME_DATA_RESPONSE(Pattern.compile("/cloud/single/.+/.+/rtg")),

        CLOUD_DATA_CALL_REQUEST(Pattern.compile("/cloud/single/.+/.+/call")),

        CLOUD_CMD_REQUEST(Pattern.compile("/cloud/single/.+/.+/set")),

        CLOUD_PARAM_UPDATE_RESPONSE(Pattern.compile("/cloud/single/.+/.+/change")),
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
