package cn.enncloud.iot.gateway.protocol.std.energy.msg.up;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.UpPacket;
import io.netty.buffer.ByteBuf;


/**
 * @author DongLi
 */
public class AlarmMsg extends UpPacket {
    @Override
    protected void parseBody() {
        super.parseBody();
    }

    public AlarmMsg(ByteBuf payload) {
        super(payload);
    }
}
