package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class StatusCloudCallRequest extends Message{
    List<Metric> metrics;
    long timeStamp;
    public StatusCloudCallRequest(){
        setMessageType(MessageType.DEVICE_STATUS_REQ);
    }
}
