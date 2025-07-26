package cn.enncloud.iot.gateway.protocol.udf.messgae;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlarmInfo implements Serializable {

    private int wiretype;

    private String imei;

    private float lat;

    private float lng;

    private long t;

    private int wtype;

    public AlarmInfo() {
    }

    public AlarmInfo(JSONObject jsonObject) {
        this.wiretype = jsonObject.getInteger("wiretype");
        this.imei = jsonObject.getString("imei");
        this.lat = jsonObject.getFloat("lat");
        this.lng = jsonObject.getFloat("lng");
        this.t = jsonObject.getInteger("t");
        this.wtype = jsonObject.getInteger("wtype");
    }

}
