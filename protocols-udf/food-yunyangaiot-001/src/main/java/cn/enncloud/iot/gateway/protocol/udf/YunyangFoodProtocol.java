/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.entity.Device;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.message.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.parser.JsonMessagePayloadParser;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kanglele
 * @version $Id: YunyangFoodProtocol, v 0.1 2024/2/21 14:22 kanglele Exp $
 */
@Slf4j
public class YunyangFoodProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "yunyangaiot-latest";
    }

    @Override
    public String getName() {
        return "水培菜";
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        JSONObject req = JSONObject.parseObject(new String(messageBytes, StandardCharsets.UTF_8));
        List<MetricReportRequest> requests = new ArrayList<>();

        JSONObject req1 = req.getJSONObject("data");
        if(req1==null){
            log.warn("data数据为空 {}",req.toJSONString());
            return requests;
        }
        MetricReportRequest reportRequest = new MetricReportRequest();
        String sn = req1.getString("ie");
        String deviceId = getDeviceContext().getDeviceIdBySn("yunyangaiot", sn);
        if (StringUtils.isBlank(deviceId)) {
            //没有对应的恩牛设备
            log.warn("{} 没有对应的恩牛设备",sn);
            return null;
        }
        reportRequest.setDeviceId(deviceId);
        reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
        reportRequest.setMessageType(MessageType.DEVICE_REPORT_REQ);
        reportRequest.setTimeStamp(System.currentTimeMillis());
        reportRequest.setIngestionTime(System.currentTimeMillis());

        List<Metric> metrics = new ArrayList<>();
        Long datatime = (Long)JsonMessagePayloadParser.typeOf(req1.getString("onlineTimeStr"),DataTypeEnum.DATE);
        JSONObject data = req1.getJSONObject("data");
        Object metricObj = getParams().get("metric");
        JSONObject metricData = JSONObject.parseObject(JSONObject.toJSONString(metricObj));
        for(Map.Entry<String, Object> entry:metricData.entrySet()){
            if("online".equals(entry.getKey())){
                Metric metric1 = new Metric(datatime,(String)entry.getValue(), JsonMessagePayloadParser.typeOf(req1.get(entry.getKey()), DataTypeEnum.BOOLEAN));
                metrics.add(metric1);
            } else {
                Metric metric1 = new Metric(datatime,(String)entry.getValue(), JsonMessagePayloadParser.typeOf(data.get(entry.getKey()), DataTypeEnum.FLOAT));
                metrics.add(metric1);
            }
        }

        reportRequest.setMetrics(metrics);

        requests.add(reportRequest);
        return requests;
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
