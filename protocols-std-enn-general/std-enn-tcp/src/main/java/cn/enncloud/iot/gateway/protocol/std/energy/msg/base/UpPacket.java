package cn.enncloud.iot.gateway.protocol.std.energy.msg.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import lombok.Data;
import lombok.ToString;

/**
 * @author DongLi
 */
@Data
@ToString(callSuper = true)
public class UpPacket extends DataPacket{
    protected String data;

    @Override
    protected void parseBody() {
        ByteBuf bb =  this.payload;
        this.setData(ByteBufUtil.hexDump(bb));
    }

    public UpPacket(ByteBuf payload) {
        super(payload);
    }
}
