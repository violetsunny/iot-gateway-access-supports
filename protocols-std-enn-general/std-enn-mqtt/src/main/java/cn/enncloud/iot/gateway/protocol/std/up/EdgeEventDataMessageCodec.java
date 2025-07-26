/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.up;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.message.EventReportRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.protocol.std.dto.EdgeEventData;
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
public class EdgeEventDataMessageCodec {
    private final DeviceContext deviceContext;

    public EdgeEventDataMessageCodec(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
    }

    public List<? extends Message> decodeMulti(EdgeEventData data, TopicParams topic) {
        List<EventReportRequest> requests = new ArrayList<>();

        for(EdgeEventData.DevsDTO device:data.getDevs()){
            Long deviceTime = device.getTs();
            if(deviceTime==null){
                deviceTime = System.currentTimeMillis();
            }
            long time = String.valueOf(deviceTime).length() == 10 ? deviceTime * 1000 : deviceTime;
            List<Metric> metrics = device.getValue().entrySet().stream().filter(d->d.getKey()!=null&&d.getValue()!=null).map(d-> new Metric(time,d.getKey(),d.getValue())).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(metrics)){
                EventReportRequest reportRequest = new EventReportRequest();
                reportRequest.setDeviceId(device.getDev());
                reportRequest.setMessageId(String.format("%s%s", device.getDev(), CommonUtils.getUUID()));
                reportRequest.setTimeStamp(System.currentTimeMillis());
                reportRequest.setIdentifier(device.getIdentifier());
                reportRequest.setType(device.getEventType());
                reportRequest.setVersion(data.getVer());
                reportRequest.setMetrics(metrics);
                requests.add(reportRequest);

                this.deviceContext.putDeviceProtocol(device.getDev(), "MQTT-STANDARD");
            }
        }
        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(data.getSn(), "MQTT-STANDARD");
        return requests;
    }

}
