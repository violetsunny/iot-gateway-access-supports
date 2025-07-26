package cn.enncloud.iot.gateway.protocol.std.energy.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2015/4/9.
 */
public class AESUtils {

    private static final String CipherMode = "AES/ECB/NoPadding";
    private static final String KEY_PAIR_GENERATOR = "AES";
    private static final int MOD = 16;
    private static Cipher cipher = null;
    private static final Queue<Cipher> threadCipherQueue = new ConcurrentLinkedQueue();
    private static final Map<String,Cipher> threadCipherMap = new ConcurrentHashMap();
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtils.class);

    static {
        try {
            cipher = Cipher.getInstance(CipherMode);
        } catch (Exception ee) {
            LOGGER.error("初始话化AES加减密工具失败",ee);
        }
    }

    /**
     * add by lihaifengh 20220318 初始化worker执行组加减密工具
     * @param nThreads
     */
    public static void initThreadCiphers(int nThreads){
        if(nThreads > 0){
            try {
                for(int i=0; i<nThreads; i++){
                    Cipher threadCipher = Cipher.getInstance(CipherMode);
                    threadCipherQueue.add(threadCipher);
                }
            }catch (Exception ee) {
                LOGGER.error("初始话化AES加减密工具失败",ee);
            }

        }

    }

    /**
     * add by lihaifengh 20220318  为worker执行组分配加减密工具
     * @param threadNum
     * @return
     */
    private static Cipher getCipher(long threadNum){
        Cipher threadCipher = threadCipherMap.get(String.valueOf(threadNum));
        if(threadCipher == null && !threadCipherQueue.isEmpty()){
            threadCipher = threadCipherQueue.poll();
            threadCipherMap.put(String.valueOf(threadNum),threadCipher);
        }
        if(threadCipher != null){
            return threadCipher;
        }
        return cipher;
    }

    public static String encrypt(String data, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String ret;
        SecretKeySpec keySpec = createKey(key);
        Cipher cipher = getCipher(Thread.currentThread().getId());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] result = cipher.doFinal(dataPadding(data));
        ret = HexUtils.hex2str(result);
        return ret;
    }

    public static void encrypt(ByteBuf data, String key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKeySpec keySpec = createKey(key);
        data.markReaderIndex();
        data.readerIndex(15);
        byte[] dataBytes = ByteBufUtil.getBytes(data);
        Cipher cipher = getCipher(Thread.currentThread().getId());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] result = cipher.doFinal(dataPadding(dataBytes));
        data.resetReaderIndex();
        data.writerIndex(15);
        data.writeBytes(result);
    }

    public static String decrypt(String data, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String ret;
        SecretKeySpec keySpec = createKey(key);
        Cipher cipher = getCipher(Thread.currentThread().getId());
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] result = cipher.doFinal(HexUtils.str2hex(data));
        ret = HexUtils.hex2str(result);
        return ret;
    }

    public static void decrypt(ByteBuf buf, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec keySpec = createKey(key);
        buf.markReaderIndex();
        buf.readerIndex(15);
        byte[] bytes = ByteBufUtil.getBytes(buf);
        Cipher cipher = getCipher(Thread.currentThread().getId());
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] result = cipher.doFinal(bytes);
        buf.resetReaderIndex();
        buf.writerIndex(15);
        buf.writeBytes(result);
    }


    private static SecretKeySpec createKey(String password) {
        byte[] data = keyPadding(password);
        return new SecretKeySpec(data, KEY_PAIR_GENERATOR);
    }

    private static byte[] dataPadding(String data) {
        byte[] ret = null;

        if (StringUtils.isNotBlank(data)) {
            byte[] tmp = HexUtils.str2hex(data);
            int tmpLength = tmp.length;
            int padLength = (tmpLength / MOD + ((tmpLength % MOD) > 0 ? 1 : 0)) * MOD;
            if (tmpLength % MOD > 0) {
                ret = new byte[padLength];
                System.arraycopy(tmp, 0, ret, 0, tmpLength);
                for (int i = tmpLength; i < padLength; i++) {
                    ret[i] = (byte) (padLength - tmpLength);
                }
            } else {
                ret = tmp;
            }
        }
        return ret;
    }

    private static byte[] dataPadding(byte[] data) {
        byte[] ret = null;
        if (data.length > 1) {
            if (data != null) {
                int tmpLength = data.length;
                int padLength = (tmpLength / MOD + ((tmpLength % MOD) > 0 ? 1 : 0)) * MOD;
                if (tmpLength % MOD > 0) {
                    ret = new byte[padLength];
                    System.arraycopy(data, 0, ret, 0, tmpLength);
                    for (int i = tmpLength; i < padLength; i++) {
                        ret[i] = (byte) (padLength - tmpLength);
                    }
                } else {
                    ret = data;
                }
            }
        }
        return ret;
    }

    private static byte[] keyPadding(String key) {
        byte[] ret = null;
        if (StringUtils.isNotBlank(key)) {
            byte[] tmp = HexUtils.str2hex(key);
            int tmpLen = tmp.length;
            if (tmpLen < MOD) {
                ret = new byte[MOD];
                for (int i = tmpLen; i < MOD; i++) {
                    ret[i] = (byte) (MOD - tmpLen);
                }
            } else {
                ret = tmp;
            }
        }
        return ret;
    }

    public static String getKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static int getKeyNum() {
        Random random = new Random();
        return random.nextInt(8) + 2;
    }

    public static String buildKeyGroup() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 8; ++i) {
            sb.append(getKey());
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString().toUpperCase();
    }
}
