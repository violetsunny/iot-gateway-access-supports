package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CloudNtpRequest extends Message{
    Map<String, Object> param;
    Map<String, Object> payload;
    long timeStamp;
    String entityTypeCode;
    String topic;
    String pKey;
    public CloudNtpRequest(){
        setMessageType(MessageType.CLOUD_NTP_REQ);
    }
}
