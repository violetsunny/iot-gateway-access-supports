/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.loader.script;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglele
 * @version $Id: JsComonLine, v 0.1 2024/3/26 15:11 kanglele Exp $
 */
//@Component
@Slf4j
public class JsCommandLine implements CommandLineRunner {

//    @Resource
    private DeviceContext deviceContext;

    @Override
    public void run(String... args) throws Exception {
        String script = "codec.decodeMulti(function(dataStr,params) {\n" +
                "    var jsonObject = JSON.parse(dataStr);\n" +
                "    var requests = [];\n" +
                "    var array = jsonObject.data;\n" +
                "    if (array == null){\n" +
                "        $log.warn('data数据为空 {}',dataStr);\n" +
                "        return null;\n" +
                "    }\n" +
                "\n" +
                "    var modelRef = {\n" +
                "        'ia': 'ia',\n" +
                "        'ua': 'ua',\n" +
                "        'ub': 'ub',\n" +
                "        'uc': 'uc',\n" +
                "        'uab': 'uab',\n" +
                "        'ubc': 'ubc',\n" +
                "        'uca': 'uca'\n" +
                "    };\n" +
                "    modelRef = $ctx.modelRef('futianchangsha',params[1],modelRef);\n" +
                "\n" +
                "    array.forEach(function(data) {\n" +
                "        var timestamp = Date.now();\n" +
                "        var sn = data.device_number;\n" +
                "        var deviceId = $ctx.getDeviceIdBySn('futianchangsha', sn);\n" +
                "        if (deviceId==null || deviceId==='') {\n" +
                "            //没有对应的恩牛设备\n" +
                "            $log.warn('{} 没有对应的恩牛设备',sn);\n" +
                "        } else {\n" +
                "\n" +
                "            var reportRequest = {};\n" +
                "            reportRequest.deviceId=deviceId;\n" +
                "            reportRequest.messageType='DEVICE_REPORT_REQ';\n" +
                "            reportRequest.timeStamp=timestamp;\n" +
                "            reportRequest.ingestionTime=timestamp;\n" +
                "\n" +
                "            var metrics = [];\n" +
                "            for (var key in data.tags){\n" +
                "                if(data.tags[key]!=null){\n" +
                "                    var metr = data.tags[key];\n" +
                "                    if (metr!=null&& metr.val!=null){\n" +
                "                        var metric = $ctx.modelRefMetric(key, modelRef);\n" +
                "                        metrics.push({code: metric, value: metr.val,ts: Date.parse(metr.log_time)});\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            if (metrics.length !== 0){\n" +
                "                reportRequest.metrics = metrics;\n" +
                "                requests.push(reportRequest);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "    });\n" +
                "    return JSON.stringify(requests);\n" +
                "});";

        ScriptProtocol scriptProtocol = new ScriptProtocol(script);
        String json = "{\n" +
                "    \"status\": 200,\n" +
                "    \"msg\": \"\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"1\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e2_b1\",\n" +
                "            \"device_number\": \"FT09-Dg-1-2-ZZ-001\",\n" +
                "            \"level\": \"2\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"181\",\n" +
                "            \"desc\": \"\\u603b\\u88c5\\u8f66\\u95f4\",\n" +
                "            \"device_desc\": \"1AA1 \\u8fdb\\u7ebf\\u67dc\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 234.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 234.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 234.7,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 406.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 406.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 406.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 477,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 464,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 460,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 326,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 35,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 0.995,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 328,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 3336717,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e2_b2\",\n" +
                "            \"device_number\": \"FT09-Dg-1-3-ZZ-001\",\n" +
                "            \"level\": \"3\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"1\",\n" +
                "            \"desc\": \"1AA2 \\u7535\\u5bb9\\u4e3b\\u67dc\",\n" +
                "            \"device_desc\": \"1AA2 \\u7535\\u5bb9\\u4e3b\\u67dc\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 234.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 234.5,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 234.7,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 406.2,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 406.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 406.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 213,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:13\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 213,\n" +
                "                    \"log_time\": \"2024-05-28 10:34:13\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 218,\n" +
                "                    \"log_time\": \"2024-05-28 10:34:13\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 0.7,\n" +
                "                    \"log_time\": \"2024-05-28 10:34:03\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 151.5,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 0.005,\n" +
                "                    \"log_time\": \"2024-05-28 10:34:13\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 1515,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 3836,\n" +
                "                    \"log_time\": \"2024-05-28 10:32:13\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"3\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e2_b3\",\n" +
                "            \"device_number\": \"FT09-Dg-1-3-ZZ-002\",\n" +
                "            \"level\": \"3\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"1\",\n" +
                "            \"desc\": \"1AA3 \\u7535\\u5bb9\\u8f85\\u67dc\",\n" +
                "            \"device_desc\": \"1AA3 \\u7535\\u5bb9\\u8f85\\u67dc\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 234.5,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 234.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 234.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 405.9,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 405.9,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 406,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 106,\n" +
                "                    \"log_time\": \"2024-05-28 10:33:03\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 106,\n" +
                "                    \"log_time\": \"2024-05-28 10:33:03\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 108,\n" +
                "                    \"log_time\": \"2024-05-28 10:33:03\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 0.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:33:03\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 75.5,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 0.004,\n" +
                "                    \"log_time\": \"2024-05-28 10:33:03\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 754,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 3967,\n" +
                "                    \"log_time\": \"2024-05-28 10:32:53\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"4\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e2_b4\",\n" +
                "            \"device_number\": \"FT09-Dg-1-3-ZZ-003\",\n" +
                "            \"level\": \"3\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"1\",\n" +
                "            \"desc\": \"1AA4 \\u6ee4\\u6ce2\\u67dc\",\n" +
                "            \"device_desc\": \"1AA4 \\u6ee4\\u6ce2\\u67dc\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 234.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 234.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 234.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 405.9,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 406.1,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 406.1,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:43\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 1,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 0,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 1732,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:23\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"5\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e3_b1\",\n" +
                "            \"device_number\": \"FT09-Dg-1-3-ZZ-004W\",\n" +
                "            \"level\": \"3\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"1\",\n" +
                "            \"desc\": \"1AA3-1 \\u7269\\u6d41\\u8f6e\\u80ce\\u7ebf\",\n" +
                "            \"device_desc\": \"1AA3-1 \\u5907\\u7528\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 233.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 233.4,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 233.8,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 404,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 403.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 404.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 3.2,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 6.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 2,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 2.2,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 0.07,\n" +
                "                    \"log_time\": \"2024-05-28 10:34:53\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 0.806,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 27,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 141754,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"6\",\n" +
                "            \"tg_name\": \"TG757\",\n" +
                "            \"device_name\": \"e3_b2\",\n" +
                "            \"device_number\": \"FT09-Dg-1-3-ZZ-005W\",\n" +
                "            \"level\": \"3\",\n" +
                "            \"is_exists\": \"1\",\n" +
                "            \"pid\": \"1\",\n" +
                "            \"desc\": \"1AA3-2 \\u7269\\u6d41\\u7a7a\\u538b\\u673a\",\n" +
                "            \"device_desc\": \"1AA3-2 \\u5907\\u7528\",\n" +
                "            \"tags\": {\n" +
                "                \"ua\": {\n" +
                "                    \"val\": 233.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ub\": {\n" +
                "                    \"val\": 233.9,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uc\": {\n" +
                "                    \"val\": 233.9,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uab\": {\n" +
                "                    \"val\": 404.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ubc\": {\n" +
                "                    \"val\": 404.1,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"uca\": {\n" +
                "                    \"val\": 404.6,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ia\": {\n" +
                "                    \"val\": 77,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ib\": {\n" +
                "                    \"val\": 75.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ic\": {\n" +
                "                    \"val\": 73.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"p\": {\n" +
                "                    \"val\": 40.3,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"q\": {\n" +
                "                    \"val\": 1.23,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"pf\": {\n" +
                "                    \"val\": 0.767,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"s\": {\n" +
                "                    \"val\": 527,\n" +
                "                    \"log_time\": \"2024-05-28 10:37:33\"\n" +
                "                },\n" +
                "                \"ep\": {\n" +
                "                    \"val\": 273380,\n" +
                "                    \"log_time\": \"2024-05-28 10:36:43\"\n" +
                "                }\n" +
                "            }\n" +
                "        }]}";

