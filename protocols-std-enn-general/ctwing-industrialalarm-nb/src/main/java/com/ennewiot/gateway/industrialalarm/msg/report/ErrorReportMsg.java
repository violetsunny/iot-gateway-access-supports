package com.ennewiot.gateway.industrialalarm.msg.report;

import com.ennewiot.gateway.industrialalarm.enums.ErrorCodeEnum;
import com.ennewiot.gateway.industrialalarm.msg.base.DataPacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class ErrorReportMsg extends DataPacket {
    private Byte errorCode;
    private String errorDesc;
    public ErrorReportMsg(ByteBuf paload) {
        super(paload);
    }

    @Override
    protected void parseBody() {
        ByteBuf bb = this.payload;
        this.setErrorCode(bb.readByte());
        this.setErrorDesc(ErrorCodeEnum.getDesc(this.getErrorCode()));
    }
}
