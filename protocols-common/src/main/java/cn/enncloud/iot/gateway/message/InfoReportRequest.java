package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class InfoReportRequest extends Message{
    JSONObject data;
    long timeStamp;
    long ingestionTime;
    public InfoReportRequest(){
        setMessageType(MessageType.DEVICE_INFO_REQ);
    }
}
