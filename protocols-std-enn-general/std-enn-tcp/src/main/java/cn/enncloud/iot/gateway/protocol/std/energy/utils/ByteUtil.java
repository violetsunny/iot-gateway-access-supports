package cn.enncloud.iot.gateway.protocol.std.energy.utils;


import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.zip.CRC32;

public class ByteUtil {

	/**
     * 计算CRC32值
     *
     * @param data
     * @return
     */
	public static long calCrc32(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        return crc32.getValue();
    }
    
    /**
	 * 判断指令是否为服务器主动下发后通讯模块回复的ACK消息
	 * 说明：
	 * 		CMD最低位：0表示通讯模块发起的请求，为1表示服务器下发后通信模块的响应
	 * 		服务器主动下发的指令，当服务器收到设备返回的消息后，不需要响应，否则会出现死循环
	 *
	 * @param cmd
	 * @return
	 */
    public static boolean isAckCmd(short cmd) {
		return (cmd & 0x00000001) == 1;
	}
    
	/**
     * 将十进制整数形式转换成127.0.0.1形式的ip地址
     *
     * @param longIp
     * @return
     */
    public static String longToIP(long longIp) {
        StringBuilder sb = new StringBuilder("");
        // 直接右移24位
        sb.append((longIp >>> 24));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append((longIp & 0x000000FF));
        return sb.toString();
    }
    
    /**
	 * 二进制转16进制
	 * 
	 * @author kansum
	 */
    public static String byteToHex(byte... src) {
		StringBuilder strBuff = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			strBuff.append(Integer.toHexString((0x000000FF & src[i]) | 0xFFFFFF00).substring(6));
		}
		return strBuff.toString().toUpperCase();
	}

	/**
	 * @Author DongLi
	 * @Description 转进制字符串
	 * @Date 2022/8/15 16:06
	 * @Param [bytes, radix] 字节数组，几进制
	 * @return java.lang.String
	 **/
	public static String binary(byte[] bytes, int radix){
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}

	public static  String toBinaryString(byte[] bytes){
		String binary = binary(bytes, 2);
		return StringUtils.leftPad(binary, 8 * bytes.length, '0');
	}


	
}
