package com.ennewiot.gateway.industrialalarm.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * @author DongLi
 */
@Slf4j
public class Util {



    public static String byteToVersion(byte b) {
        String binaryString = StringUtils.leftPad(Integer.toBinaryString(b), 8, '0');
        binaryString = binaryString.substring(binaryString.length() - 8);
        String X = Integer.valueOf(binaryString.substring(0, 2), 2).toString();
        String Y = Integer.valueOf(binaryString.substring(2, 6), 2).toString();
        String Z = Integer.valueOf(binaryString.substring(6, 8), 2).toString();
        return X + "." + Y + "." + Z;
    }

    /**
     * 计算CRC16校验码
     * 此标准协议专用，其它协议不适用
     *
     *   字节数组
     * @return {@link String} 校验码
     */
    public static int getCRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;
        int i, j;
        //索引从1开始，略过包头
        for (i = 1; i < bytes.length; i++) {
            CRC ^= bytes[i] & 0x000000ff;
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        return CRC;
    }

    public static int crc16(byte[] source) {
        byte data;
        byte[] reg;
        byte[] ploy;
        //byte Op;
        //初始化多项式
        int temp = 0xFFFF;
        ploy = intToByteArray(temp, 2);
        //初始化寄存器
        temp = 0xFFFF;
        reg = intToByteArray(temp, 2);
        for (int i = 1; i < source.length; i++) {
            //获取数据
            data = source[i];
            ploy[0] = reg[1];
            ploy[1] = reg[0];
            ploy[0] = (byte) (ploy[0] ^ data);
            reg = intToByteArray(((byteArrayToInt(ploy)) ^ ((byteArrayToInt(ploy) & 0xFF) >> 4)), 2);
            reg = intToByteArray(((byteArrayToInt(reg)) ^ (byteArrayToInt(reg) << 12)), 2);
            reg = intToByteArray(((byteArrayToInt(reg)) ^ ((byteArrayToInt(reg) & 0xFF) << 5)), 2);
        }
        return byteArrayToInt(reg);
    }

    /**
     * 格式化辅助函数
     */
    private static byte[] intToByteArray(int iSource, int iArrayLen) {
        byte[] bLocalArr = new byte[iArrayLen];
        for (int i = 0; (i < 4) && (i < iArrayLen); i++) {
            bLocalArr[i] = (byte) (iSource >> 8 * i & 0xFF);
        }
        return bLocalArr;
    }

    private static int byteArrayToInt(byte[] bRefArr) {
        int iOutcome = 0;
        byte bLoop;

        for (int i = 0; i < bRefArr.length; i++) {
            bLoop = bRefArr[i];
            iOutcome += (bLoop & 0xFF) << (8 * i);
        }
        return iOutcome;
    }

    public static String getDeviceId(ByteBuf buf){
        return ByteBufUtil.hexDump(ByteBufUtil.getBytes(buf,3,8)).toUpperCase(Locale.ROOT);
    }

    /**
     * 从下发命令的报文中获取 命令码
     * @param buf
     * @return
     */
    public static String getDownCmdType(ByteBuf buf){
        if(buf == null || MathUtil.isOutOfBounds(12, 1, buf.capacity())){
            return "";
        }
        byte[] bytes = ByteBufUtil.getBytes(buf, 12, 1);
        String s = StringUtils.leftPad(Integer.toHexString(bytes[0]), 2, '0').toUpperCase();
        return s + "H";
    }

    /**
     * 解析数据,测试用
     * @param data
     */
//    public static void testParse(String data){
//        log.debug("testParse data: {}", data);
//        if(data==null || data.length()<40){
//            return;
//        }
//        StringBuilder sb= new StringBuilder();
//        sb.append("\n包头:"+data.substring(0,2));
//        sb.append("\n协议版本:"+data.substring(2,4));
//        sb.append("\n设备类型:"+data.substring(4,6));
//        String did = data.substring(6, 22);
//        sb.append("\n设备编号:"+ did);
//        String sec = data.substring(22, 24);
//        sb.append("\n密钥号:"+ sec);
//        String cmd = data.substring(24, 26);
//        sb.append("\n命令码:"+ cmd);
//        if(!"22".equals(cmd)&&!"23".equals(cmd)){
//            return;
//        }
//        String lens=data.substring(26,30);
//        int i = HexUtils.hex2int(lens, 2);
//        sb.append("\n长度:"+lens + "十进制:" + i);
//        String d2 = data.substring(30, 30 + i * 2);
//        int x = 2;
//        sb.append("\n数据域:");
//        sb.append("\n本包条数:"+ d2.substring(0, x));
//        sb.append("\n上报类型:" + d2.substring(x, x=x+2));
//        sb.append("\n数据类型:" + d2.substring(x, x=x+2));
//        sb.append("\n时间:" + d2.substring(x, x=x+12));
//        sb.append("\n电池电压:" + d2.substring(x, x=x+4));
//        sb.append("\n信号强度:" + d2.substring(x, x=x+2));
//       /* for(int k=1;k<11;k++){
//            sb.append("\n探测器:" + k);
//            sb.append("\n浓度:" + d2.substring(x, x=x+4));
//            sb.append("\n状态:" + d2.substring(x, x=x+2));
//        }
//        for(int k=1;k<11;k++){
//            sb.append("\n输出模块:" + k);
//            sb.append("\n状态:" + d2.substring(x, x=x+2));
//        }*/
//        log.debug("测试用 22H或23H数据: {}", sb.toString());
//    }
}
