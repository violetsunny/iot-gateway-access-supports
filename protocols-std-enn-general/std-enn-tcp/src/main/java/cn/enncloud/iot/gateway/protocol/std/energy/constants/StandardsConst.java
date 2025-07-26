package cn.enncloud.iot.gateway.protocol.std.energy.constants;


import java.nio.charset.Charset;


/**
 * @author DongLi
 */
public class StandardsConst {

    /**
     * 默认字符集
     */
    public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

    public static final byte UP_HEAD = 0x67;

    public static final short DOWN_HEAD = 0x83;

    public static final String DOWN_HEAD_STR = "83";

    public static final short TAIL = 0xED;

    public static final String TAIL_STR = "ED";

    public static final String ALARM_UP = "02H";

    public static final String HISTORY_UP = "12H";

    // 终端->系统消息
    public static final short TERMINAL_MSG_HEARTBEAT = 0x00cc; //心跳
    public static final short TERMINAL_MSG_ALARM_WITH_TYPE = 0x0001; // 带数据类型报警上报
    public static final short TERMINAL_MSG_UPLOAD = 0x0012; //数据上报
    public static final short TERMINAL_MSG_UPLOAD_WITH_TYPE = 0x0022; //带数据类型数据上报
    public static final short TERMINAL_MSG_ALARM = 0x0002;//报警上报
    public static final short TERMINAL_MSG_LOGOUT = 0x0006;//终止帧
    public static final short TERMINAL_MSG_HISTORY_RECALL = 0x0013;//历史数据补掉
    public static final short TERMINAL_MSG_HISTORY_RECALL_WITH_TYPE = 0x0023;//带数据类型历史数据补掉
    public static final short TERMINAL_MSG_ERROR_RESP = 0x000e;
    /**
     * 远程升级,终端和系统都用到
     */
    public static final short TERMINAL_MSG_UPGRADE = 0x0059;

    //系统->终端消息
    public static final short SERVER_MSG_SEND_SECRET = 0x0008;
    public static final short SERVER_MSG_DISCONNECT = 0x0004;

    public static final short SERVER_MSG_UPGRADE = TERMINAL_MSG_UPGRADE;
    public static final short SERVER_MSG_UPGRADE_NB = 0x005A;
}
