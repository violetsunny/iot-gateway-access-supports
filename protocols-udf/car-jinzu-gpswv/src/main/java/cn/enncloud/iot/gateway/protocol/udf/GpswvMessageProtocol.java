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
 * https://open.gpswv.com/doc/web/#/2/832
 *
 * {
 *     "data": [
 *         {
 *             "vehicleId": 10329111,
 *             "vin": "LZFF31T69ND002706",
 *             "organizationId": 1202267,
 *             "organizationName": "盐城丰胜汽车销售有限公司",
 *             "carCapital": "河北金租",
 *             "deviceDetailBeanList": [
 *                 {
 *                     "imei": "863114540563813",
 *                     "deviceType": "G18",
 *                     "isWireless": "有线",
 *                     "gpsTime": 1706589332,
 *                     "durationTime": 522417,
 *                     "locationType": "GPS",
 *                     "lat": "33.231994",
 *                     "lng": "120.701953",
 *                     "platformEndtime": 1727082934,
 *                     "status": 10,
 *                     "duration": "6天1小时6分钟57秒",
 *                     "deviceStatusDesc": "离线"
 *                 },
 *                 {
 *                     "imei": "668613320029901",
 *                     "deviceType": "S18",
 *                     "chargePercentage": 76,
 *                     "isWireless": "无线",
 *                     "gpsTime": 1695225695,
 *                     "durationTime": 11718000,
 *                     "locationType": "GPS",
 *                     "lat": "33.217018",
 *                     "lng": "120.583397",
 *                     "platformEndtime": 1727082934,
 *                     "status": 10,
 *                     "duration": "135天15小时0秒",
 *                     "deviceStatusDesc": "离线"
 *                 }
 *             ]
 *         },
 *         {
 *             "vehicleId": 524156,
 *             "vin": "LZFF31W63KD035935",
 *             "organizationId": 1013991,
 *             "organizationName": "荃倾资产管理(上海)有限公司",
 *             "carCapital": "河北金租",
 *             "deviceDetailBeanList": [
 *                 {
 *                     "imei": "863656040477254",
 *                     "deviceType": "G17",
 *                     "isWireless": "有线",
 *                     "gpsTime": 1640915470,
 *                     "durationTime": 66201025,
 *                     "locationType": "GPS",
 *                     "lat": "37.257282",
 *                     "lng": "121.848953",
 *                     "platformEndtime": 1668749347,
 *                     "status": 30,
 *                     "duration": "766天5小时10分钟25秒",
 *                     "deviceStatusDesc": "未启用"
 *                 },
 *                 {
 *                     "imei": "668614472290793",
 *                     "deviceType": "S18",
 *                     "chargePercentage": 51,
 *                     "isWireless": "无线",
 *                     "gpsTime": 1669269726,
 *                     "durationTime": 37760369,
 *                     "locationType": "基站",
 *                     "lat": "37.1299",
 *                     "lng": "122.413306",
 *                     "platformEndtime": 1668751305,
 *                     "status": 30,
 *                     "duration": "437天59分钟29秒",
 *                     "deviceStatusDesc": "未启用"
 *                 }
 *             ]
 *         }
 *     ],
 *     "page": {
 *         "pageSize": 10,
 *         "currentPage": 1,
 *         "count": -1
 *     },
 *     "resultStatusBean": {
 *         "code": 0
 *     }
 * }
 * @author kanglele
 * @version $Id: GpswvMessageProtocol, v 0.1 2024/1/29 15:19 kanglele Exp $
 */
@Slf4j
public class GpswvMessageProtocol extends AbstractProtocol {
    @Override
    public String getId() {
        return "gpswv-gps";
    }

    @Override
    public String getName() {
        return "万位";
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
        List<Device> sns = new ArrayList<>();
        //分为两种 page-gps 返回定位信息  refer-mileage返回当日里程和当日行驶时长
        //第一个page-gps
        JSONArray array = req.getJSONArray("data");
        if(CollectionUtils.isEmpty(array)){
            log.warn("data数据为空 {}",req.toJSONString());
            return requests;
        }
        for (Object obj : array) {
            JSONObject data = JSONObject.parseObject(JSONObject.toJSONString(obj));
            MetricReportRequest reportRequest = new MetricReportRequest();
            //车架号
            String sn = data.getString("vin");
            String deviceId = getDeviceContext().getDeviceIdBySn("gpswv", sn);
            if (StringUtils.isBlank(deviceId)) {
                //没有对应的恩牛设备
                log.warn("{} 没有对应的恩牛设备",sn);
                continue;
            }
            reportRequest.setDeviceId(deviceId);
            reportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
            reportRequest.setTimeStamp(System.currentTimeMillis());
            reportRequest.setIngestionTime(System.currentTimeMillis());

            List<Metric> metrics = new ArrayList<>();
            JSONArray array1 = data.getJSONArray("deviceDetailBeanList");
            if(CollectionUtils.isEmpty(array1)){
                log.warn("deviceDetailBeanList数据为空 {}",data.toJSONString());
                continue;
            }
            for(Object obj1:array1){
                JSONObject data1 = JSONObject.parseObject(JSONObject.toJSONString(obj1));
                String isWireless = data1.getString("isWireless");
                if(StringUtils.isNotBlank(isWireless) && "有线".equals(isWireless)){
                    Object metricObj = getParams().get("metric");
                    JSONObject metricData = JSONObject.parseObject(JSONObject.toJSONString(metricObj));
                    for(Map.Entry<String, Object> entry:metricData.entrySet()){
                        Metric metric1 = new Metric(System.currentTimeMillis(),(String)entry.getValue(), data1.get(entry.getKey()));
                        metrics.add(metric1);
                    }

                    Device device = new Device();
                    device.setSn(sn);
                    device.setVehicleImei(data1.getString("imei"));
                    sns.add(device);
                }
            }

            if(CollectionUtils.isEmpty(metrics)){
                continue;
            }

            reportRequest.setMetrics(metrics);

            requests.add(reportRequest);
        }

        //反写imei
        if(CollectionUtils.isNotEmpty(sns)){
            getDeviceContext().updateImei(sns);
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
