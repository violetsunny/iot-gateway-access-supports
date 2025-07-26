/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

/**
 * @author kanglele
 * @version $Id: HttpReqDataConfig, v 0.1 2024/1/23 15:29 kanglele Exp $
 */
@Data
public class HttpDataConfig {
    String reqUrl;
    String reqMethod;
    String objPath;
    String tokenKey;
}
