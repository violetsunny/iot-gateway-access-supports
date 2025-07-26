package com.ennewiot.gateway.industrialalarm.msg.up;

import com.ennewiot.gateway.industrialalarm.msg.base.UpPacket;
import io.netty.buffer.ByteBuf;

/**
 * 数据上报
 *
 * @author DongLi
 */
public class DataReportMsg extends UpPacket {
    @Override
    protected void parseBody() {
        super.parseBody();
    }

    public DataReportMsg(ByteBuf payload) {
        super(payload);
    }

}
