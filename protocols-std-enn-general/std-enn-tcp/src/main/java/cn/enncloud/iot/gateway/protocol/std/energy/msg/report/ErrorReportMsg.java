package cn.enncloud.iot.gateway.protocol.std.energy.msg.report;

import cn.enncloud.iot.gateway.protocol.std.energy.enums.ErrorCodeEnum;
import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
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
