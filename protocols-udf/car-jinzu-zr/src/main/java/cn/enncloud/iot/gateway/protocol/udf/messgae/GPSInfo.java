package cn.enncloud.iot.gateway.protocol.udf.messgae;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class GPSInfo implements Serializable {

    private int pktype;

    private int wiretype;

    private String imei;

    private String devtype;

    private int loctype;

    private float lng;

    private float lat;

    private int spd;

    private int dir;

    private int bat;

    private long t;

    public GPSInfo() {
    }

    public GPSInfo(JSONObject jsonObject) {
        this.pktype = jsonObject.getInteger("Pktype");
        this.wiretype = jsonObject.getInteger("Wiretype");
        this.imei = jsonObject.getString("Imei");
        this.devtype = jsonObject.getString("devtype");
        this.loctype = jsonObject.getInteger("Loctype");
        this.lng = jsonObject.getFloat("Lng");
        this.lat = jsonObject.getFloat("Lat");
        this.spd = jsonObject.getInteger("Spd");
        this.dir = jsonObject.getInteger("dir");
        this.bat = jsonObject.getInteger("bat");
        this.t = jsonObject.getLong("t");
    }

}
