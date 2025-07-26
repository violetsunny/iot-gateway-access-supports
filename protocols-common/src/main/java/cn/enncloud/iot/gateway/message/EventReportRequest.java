package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EventReportRequest extends Message{
    //增加"eventStatus":1
    List<Metric> metrics;

    Long timeStamp;

    long ingestionTime;

    String version;
    //事件标识
    String identifier;
    //info-信息，alarm-告警，fault–故障
    String type;

    public EventReportRequest(){
        setMessageType(MessageType.DEVICE_EVENT_REQ);
    }
}
