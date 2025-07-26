package com.ennewiot;

import cn.enncloud.iot.gateway.message.MetricReportRequest;
import com.alibaba.fastjson.JSONObject;
import com.ennewiot.gateway.industrialalarm.protocol.NbAlarmDevMessageCodec;

public class Main {

    public static void main(String[] args) throws Exception {


//        String input = "{\n" +
//                "  \"IMEI\": \"862806069360672\",\n" +
//                "  \"IMSI\": \"undefined\",\n" +
//                "  \"assocAssetId\": \"\",\n" +
//                "  \"deviceId\": \"5abdcf285d4e462596853fa2340dd545\",\n" +
//                "  \"deviceType\": \"\",\n" +
//                "  \"messageType\": \"dataReport\",\n" +
//                "  \"payload\": {\n" +
//                "    \"APPdata\": \"Z0AVAWIVIP////8BIqABvOXnAKtQanZFCqzcWoxpSuVKndzp+zy4hdbq+SRyE9NpNr+ez6EFLNVq0gft4XgowGXZKx66qiSRTQl3D7/7LeVKndzp+zy4hdbq+SRyE9NpNr+ez6EFLNVq0gft4XgowGXZKx66qiSRTQl3D7/7LeVKndzp+zy4hdbq+SRyE9NpNr+ez6EFLNVq0gft4XgowGXZKx66qiSRTQl3D7/7LeVKndzp+zy4hdbq+SRyE9NpNr+ez6EFLNVq0gft4XgowGXZKx66qiSRTQl3D7/7Lfp2hN3rD4ip/yYtR+a7GBkd5S8Si+7G9NkycstwU9urLpOj3SiFCYYSQUt8Kaz5P+FD4gtxJO/vMPneVEMvs0Id5S8Si+7G9NkycstwU9urLpOj3SiFCYYSQUt8Kaz5P+FD4gtxJO/vMPneVEMvs0Id5S8Si+7G9NkycstwU9urLpOj3SiFCYYSQUt8Kaz5P+FD4gtxJO/vMPneVEMvs0Id5S8Si+7G9NkycstwU9urgWZ/n072WBP1IRcyer6/jZlcNfr+A9Y2h3pPu0tFAW2ivu0=\"\n" +
//                "  },\n" +
//                "  \"productId\": \"16996520\",\n" +
//                "  \"protocol\": \"lwm2m\",\n" +
//                "  \"serviceId\": \"\",\n" +
//                "  \"tenantId\": \"2000102221\",\n" +
//                "  \"timestamp\": 1700709413480,\n" +
//                "  \"topic\": \"v1/up/ad\",\n" +
//                "  \"upDataSN\": -1,\n" +
//                "  \"upPacketSN\": -1\n" +
//                "}";

//        String input = "{\"upPacketSN\":-1,\"upDataSN\":-1,\"topic\":\"v1/up/ad\",\"timestamp\":1701663603390,\"tenantId\":\"2000102221\",\"serviceId\":\"\",\"protocol\":\"lwm2m\",\"productId\":\"17001268\",\"payload\":{\"APPdata\":\"Z0AFASkFISMgBiEBAiAAldBWCbR2n/YWXkrlQZhXevPiB3a7o5ylq7e3HEa56Rqr9u0=\"},\"messageType\":\"dataReport\",\"deviceType\":\"\",\"deviceId\":\"7080211e52c94624b5ae833f54e3cc1a\",\"assocAssetId\":\"\",\"IMSI\":\"undefined\",\"IMEI\":\"861096065331304\"}";
//        String input = "{\"IMEI\":\"862651061441405\",\"IMSI\":\"undefined\",\"assocAssetId\":\"\", \"deviceId\":\"517aa973319e44b982600d649239c0cf\",\"deviceType\":\"\",\"messageType\":\"dataReport\",\"payload\":{\"APPdata\":\"ZwEFATAFIWFEFAUBEhAAVb6SUogOyIEyROXyFYAlO+Uv7Q==\"},\"productId\":\"17004655\",\"protocol\":\"lwm 2m\",\"serviceId\":\"\",\"tenantId\":\"2000102221\",\"timestamp\":1702365304798,\"topic\":\"v1/up/ad\",\"upDataSN\":-1,\"upPacketSN\":-1}";

//        String input = "{\"IMEI\":\"866693052453573\",\"IMSI\":\"undefined\",\"assocAssetId\":\"\",\"deviceId\":\"16e379c8c66a4ea08da7d1f5697bbe40\",\"deviceType\":\"\",\"messageType\":\"dataReport\",\"payload\":{\"APPdata\":\"AAAA\"},\"productId\":\"16996520\",\"protocol\":\"lwm2m\",\"serviceId\":\"\",\"tenantId\":\"2000102221\",\"timestamp\":1701162608528,\"topic\":\"v1/up/ad\",\"upDataSN\":-1,\"upPacketSN\":-1}";
        String input = "{\"IMEI\":\"862651061441405\",\"IMSI\":\"undefined\",\"assocAssetId\n" +
                "\":\"\",\"deviceId\":\"517aa973319e44b982600d649239c0cf\",\"deviceType\":\"\",\"messageType\":\"dataReport\",\"payload\":{\"APPdata\":\"ZwEFATAFIWFEFAUBEhAAg0OuxGW0t79gZggxTcJA8f297Q==\"},\"productId\":\"17004655\",\"protocol\"\n" +
                ":\"lwm2m\",\"serviceId\":\"\",\"tenantId\":\"2000102221\",\"timestamp\":1702539513012,\"topic\":\"v1/up/ad\",\"upDataSN\":-1,\"upPacketSN\":-1}";

        JSONObject jsonObject = JSONObject.parseObject(input);

        MetricReportRequest message = (MetricReportRequest) new NbAlarmDevMessageCodec().decode(JSONObject.toJSONBytes(jsonObject));

//        if (message == null || MapUtils.isEmpty(message.getMetric())) {
//            log.warn("电信云无有效上传测点:{},{}", message.getDeviceId(), 1);
//            return;
//        }
        System.out.println(JSONObject.toJSONString(message));
    }
}