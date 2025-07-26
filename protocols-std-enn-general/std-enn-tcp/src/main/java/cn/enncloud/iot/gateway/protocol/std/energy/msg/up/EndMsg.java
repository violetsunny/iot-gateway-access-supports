package cn.enncloud.iot.gateway.protocol.std.energy.msg.up;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

/**
 * @author DongLi
 */
@Data
public class EndMsg extends DataPacket {
    private byte flag;
    @Override
    protected void parseBody() {
        ByteBuf bb =  this.payload;
        this.setFlag(bb.readByte());
    }

    public EndMsg(ByteBuf payload) {
        super(payload);
    }
}
