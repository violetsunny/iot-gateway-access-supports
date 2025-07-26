package cn.enncloud.iot.gateway.protocol.std.energy.msg.down;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

/**
 * 确认帧
 * @author DongLi
 */
@Data
public class CommonResp extends DataPacket {

    public static final byte SUCCESS = 0x01;//成功/确认

    @Override
    public ByteBuf toByteBufMsg() {
        ByteBuf bb = super.toByteBufMsg();
        bb.writeByte(7);
        //不足16字节要填充至16字节
        bb.writeShortLE(16);
        bb.writeByte(SUCCESS);
        byte[] bytes = new byte[15];
        bb.writeBytes(bytes);
        return bb;
    }

    public static CommonResp success(DataPacket msg) {
        CommonResp resp = new CommonResp();
        resp.setHeader(msg.getHeader());
        return resp;
    }
}