//        Object decode = messageCodec.decodeMulti(JSONObject.toJSONBytes(JSONObject.parseObject(json)));

//        String as ="{\"messageType\":\"DEVICE_REPORT_REQ\",\"metrics\":[{\"code\":\"a1\",\"value\":\"sssss\"},{\"code\":\"b1\",\"value\":\"sssss222\"}],\"timeStamp\":1705996049155}";
//
//        MetricReportRequest metricReportRequest = JSONObject.parseObject(as, MetricReportRequest.class);

        scriptProtocol.setDeviceContext(deviceContext);
        List<? extends Message> decode = scriptProtocol.decodeMulti(JSONObject.toJSONBytes(JSONObject.parseObject(json)),"",null);

        log.info("执行结果：" + JSONObject.toJSONString(decode));
    }

    @SneakyThrows
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            // 创建包含复杂类型属性的Metric对象列表
            List<Object> complexList = Arrays.asList(
                    new Metric(123456782L, "key2", "complexList"),
                    new Metric(987654331L, "key3", "complexList")
            );
            List<Metric> metrics = Arrays.asList(
                    new Metric(123456789L, "key1", complexList),
                    new Metric(987654321L, "key2", complexList)
            );

            // 将Metric对象列表传递给JavaScript
            engine.put("metrics", metrics);

            // 在JavaScript中访问Metric对象的code属性，它是一个复杂类型List<Object>
            engine.eval("print(metrics[0].getValue());"); // 输出 "item1"

        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
