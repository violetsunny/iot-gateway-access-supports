package cn.enncloud.iot.gateway.protocol.std.energy.msg.report;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.UpPacket;
import io.netty.buffer.ByteBuf;

/**
 * NB远程升级
 */
public class UpgradeNBMsg extends UpPacket {
    /**
     *
     */
    private Boolean fail;

    public UpgradeNBMsg(ByteBuf payload) {
        super(payload);
    }

    @Override
    public void parseBody(){
        ByteBuf bb =  this.payload;
        super.parseBody();
        boolean fail = bb.readBoolean();
        this.setFail(false);
    }

    public Boolean getFail() {
        return fail;
    }

    public void setFail(Boolean fail) {
        this.fail = fail;
    }
}
