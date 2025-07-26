package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class HistoryMetricReportRequest extends Message{
    List<Metric> metrics;
    long timeStamp;
    public HistoryMetricReportRequest(){
        setMessageType(MessageType.CLOUD_HISTORY_REQ);
    }
}
