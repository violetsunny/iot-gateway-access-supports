package cn.enncloud.iot.gateway.protocol.std.energy.utils.crypt;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 2017/6/30.
 */
@Slf4j
public enum DataType {
    String,    //字符串
    TancyCurrency,
    TimeBcdSix,//6字节的字符串
    HEX2BinString,//十六进制字符串转二进制字符串
    Long_currency,//最高位为符号位8字节原码字符串
    Time_BCD,   //天信私有协议v1.3
    Float,    //modbus协议标准4字节
    Double,   //mudbus协议标准8字节
    Time_mBCD,//天信modbus协议
    Time,//室温采集器
    Temperature,//室温采集器
    BCD_float,
    Bytes,   //modbus协议
    Float_P,   //天信私有协议v1.3
    Float_BCD_P,  //天信私有协议v1.3
    Double_TX,    //天信压缩包协议，前2字节为小数，后4字节为整数
    Time_TX,      //天信压缩包协议，时间
    Float_CN,//苍南协议前6个字节为整数，后2个字节为小数
    Float_CN_D,//苍南协议前3个字节为整数，后1个字节为小数
    int32,
    Float_jinka,
    HEX,
    Price_BCD_CPU,
    Float_CUSTOM,//自定义数据类型4和6字节浮点数
    HEX_CUSTOM,//自定义数据类型1字节状态码故障码
    Float_XDF,//金卡信东协议中4个字节标况流量等整形数,隐含2位小数
    Float_XDS,//金卡信东协议中6个字节标况累计总量整数部分＋小数部分
    Float_TEM,//信东温度整形数,隐含1位小数，最高位符号位
    Float_TEM2,
    Float_PRE,//信东压力整形数,隐含1位小数
    Float_TPRE,
    unknown,
    Float_AZ,//金卡爱知协议工况瞬时带符号4字节100倍值
    UNFloat_AZ,//金卡爱知协议工况累计量无符号4字节10倍值
    Time_BCD_CPU,
    Float_CPU,
    Float_EE,
    ULONG_ENLARGE, //无符号长整型，低位在前，扩大10000倍
    ULONG,         //无符号长整型，低位在前
    SIGNED_INT,    //有符号整型，低位在前，扩大100倍
    ULONG_INT,     //整数部分，无符号长整型，低位在前/小数部分，扩大10000倍
    Double_pressureTran,
    Double_Float_JG,
    Float_REDUCE10,
    Float_REDUCE100,
    Float_ENLARGE10,
    Float_ENLARGE100,
    REDUCE10,
    REDUCE100,
    REDUCE1000,
    REDUCE10000,
    DOUBLE_MODBUS,
    INT32,
    DoublePenny,
    Status,
    BIT,
    INT_DIVIDE_10,
    INT_DIVIDE_100,
    INT_DIVIDE_1000,
    INT_DIVIDE_10000,
    ASCII;

    static final private int MAX_ASCII_LENGTH = 19;//发往大数据的数据ascii类型最大长度为19（小于Long.MAX_VALUE 9223372036854775807）

    private double getFloat_TPRE(String fieldData) {
        //信东中压力
        long yl = Long.parseLong(fieldData, 16);
        double ylI = yl / 10.0;
        return ylI;
    }

    private double getFloat_PRE(String fieldData) {
        //信东中压力
        long yl = Long.parseLong(fieldData, 16);
        double ylI = yl / 1.0;
        return ylI;
    }

    private int getInt32(String fieldData, ByteOrder byteOrder) {
        return HexUtils.hex2int(fieldData, byteOrder);
    }

