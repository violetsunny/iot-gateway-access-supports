package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class MetricReportRequest extends Message{
    List<Metric> metrics;
    String resume = "N"; //Y-续传，N-非续传
    long timeStamp;
    long ingestionTime;
    boolean changeRpt = false;

    public MetricReportRequest(){
        setMessageType(MessageType.DEVICE_REPORT_REQ);
    }
}
