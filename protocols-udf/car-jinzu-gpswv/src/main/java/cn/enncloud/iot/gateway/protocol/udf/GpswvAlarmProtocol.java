/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.udf;

import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import cn.enncloud.iot.gateway.utils.JsonUtil;
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
 * https://open.gpswv.com/doc/web/#/60/760
 *
 * accessToken	string	约定的鉴权key
 * dataType	string	数据类型：alarm，gps，heartbeat，ext，obd
 * Content-Type	string	application/json;charset=UTF-8
 *
 *  [{
 *   "alarmCode": "TURNOVER",
 *   "course": 109,
 *   "imei": "868035043078226",
 *   "lat": "45.710503",
 *   "lng": "126.533974",
 *   "positionType": "GPS",
 *   "speed": 0,
 *   "time": 1603724123,
 *   "fenceId":"12138"
 * }]
 * @author kanglele
 * @version $Id: GpswvMessageProtocol, v 0.1 2024/1/29 15:19 kanglele Exp $
 */
@Slf4j
public class GpswvAlarmProtocol extends AbstractProtocol {
    @Override
    public String getId() {
        return "gpswv-alarm";
    }

    @Override
    public String getName() {
        return "万位-告警";
    }


    @Override
    public Message decode(byte[] messageBytes, Object... params0) throws DecodeMessageException {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        Map<String,String> headers = (Map) params[1];
        List<EventReportRequest> requests = new ArrayList<>();
        String datatype = headers.get("datatype");
        log.info("headers:{}",datatype);
        if(StringUtils.isBlank(datatype)){
            log.info("Path:{}",params[2]);
            datatype = String.valueOf(params[2]);
        }
        if(StringUtils.isNotBlank(datatype) && "alarm".equals(datatype)){
            JSONArray jsonArray = JSONObject.parseArray(JSONArray.toJSONString(new String(messageBytes, StandardCharsets.UTF_8)));
            for(Object obj:jsonArray){
                JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(obj));
                EventReportRequest reportRequest = new EventReportRequest();
                //imei换设备id
                String imei = data.getString("imei");
//                String deviceId = "17949748";//17949748-LZFF31T69ND002706-863114540563813
                String deviceId = getDeviceContext().getDeviceIdByImei(imei);
//                deviceId = (String)getParams().get(imei);//TODO test
                if (StringUtils.isBlank(deviceId)) {
                    //没有对应的恩牛设备
                    log.warn("{} 没有对应的恩牛设备",imei);
                    continue;
                }
                reportRequest.setDeviceId(deviceId);
                reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
                reportRequest.setTimeStamp(System.currentTimeMillis());
                reportRequest.setIdentifier((String)getParams().get("identifier"));
                reportRequest.setType("alarm");
                reportRequest.setVersion("0.0.1");

                List<Metric> metrics = new ArrayList<>();

                Object metricObj = getParams().get("metric");
                JSONObject metricData = JSONObject.parseObject(JSONObject.toJSONString(metricObj));
                Object mappingObj = getParams().get("mapping");
                JSONObject mappingData = JSONObject.parseObject(JSONObject.toJSONString(mappingObj));
                for(Map.Entry<String, Object> entry:metricData.entrySet()){
                    if(entry.getKey().equals("alarmCode")){
                        Object value = mappingData.get(data.getString(entry.getKey()));
                        if(value==null){
                            log.warn("没有这个告警类型 {}",data.getString(entry.getKey()));
                            continue;
                        }
                        Metric metric1 = new Metric(System.currentTimeMillis(),(String)entry.getValue(),value);
                        metrics.add(metric1);
                    } else {
                        Metric metric1 = new Metric(System.currentTimeMillis(),(String)entry.getValue(),data.getString(entry.getKey()));
                        metrics.add(metric1);
                    }

                }

                if(CollectionUtils.isEmpty(metrics)){
                    continue;
                }

                reportRequest.setMetrics(metrics);

                requests.add(reportRequest);
            }
        }


        return requests;
    }


    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        String sn = getDeviceContext().getSnByDeviceId(message.getDeviceId());
        if(StringUtils.isBlank(sn)){
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