    /*private double getDouble_TX(String fieldData) {
        return java.lang.Double.valueOf(HexUtils.hex2int(fieldData.substring(4, 12)) + "." + HexUtils.hex2int(fieldData.substring(0, 4)));
    }*/
    private String hexStrTurnOver(String hexStr) {//高在前
        if (hexStr.length() % 2 > 0) {
            hexStr = "0" + hexStr;
        }
        int length = hexStr.length();
        StringBuffer swhole = new StringBuffer();
        ;
        for (int i = 0; i <= length - 2; i = i + 2) {
            String s = hexStr.substring(i, i + 2);
            swhole = swhole.insert(0, s);
        }
        return swhole + "";
    }

    private String getDouble_TX(String fieldData) {
        String s = fieldData;
        String ss = hexStrTurnOver(s.substring(4, 12));
        String str = bytes2BinaryStr(hexStringToByte(ss/*.substring(0,2)*/));

        String fh = str.substring(0, 1);
        if (fh.equals("1")) {
            //负数
            String zt = "-" + Long.parseLong(str.substring(1, 32), 2) + "." + HexUtils.hex2int(s.substring(0, 4));
            return zt;
        } else {
            return HexUtils.hex2int(fieldData.substring(4, 12)) + "." + HexUtils.hex2int(fieldData.substring(0, 4));

        }
    }

    private double getFloat_CN(String fieldData) {
        return java.lang.Double.valueOf(HexUtils.hex2long(fieldData.substring(0, 12)) + (HexUtils.hex2int(fieldData.substring(12), fieldData.substring(12).length() / 2, ByteOrder.BIG_ENDIAN)) / 65536.0);
    }

    private double getFloat_CN_D(String fieldData) {
        long a = HexUtils.hex2long(fieldData.substring(0, 6));
        double b = (HexUtils.hex2int(fieldData.substring(6), fieldData.substring(6).length() / 2, ByteOrder.BIG_ENDIAN)) / 256.0;
        return java.lang.Double.valueOf(a + b);
    }

    private String getHEX_CUSTOM(String fieldData) {
        return fieldData;
    }


    /**
     * 6字节公式 data / 2^(39+-阶码) 原码是左移(+) 补码是右移(-)
     * 4字节公式 data / 2^(23+-阶码)
     *
     * @param fieldData
     * @return
     */
    private double getFloat_CUSTOM(String fieldData) {
        double v;
        String str = bytes2BinaryStr(hexStringToByte(fieldData));
        Long data = Long.valueOf(str.substring(9), 2);
        //  1、 a是第8位在自定义中是符号位
        String fh = str.substring(8, 9);
        // 符号
        double fhI = Math.pow((-1), Integer.parseInt(fh));

        String jm = str.substring(0, 8);
        // 需要求原码的
        if ("1".equals(jm.substring(0, 1))) {
            StringBuffer jm2 = new StringBuffer();
            for (int i = 0; i < 8; i++) {
                String jmt = jm.substring(i, i + 1);
                if ("1".equals(jmt)) {
                    jm2.append("0");
                } else {
                    jm2.append("1");
                }
            }
            int i = Integer.valueOf(jm2.toString(), 2) + 1;
            if (fieldData.length() == 12) {
                v = fhI * (data / Math.pow(2, 39 + i));
            } else {
                v = fhI * (data / Math.pow(2, 23 + i));
            }
        } else {
            int jmI = Integer.valueOf(jm, 2);
            if (fieldData.length() == 12) {
                v = fhI * (data / Math.pow(2, 39 - jmI));
            } else {
                v = fhI * (data / Math.pow(2, 23 - jmI));
            }
        }
        return v;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static String bytes2BinaryStr(byte[] bArray) {

        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            //高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            //低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;

    }

    private static String[] binaryArray =
            {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};


    private Date getTime_TX(String fieldData) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = sdf.parse("20" + fieldData);
        } catch (ParseException e) {
        }
        return date;
    }

    private String getStringValue(String fieldData) {
        return fieldData;
    }

