package com.ennewiot.gateway.industrialalarm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    UNKNOWN_ERROR(0,"未知错误"),
    FRAME_HEAD_ERROR(1,"帧头格式错误"),
    FRAME_TAIL_ERROR(2,"帧尾格式错误"),
    SECRET_KENO_ERROR(3,"密钥号错误"),
    DATA_LENGTH_OUT_RANGE(4,"协议中数据“长度”数值超范围"),
    CRC_ERROR(5,"CRC校验错"),
    VERSION_ERROR(6,"协议版本号错"),
    DEVICE_TYPE_ERROR(7,"设备类型错误"),
    DEVICE_ID_ERROR(8,"设备编号错误"),
    INVALID_COMMAND(9,"无效命令码");

    private int errorCode;
    private String errorDesc;

    public static String getDesc(int errorCode){
        Optional<ErrorCodeEnum> first = Arrays.stream(values()).filter(t -> t.getErrorCode() == errorCode).findFirst();
        if(first.isPresent()){
            return first.get().getErrorDesc();
        }
        return null;
    }

}
