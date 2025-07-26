package cn.enncloud.iot.gateway.protocol.std.energy.msg.up;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.UpPacket;
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
