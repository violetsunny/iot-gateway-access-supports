/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.loader.script;

import com.alibaba.fastjson.JSONObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author kanglele
 * @version $Id: JsGeneratorHelper, v 0.1 2024/5/29 14:49 kanglele Exp $
 */
public class JsGeneratorHelper {

    public static String generatorReport(String jsonPath,String deviceFiled,String timeFiled,Boolean event,String eventCode,String identifier){
        StringBuilder sbScript = new StringBuilder();
        sbScript.append("codec.decodeMulti(function(dataStr,params) {\n");
        sbScript.append("    var jsonObject1 = JSON.parse(dataStr);\n");
        String[] paths = StringUtils.split(jsonPath,".");
        int length = paths.length;
        for(int i=1;i<length;i++){
            if((i+1)==length){
                sbScript.append("    var array = jsonObject").append(i).append(".").append(paths[i]).append(";\n");
                sbScript.append("    if (array == null){\n");
                sbScript.append("        $log.warn('{} {} {} data数据为空 {}',params[2],params[0],params[1],jsonObject").append(i).append(");\n");
                sbScript.append("        return null;\n");
                sbScript.append("    }\n");
            } else {
                sbScript.append("    var jsonObject").append(i + 1).append(" = jsonObject").append(i).append(".").append(paths[i]).append(";\n");
                sbScript.append("    if (jsonObject").append(i + 1).append(" == null){\n");
                sbScript.append("        $log.warn('{} {} {} data数据为空 {}',params[2],params[0],params[1],jsonObject").append(i).append(");\n");
                sbScript.append("        return null;\n");
                sbScript.append("    }\n");
            }
        }

        sbScript.append("    var requests = [];\n");
        sbScript.append("    var modelRef = $ctx.modelRef(params[2],params[1],null);\n");
        //区分是否是事件
        if(!event){
            sbScript.append("    array.forEach(function(data) {\n")
                    .append("        var timestamp = Date.now();\n")
                    .append("        var sn = data.").append(deviceFiled).append(";\n")
                    .append("        var deviceId = $ctx.getDeviceIdBySn(params[2], sn);\n")
                    .append("        if (deviceId==null || deviceId==='' || !$ctx.validSnBelongProduct(sn,params[1])) {\n")
                    .append("            //没有对应的恩牛设备\n")
                    .append("            $log.warn('{} {} {} {} 没有对应的恩牛设备',params[2],params[0],params[1],sn);\n")
                    .append("        } else {\n")
                    .append("            var reportRequest = {};\n")
                    .append("            reportRequest.deviceId=deviceId;\n")
                    .append("            reportRequest.messageType='DEVICE_REPORT_REQ';\n")
                    .append("            reportRequest.timeStamp=timestamp;\n")
                    .append("            reportRequest.ingestionTime=timestamp;\n")
                    .append("\n")
                    .append("            var metrics = [];\n");
            if(StringUtils.isNotBlank(timeFiled)){
                sbScript.append("            var time = Date.parse(data.").append(timeFiled).append(");\n")
                        .append("            time = time==null?timestamp:time;\n");
            } else {
                sbScript.append("            var time = timestamp;\n");
            }
            sbScript.append("            for (var key in data){\n")
                    .append("                if(data[key]!=null){\n")
                    .append("                    var metric = $ctx.modelRefMetric(key, modelRef);\n")
                    .append("                    metrics.push({code: metric, value: data[key],ts: time});\n")
                    .append("                }\n")
                    .append("            }\n")
                    .append("            if (metrics.length !== 0){\n")
                    .append("                reportRequest.metrics = metrics;\n")
                    .append("                requests.push(reportRequest);\n")
                    .append("            }\n")
                    .append("        }\n")
                    .append("    });\n");
        } else {
            sbScript.append("    if(!'").append(eventCode).append("'.equals(params[0])){\n")
                    .append("      array.forEach(function(data) {\n")
                    .append("        var timestamp = Date.now();\n")
                    .append("        var sn = data.").append(deviceFiled).append(";\n")
                    .append("        var deviceId = $ctx.getDeviceIdBySn(params[2], sn);\n")
                    .append("        if (deviceId==null || deviceId==='' || !$ctx.validSnBelongProduct(sn,params[1])) {\n")
                    .append("            //没有对应的恩牛设备\n")
                    .append("            $log.warn('{} {} {} {} 没有对应的恩牛设备',params[2],params[0],params[1],sn);\n")
                    .append("        } else {\n")
                    .append("            var reportRequest = {};\n")
                    .append("            reportRequest.deviceId=deviceId;\n")
                    .append("            reportRequest.messageType='DEVICE_EVENT_REQ';\n")
                    .append("            reportRequest.timeStamp=timestamp;\n")
                    .append("            reportRequest.identifier='").append(identifier).append("';\n")
                    .append("            reportRequest.type='alarm';\n")
                    .append("            reportRequest.version='0.0.1';\n")
                    .append("\n")
                    .append("            var metrics = [];\n");
            if(StringUtils.isNotBlank(timeFiled)){
                sbScript.append("            var time = Date.parse(data.").append(timeFiled).append(");\n")
                        .append("            time = time==null?timestamp:time;\n");
            } else {
                sbScript.append("            var time = timestamp;\n");
            }
            sbScript.append("            for (var key in data){\n")
                    .append("                if(data[key]!=null){\n")
                    .append("                    var metric = $ctx.modelRefMetric(key, modelRef);\n")
                    .append("                    metrics.push({code: metric, value: data[key],ts: time});\n")
                    .append("                }\n")
                    .append("            }\n")
                    .append("            if (metrics.length !== 0){\n")
                    .append("                reportRequest.metrics = metrics;\n")
                    .append("                requests.push(reportRequest);\n")
                    .append("            }\n")
                    .append("        }\n")
                    .append("      });\n")
                    .append("    }\n");

            sbScript.append("    if('").append(eventCode).append("'.equals(params[0])){\n")
                    .append("      array.forEach(function(data) {\n")
                    .append("        var timestamp = Date.now();\n")
                    .append("        var sn = data.").append(deviceFiled).append(";\n")
                    .append("        var deviceId = $ctx.getDeviceIdBySn(params[2], sn);\n")
                    .append("        if (deviceId==null || deviceId==='' || !$ctx.validSnBelongProduct(sn,params[1])) {\n")
                    .append("            //没有对应的恩牛设备\n")
                    .append("            $log.warn('{} {} {} {} 没有对应的恩牛设备',params[2],params[0],params[1],sn);\n")
                    .append("        } else {\n")
                    .append("            var reportRequest = {};\n")
                    .append("            reportRequest.deviceId=deviceId;\n")
                    .append("            reportRequest.messageType='DEVICE_REPORT_REQ';\n")
                    .append("            reportRequest.timeStamp=timestamp;\n")
                    .append("            reportRequest.ingestionTime=timestamp;\n")
                    .append("\n")
                    .append("            var metrics = [];\n");
            if(StringUtils.isNotBlank(timeFiled)){
                sbScript.append("            var time = Date.parse(data.").append(timeFiled).append(");\n")
                        .append("            time = time==null?timestamp:time;\n");
            } else {
                sbScript.append("            var time = timestamp;\n");
            }
            sbScript.append("            for (var key in data){\n")
                    .append("                if(data[key]!=null){\n")
                    .append("                    var metric = $ctx.modelRefMetric(key, modelRef);\n")
                    .append("                    metrics.push({code: metric, value: data[key],ts: time});\n")
                    .append("                }\n")
                    .append("            }\n")
                    .append("            if (metrics.length !== 0){\n")
                    .append("                reportRequest.metrics = metrics;\n")
                    .append("                requests.push(reportRequest);\n")
                    .append("            }\n")
                    .append("        }\n")
                    .append("      });\n")
                    .append("    }\n");
        }

        sbScript.append("    return JSON.stringify(requests);\n")
                .append("});");
        return sbScript.toString();
    }

//    public static String generatorEvent(String pcode,String jsonPath,String deviceFiled,String timeFiled,String identifier){
//        StringBuilder sbScript = new StringBuilder();
//        sbScript.append("codec.decodeMulti(function(dataStr,params) {\n");
//        sbScript.append("    var jsonObject1 = JSON.parse(dataStr);\n");
//        String[] paths = StringUtils.split(jsonPath,".");
//        int length = paths.length;
//        for(int i=1;i<length;i++){
//            if((i+1)==length){
//                sbScript.append("    var array = jsonObject").append(i).append(".").append(paths[i]).append(";\n");
//                sbScript.append("    if (array == null){\n");
//                sbScript.append("        $log.warn('data数据为空 {}',jsonObject").append(i).append(");\n");
//                sbScript.append("        return null;\n");
//                sbScript.append("    }\n");
//            } else {
//                sbScript.append("    var jsonObject").append(i + 1).append(" = jsonObject").append(i).append(".").append(paths[i]).append(";\n");
//                sbScript.append("    if (jsonObject").append(i + 1).append(" == null){\n");
//                sbScript.append("        $log.warn('data数据为空 {}',jsonObject").append(i).append(");\n");
//                sbScript.append("        return null;\n");
//                sbScript.append("    }\n");
//            }
//        }
//
//        sbScript.append("    var requests = [];\n");
//        sbScript.append("    var modelRef = $ctx.modelRef('").append(pcode).append("',params[1],null);\n");
//        sbScript.append("    array.forEach(function(data) {\n")
//                .append("        var timestamp = Date.now();\n")
//                .append("        var sn = data.").append(deviceFiled).append("+'';\n")
//                .append("        var deviceId = $ctx.getDeviceIdBySn('").append(pcode).append("', sn);\n")
//                .append("        if (deviceId==null || deviceId==='' || $ctx.validSnBelongProduct(sn,params[1])) {\n")
//                .append("            //没有对应的恩牛设备\n")
//                .append("            $log.warn('{} {} 没有对应的恩牛设备',sn,params[1]);\n")
//                .append("        } else {\n")
//                .append("            var reportRequest = {};\n")
//                .append("            reportRequest.deviceId=deviceId;\n")
//                .append("            reportRequest.messageType='DEVICE_EVENT_REQ';\n")
//                .append("            reportRequest.timeStamp=timestamp;\n")
//                .append("            reportRequest.identifier='").append(identifier).append("';\n")
//                .append("            reportRequest.type='alarm';\n")
//                .append("            reportRequest.version='0.0.1';\n")
//                .append("\n")
//                .append("            var metrics = [];\n")
//                .append("            for (var key in data){\n")
//                .append("                if(data[key]!=null){\n")
//                .append("                    var metric = $ctx.modelRefMetric(key, modelRef);\n");
//        if(StringUtils.isNotBlank(timeFiled)){
//            sbScript.append("                    metrics.push({code: metric, value: data[key],ts: Date.parse(data.").append(timeFiled).append(")});\n");
//        } else {
//            sbScript.append("                    metrics.push({code: metric, value: data[key],ts: timestamp});\n");
//        }
//
//        sbScript.append("                }\n")
//                .append("            }\n")
//                .append("            if (metrics.length !== 0){\n")
//                .append("                reportRequest.metrics = metrics;\n")
//                .append("                requests.push(reportRequest);\n")
//                .append("            }\n")
//                .append("        }\n")
//                .append("    });\n")
//                .append("    return JSON.stringify(requests);\n")
//                .append("});");
//        return sbScript.toString();
//    }