//    private String getBCD_timeValue(String fieldData) {
//        return fieldData.substring(0, 2) + "-" + fieldData.substring(2, 4) + "-" + fieldData.substring(4, 6) + " " + fieldData.substring(6, 8) +
//                ":" + fieldData.substring(8, 10) + ":" + fieldData.substring(10);
//    }

    private String getBCD_timeValue(String fieldData) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        sdf.parse(fieldData);
        return fieldData;
    }

    private String getBCD_modbus_timeValue(String fieldData) {
        return fieldData.substring(0, 4) + "-" + fieldData.substring(6, 8) + "-" + fieldData.substring(10, 12) + " " + fieldData.substring(14, 16) +
                ":" + fieldData.substring(18, 20) + ":" + fieldData.substring(22);
    }

    private String getDouble8Value(String fieldData, ByteOrder byteOrder) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        double a = HexUtils.hex22double(newStr);
        if (fh.equals("1") && a != 0) {
            return "-" + a;
        }
        return a + "";

    }


    private float getFloat4Value(String fieldData, ByteOrder byteOrder) {
        return HexUtils.hexStr2float(fieldData, byteOrder);
    }

    private BigDecimal getBCD_floatValue(String fieldData, ByteOrder byteOrder) {
        BigDecimal decimal = new BigDecimal(fieldData.substring(0, 4));
        decimal = decimal.multiply(new BigDecimal(1000000));
        BigDecimal decimal2 = new BigDecimal(HexUtils.hexStr2float(fieldData.substring(4), byteOrder));
        return decimal.add(decimal2);
    }

    private byte[] getBytesValue(String fieldData) {
        return HexUtils.str2hex(fieldData);
    }

    private float hex2tancyPrivateFloat(String hexStr) {
        String jie = hexStr.substring(0, 2);
        String wei = hexStr.substring(2);
        int jieData, weiData;
        //小于8表示第一位为0，是正数
        if (HexUtils.hex2int(jie.substring(0, 1)) < 8) {
            jieData = Integer.parseInt(jie, 16);
        } else {
            jieData = (Integer.parseInt(jie, 16) - 128) * (-1);
        }
        if (HexUtils.hex2int(wei.substring(0, 1)) < 8) {
            weiData = Integer.parseInt(wei, 16);
        } else {
            weiData = (Integer.parseInt(wei, 16) - (int) Math.pow(2, 23)) * (-1);
        }
        return (float) (Math.pow(2, jieData) * weiData) / 8388608;
    }

    public float hex2tancyPrivateBCD_Float(String hexStr) {
        return new Integer(hexStr.substring(0, 4)) * (float) Math.pow(10, 6) + this.hex2tancyPrivateFloat(hexStr.substring(4));
    }

    private String cpuCardHextoLong(String fieldData) {
        String s = fieldData.substring(0, 2);
        long l = Long.parseLong(fieldData.substring(2), 16);
        if ("01".equals(s)) {
            fieldData = "-" + java.lang.String.valueOf(l);
        } else {
            fieldData = java.lang.String.valueOf(l);
        }
        return fieldData;
    }

    //最高位为符号位8字节原码字符串,非货币协议
    private String getLong_currency(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        if (fh.equals("1")) {
            return "-" + Long.parseLong(newStr, 2);
        } else {
            return Long.parseLong(newStr, 2) + "";
        }

    }

    private double getFloat_XDF(String fieldData) {
        //信东中四字节的，比如标况瞬时流量
        long a = Long.parseLong(fieldData, 16);
        double b = a / 100.0;
        return b;
    }

    private double getFloatByIntDivide10(String fieldData) {
        int a = HexUtils.hex2int(fieldData, ByteOrder.LITTLE_ENDIAN);
        return a / 10.0;
    }

    private double getFloatByIntDivide100(String fieldData) {
        int a = HexUtils.hex2int(fieldData, ByteOrder.LITTLE_ENDIAN);
        return a / 100.0;
    }

    private double getFloatByIntDivide1000(String fieldData) {
        int a = HexUtils.hex2int(fieldData, ByteOrder.LITTLE_ENDIAN);
        return a / 1000.0;
    }

    private double getFloat_XDS(String fieldData) {
        //信东中六字节的，比如标况累积量
        String zs = fieldData.substring(0, 8);
        String xs = fieldData.substring(8);
        long zsI = Long.parseLong(zs, 16);
        int xsI = Integer.parseInt(xs, 16);
        double xsD = xsI / 10000.0;
        double zt = zsI + xsD;
        return zt;
    }


    private String getFloat_TEM(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        if (fh.equals("1")) {
            return "-" + Long.parseLong(newStr, 2) / 10.0;
        } else {
            return Long.parseLong(newStr, 2) / 10.0 + "";
        }
    }

    private String getFloat_TEM2(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        StringBuilder sb = new StringBuilder();
        if (fh.equals("1")) {
            for (int i = 0; i < newStr.length(); i++) {
                if (newStr.substring(i, i + 1).equals("1")) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            return "-" + (Long.parseLong(sb + "", 2) + 1) / 10.0;
        } else {
            return Long.parseLong(newStr, 2) / 10.0 + "";
        }
    }

    private String getAscii(String fieldData) {
        return cn.enncloud.iot.gateway.protocol.std.energy.utils.HexUtils.parseStringAscii(fieldData);

    }

    /**
     * 从byte数组指定位置读取一个int-大端
     */
    public float getFloatB(byte[] bb, int index) {
        ByteUtil.reverse(bb);
        int l = (bb[index] & 0xFF) << 24 | (bb[index + 1] & 0xFF) << 16 | (bb[index + 2] & 0xFF) << 8 | (bb[index + 3] & 0xFF) << 0;
        return java.lang.Float.intBitsToFloat(l);
    }

    public int getIntB(byte[] bb, int index) {
//        ByteUtil.reverse(bb);
        return (bb[index + 1] & 0xFF) << 8 | (bb[index] & 0xFF) << 0;
    }

    public double getDoubleModbus(String fieldData) {
        byte[] arr = ByteUtil.hexStringToBytes(fieldData);
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value |= ((long) (arr[i] & 0xff)) << (8 * i);
        }
        return java.lang.Double.longBitsToDouble(value);
    }

    /**
     * 从byte数组指定位置读取一个float-小端
     */
    public float getFloatS(byte[] bb, int index) {
        int l = (bb[index + 3] & 0xFF) << 24 | (bb[index + 2] & 0xFF) << 16 | (bb[index + 1] & 0xFF) << 8 | (bb[index] & 0xFF) << 0;
        return java.lang.Float.intBitsToFloat(l);
    }

    public String getFloat_AZ(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        if (fh.equals("1")) {
            double d = Long.parseLong(newStr, 2) / 100.0;
            return "-" + d;
        } else {
            return Long.parseLong(newStr, 2) / 100.0 + "";
        }
    }

    private Double getPressureTransmitter(String fieldData) {
        long l = Long.parseLong(fieldData, 16);
        if (l > 800 && l < 4000) {
            return (l - 800) / (3200.0) * 0.6 * 1000;
        } else {
//            throw new EnnException("裸数据值不在800-4000之间！裸数据值=" + l);
            log.warn("裸数据值不在800-4000之间！裸数据值=" + l);
            return null;
        }
    }


    private Double signedInt(String hex) {
        java.lang.String fieldData = hex.substring(2, 4) + hex.substring(0, 2);
        Integer integer = Integer.valueOf(fieldData, 16);
        if (integer > 0x8000) {
            double v = ((integer ^ 0xFFFF) + 1) / 100.0;
            String s = "-" + v;
            return java.lang.Double.valueOf(s);
        } else {
            return integer / 100.0;
        }
    }

    private Double getUlongEnlarge(String fieldData) {
        java.lang.String s = fieldData.substring(6, 8) + fieldData.substring(4, 6) + fieldData.substring(2, 4) + fieldData.substring(0, 2);
        return Long.parseLong(s, 16) / 10000.0;
    }

    private Double getUlong(String fieldData) {
        java.lang.String s = fieldData.substring(6, 8) + fieldData.substring(4, 6) + fieldData.substring(2, 4) + fieldData.substring(0, 2);
        return Long.parseLong(s, 16) / 1000.0;
    }

    private Double getUlongInt(String fieldData) {
        java.lang.String s1 = fieldData.substring(6, 8) + fieldData.substring(4, 6) + fieldData.substring(2, 4) + fieldData.substring(0, 2);
        java.lang.String s2 = fieldData.substring(10, 12) + fieldData.substring(8, 10);
        long a = Long.parseLong(s1, 16);
        long b = Long.parseLong(s2, 16);
        double v = a + (b / 10000.0);
        return v;
    }

    public Date getTime(String fieldData) {

        Date date3 = null;
        try {
            DateFormat format1 = new SimpleDateFormat("yyMMddHHmm");
            date3 = format1.parse(fieldData);
        } catch (ParseException e) {
            log.error("inputParams:{} and errorMessage:{}", fieldData, e.getMessage(), e);
        }
        return date3;
    }

    private String getTemperature(String fieldData) {
        String pre;
        if (fieldData.startsWith("01")) {
            pre = "-";
        } else {
            pre = "";
        }
        return pre + fieldData.substring(2, 4) + "." + Integer.valueOf(fieldData.substring(4));
    }

    private String getTancyCurrency(String fieldData) {
        if (fieldData.equals("FFFFFFFF")) {
            return "";
        } else {
            return Integer.valueOf(fieldData.substring(0, 4)) + "." + Integer.valueOf(fieldData.substring(4));
        }
    }

    private Float getDouble_Float_JG(String fieldData, ByteOrder byteOrder) {
        java.lang.String high = fieldData.substring(0, 8);
        java.lang.String low = fieldData.substring(8);
        float h = HexUtils.hexStr2float(high, byteOrder);
        float l = HexUtils.hexStr2float(low, byteOrder);
        float i = h * 1000000 + l;
        return i;
    }

    private String getHEX2BinString(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));
        return str;
    }

    private String getTimeBcdSix(String fieldData) {
        return 20 + fieldData.substring(0, 2) + "-" + fieldData.substring(2, 4) + "-" + fieldData.substring(4, 6) + " " + fieldData.substring(6, 8) +
                ":" + fieldData.substring(8, 10) + ":" + fieldData.substring(10);
    }

    private String getReduceHundredTimes(String fieldData) {
        java.lang.String head = fieldData.substring(0, 1);
        if ("+".equals(head) || "-".equals(head)) {
            double v = java.lang.Double.valueOf(fieldData.substring(1)) / 100.0;
            return head.concat(java.lang.String.valueOf(v));
        } else {
            double v = java.lang.Double.valueOf(fieldData) / 100.0;
            return java.lang.String.valueOf(v);
        }
    }

    private Double getReduceTenTimes(String fieldData) {
        double v = java.lang.Double.valueOf(fieldData) / 10;
        return v;
    }

    private Double getReduceThousandTimes(String fieldData) {
        double v = java.lang.Double.valueOf(fieldData) / 1000;
        return v;
    }

    private Double getReduceTenThousandTimes(String fieldData) {
        double v = java.lang.Double.parseDouble(fieldData) / 10000;
        return v;
    }

    private String getDoublePenny(String fieldData) {
        String str = bytes2BinaryStr(hexStringToByte(fieldData));//十六进制转二进制字符串
        String fh = str.substring(0, 1);
        String newStr = str.substring(1);
        double a = HexUtils.hex22double(newStr) / 100.0;
        if (fh.equals("1") && a != 0) {
            return "-" + a;
        }
        return a + "";
    }

    private String getStatus(String fieldData) {
        int i1 = Integer.parseInt(fieldData.substring(0, 2));
        int i2 = Integer.parseInt(fieldData.substring(2));
        java.lang.String s = java.lang.String.valueOf(i1) + java.lang.String.valueOf(i2);
        return s;
    }

    public static void putValue2map(Map<String, Object> map, String fieldName, DataType type, String fieldData, ByteOrder bo) throws ParseException {
        switch (type) {
            case HEX:
                map.put(fieldName, Integer.parseInt(fieldData, 16));
                break;
            case TancyCurrency:
                map.put(fieldName, type.getTancyCurrency(fieldData));
                break;
            case Price_BCD_CPU:
                map.put(fieldName, java.lang.Float.parseFloat(fieldData) / 10000);
                break;
            case Time_BCD_CPU:
                map.put(fieldName, fieldData);
                break;
            case String:
                map.put(fieldName, fieldData);
                break;
            case HEX2BinString:
                map.put(fieldName, type.getHEX2BinString(fieldData));
                break;
            case Time://最高位为符号位8字节原码字符串
                map.put(fieldName, type.getTime(fieldData));
                break;
            case TimeBcdSix://最高位为符号位8字节原码字符串
                map.put(fieldName, type.getTimeBcdSix(fieldData));
                break;
            case Temperature://最高位为符号位8字节原码字符串
                map.put(fieldName, type.getTemperature(fieldData));
                break;
            case Long_currency://最高位为符号位8字节原码字符串
                map.put(fieldName, type.getLong_currency(fieldData));
                break;
            case Time_BCD:
                map.put(fieldName, type.getBCD_timeValue(fieldData));
                break;
            case Float:
                map.put(fieldName, type.getFloat4Value(fieldData, bo));
                break;
            case Float_REDUCE10:
                map.put(fieldName, type.getFloat4Value(fieldData, bo) / 10.0);
                break;
            case Float_REDUCE100:
                map.put(fieldName, type.getFloat4Value(fieldData, bo) / 100.0);
                break;
            case Float_ENLARGE10:
                map.put(fieldName, type.getFloat4Value(fieldData, bo) * 10);
                break;
            case Float_ENLARGE100:
                map.put(fieldName, type.getFloat4Value(fieldData, bo) * 100);
                break;
            case int32:
                map.put(fieldName, type.getInt32(fieldData, bo));
                break;
            case BCD_float:
                map.put(fieldName, type.getBCD_floatValue(fieldData, bo));
                break;
            case Float_jinka:
                map.put(fieldName, Math.abs(type.getFloat4Value(fieldData, bo)));
                break;
            case Float_P:
                map.put(fieldName, type.hex2tancyPrivateFloat(fieldData));
                break;
            case Float_BCD_P:
                map.put(fieldName, type.hex2tancyPrivateBCD_Float(fieldData));
                break;
            case Bytes:
                map.put(fieldName, type.getBytesValue(fieldData));
                break;
            case Time_mBCD:
                map.put(fieldName, type.getBCD_modbus_timeValue(fieldData));
                break;
            case Double:
                map.put(fieldName, type.getDouble8Value(fieldData, bo));
                break;
            case Double_TX:
                map.put(fieldName, type.getDouble_TX(fieldData));
                break;
            case Time_TX:
                map.put(fieldName, type.getTime_TX(fieldData));
                break;
            case Float_CN://苍南协议1.2的float类型
                map.put(fieldName, type.getFloat_CN(fieldData));
                break;
            case Float_CN_D://苍南协议1.2的float类型
                map.put(fieldName, type.getFloat_CN_D(fieldData));
                break;
            case Float_CUSTOM://自定义数据类型的4字节和6字节float
                map.put(fieldName, type.getFloat_CUSTOM(fieldData));
                break;
            case HEX_CUSTOM://自定义数据类型的1字节的故障码和状态字
                map.put(fieldName, type.getHEX_CUSTOM(fieldData));
                break;
            case Float_XDF://金卡信东协议中4个字节标况流量等整形数,隐含2位小数
                map.put(fieldName, type.getFloat_XDF(fieldData));
                break;
            case Float_XDS://金卡信东协议中6个字节标况累计总量整数部分＋小数部分
                map.put(fieldName, type.getFloat_XDS(fieldData));
                break;
            case Float_PRE://信东压力整形数,隐含1位小数
                map.put(fieldName, type.getFloat_PRE(fieldData));
                break;
            case Float_TPRE://信东压力整形数,隐含1位小数
                map.put(fieldName, type.getFloat_TPRE(fieldData));
                break;
            case Float_TEM://信东温度整形数最高位符号位,隐含1位小数
                map.put(fieldName, type.getFloat_TEM(fieldData));
                break;
            case Float_TEM2://信东温度整形数最高位符号位,隐含1位小数
                map.put(fieldName, type.getFloat_TEM2(fieldData));
                break;
            case Float_CPU:
                map.put(fieldName, type.cpuCardHextoLong(fieldData));
                break;
            case Float_AZ:
                map.put(fieldName, type.getFloat_AZ(fieldData));
                break;
            case Float_EE:
                byte[] data = ByteUtil.hexStringToBytes(fieldData);
                if ("BIG_ENDIAN".equals(bo.toString())) {
                    map.put(fieldName, type.getFloatB(data, 0));
                } else if ("LITTLE_ENDIAN".equals(bo.toString())) {
                    map.put(fieldName, type.getFloatS(data, 0));
                }
                break;
            case ULONG_ENLARGE:
                map.put(fieldName, type.getUlongEnlarge(fieldData));
                break;
            case ULONG:
                map.put(fieldName, type.getUlong(fieldData));
                break;
            case SIGNED_INT:
                map.put(fieldName, type.signedInt(fieldData));
                break;
            case ULONG_INT:
                map.put(fieldName, type.getUlongInt(fieldData));
                break;
            case Double_pressureTran:
                map.put(fieldName, type.getPressureTransmitter(fieldData));
                break;
            case Double_Float_JG:
                map.put(fieldName, type.getDouble_Float_JG(fieldData, bo));
                break;
            case REDUCE10:
                map.put(fieldName, type.getReduceTenTimes(fieldData));
                break;
            case REDUCE100:
                map.put(fieldName, type.getReduceHundredTimes(fieldData));
                break;
            case REDUCE1000:
                map.put(fieldName, type.getReduceThousandTimes(fieldData));
                break;
            case REDUCE10000:
                map.put(fieldName, type.getReduceTenThousandTimes(fieldData));
                break;
            case DOUBLE_MODBUS:
                map.put(fieldName, type.getDoubleModbus(fieldData));
                break;
            case INT32:
                map.put(fieldName, HexUtils.hex2int(fieldData, 4, bo));
                break;
            case DoublePenny:
                map.put(fieldName, type.getDoublePenny(fieldData));
                break;
            case Status:
                map.put(fieldName, type.getStatus(fieldData));
                break;
            case INT_DIVIDE_10:
                map.put(fieldName, type.getFloatByIntDivide10(fieldData));
                break;
            case INT_DIVIDE_100:
                map.put(fieldName, type.getFloatByIntDivide100(fieldData));
                break;
            case INT_DIVIDE_1000:
                map.put(fieldName, type.getFloatByIntDivide1000(fieldData));
                break;
            case ASCII:
                java.lang.String ascii = type.getAscii(fieldData);
//                map.put(fieldName,ascii);
                if (ascii.length() > MAX_ASCII_LENGTH) {
                    map.put(fieldName, ascii.substring(0, MAX_ASCII_LENGTH));
                }
                break;
            case unknown:
                break;
            default:
        }
    }
}
