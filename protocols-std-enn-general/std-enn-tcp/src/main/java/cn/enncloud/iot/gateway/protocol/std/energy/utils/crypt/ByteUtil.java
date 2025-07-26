package cn.enncloud.iot.gateway.protocol.std.energy.utils.crypt;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.zip.CRC32;

public class ByteUtil {

    private static final byte[] _secretKey = hexStringToBytes(str2HexStr("879cbe43fc790c53415e884757629733"));

    public ByteUtil() {
    }

    public static byte[] reverse(byte[] array) {
        for(int i = 0; i < array.length / 2; ++i) {
            byte temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return array;
    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[]{(byte)(res & 255), (byte)(res >> 8 & 255), (byte)(res >> 16 & 255), (byte)(res >>> 24)};
        return targets;
    }

    public static int byte2int(byte[] res) {
        int targets = res[0] & 255 | res[1] << 8 & '\uff00' | res[2] << 24 >>> 8 | res[3] << 24;
        return targets;
    }

    public static byte[] intToByteArray(int i) throws Exception {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(buf);
        out.writeInt(i);
        byte[] b = buf.toByteArray();
        out.close();
        buf.close();
        return b;
    }

    public static long byteToUnsingedInt(byte[] res) {
        return (long)((res[0] & -16777216) + ((res[1] & 255) << 16) + ((res[2] & 255) << 8) + (res[3] & 255));
    }

    public static byte[] shortToByteArray(short s) {
        byte[] targets = new byte[2];

        for(int i = 0; i < 2; ++i) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte)(s >>> offset & 255);
        }

        return targets;
    }

