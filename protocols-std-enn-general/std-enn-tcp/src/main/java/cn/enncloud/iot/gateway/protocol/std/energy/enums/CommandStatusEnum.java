package cn.enncloud.iot.gateway.protocol.std.energy.enums;


public enum CommandStatusEnum {
    NON_EXE(0, "NON_EXE"),
    EXE_SUCCESS(1, "EXE_SUCCESS"),
    EXE_FAIL(2, "EXE_FAIL");

    private Integer code;
    private String name;

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    private CommandStatusEnum(final Integer code, final String name) {
        this.code = code;
        this.name = name;
    }
}
