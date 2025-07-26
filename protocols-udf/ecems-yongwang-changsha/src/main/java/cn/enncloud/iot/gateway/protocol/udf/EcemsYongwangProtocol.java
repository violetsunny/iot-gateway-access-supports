/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.message.enums.DataTypeEnum;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.parser.JsonMessagePayloadParser;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import cn.enncloud.iot.gateway.utils.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author kanglele
 * @version $Id: EcemsYongwangProtocol, v 0.1 2024/5/20 15:37 kanglele Exp $
 */
@Slf4j
public class EcemsYongwangProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "ecems";
    }

    @Override
    public String getName() {
        return "ecems-api";
    }


    @Override
    public Message decode(byte[] messageBytes, Object... params0) throws DecodeMessageException {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        JSONObject req = JSONObject.parseObject(new String(messageBytes, StandardCharsets.UTF_8));

        if (params.length == 0 || params[0] == null) {
            log.warn("params is null");
            return null;
        }
        JSONObject reqData = req.getJSONObject("data");
        if (reqData == null) {
            log.warn("{} {} {} data数据为空 {}",params[2],params[0], params[1], req.toJSONString());
            return null;
        }

        Object modelRefObj = null;
        if(getParams()!=null){
            modelRefObj = getParams().get("metric");
        }
        Map<String, String> measureRefMap = getDeviceContext().modelRef(String.valueOf(params[2]), String.valueOf(params[1]),modelRefObj);

        String taskCode = String.valueOf(params[0]);
        if (taskCode.equalsIgnoreCase("meterParam_dian") || taskCode.equalsIgnoreCase("meterParam_shui")) {
            List<MetricReportRequest> requests = new ArrayList<>();
            JSONArray array = reqData.getJSONArray("result");
            if (CollectionUtils.isEmpty(array)) {
                log.warn("{} {} {} result数据为空 {}",params[2],params[0], params[1], reqData.toJSONString());
                return null;
            }

            Map<String, List<Object>> dataMap = array.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(t -> {
                JSONObject key = JSONObject.parseObject(JSONObject.toJSONString(t));
                return key.getString("fMetercode")+key.getString("fUpdatetime");
            }));

            for (Map.Entry<String, List<Object>> entry : dataMap.entrySet()) {
                JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(entry.getValue().get(0)));
                MetricReportRequest reportRequest = new MetricReportRequest();
                String sn = data.getString("fMetercode");
                String deviceId = getDeviceContext().getDeviceIdBySn("ecems", sn);
                if (StringUtils.isBlank(deviceId)) {
                    //没有对应的恩牛设备
                    log.warn("{} {} {} {} 没有对应的恩牛设备", params[2],params[0], params[1], sn);
                    continue;
                }
                reportRequest.setDeviceId(deviceId);
                reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
                reportRequest.setTimeStamp(System.currentTimeMillis());
                reportRequest.setIngestionTime(System.currentTimeMillis());

                List<Metric> metrics = new ArrayList<>();
                Object ts = JsonMessagePayloadParser.typeOf(data.get("fUpdatetime"), DataTypeEnum.DATE);
                for (Object metric : entry.getValue()) {
                    JSONObject metricData = JSONObject.parseObject(JSONObject.toJSONString(metric));
                    if(metricData.get("fValue")!=null){
                        Metric metric1 = new Metric(ts != null ? (Long) ts : System.currentTimeMillis(), getDeviceContext().modelRefMetric(metricData.getString("fParamcode"),measureRefMap), metricData.get("fValue"));
                        metrics.add(metric1);
                    }
                }

                if (CollectionUtils.isEmpty(metrics)) {
                    log.warn("{} {} {} {} 没有对应的测点", params[2],params[0], params[1], sn);
                    continue;
                }

                reportRequest.setMetrics(metrics);

                requests.add(reportRequest);
            }

            return requests;
        }
        if (taskCode.equalsIgnoreCase("alarmEvent")) {
            List<EventReportRequest> requests = new ArrayList<>();
            JSONArray array = reqData.getJSONArray("list");
            for (Object obj : array) {
                JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(obj));
                EventReportRequest reportRequest = new EventReportRequest();
                String sn = data.getString("fDevicecode");
                String deviceId = getDeviceContext().getDeviceIdBySn("ecems", sn);
                if (StringUtils.isBlank(deviceId)) {
                    //没有对应的恩牛设备
                    log.warn("{} {} {} {} 没有对应的恩牛设备", params[2],params[0], params[1], sn);
                    continue;
                }
                reportRequest.setDeviceId(deviceId);
                reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
                reportRequest.setTimeStamp(System.currentTimeMillis());
                reportRequest.setIdentifier("alarm");
                reportRequest.setType("alarm");
                reportRequest.setVersion("0.0.1");

                List<Metric> metrics = new ArrayList<>();
                Object ts = JsonMessagePayloadParser.typeOf(data.get("fAlarmTime"), DataTypeEnum.DATE);
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    if(entry.getValue()!=null){
                        Metric metric1 = new Metric(ts != null ? (Long) ts : System.currentTimeMillis(), getDeviceContext().modelRefMetric(entry.getKey(),measureRefMap), entry.getValue());
                        metrics.add(metric1);
                    }
                }

                if (CollectionUtils.isEmpty(metrics)) {
                    log.warn("{} {} {} {} 没有对应的测点", params[2],params[0], params[1], sn);
                    continue;
                }

                reportRequest.setMetrics(metrics);

                requests.add(reportRequest);
            }

            return requests;
        }

        return null;
    }


    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        String sn = getDeviceContext().getSnByDeviceId(message.getDeviceId());
        if (StringUtils.isBlank(sn)) {
            throw new EncodeMessageException("没有对应的设备");
        }
        message.setDeviceId(sn);
        message.setMessageType(MessageType.CLOUD_OPERATION_REQ);
        return JsonUtil.object2JsonBytes(message);
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        return new byte[0];
    }


    @Override
    public boolean login(LoginRequest loginRequest) {
        return true;
    }

}