//    public static short byteToShort(byte[] b) {
//        short s = false;
//        short s0 = (short)(b[0] & 255);
//        short s1 = (short)(b[1] & 255);
//        s0 = (short)(s0 << 8);
//        short s = (short)(s0 | s1);
//        return s;
//    }

    public static String bytes2HexString(byte[] b) {
        String ret = "";

        for(int i = 0; i < b.length; ++i) {
            String hex = Integer.toHexString(b[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            ret = ret + hex.toUpperCase();
        }

        return ret;
    }

    public static String byte2HexString(byte b) {
        return Integer.toHexString(b & 255 | -256).substring(6);
    }

    public static String bytesToBits(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        byte[] var2 = bytes;
        int var3 = bytes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            sb.append(byteToBits(b));
        }

        return sb.toString();
    }

    public static String byteToBits(byte b) {
        int z = b | 256;
        String str = Integer.toBinaryString(z);
        int len = str.length();
        return str.substring(len - 8, len);
    }

    public static final byte[] crc32(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        Long l = crc32.getValue();
        byte[] b = longToByte(l);
        b = reverse(b);
        return Arrays.copyOfRange(b, 4, b.length);
    }

    public static byte[] longToByte(long number) {
        long temp = number;
        byte[] b = new byte[8];

        for(int i = 0; i < b.length; ++i) {
            b[i] = (new Long(temp & 255L)).byteValue();
            temp >>= 8;
        }

        return b;
    }

    public static final int calculateCheckSum(byte[] bytes) {
        int sum = 0;
        byte[] var2 = bytes;
        int var3 = bytes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            sum += b;
        }

        return sum > 65535 ? sum - '\uffff' : sum;
    }

    public static void putShort(byte[] b, short s, int index) {
        b[index + 1] = (byte)(s >> 8);
        b[index + 0] = (byte)(s >> 0);
    }

    public static short getShort(byte[] b, int index) {
        reverse(b);
        return (short)(b[index + 1] << 8 | b[index + 0] & 255);
    }

    public int getUnsignedByte(byte data) {
        return data & 255;
    }

    public static void putInt(byte[] bb, int x, int index) {
        bb[index + 3] = (byte)(x >> 24);
        bb[index + 2] = (byte)(x >> 16);
        bb[index + 1] = (byte)(x >> 8);
        bb[index + 0] = (byte)(x >> 0);
    }

    public static int getInt(byte[] bb, int index) {
        return (bb[index + 3] & 255) << 24 | (bb[index + 2] & 255) << 16 | (bb[index + 1] & 255) << 8 | (bb[index + 0] & 255) << 0;
    }

    public static void putLong(byte[] bb, long x, int index) {
        bb[index + 7] = (byte)((int)(x >> 56));
        bb[index + 6] = (byte)((int)(x >> 48));
        bb[index + 5] = (byte)((int)(x >> 40));
        bb[index + 4] = (byte)((int)(x >> 32));
        bb[index + 3] = (byte)((int)(x >> 24));
        bb[index + 2] = (byte)((int)(x >> 16));
        bb[index + 1] = (byte)((int)(x >> 8));
        bb[index + 0] = (byte)((int)(x >> 0));
    }

    public static long getLong(byte[] bb, int index) {
        return (long)((bb[index + 7] & 255) << 56 | (bb[index + 6] & 255) << 48 | (bb[index + 5] & 255) << 40 | (bb[index + 4] & 255) << 32 | (bb[index + 3] & 255) << 24 | (bb[index + 2] & 255) << 16 | (bb[index + 1] & 255) << 8 | (bb[index + 0] & 255) << 0);
    }

    public static void putChar(byte[] bb, char ch, int index) {
        int temp = ch;

        for(int i = 0; i < 2; ++i) {
            bb[index + i] = (new Integer(temp & 255)).byteValue();
            temp >>= 8;
        }

    }

    public static char getChar(byte[] b, int index) {
        int s = 0;
        if (b[index + 1] > 0) {
            s += b[index + 1];
        } else {
            s += 256 + b[index + 0];
        }

        s *= 256;
        if (b[index + 0] > 0) {
            s += b[index + 1];
        } else {
            s += 256 + b[index + 0];
        }

        char ch = (char)s;
        return ch;
    }

    public static void putFloat(byte[] bb, float x, int index) {
        int l = Float.floatToIntBits(x);

        for(int i = 0; i < 4; ++i) {
            bb[index + i] = (new Integer(l)).byteValue();
            l >>= 8;
        }

    }

    public static float getFloat(byte[] b, int index) {
        int l = b[index + 0];
        l &= 255;
        l |= b[index + 1] << 8;
        l &= 65535;
        l |= b[index + 2] << 16;
        l &= 16777215;
        l |= b[index + 3] << 24;
        return Float.intBitsToFloat(l);
    }

    public static float getFloatD(byte[] b, int index) {
        reverse(b);
        int l = b[index + 0];
        l &= 255;
        l |= b[index + 1] << 8;
        l &= 65535;
        l |= b[index + 2] << 16;
        l &= 16777215;
        l |= b[index + 3] << 24;
        return Float.intBitsToFloat(l);
    }

    public static void putDouble(byte[] bb, double x, int index) {
        long l = Double.doubleToLongBits(x);

        for(int i = 0; i < 8; ++i) {
            bb[index + i] = (new Long(l)).byteValue();
            l >>= 8;
        }

    }

    public static double getDouble(byte[] b, int index) {
        long l = (long)b[0];
        l &= 255L;
        l |= (long)(b[1] << 8);
        l &= 65535L;
        l |= (long)(b[2] << 16);
        l &= 16777215L;
        l |= (long)(b[3] << 24);
        l &= -1L;
        l |= (long)(b[4] << 32);
        l &= -1L;
        l |= (long)(b[5] << 40);
        l &= -1L;
        l |= (long)(b[6] << 48);
        l &= -1L;
        l |= (long)(b[7] << 56);
        return Double.longBitsToDouble(l);
    }

    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();

        for(int i = 0; i < bs.length; ++i) {
            int bit = (bs[i] & 240) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 15;
            sb.append(chars[bit]);
        }

        return sb.toString();
    }

    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static String getHexString(byte[] b, int index, int count) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (b != null && index >= 0 && b.length >= index + count) {
            for(int i = index; i < count + index; ++i) {
                int v = b[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static String getBinaryString(int d, int length) {
        StringBuilder stringBuilder = new StringBuilder("");
        String hv = Integer.toBinaryString(d);

        for(int j = 0; j < length - hv.length(); ++j) {
            stringBuilder.append(0);
        }

        stringBuilder.append(hv);
        return stringBuilder.toString();
    }

    public static String getBinaryReverseString(int d, int length) {
        StringBuilder stringBuilder = new StringBuilder("");
        String hv = Integer.toBinaryString(d);

        for(int j = 0; j < length - hv.length(); ++j) {
            stringBuilder.append(0);
        }

        stringBuilder.append(hv);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static byte[] ReversEndian(byte[] b, int count, boolean big) {
        byte[] data = new byte[count];

        int i;
        for(i = 0; i < count; ++i) {
            data[i] = b[i];
        }

        if (!big) {
            for(i = 0; i < count; ++i) {
                byte by = b[i];
                data[count - i - 1] = by;
            }
        }

        return data;
    }

//    public static short htons(short s) {
//        short rslt = false;
//        byte[] bs1 = new byte[2];
//        putShort(bs1, s, 0);
//        byte[] bs2 = ReversEndian(bs1, 2, false);
//        short rslt = getShort(bs2, 0);
//        return rslt;
//    }
//
//    public static int htonl(int d) {
//        int rslt = false;
//        byte[] bs1 = new byte[4];
//        putInt(bs1, d, 0);
//        byte[] bs2 = ReversEndian(bs1, 4, false);
//        int rslt = getInt(bs2, 0);
//        return rslt;
//    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    public static int hexStringToInt(String hex) {
        BigInteger bi = new BigInteger(hex, 16);
        return bi.intValue();
    }

    public static long hexStringToLong(String hex) {
        BigInteger bi = new BigInteger(hex, 16);
        return bi.longValue();
    }

    public static short hexStringToShort(String hex) {
        BigInteger bi = new BigInteger(hex, 16);
        return bi.shortValue();
    }

    public static byte[] concatAll(byte[] first, byte[]... others) {
        int totalLength = first.length;
        byte[][] var3 = others;
        int offset = others.length;

        for(int var5 = 0; var5 < offset; ++var5) {
            byte[] array = var3[var5];
            totalLength += array.length;
        }

        byte[] result = Arrays.copyOf(first, totalLength);
        offset = first.length;
        byte[][] arrayOfByte2 = others;
        int arrayCount = others.length;

        for(int i = 0; i < arrayCount; ++i) {
            byte[] array = arrayOfByte2[i];
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    public static String double2String(double d) {
        BigDecimal bg = new BigDecimal(d * 100.0);
        double doubleValue = bg.setScale(2, 4).doubleValue();
        return String.valueOf((int)doubleValue);
    }

    public static boolean memcmp(byte[] data1, byte[] data2, int len) {
        if (data1 == null && data2 == null) {
            return true;
        } else if (data1 != null && data2 != null) {
            if (data1 == data2) {
                return true;
            } else {
                boolean bEquals = true;

                for(int i = 0; i < data1.length && i < data2.length && i < len; ++i) {
                    if (data1[i] != data2[i]) {
                        bEquals = false;
                        break;
                    }
                }

                return bEquals;
            }
        } else {
            return false;
        }
    }

    public static String setEncrypt(String str) {
        String sn = "xinaotest";
        int[] snNum = new int[str.length()];
        String result = "";
        String temp = "";
        int i = 0;

        int k;
        for(k = 0; i < str.length(); ++k) {
            if (k == sn.length()) {
                k = 0;
            }

            snNum[i] = str.charAt(i) ^ sn.charAt(k);
            ++i;
        }

        for(k = 0; k < str.length(); ++k) {
            if (snNum[k] < 10) {
                temp = "00" + snNum[k];
            } else if (snNum[k] < 100) {
                temp = "0" + snNum[k];
            }

            result = result + temp;
        }

        return result;
    }

    public static String getEncrypt(String str) {
        String sn = "xinaotest";
        char[] snNum = new char[str.length() / 3];
        String result = "";
        int i = 0;

        int k;
        for(k = 0; i < str.length() / 3; ++k) {
            if (k == sn.length()) {
                k = 0;
            }

            int n = Integer.parseInt(str.substring(i * 3, i * 3 + 3));
            snNum[i] = (char)((char)n ^ sn.charAt(k));
            ++i;
        }

        for(k = 0; k < str.length() / 3; ++k) {
            result = result + snNum[k];
        }

        return result;
    }

    public static int getUnsignedByte(short data) {
        return data & '\uffff';
    }

    public static String encryptDecrypt(String input) {
        String a = "879cbe43fc790c53415e884757629733 ";
        char[] key = a.toCharArray();
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); ++i) {
            output.append((char)(input.charAt(i) ^ key[i % key.length]));
        }

        return output.toString();
    }

    public static byte[] byteXOR(byte[] param1) {
        byte[] ByteXOR = new byte[param1.length];

        for(int i = 0; i < param1.length; ++i) {
            byte temp1 = param1[i];
            byte temp3 = (byte)(temp1 ^ _secretKey[i % _secretKey.length]);
            ByteXOR[i] = temp3;
        }

        return ByteXOR;
    }

    /** @deprecated */
    @Deprecated
    public static byte[] byteXOR(byte[] parameter1, byte[] parameter2) {
        byte[] ByteXOR = new byte[parameter1.length];

        for(int i = 0; i < parameter1.length; ++i) {
            byte temp1 = parameter1[i];
            byte temp2 = parameter2[i];
            byte temp3 = (byte)(temp1 ^ temp2);
            ByteXOR[i] = temp3;
        }

        return ByteXOR;
    }

    public static void main(String[] args) {
        System.out.println(bytes2HexString("xinaotest".getBytes()));
        System.out.println(str2HexStr("fecc8bf3"));
        System.out.println(bytes2HexString("879cbe43fc790c53415e884757629733".getBytes()));
        byte[] bs = byteXOR(hexStringToBytes("000032303134313132393031582D28330001449A000151EC0002000000020148000300000003001C0003BE9900031A830004001600050001"));
        System.out.println(new String(hexStringToBytes("454E43303030303030303100")));
        System.out.println(bytes2HexString(bs));
        System.out.println("---------------------");
        DecimalFormat fnum = new DecimalFormat("##0.00");
        String stringValue = fnum.format((double)getFloat(hexStringToBytes("0000A040"), 0));
        System.out.println(stringValue);
        System.out.println(String.valueOf(getShort(hexStringToBytes("0006"), 0)));
        byte b = -16;
        System.out.println(byte2HexString(b));
        System.out.println(getFloatD(hexStringToBytes("40066666"), 0));
        System.out.println(str2HexStr(encryptDecrypt("TIH0018255907")));
    }

    public static byte[] byteIncrement(byte parameter1, byte parameter2) {
        byte[] bytes = new byte[2];
        String parameter = byte2HexString(parameter1) + byte2HexString(parameter2);
        int i = Integer.parseInt(parameter);
        ++i;
        if (i > 9999) {
            parameter1 = 0;
            parameter2 = 0;
        } else {
            String s = String.valueOf(i);
            if (s.length() == 1) {
                s = "000" + s;
            } else if (s.length() == 2) {
                s = "00" + s;
            } else if (s.length() == 3) {
                s = "0" + s;
            }

            parameter1 = Byte.parseByte(s.substring(0, 2));
            parameter2 = Byte.parseByte(s.substring(2, 4));
        }

        bytes[0] = parameter1;
        bytes[1] = parameter2;
        return bytes;
    }
}
