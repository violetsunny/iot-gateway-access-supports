/**
 * llkang.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.message.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author kanglele
 * @version $Id: DataType, v 0.1 2023/12/20 15:23 kanglele Exp $
 */
@Getter
@AllArgsConstructor
public enum DataTypeEnum {

    /**
     * 请求认证参数的类型
     */

    STRING("String"),
    FLOAT("Float"),
    BOOLEAN("Boolean"),
    INT("Int"),
    DATE("Date"),
    LONG("Long"),
    BIG_DECIMAL("BigDecimal"),
    DOUBLE("Double"),

    ;

    private final String code;

    public static DataTypeEnum valueOfCode(String dataType) {
        return Arrays.stream(DataTypeEnum.values()).filter(e -> e.getCode().equalsIgnoreCase(dataType)).findFirst().orElse(STRING);
    }
}
