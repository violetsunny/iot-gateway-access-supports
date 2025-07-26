/**
 * llkang.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.entity.tsl;

import lombok.Getter;

/**
 * @author kanglele
 * @version $Id: MessageType, v 0.1 2023/2/3 12:07 kanglele Exp $
 */
@Getter
public enum DataType {
    String,
    Int,
    BigInt,
    Float,
    Double,
    Boolean,
    Date,
    DateTime
}
