package cn.enncloud.iot.gateway;

import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.OperationRequest;
import cn.enncloud.iot.gateway.airwind.protocol.MqttAirWindMessageCodec;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String readString = FileUtil.readString("msg.json", Charset.defaultCharset());
        int length = readString.getBytes().length;
        MqttAirWindMessageCodec mqttAirWindMessageCodec = new MqttAirWindMessageCodec();
        try {
            List<? extends Message> decode = mqttAirWindMessageCodec.decodeMulti(readString.getBytes());

            System.out.println(JSONUtil.toJsonStr(decode));


            OperationRequest operationRequest = new OperationRequest();
            operationRequest.setTimeStamp(System.currentTimeMillis());
            Map<String, Object> jsonObject = new HashMap<>();
            jsonObject.put("HAs", "1");
            operationRequest.setDeviceId("P0013_" + "KT51_CF3");
            operationRequest.setParam(jsonObject);
            byte[] encode = mqttAirWindMessageCodec.encode(operationRequest);

        } catch (DecodeMessageException | EncodeMessageException e) {
            throw new RuntimeException(e);
        }
    }
}