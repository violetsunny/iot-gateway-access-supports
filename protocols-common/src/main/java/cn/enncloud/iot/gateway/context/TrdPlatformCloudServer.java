/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.context;

import cn.enncloud.iot.gateway.entity.cloud.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author kanglele
 * @version $Id: TrdPlatformCloudServer, v 0.1 2024/3/13 16:44 kanglele Exp $
 */
public interface TrdPlatformCloudServer {

    JSONObject sendRequest(String method, String url, Map<String, String> headers, Object req, Class res) throws Exception;

    TrdPlatformReq taskReqContext(String pCode, String taskCode) throws Exception;

    TrdPlatformReq downReqContext(String productId, String taskCode) throws Exception;

    List<TrdPlatformTask> taskWorkList(String pCode);

    TrdPlatformTask taskWork(String pCode, String taskCode);

    void operateTaskWork(TrdPlatformTask task,Integer operate,String jobType);

    TrdPlatformAuthToken authRefreshToken(String pCode, Long api, TrdPlatformBody body) throws Exception;

    Object getEnum(String type,String name);

    String getTrdPlatformProtocol(String pCode, TrdPlatformEnum.FunctionTypeEnum functionType);

}
