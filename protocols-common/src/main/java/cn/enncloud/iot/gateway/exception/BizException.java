package cn.enncloud.iot.gateway.exception;

public class BizException  extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public BizException(String message) {
        super(message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Throwable e) {
        super(message, e);
    }

    public BizException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
