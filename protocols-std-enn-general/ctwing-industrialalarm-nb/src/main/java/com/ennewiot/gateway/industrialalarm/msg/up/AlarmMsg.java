package com.ennewiot.gateway.industrialalarm.msg.up;

import com.ennewiot.gateway.industrialalarm.msg.base.UpPacket;
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
