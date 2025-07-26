package cn.enncloud.iot.gateway.exception;

import lombok.Getter;

public class EncodeMessageException extends Exception{

    public EncodeMessageException(String message){
        super(message);
    }
    @Getter
    int errorType;

    @Getter
    String errorMsg;
    public EncodeMessageException(int errorType, String errorMsg){
        super(errorMsg);
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }
}
