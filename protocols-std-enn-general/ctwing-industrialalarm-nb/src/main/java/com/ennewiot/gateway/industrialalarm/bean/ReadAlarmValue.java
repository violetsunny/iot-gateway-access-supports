package com.ennewiot.gateway.industrialalarm.bean;

import com.ennewiot.gateway.industrialalarm.utils.HexUtils;
import lombok.Data;

import java.nio.ByteOrder;

/**
 * @author DongLi
 */
@Data
public class ReadAlarmValue {
    private String dataType;
    private String lowAlarmValue;
    private String highAlarmValue;

    public ReadAlarmValue parseBody(String payload){
        String dataType = payload.substring(0, 2);
        String lowAlarmValue = payload.substring(2, 10);
        String highAlarmValue = payload.substring(10,18);
        this.setDataType(dataType);
        this.setLowAlarmValue(String.valueOf(HexUtils.hex2int(lowAlarmValue, ByteOrder.LITTLE_ENDIAN) / 100.0));
        this.setHighAlarmValue(String.valueOf(HexUtils.hex2int(highAlarmValue, ByteOrder.LITTLE_ENDIAN) / 100.0));
        return this;
    }
}
