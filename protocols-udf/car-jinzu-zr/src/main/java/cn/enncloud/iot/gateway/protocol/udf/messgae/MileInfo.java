package cn.enncloud.iot.gateway.protocol.udf.messgae;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class MileInfo {

    private String imei;

    private Double mile;

    private String dateTime;

    public MileInfo() {

    }

    public MileInfo(JSONObject jsonObject) {
        this.imei = jsonObject.getString("Imei");
        this.mile = jsonObject.getDouble("Mile");
        this.dateTime = jsonObject.getString("DateTime");
    }

}
