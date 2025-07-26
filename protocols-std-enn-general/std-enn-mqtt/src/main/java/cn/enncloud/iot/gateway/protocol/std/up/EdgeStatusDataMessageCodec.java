/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.up;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.std.dto.EdgeStatusData;
import cn.enncloud.iot.gateway.protocol.std.dto.TopicParams;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kanglele
 * @version $Id: EdgeRtgDataMessageCodec, v 0.1 2024/4/17 17:59 kanglele Exp $
 */
@Slf4j
public class EdgeStatusDataMessageCodec {

    private final DeviceContext deviceContext;

    public EdgeStatusDataMessageCodec(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
    }

    public List<? extends Message> decodeMulti(EdgeStatusData data, TopicParams topic) {
        List<MetricReportRequest> requests = new ArrayList<>();
        String deviceId = data.getDeviceId() != null ? data.getDeviceId() : topic.getSn();
        Long deviceTime = data.getTs();
        if(deviceTime==null){
            deviceTime = System.currentTimeMillis();
        }
        Long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
        List<Metric> metrics = data.getData().entrySet().stream().map(d-> new Metric(time,d.getKey(),d.getValue())).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(metrics)){
            MetricReportRequest metricReportRequest = new MetricReportRequest();
            metricReportRequest.setDeviceId(deviceId);
            metricReportRequest.setMetrics(metrics);
            metricReportRequest.setTimeStamp(time);
            metricReportRequest.setIngestionTime(System.currentTimeMillis());
            metricReportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
            requests.add(metricReportRequest);

        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(deviceId, "MQTT-STANDARD");

        return requests;
    }

}
