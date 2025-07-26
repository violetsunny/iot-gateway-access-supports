package cn.enncloud.iot.gateway.protocol.std.energy.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author DongLi
 */
public class AnalysicUtils {

    /**
     * 编码表号 用于构建下行协议
     *
     * @param str
     * @return
     */
    public static String encodeCmdType(String str) {
        return str.substring(0,2);
    }

    /**
     * 获取数据报文CS校验码
     */
    public static String getCs(String... params) {
        StringBuilder res = new StringBuilder();
        for (String param : params) {
            if (StringUtils.isNotEmpty(param)) {
                res.append(param);
            }
        }
        return HexUtils.hex2str(CRCUtils.crc16(HexUtils.str2hex(res.toString()))).toUpperCase();
    }

    public static long getMeterDelayTime(final Long receiveTime, final long delayTime) {
        long now = System.currentTimeMillis();
        long passTime = now - receiveTime;
        long sleepTime = delayTime - passTime;
        if (sleepTime < 0) {
            sleepTime = 0;
        }
        return sleepTime;
    }

}
