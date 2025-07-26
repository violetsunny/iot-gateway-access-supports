package cn.enncloud.iot.gateway.protocol.std.energy.enums;

public enum ResponseCodeEnum {
    SUCCESS("0", ""),
    ERR001("ERR001", "调用接口异常"),
    ERR002("ERR002", "表计未注册"),
    ERR003("ERR003", "设备类型不存在"),
    ERR004("ERR004", "密钥已存在，不能重复下发"),
    ERR005("ERR005", "上报指令保存数据库失败"),
    ERR006("ERR006", "回执指令更新数据库失败"),
    ERR007("ERR007", "指令信息不能为空"),
    ERR008("ERR008", "指令信息验证失败"),
    ERR009("ERR009", "下发指令保存数据库失败"),
    ERR010("ERR010", "指令不存在");

    private String description;
    private String code;

    private ResponseCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static String getName(String code) {
        ResponseCodeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResponseCodeEnum c = var1[var3];
            if (c.getCode().equals(code)) {
                return c.description;
            }
        }

        return null;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
