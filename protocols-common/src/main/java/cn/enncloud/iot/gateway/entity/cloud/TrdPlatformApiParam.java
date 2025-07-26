/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.entity.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author kanglele
 * @version $Id: TrdPlatformBasic, v 0.1 2024/3/12 17:30 kanglele Exp $
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrdPlatformApiParam {

    private Long id;

    private Long apiId;

    private String paramKey;

    private Integer paramType;

    private Integer paramPosition;

    private Object paramValue;

}
