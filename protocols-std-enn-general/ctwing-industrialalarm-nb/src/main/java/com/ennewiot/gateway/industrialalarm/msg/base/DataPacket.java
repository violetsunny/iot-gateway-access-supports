package com.ennewiot.gateway.industrialalarm.msg.base;

import com.ennewiot.gateway.industrialalarm.constants.StandardsConst;
import com.ennewiot.gateway.industrialalarm.utils.HexUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

/**
 * @author DongLi
 */
@Slf4j
@Data
public class DataPacket {

    /**
     * 消息头
     */
    protected Header header = new Header();

    /**
     * 消息体
     */
    protected ByteBuf payload;

    public DataPacket() {
    }

    public DataPacket(ByteBuf payload) {
        this.payload = payload;
    }

    public void parse() {
        try {
            String arg = ByteBufUtil.hexDump(this.payload);
            log.info("解密后数据报文：{}", arg);
            this.parseHead();
            //验证包体长度
            if (this.header.length != this.payload.readableBytes()) {
                throw new RuntimeException("包体长度有误，包长度："+this.payload.readableBytes()+"字节");
            }
            this.parseBody();
        } finally {
            this.clear();
        }
    }

    protected void parseHead() {
        header.setHead(Integer.toHexString(payload.readByte()));
        header.setVersion(payload.readByte());
        header.setDeviceType(payload.readByte());
        header.setDeviceId(ByteBufUtil.hexDump(readBytes(8)).toUpperCase(Locale.ROOT));
        header.setKeyNum(payload.readByte());
        header.setCmdCode(payload.readByte());
        header.setLength(payload.readShortLE());
        header.setCmdType(StringUtils.leftPad(Integer.toHexString(header.cmdCode), 2, '0').toUpperCase() + "H");
        log.info("-->> deviceId: {}, cmdType: {}", header.getDeviceId(), header.getCmdType());
    }

    /**
     * 请求报文重写
     */
    protected void parseBody(){
    }

    /**
     * 将多余没读的报文读掉
     */
    protected void clear(){
        this.payload.clear();
    }

    /**
     * 响应报文重写 并调用父类
     */
    public ByteBuf toByteBufMsg() {
        ByteBuf bb = ByteBufAllocator.DEFAULT.heapBuffer();
        bb.writeByte(StandardsConst.DOWN_HEAD);
        bb.writeByte(this.header.getVersion());
        bb.writeByte(this.header.getDeviceType());
        bb.writeBytes(HexUtils.str2hex(this.header.deviceId));
        bb.writeByte(0);//秘钥号，先占一个字节，后面encode替换
        return bb;
    }

    private static int getKeyNum() {
        Random random = new Random();
        return random.nextInt(8) + 2;
    }

    /**
     * 从ByteBuf中read固定长度的数组,相当于ByteBuf.readBytes(byte[] dst)的简单封装
     */
    public byte[] readBytes(int length) {
        byte[] bytes = new byte[length];
        this.payload.readBytes(bytes);
        return bytes;
    }

    /**
     * 从ByteBuf中读出固定长度的数组
     */
    public String readString(int length) {
        return new String(readBytes(length), StandardsConst.DEFAULT_CHARSET);
    }

    @Data
    public static class Header {
        //包头
        private String head;
        //协议版本
        private short version;
        //设备类型
        private short deviceType;
        //设备编号
        private String deviceId;
        //秘钥号
        private byte keyNum;
        //命令码
        private byte cmdCode;
        //长度
        private int length;
        //CRC校验码
        private String crc;
        //包尾
        private String tail;
        //自定义字段，非解析字段 命令码
        private String cmdType;
    }
}
