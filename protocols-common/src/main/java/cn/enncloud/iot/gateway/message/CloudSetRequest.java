package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.Map;

@Data
public class CloudSetRequest extends Message{
    Map<String, Object> param;//设备参数
    Map<String, Object> payload;//设备数据
    long timeStamp;
    String entityTypeCode;
    String topic;
    String pKey;
    public CloudSetRequest(){
        setMessageType(MessageType.CLOUD_SET_REQ);
    }
}
