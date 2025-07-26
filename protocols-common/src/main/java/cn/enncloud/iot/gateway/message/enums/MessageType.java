/**
 * llkang.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.message.enums;

import lombok.Getter;

/**
 * @author kanglele
 * @version $Id: MessageType, v 0.1 2023/2/3 12:07 kanglele Exp $
 */
@Getter
public enum MessageType {
    HEARTBEAT,
    /**
     * <pre>
     * 登录请求
     * </pre>
     *
     * <code>LOGIN_REQ = 1;</code>
     */
    DEVICE_LOGIN_REQ,
    /**
     * <pre>
     * 登录响应
     * </pre>
     *
     * <code>LOGIN_RSP = 2;</code>
     */
    DEVICE_LOGIN_RSP,
    /**
     * <pre>
     * 数据上报请求
     * </pre>
     *
     * <code>REPORT_REQ = 3;</code>
     */
    DEVICE_REPORT_REQ,
    /**
     * <pre>
     * 数据上报响应
     * </pre>
     *
     * <code>REPORT_RSP = 4;</code>
     */
    DEVICE_REPORT_RSP,


    /**
     * 工况上报
     */
    DEVICE_STATUS_REQ,
    /**
     * 信息上报
     */
    DEVICE_INFO_REQ,
    /**
     * 事件上报
     */
    DEVICE_EVENT_REQ,
    DEVICE_NTP_REQ,
    DEVICE_NTP_RSP,
    /**
     * <pre>
     * 下发指令
     * </pre>
     *
     * <code>OPERATION_REQ = 5;</code>
     */
    CLOUD_OPERATION_REQ,
    /**
     * <pre>
     * 指令相应
     * </pre>
     *
     * <code>OPERATION_RSP = 6;</code>
     */
    CLOUD_OPERATION_RSP,
    /**
     * 历史数据上报
     */
    CLOUD_HISTORY_REQ,
    CLOUD_NTP_REQ,
    CLOUD_NTP_RSP,
    CLOUD_CALL_REQ,
    CLOUD_SET_REQ,
    DEVICE_CHANGE_REQ,
}
