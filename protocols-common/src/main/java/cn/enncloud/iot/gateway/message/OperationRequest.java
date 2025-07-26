package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.Map;

@Data
public class OperationRequest extends Message{
    Map<String, Object> param;
    String function;
    long timeStamp;
    String topic;
    public OperationRequest(){
        setMessageType(MessageType.CLOUD_OPERATION_REQ);
    }
}
