package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ChangeDataReportRequest extends Message{
    Map<String, Object> param;//设备参数
    List<Metric> metrics;;//设备数据
    long timeStamp;
    long ingestionTime;
    public ChangeDataReportRequest(){
        setMessageType(MessageType.DEVICE_CHANGE_REQ);
    }
}