    public static String generatorAuth(String jsonPath,String time,String paramKey,String prefix){
        StringBuilder sbGroovy = new StringBuilder();
        sbGroovy.append("import cn.enncloud.iot.gateway.entity.cloud.TrdPlatformAuthToken;import com.alibaba.fastjson.JSONPath;import com.alibaba.fastjson.JSON;");
        String[] paths = StringUtils.split(jsonPath,".");
        if(paths.length==2) {
            sbGroovy.append("String token = String.valueOf(data);");
            sbGroovy.append("return TrdPlatformAuthToken.builder().expirationTime('").append(time).append("').paramKey('").append(paramKey).append("').paramName('token')");
        } else {
            sbGroovy.append("String datasJson = JSON.toJSONString(").append(paths[1]).append(");");
            StringBuilder jsonPath2 = new StringBuilder("$");
            for(int i = 2;i<paths.length;i++){
                jsonPath2.append(".").append(paths[i]);
            }
            sbGroovy.append("Object token = JSONPath.read(datasJson, '").append(jsonPath2).append("');");
            sbGroovy.append("return TrdPlatformAuthToken.builder().expirationTime('").append(time).append("').paramKey('").append(paramKey).append("').paramName('token')");
        }

        if(StringUtils.isNotBlank(prefix)){
            sbGroovy.append(".paramValue('").append(prefix).append(" '+token).build();");
        } else {
            sbGroovy.append(".paramValue(token).build();");
        }

        return sbGroovy.toString();
    }

