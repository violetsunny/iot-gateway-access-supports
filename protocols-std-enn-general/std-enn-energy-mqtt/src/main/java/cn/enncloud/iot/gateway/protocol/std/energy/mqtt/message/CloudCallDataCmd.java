package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.message;

import lombok.Data;

@Data
public class CloudCallDataCmd {

    private String devtype;

    private String seq;

    private String ts;


}
