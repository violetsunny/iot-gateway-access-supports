package cn.enncloud.iot.gateway.protocol.enums;

public enum ProtocolTypeEnum {


    JAR("jar"),
    SCRIPT("script");


    private final String name;

    ProtocolTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
