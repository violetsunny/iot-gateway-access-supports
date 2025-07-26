package cn.enncloud.iot.gateway.protocol.std.energy.utils;

import sun.misc.BASE64Decoder;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * @Author tang yong
 * @Description //TODO $
 * @version: v1.8.0
 * @Date $ $
 * @Param $
 * @return $
 **/
public class Base64Util {
    public static String decryptBASE64(String key) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(key);
        return  new HexBinaryAdapter().marshal(bytes);
    }
}
