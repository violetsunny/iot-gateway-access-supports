/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.up;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.message.InfoReportRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.protocol.std.dto.TopicParams;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglele
 * @version $Id: EdgeRtgDataMessageCodec, v 0.1 2024/4/17 17:59 kanglele Exp $
 */
@Slf4j
public class EdgeInfoDataMessageCodec {
    private final DeviceContext deviceContext;

    public EdgeInfoDataMessageCodec(DeviceContext deviceContext) {
        this.deviceContext = deviceContext;
    }

    public List<? extends Message> decodeMulti(JSONObject jsonObject, TopicParams topic) {
        List<InfoReportRequest> requests = new ArrayList<>();

        String deviceId = jsonObject.getString("deviceId") != null ? jsonObject.getString("deviceId") : topic.getSn();

        InfoReportRequest metricReportRequest = new InfoReportRequest();
        metricReportRequest.setDeviceId(deviceId);
        metricReportRequest.setData(jsonObject);
        metricReportRequest.setTimeStamp(System.currentTimeMillis());
        metricReportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        requests.add(metricReportRequest);

        //向redis回填网关设备的消息协议
        this.deviceContext.putDeviceProtocol(deviceId, "MQTT-STANDARD");

        return requests;
    }

}
