///**
// * llkang.com Inc.
// * Copyright (c) 2010-2024 All Rights Reserved.
// */
//package cn.enncloud.iot.gateway.context;
//
//import cn.enncloud.iot.gateway.entity.cloud.*;
//import io.vertx.core.http.HttpMethod;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author kanglele
// * @version $Id: CloudDockingServer, v 0.1 2024/3/13 14:45 kanglele Exp $
// */
//public interface CloudDockingServer {
//
//    CloudDockingAuthTokenBo createAuthToken(String authCode);
//
//    Map<String, List<CloudDockingBodyBo>> getCloudDockingBody(String code, CloudDockingAuthTokenBo authToken, String dataCode, String updown) throws Exception;
//
//    <T> T sendRequest(HttpMethod method, String url, Map<String, String> headers, Object req, Class<T> res) throws Exception;
//
//}
