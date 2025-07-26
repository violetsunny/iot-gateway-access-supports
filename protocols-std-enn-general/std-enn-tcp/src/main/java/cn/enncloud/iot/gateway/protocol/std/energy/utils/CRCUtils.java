package cn.enncloud.iot.gateway.protocol.std.energy.utils;

/**
 * CRC16实现
 * CRC循环冗余错误校验计算方法
 * CRC-16C(循环冗余错误校验)生成CRC-16校验字节的步聚如下：
 * (1)装入一个16位寄存器，所有数位均为1。
 * (2)该16位寄存器的高位字节与开始8位字节进行“异或”运算。运算结果放入这个16位寄存器。
 * (3)把这个16位寄存器向右移1位。
 * (4a)若向右(标记位)移出的数位是1，则生成多项式1010000000000001和这个寄存器进行“异或”运算。
 * (4b)若向右移出的数位是0，则返回(3)。
 * (5)重处处(3)和(4)，直至移出8位。
 * (6)另外8位与该16位寄存器进行“异或”运算。
 * (7)重处处(3)-(6)，直至该报文所有字节均与16位寄存器进行“异或”运算，并移位8次。
 * (8)这个16位寄存器的内容即2字节CRC错误校验。
 */
public class CRCUtils {

    public static byte[] crc16(byte[] source) {
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
        for (byte aSource : source) {
            //获取数据
            data = aSource;
            ploy[0] = reg[1];
            ploy[1] = reg[0];
            ploy[0] = (byte) (ploy[0] ^ data);
            reg = intToByteArray(((byteArrayToInt(ploy)) ^ ((byteArrayToInt(ploy) & 0xFF) >> 4)), 2);
            reg = intToByteArray(((byteArrayToInt(reg)) ^ (byteArrayToInt(reg) << 12)), 2);
            reg = intToByteArray(((byteArrayToInt(reg)) ^ ((byteArrayToInt(reg) & 0xFF) << 5)), 2);
        }
        return reg;
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
}
