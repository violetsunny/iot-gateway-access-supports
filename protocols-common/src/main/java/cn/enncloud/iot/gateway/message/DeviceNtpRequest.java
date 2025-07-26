package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

import java.util.List;

@Data
public class DeviceNtpRequest extends Message{
    List<Metric> metrics;
    long timeStamp;
    public DeviceNtpRequest(){
        setMessageType(MessageType.DEVICE_REPORT_REQ);
    }
}
