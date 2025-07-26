package cn.enncloud.iot.gateway.exception;

import lombok.Getter;

public class DecodeMessageException extends Exception{
    @Deprecated
    public static int ErrorType_Timestamp = 1;
    @Deprecated
    public static int ErrorType_Unexpect_Metric = 2;
    @Deprecated
    public static int ErrorType_Unexpect_Receive = 3;



    /**
     * 时间戳错误
     */
    public static final int ERROR_TIMESTAMP = 1;

    /**
     * 指标错误
     */
    public static final int UNEXPECTED_METRIC = 2;

    /**
     * 接受数据异常
     */
    public static final int UNEXPECTED_RECEIVE = 3;

    /**
     * 方法不支持
     */
    public static final int UNSUPPORTED_METHOD = 4;

    /**
     * 参数错误
     */
    public static final int ILLEGAL_ARGUMENT = 5;


    /**
     * JS脚本调用返回错误
     */
    public static final int SCRIPT_INVOKE_ERROR = 6;


    @Getter
    int errorType;

    @Getter
    String errorMsg;
    public DecodeMessageException(int errorType, String errorMsg){
        super(errorMsg);
        this.errorType = errorType;
        this.errorMsg = errorMsg;
    }
}
