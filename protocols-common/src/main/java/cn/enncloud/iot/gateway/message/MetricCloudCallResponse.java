package cn.enncloud.iot.gateway.message;

import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

@Data
public class MetricCloudCallResponse extends Message{
    boolean result;
    long timeStamp;

    public MetricCloudCallResponse(){
        this.setMessageType(MessageType.DEVICE_REPORT_RSP);
    }
}
