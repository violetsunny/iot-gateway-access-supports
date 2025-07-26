package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

@Data
public class CloudAck {

    public static final String CODE_SUCCESS = "200";

    private String devtype;

    private String seq;

    private String ts;

    private String code;

    public CloudAck() {
    }

    public CloudAck(String devtype, String seq) {
        this(devtype, seq, CODE_SUCCESS);
    }

    public CloudAck(String devtype, String seq, String code) {
        this.devtype = devtype;
        this.seq = seq;
        this.ts = String.valueOf(System.currentTimeMillis());
        this.code = code;
    }


}
