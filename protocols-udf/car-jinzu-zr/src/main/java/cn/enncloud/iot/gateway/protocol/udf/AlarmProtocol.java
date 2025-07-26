package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.EventReportRequest;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.protocol.udf.messgae.AlarmInfo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class AlarmProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params0) throws DecodeMessageException {
        List<AlarmInfo> alarmInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), AlarmInfo.class);
        if (CollectionUtils.isEmpty(alarmInfoList)) {
            throw new DecodeMessageException(3, "解析MQ Alarm数据为空");
        }
        return convert(alarmInfoList.get(0));
    }

    private EventReportRequest convert(AlarmInfo alarmInfo) throws DecodeMessageException {
        String deviceId = deviceContext.getDeviceIdByImei(alarmInfo.getImei());
        if (StringUtils.isBlank(deviceId)) {
            throw new DecodeMessageException(3, "Alarm 没有对应的恩牛设备 " + alarmInfo.getImei());
        }
        EventReportRequest eventReportRequest = new EventReportRequest();

        eventReportRequest.setDeviceId(deviceId);
        eventReportRequest.setMessageId(String.format("%s%s", deviceId, UUID.randomUUID().toString().replace("-", "")));
        long currentTimeMillis = System.currentTimeMillis();
        eventReportRequest.setTimeStamp(currentTimeMillis);
        eventReportRequest.setIdentifier((String) getParams().get("identifier"));
        eventReportRequest.setType("alarm");
        eventReportRequest.setVersion("0.0.1");

        List<Metric> metrics = new ArrayList<>();
        Object mappingObj = getParams().get("mapping");
        JSONObject mappingData = JSONObject.parseObject(JSONObject.toJSONString(mappingObj));
        Integer value = mappingData.getInteger(String.valueOf(alarmInfo.getWtype()));
        if (value == null) {
            log.warn("{} 没有这个告警类型 {}", deviceId, alarmInfo.getWtype());
            return null;
        }
        metrics.add(new Metric(alarmInfo.getT(), "alarmCode", value));

        eventReportRequest.setMetrics(metrics);
        return eventReportRequest;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        List<AlarmInfo> alarmInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), AlarmInfo.class);
        if (CollectionUtils.isEmpty(alarmInfoList)) {
            throw new DecodeMessageException(3, "解析MQ Alarm数据为空");
        }
        List<EventReportRequest> eventReportRequests = new ArrayList<>();
        for (AlarmInfo alarmInfo : alarmInfoList) {
            eventReportRequests.add(convert(alarmInfo));
        }
        return eventReportRequests;
    }

    @Override
    public byte[] encode(Message message, Object... params0) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params0) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }

}
