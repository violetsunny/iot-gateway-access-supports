package cn.enncloud.iot.gateway.message;


import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

@Data
public class Message {
    private String messageId;
    private String deviceId;
    private String sn;
    private MessageType messageType;
    private String response;
}
