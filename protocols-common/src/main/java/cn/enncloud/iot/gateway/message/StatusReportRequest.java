package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class StatusReportRequest extends Message{
    List<Metric> metrics;
    long timeStamp;
    public StatusReportRequest(){
        setMessageType(MessageType.DEVICE_STATUS_REQ);
    }
}
