package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MetricCloudCallRequest extends Message{
    Map<String, Object> param;
    long timeStamp;
    String entityTypeCode;
    String topic;
    String pKey;
    public MetricCloudCallRequest(){
        setMessageType(MessageType.CLOUD_CALL_REQ);
    }
}
