package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class InfoCloudCallRequest extends Message{
    List<Metric> metrics;
    long timeStamp;
    public InfoCloudCallRequest(){
        setMessageType(MessageType.DEVICE_STATUS_REQ);
    }
}
