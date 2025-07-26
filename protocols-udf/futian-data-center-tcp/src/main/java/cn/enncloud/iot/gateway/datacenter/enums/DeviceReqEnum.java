package cn.enncloud.iot.gateway.datacenter.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DeviceReqEnum {


    REQUEST("request", "id_validate", "sequence"),
    MD5("md5", "id_validate", "result"),

    NOTIFY("notify", "heart_beat", "time"),

    REPORT("report", "supcon", "record_arrive"),

    AUTO_HISTORY("auto_history", "supcon", "auto_history_ack"),

    CONTINUOUS("continuous", "supcon", "record_arrive"),
    CONTINUOUS_END("continuous", "data", "continuous_ack");


    private String req;
    private String respName;

    private String resp;

    DeviceReqEnum(String req, String respName, String resp) {
        this.req = req;
        this.respName = respName;
        this.resp = resp;
    }

    public String getReq() {
        return req;
    }

    public String getResp() {
        return resp;
    }

    public String getRespName() {
        return respName;
    }

    public static DeviceReqEnum getRequestEnum(String reqType) {

        Optional<DeviceReqEnum> first = Arrays.stream(DeviceReqEnum.values()).filter(deviceReqEnum -> deviceReqEnum.req.equals(reqType)).findFirst();
        return first.orElse(null);
    }
}
