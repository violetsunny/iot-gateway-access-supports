package cn.enncloud.iot.gateway.message;

import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

@Data
public class OperationResponse extends Message{
    boolean result;
    long timeStamp;

    public OperationResponse(){
        this.setMessageType(MessageType.CLOUD_OPERATION_RSP);
    }
}
