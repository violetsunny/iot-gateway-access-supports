package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.protocol.udf.messgae.GPSInfo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class GPSProtocol extends AbstractProtocol {

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
        List<GPSInfo> gpsInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), GPSInfo.class);
        if (CollectionUtils.isEmpty(gpsInfoList)) {
            throw new DecodeMessageException(3, "解析MQ GPS数据为空");
        }
        return convert(gpsInfoList.get(0));
    }

    private MetricReportRequest convert(GPSInfo gpsInfo) throws DecodeMessageException {
        String deviceId = deviceContext.getDeviceIdByImei(gpsInfo.getImei());
        if (StringUtils.isBlank(deviceId)) {
            throw new DecodeMessageException(3, "GPS 没有对应的恩牛设备" + gpsInfo.getImei());
        }
        MetricReportRequest reportRequest = new MetricReportRequest();

        reportRequest.setDeviceId(deviceId);
        reportRequest.setMessageId(String.format("%s%s", deviceId, UUID.randomUUID().toString().replace("-", "")));
        long currentTimeMillis = System.currentTimeMillis();
        reportRequest.setTimeStamp(currentTimeMillis);
        reportRequest.setIngestionTime(currentTimeMillis);
        if (gpsInfo.getPktype() == 1) {
            log.warn("Pktype==1时,该值无效");
            return null;
        }
        List<Metric> metrics = new ArrayList<>();
        metrics.add(new Metric(gpsInfo.getT(), "Longitude", gpsInfo.getLng()));
        metrics.add(new Metric(gpsInfo.getT(), "Latitude", gpsInfo.getLat()));

        reportRequest.setMetrics(metrics);
        return reportRequest;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        List<GPSInfo> gpsInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), GPSInfo.class);
        if (CollectionUtils.isEmpty(gpsInfoList)) {
            throw new DecodeMessageException(3, "解析MQ GPS数据为空");
        }
        List<MetricReportRequest> metricReportRequests = new ArrayList<>();
        for (GPSInfo gpsInfo : gpsInfoList) {
            metricReportRequests.add(convert(gpsInfo));
        }
        return metricReportRequests;
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

}