    public static Object groovyShellCal(String groovyCode, String data) {
        // 创建一个绑定，用于存储变量
        Binding binding = new Binding();
        // 创建一个GroovyShell，用于执行Groovy代码
        GroovyShell shell = new GroovyShell(binding);

        // 设置变量
        if (data != null) {
            Map<String,Object> bodyre = JSONObject.parseObject(data);
            bodyre.forEach(binding::setVariable);
        }

        // 执行代码
        Object res = shell.evaluate(groovyCode);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(generatorAuth("$.result.token","600","Authorization","Bearer "));
        System.out.println(generatorReport("$.data","shutterDoorCode","shutterDoorStatusTime",false,"",""));

//        String code = "import cn.enncloud.iot.gateway.entity.cloud.TrdPlatformAuthToken;import com.alibaba.fastjson.JSONPath;import com.alibaba.fastjson.JSON;String datasJson = JSON.toJSONString(result);Object refreshToken = JSONPath.read(datasJson, '$.refreshToken');Object token = refreshToken!=null?refreshToken:JSONPath.read(datasJson, '$.accessToken');res = TrdPlatformAuthToken.builder().expirationTime('600').paramKey('accessToken').paramName('token').paramValue(token).build();";
//        String jdata = "{\"result\":{\"accessToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOjQwMTUwNjEyNTcyNjAyMSwiVGVuYW50SWQiOjEyMzQ1Njc4MDAwMDAwMCwiQWNjb3VudCI6ImZ0YWRtaW4iLCJSZWFsTmFtZSI6Iuemj-eUsOaxvei9piIsIkFjY291bnRUeXBlIjowLCJPcmdJZCI6MjUyODg1MjYzMDAzNzIwLCJpYXQiOjE3MTc0MDU5MjYsIm5iZiI6MTcxNzQwNTkyNiwiZXhwIjoxNzE4MDEwNzI2LCJpc3MiOiJFbmVyZ3lQbGF0Rm9ybSIsImF1ZCI6IkVuZXJneVBsYXRGb3JtIn0.Mo6_ef7UvwTyENO3FRu4f_nLQDFM_B2auslTBITRCpw\",\"refreshToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmIjoiZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5IiwiZSI6Ik1vNl9lZjdVdndUeUVOTzNGUnU0Zl9uTFFERk1fQjJhdXNsVEJJVFJDcHciLCJzIjoxMTYsImwiOjgsImsiOiJqLWVVc09heCIsImlhdCI6MTcxNzQwNTkyNiwibmJmIjoxNzE3NDA1OTI2LCJleHAiOjE3MTg2MTU1MjYsImlzcyI6IkVuZXJneVBsYXRGb3JtIiwiYXVkIjoiRW5lcmd5UGxhdEZvcm0ifQ.hPFXgmLUIOskUOS7XRa5bvGCmB5iCJqO7HE6yb75B7g\"},\"headers\":{\"Transfer-Encoding\":\"chunked\",\"environment\":\"Production\",\"Server\":\"Kestrel\",\"X-Rate-Limit-Remaining\":\"999971\",\"X-Rate-Limit-Limit\":\"1d\",\"X-Rate-Limit-Reset\":\"2024-06-04T02:30:00.2075992Z\",\"access-token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOjQwMTUwNjEyNTcyNjAyMSwiVGVuYW50SWQiOjEyMzQ1Njc4MDAwMDAwMCwiQWNjb3VudCI6ImZ0YWRtaW4iLCJSZWFsTmFtZSI6Iuemj-eUsOaxvei9piIsIkFjY291bnRUeXBlIjowLCJPcmdJZCI6MjUyODg1MjYzMDAzNzIwLCJpYXQiOjE3MTc0MDU5MjYsIm5iZiI6MTcxNzQwNTkyNiwiZXhwIjoxNzE4MDEwNzI2LCJpc3MiOiJFbmVyZ3lQbGF0Rm9ybSIsImF1ZCI6IkVuZXJneVBsYXRGb3JtIn0.Mo6_ef7UvwTyENO3FRu4f_nLQDFM_B2auslTBITRCpw\",\"Date\":\"Mon, 03 Jun 2024 09:12:06 GMT\",\"Content-Language\":\"zh-CN\",\"Content-Type\":\"application/json; charset=utf-8\",\"x-access-token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJmIjoiZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5IiwiZSI6Ik1vNl9lZjdVdndUeUVOTzNGUnU0Zl9uTFFERk1fQjJhdXNsVEJJVFJDcHciLCJzIjoxMTYsImwiOjgsImsiOiJqLWVVc09heCIsImlhdCI6MTcxNzQwNTkyNiwibmJmIjoxNzE3NDA1OTI2LCJleHAiOjE3MTg2MTU1MjYsImlzcyI6IkVuZXJneVBsYXRGb3JtIiwiYXVkIjoiRW5lcmd5UGxhdEZvcm0ifQ.hPFXgmLUIOskUOS7XRa5bvGCmB5iCJqO7HE6yb75B7g\"},\"code\":200,\"type\":\"success\",\"message\":\"null\",\"timestamp\":1717405926291}";
//        Object res = groovyShellCal(code,jdata);
//        System.out.println(JSONObject.toJSONString(res));
    }
}
