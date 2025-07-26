package cn.enncloud.iot.gateway.protocol.std.energy.msg.down;

import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.BCD;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DongLi
 */
@Data
public class DisConnectResp extends DataPacket {

    private String time;

    @Override
    public ByteBuf toByteBufMsg() {
        ByteBuf bb = super.toByteBufMsg();
        bb.writeByte(4);
        //不足16字节要填充至16字节
        bb.writeShortLE(16);
        byte[] timeBytes = BCD.toBcdBytes(time);
        bb.writeBytes(timeBytes);
        int patchLen = 16 - timeBytes.length;
        bb.writeBytes(new byte[patchLen]);
        return bb;
    }

    public static DisConnectResp disconnect(DataPacket msg) {
        DisConnectResp resp = new DisConnectResp();
        resp.setHeader(msg.getHeader());
        //年月日时分秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        String format = dateFormat.format(date);
        resp.setTime(format);
        return resp;
    }
}
