package cn.enncloud.iot.gateway.message;

import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

@Data
public class LoginResponse  extends Message{
    boolean login;
    long timeStamp;

    public LoginResponse(){
        setMessageType(MessageType.DEVICE_LOGIN_RSP);
    }
}
