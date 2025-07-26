/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.entity.Device;
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

/**
 * @author kanglele
 * @version $Id: GpswvMessageProtocol, v 0.1 2024/1/29 15:19 kanglele Exp $
 */
@Slf4j
public class WyDeviceProtocol extends AbstractProtocol {
    @Override
    public String getId() {
        return "wy-device";
    }

    @Override
    public String getName() {
        return "设备";
    }


    @Override
    public Message decode(byte[] messageBytes, Object... params0) throws DecodeMessageException {


//        Map<String, Object> params = getParams();
//        String sn = req.getString((String) params.get("sn"));
//        String deviceId = getDeviceContext().getDeviceIdBySn("gpswv", sn);
//        if(StringUtils.isBlank(deviceId)){
//            throw new DecodeMessageException(3,"没有对应的恩牛设备");
//        }
//        reportRequest.setDeviceId(deviceId);
//        reportRequest.setMessageId(String.format("%s%s", deviceId, UUID.randomUUID().toString().replace("-", "")));
//        reportRequest.setMessageType(MessageType.DEVICE_REPORT_REQ);
//
//        reportRequest.setTimeStamp(System.currentTimeMillis());
//        reportRequest.setIngestionTime(System.currentTimeMillis());
//
//        List<Metric> metrics = new ArrayList<>();
//        Collection<Map<String, String>> paramMap = ((Map) params.get("metrics")).values();
//        for (Map<String, String> param : paramMap) {
//            metrics.add(new Metric((Long) JsonMessagePayloadParser.typeOf(req.getString(param.get("ts")), DataTypeEnum.LONG), param.get("key"), req.getString(param.get("value"))));
//        }
//        reportRequest.setMetrics(metrics);
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        JSONObject req = JSONObject.parseObject(new String(messageBytes, StandardCharsets.UTF_8));
        List<MetricReportRequest> requests = new ArrayList<>();
        JSONObject datas = req.getJSONObject("datas");
        if(datas==null){
            log.warn("data数据为空 {}",req.toJSONString());
            return requests;
        }
        JSONArray array = datas.getJSONArray("content");
        if(CollectionUtils.isEmpty(array)){
            log.warn("data数据为空 {}",req.toJSONString());
            return requests;
        }
        for (Object obj : array) {
            JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(obj));
            MetricReportRequest reportRequest = new MetricReportRequest();
            String imei = data.getString("imei");
            String deviceId = getDeviceContext().getDeviceIdByImei(imei);
            if (StringUtils.isBlank(deviceId)) {
                //没有对应的恩牛设备
                log.warn("{} 没有对应的恩牛设备",deviceId);
                Device device = new Device();
                device.setSn(imei);
                device.setName(imei);
                device.setProductId(String.valueOf(getParams().get("productId")));
                device.setExtend(data);
                device.setTenantId(String.valueOf(getParams().get("tenantId")));
                device.setDeptId(String.valueOf(getParams().get("deptId")));
                deviceId = getDeviceContext().registerDevice(device);
                if (StringUtils.isBlank(deviceId)) {
                    continue;
                }

            }
            reportRequest.setDeviceId(deviceId);
            reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
            reportRequest.setTimeStamp(System.currentTimeMillis());
            reportRequest.setIngestionTime(System.currentTimeMillis());

            List<Metric> metrics = new ArrayList<>();
            Object metricObj = getParams().get("metric");
            JSONObject metricData = JSONObject.parseObject(JSONObject.toJSONString(metricObj));

            for(Map.Entry<String, Object> entry:metricData.entrySet()){
                Object ts = JsonMessagePayloadParser.typeOf(data.get("dataUpdateTime"), DataTypeEnum.DATE);
                Metric metric1 = new Metric(ts!=null?(Long)ts:System.currentTimeMillis(),(String)entry.getValue(), data.get(entry.getKey()));
                metrics.add(metric1);
            }

            if(CollectionUtils.isEmpty(metrics)){
                continue;
            }

            reportRequest.setMetrics(metrics);

            requests.add(reportRequest);
        }

        return requests;
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
