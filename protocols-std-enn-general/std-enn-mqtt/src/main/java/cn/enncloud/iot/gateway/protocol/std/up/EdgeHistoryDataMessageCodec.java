/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.up;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.std.dto.DeviceData;
import cn.enncloud.iot.gateway.protocol.std.dto.EdgeRtgData;
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
public class EdgeHistoryDataMessageCodec {
    private final DeviceContext deviceContext;

    public EdgeHistoryDataMessageCodec(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
    }

    public List<? extends Message> decodeMulti(EdgeRtgData data, TopicParams topic) {
        List<MetricReportRequest> requests = new ArrayList<>();

        for(DeviceData device:data.getDevs()){
            Long deviceTime = device.getTs();
            if(deviceTime==null){
                deviceTime = System.currentTimeMillis();
            }
            long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
            List<Metric> metrics = device.getD().stream().filter(d->d.getDq() == 0).filter(d->d.getM()!=null&&d.getV()!=null).map(d-> new Metric(d.getTs()==null?time:d.getTs(),d.getM(),d.getV())).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(metrics)){
                MetricReportRequest metricReportRequest = new MetricReportRequest();
                metricReportRequest.setDeviceId(device.getDev());
                metricReportRequest.setMetrics(metrics);
                metricReportRequest.setTimeStamp(time);
                metricReportRequest.setIngestionTime(System.currentTimeMillis());
                metricReportRequest.setMessageId(String.format("%s%s", device.getDev(), CommonUtils.getUUID()));
                metricReportRequest.setChangeRpt(data.getChangeRpt() != null && data.getChangeRpt());
                metricReportRequest.setResume("Y");
                requests.add(metricReportRequest);

                this.deviceContext.putDeviceProtocol(device.getDev(), "MQTT-STANDARD");
            }
        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(data.getSn(), "MQTT-STANDARD");
        return requests;
    }

}
