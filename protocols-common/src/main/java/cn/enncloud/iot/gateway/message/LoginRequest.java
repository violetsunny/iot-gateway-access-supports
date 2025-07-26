package cn.enncloud.iot.gateway.message;

import cn.enncloud.iot.gateway.message.enums.MessageType;
import lombok.Data;

@Data
public class LoginRequest extends Message{
    String username;
    String password;
    public LoginRequest(){
        setMessageType(MessageType.DEVICE_LOGIN_REQ);
    }

}
