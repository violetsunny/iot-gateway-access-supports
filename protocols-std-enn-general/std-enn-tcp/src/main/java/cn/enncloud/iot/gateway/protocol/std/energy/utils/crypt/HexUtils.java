package cn.enncloud.iot.gateway.protocol.std.energy.utils.crypt;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HexUtils {
    private static final Logger log = LoggerFactory.getLogger(HexUtils.class);
    static String hexString = "0123456789ABCDEF";

    public HexUtils() {
    }

    public static String int2hex(int val) {
        return int2hex(val, 4, ByteOrder.LITTLE_ENDIAN);
    }

    public static String int2hex(int val, int len) {
        return int2hex(val, len, ByteOrder.LITTLE_ENDIAN);
    }

    public static String int2hex(int val, int len, ByteOrder bo) {
        ByteBuf buf = Unpooled.buffer(len).order(bo);
        switch (len) {
            case 1:
                buf.writeByte(val);
                break;
            case 2:
                buf.writeShort(val);
            case 3:
            default:
                break;
            case 4:
                buf.writeInt(val);
        }

        return ByteBufUtil.hexDump(buf);
    }

    public static int hex2int2big(String val) {
        return hex2int(val, 2, ByteOrder.BIG_ENDIAN);
    }

    public static int hex2int(String val) {
        return hex2int(val, ByteOrder.LITTLE_ENDIAN);
    }

    public static long hex2long(String val) {
        return Long.parseLong(val, 16);
    }

    public static int hex2int(String val, ByteOrder bo) {
        if (val.length() % 2 > 0) {
            val = "0" + val;
        }

        return hex2int(val, val.length() / 2, bo);
    }

    public static int hex2int(String val, int len) {
        return hex2int(val, len, ByteOrder.LITTLE_ENDIAN);
    }

    public static int hex2int(String val, int len, ByteOrder bo) {
        ByteBuf buf = null;

        try {
            buf = Unpooled.buffer(len).order(bo);
            buf.writeBytes(Hex.decodeHex(val.toCharArray()));
            switch (len) {
                case 1:
                    return buf.readByte();
                case 2:
                    return buf.readShort();
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    throw new Exception("Length field value " + len + " (expected: 1, 2, 3, 4, or 8)" + val);
                case 4:
                    return buf.readInt();
                case 8:
                    Long v = buf.readLong();
                    return v.intValue();
            }
        } catch (Exception var5) {
            assert buf != null;

            buf.clear();
            log.error("inputParams:{} and errorMessage:{}", new Object[]{val, var5.getMessage(), var5});
            return 0;
        }
    }

    public static byte[] str2hex(String ss) {
        byte[] digest = new byte[ss.length() / 2];

        for(int i = 0; i < digest.length; ++i) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte)byteValue;
        }

        return digest;
    }

    public static String hex2str(byte[] b) {
        StringBuilder hexString = new StringBuilder();
        byte[] var2 = b;
        int var3 = b.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte aB = var2[var4];
            String plainText = Integer.toHexString(255 & aB);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }

            hexString.append(plainText);
        }

        return hexString.toString();
    }

    public static float hexStr2float(String hexStr, ByteOrder byteOrder) {
        return Float.intBitsToFloat(hex2int(hexStr, byteOrder));
    }

    public static String float2hexStr(float f, ByteOrder byteOrder) {
        String value = Integer.toHexString(Float.floatToIntBits(f));
        if (byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
            value = value.substring(6) + value.substring(4, 6) + value.substring(2, 4) + value.substring(0, 2);
        }

        return value;
    }

    public static int checksum(String val) {
        int chkValue = 0;

        try {
            byte[] hex = Hex.decodeHex(val.toCharArray());
            byte[] var3 = hex;
            int var4 = hex.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Byte t = var3[var5];
                chkValue += t.intValue();
            }
        } catch (DecoderException var7) {
            log.error("inputParams:{} and errorMessage:{}", new Object[]{val, var7.getMessage(), var7});
            chkValue = 0;
        }

        return chkValue & 255;
    }

    public static String getCRC(byte[] bytes) {
        int CRC = 65535;
        int POLYNOMIAL = 'ꀁ';

        for(int i = 0; i < bytes.length; ++i) {
            CRC ^= bytes[i] & 255;

            for(int j = 0; j < 8; ++j) {
                if ((CRC & 1) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }

        return Integer.toHexString(CRC);
    }

    public static double hex2double(String hexStr, ByteOrder byteOrder) {
        return Double.longBitsToDouble(Long.parseLong(hexStr, 16));
    }

    public static double hex22double(String hexStr) {
        return Double.longBitsToDouble(Long.parseLong(hexStr, 2));
    }

    public static String hexString2binaryString(String hexString) {
        if (hexString != null && hexString.length() % 2 == 0) {
            String bString = "";

            for(int i = 0; i < hexString.length(); ++i) {
                String tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
                bString = bString + tmp.substring(tmp.length() - 4);
            }

            return bString;
        } else {
            return null;
        }
    }

    public static String hexString2String(String src) {
        String temp = "";

        for(int i = 0; i < src.length() / 2; ++i) {
            temp = temp + (char)Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }

        return temp;
    }

    public static String toBinary(String str) {
        char[] strChar = str.toCharArray();
        String result = "";

        for(int i = 0; i < strChar.length; ++i) {
            result = result + Integer.toBinaryString(strChar[i]) + "";
        }

        return result;
    }

    public static String strTo16(String s) {
        String str = "";

        for(int i = 0; i < s.length(); ++i) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }

        return str;
    }

    public static void main2(String[] args) {
        String str = "7B01001631353233303330303131300A84BB1C0FA27B";
        System.out.println(str.length());
        System.out.println(hexString2String(str.substring(8, 30)));
    }

    public static String decode(String bytes) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);

        for(int i = 0; i < bytes.length(); i += 2) {
            baos.write(hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1)));
        }

        return new String(baos.toByteArray(), "gbk");
    }

    public static void main1(String[] args) {
        String str = "2A532C0D0A52563A2C312E302C312E302C312E302C57502C0D0A534E3A2C423931334353303031342C0D0A43443A2C38393836303262363136313733303239363432352C0D0A504E3A2C30313233343536373839302C0D0A47493A2C333134372E313239322C4E2C31313935372E363231382C452C3130332C0D0A414C3A2C342C302C302C383030302C393030302C0D0A495043313A2C3132332E35382E3234332E38392C31353234352C5443502C0D0A495043323A2C3132332E35382E3234332E38392C31353234352C5443502C0D0A41504E433A2C434D4E45542C2C2C0D0A54503A2C342C54454D502C0D0A44543A2C31382F30392F30352C31353A31383A34352B30302C0D0A44493A2C312C302C31352C6D2C0D0A5654286D56293A2C333538372C44432C0D0A45433A2C302C0D0A54543A2C312C0D0A43513A2C32302C0D0A56553A2C54454D5028A1E6292C0D0A32352C0D0A45442C0D0A43533A2C39342C0D0A";

        try {
            float f = (float)hex2int("00000A72", ByteOrder.BIG_ENDIAN) / 100.0F;
            System.out.println(f);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int a = hex2int("C1480000", ByteOrder.BIG_ENDIAN);
        System.out.println(Float.intBitsToFloat(a));
        String strOri = "7B01001631343439333130383034350A08545400007B";
        System.out.println(strOri.length());
        System.out.println(strOri.substring(8, 30));
        System.out.println(hexString2String(strOri.substring(8, 30)));
        SimpleDateFormat sf1 = new SimpleDateFormat("yy/MM/dd','HH:mm:ss");
        System.out.println(sf1.format(new Date()));
        String s = hexString2String("2A532C0D0A534E3A2C423931334353303031342C0D0A54503A2C342C54454D502C0D0A44543A2C31382F30392F31332C30323A34373A31332B30302C0D0A44493A2C312C312C31302C6D2C0D0A5654286D56293A2C333630382C44432C0D0A45433A2C302C0D0A54543A2C312C0D0A43513A2C32362C0D0A56553A2C54454D5028A1E6292C0D0A32342C0D0A45442C0D0A43533A2C3134302C0D0A");
        String[] arr = s.split(",\r\n");
        String[] var6 = arr;
        int var7 = arr.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String as = var6[var8];
            System.out.println(as);
            if (as.startsWith("DT:,")) {
                as = as.replace("DT:,", "");
                as = as.replace(",", " ");
                SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");

                try {
                    Date d = sf.parse(as);
                    System.out.println(d.getTime());
                } catch (Exception var21) {
                    var21.printStackTrace();
                }
            }
        }

        SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd','hh:mm:ss");
        System.out.println(sf.format(new Date()));
        System.out.println("1234".substring(1));
        String str = "*P,3147.1292,N,11957.6218,E,99999.9,";
        String[] arrs = str.split("");
        int itge = 0;
        int itshi = 0;
        int zong = 0;
        String[] var12 = arrs;
        int var13 = arrs.length;

        for(int var14 = 0; var14 < var13; ++var14) {
            String temp = var12[var14];
            ByteArrayInputStream in = new ByteArrayInputStream(temp.getBytes());
            DataInputStream ds = new DataInputStream(in);

            try {
                int i = ds.readUnsignedByte();
                zong += i;
                String hex = Integer.toHexString(i);
                itge += checki(hex.split("")[1]);
                itshi += checki(hex.split("")[0]);
                System.out.println(hex);
            } catch (IOException var20) {
                var20.printStackTrace();
            }
        }

        System.out.println(itge % 16);
        System.out.println(itshi % 16);
        System.out.println(Integer.toHexString(zong));
        System.out.println(hex2int("6a"));
    }

    public static int checki(String s) {
        if ("a".equals(s)) {
            return 10;
        } else if ("b".equals(s)) {
            return 11;
        } else if ("c".equals(s)) {
            return 12;
        } else if ("d".equals(s)) {
            return 13;
        } else if ("e".equals(s)) {
            return 14;
        } else {
            return "f".equals(s) ? 15 : Integer.parseInt(s);
        }
    }

    public static String StringToAsciiString(String content) {
        String result = "";
        int max = content.length();

        for(int i = 0; i < max; ++i) {
            char c = content.charAt(i);
            String b = Integer.toHexString(c);
            result = result + b;
        }

        return result;
    }

    public static String get2BinaryStr(String msg) {
        String stStr = DataType.bytes2BinaryStr(DataType.hexStringToByte(msg));
        String string = "";

        for(int i = 0; i < stStr.length(); ++i) {
            string = string + "0" + stStr.substring(i, i + 1);
        }

        return string;
    }

    public static String get2BinaryReverse(String msg) {
        String stStr = DataType.bytes2BinaryStr(DataType.hexStringToByte(msg));
        StringBuilder str = new StringBuilder(stStr);
        stStr = str.reverse().toString();
        String string = "";

        for(int i = 0; i < stStr.length(); ++i) {
            string = string + "0" + stStr.substring(i, i + 1);
        }

        return string;
    }
}
