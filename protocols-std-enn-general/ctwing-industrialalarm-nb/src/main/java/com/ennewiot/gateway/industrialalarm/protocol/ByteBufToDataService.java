package com.ennewiot.gateway.industrialalarm.protocol;


import com.alibaba.fastjson.JSONObject;
import com.ennewiot.gateway.industrialalarm.constants.StandardsConst;
import com.ennewiot.gateway.industrialalarm.msg.base.DataPacket;
import com.ennewiot.gateway.industrialalarm.msg.report.*;
import com.ennewiot.gateway.industrialalarm.protocol.encrypt.EncryptService;
import com.ennewiot.gateway.industrialalarm.protocol.encrypt.EncryptServiceImpl;
import com.ennewiot.gateway.industrialalarm.msg.up.AlarmMsg;
import com.ennewiot.gateway.industrialalarm.msg.up.DataReportMsg;
import com.ennewiot.gateway.industrialalarm.msg.up.EndMsg;
import com.ennewiot.gateway.industrialalarm.utils.HexUtils;
import com.ennewiot.gateway.industrialalarm.utils.Util;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteOrder;
import java.util.Objects;

/**
 * @Auther: xinao-663
 * @Date: 2021/7/16 10:22
 * @Description:
 */
//@Service
@Slf4j
public class ByteBufToDataService {

    //    @Autowired
    private static volatile EncryptService encryptService;

    public static EncryptService getEncryptServiceInstance() {

        if (Objects.isNull(encryptService)) {
            synchronized (EncryptService.class) {
                if (Objects.isNull(encryptService)) {
                    encryptService = new EncryptServiceImpl();
                }
            }
        }
        return encryptService;

    }

//    @Autowired
//    private AuthenticationService authenticationService;

    //    @Override
//    public DataPacket byteBufToDataPacket(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
    public DataPacket byteBufToDataPacket(ByteBuf in) throws Exception {
//        log.info("接收报文>>>>> ip:{},hex:{}", ctx.channel().remoteAddress(), ByteBufUtil.hexDump(in));
        //包头最小长度
        if (in.readableBytes() < 18 || in.getByte(0) != StandardsConst.UP_HEAD || in.getUnsignedByte(in.writerIndex() - 1) != StandardsConst.TAIL) {
            log.warn("报文异常不进行解析,data:{}",ByteBufUtil.hexDump(in));
            return null;
        }
//        if (!authenticationService.authenticationMeterCode(ctx, in)) {
//            //没有注册 直接忽略
//            String deviceId = Util.getDeviceId(in);
//            in.clear();
//            throw new NoRegException(deviceId);
//        }

        //校验
        int pkgCrc = in.getUnsignedShortLE(in.writerIndex() - 3);
        //截取至校验码前 不包含校验码
        in.writerIndex(in.writerIndex() - 3);
        int calCheckCrc = Util.crc16(ByteBufUtil.getBytes(in));
        if (pkgCrc != calCheckCrc) {
            String deviceId = Util.getDeviceId(in);
            in.clear();
            log.error(deviceId, HexUtils.int2hex(pkgCrc, 2, ByteOrder.LITTLE_ENDIAN), HexUtils.int2hex(calCheckCrc, 2, ByteOrder.LITTLE_ENDIAN));
        }
        //解码
        return parse(in);
    }

    public DataPacket parse(ByteBuf bb) throws Exception {
        DataPacket packet;
        byte cmd = bb.getByte(12);
        log.info("cmd is {}", cmd);
        switch (cmd) {
            case StandardsConst.TERMINAL_MSG_LOGOUT:
                packet = new EndMsg(bb);
                break;
            case StandardsConst.TERMINAL_MSG_UPLOAD:
            case StandardsConst.TERMINAL_MSG_HISTORY_RECALL:
            case StandardsConst.TERMINAL_MSG_UPLOAD_WITH_TYPE:
            case StandardsConst.TERMINAL_MSG_HISTORY_RECALL_WITH_TYPE:
                packet = new DataReportMsg(bb);
                break;
            case StandardsConst.TERMINAL_MSG_ALARM:
            case StandardsConst.TERMINAL_MSG_ALARM_WITH_TYPE:
                packet = new AlarmMsg(bb);
                break;
            case StandardsConst.TERMINAL_MSG_ERROR_RESP:
                packet = new ErrorReportMsg(bb);
                break;
            case StandardsConst.SERVER_MSG_SEND_SECRET:
                packet = new SecretReportMsg(bb);
                break;
            case StandardsConst.SERVER_MSG_UPGRADE:
                packet = new UpgradeMsg(bb);
                break;
            case StandardsConst.SERVER_MSG_UPGRADE_NB:
                packet = new UpgradeNBMsg(bb);
                break;
            default:
                packet = new CommandReportMsg(bb);
        }
        byte keyNum = bb.getByte(11);
        if (0 != keyNum) {
            String deviceId = Util.getDeviceId(bb);
            getEncryptServiceInstance().decrypt(deviceId, keyNum, bb);
        }
        packet.parse();
        log.info("parse:{}", packet);
        log.info("parseJson:{}", JSONObject.toJSONString(packet));
        return packet;
    }




}
