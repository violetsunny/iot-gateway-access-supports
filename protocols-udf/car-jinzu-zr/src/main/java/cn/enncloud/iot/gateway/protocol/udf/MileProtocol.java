package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.message.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.parser.JsonMessagePayloadParser;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.protocol.udf.messgae.MileInfo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class MileProtocol extends AbstractProtocol {

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
        List<MileInfo> mileageInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), MileInfo.class);
        if (CollectionUtils.isEmpty(mileageInfoList)) {
            throw new DecodeMessageException(3, "解析MQ Mile数据为空");
        }
        return convert(mileageInfoList.get(0));
    }

    private MetricReportRequest convert(MileInfo mileInfo) throws DecodeMessageException {
        String deviceId = deviceContext.getDeviceIdByImei(mileInfo.getImei());
        if (StringUtils.isBlank(deviceId)) {
            throw new DecodeMessageException(3, "Mile 没有对应的恩牛设备" + mileInfo.getImei());
        }
        MetricReportRequest reportRequest = new MetricReportRequest();

        reportRequest.setDeviceId(deviceId);
        reportRequest.setMessageId(String.format("%s%s", deviceId, UUID.randomUUID().toString().replace("-", "")));
        long currentTimeMillis = System.currentTimeMillis();
        reportRequest.setTimeStamp(currentTimeMillis);
        reportRequest.setIngestionTime(currentTimeMillis);

        List<Metric> metrics = new ArrayList<>();
        Long l = (Long) JsonMessagePayloadParser.typeOf(mileInfo.getDateTime(), DataTypeEnum.DATE);
        metrics.add(new Metric(l, "MileageYesterday", mileInfo.getMile() * 1000));

        reportRequest.setMetrics(metrics);
        return reportRequest;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        List<MileInfo> mileageInfoList = JSONObject.parseArray(new String(messageBytes, StandardCharsets.UTF_8), MileInfo.class);
        if (CollectionUtils.isEmpty(mileageInfoList)) {
            throw new DecodeMessageException(3, "解析MQ Mile数据为空");
        }
        log.info("接收到Mile消息 {}", mileageInfoList.size());
        List<MetricReportRequest> metricReportRequests = new ArrayList<>();
        for (MileInfo mileInfo : mileageInfoList) {
            metricReportRequests.add(convert(mileInfo));
        }
        return metricReportRequests;
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
