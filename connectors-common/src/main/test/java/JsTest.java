import cn.enncloud.iot.gateway.exception.DecodeMessageException;

public class JsTest {


    public static void main(String[] args) throws DecodeMessageException {


//
//        SpringContextUtil springContextUtil = new SpringContextUtil();
//        ProtocolSupportDefinition definition = new ProtocolSupportDefinition();
//        definition.setId("111");
//        definition.setName("test");
//        Map<String, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("lang", "js");
//        objectObjectHashMap.put("script","codec.decoder(function(byteArray){\n" +
//                "    var dataStr='';\n" +
//                "    for(var i=0;i<byteArray.length;i++){\n" +
//                "        dataStr+=String.fromCharCode(byteArray[i]);\n" +
//                "    }\n" +
//                "    var jsonObject=JSON.parse(dataStr);\n" +
//                "    var map =jsonObject.metrics;\n" +
//                "    \n" +
//                "    var timestamp = Date.now()\n" +
//                "    var myList = [];\n" +
//                "    for (var key in map) {\n" +
//                "         if (map.hasOwnProperty(key)) {\n" +
//                "             myList.push({ code: key, value: map[key],ts: timestamp});\n" +
//                "         }\n" +
//                "    }\n" +
//                "    jsonObject.metrics =myList;\n" +
//                "\n" +
//                "    var result = JSON.stringify(jsonObject)\n" +
//                "    logger.info('res:{}', result);\n" +
//                "    var deviceId = deviceContext.getDeviceIdBySn('yunyangaiot', 'YBF2152F006B19008E');\n" +
//                "    logger.info('deviceId:{}', deviceId);\n" +
//                "    return result;});\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "codec.encoder(function(msg){\n" +
//                "    var map={deviceId: msg.deviceId,\n" +
//                "             messageId: msg.messageId,\n" +
//                "             messageType: msg.messageType+'',\n" +
//                "             transport: msg.transport};\n" +
//                "    if(map.messageType=='LOGIN_RSP' || map.messageType=='REPORT_RSP'){\n" +
//                "        map.result=msg.result;map.timeStamp=msg.timeStamp}\n" +
//                "     var dataStr = JSON.stringify(map);\n" +
//                "    logger.info('dataStr:'+dataStr);\n" +
//                "    return dataStr;});");
//
//        definition.setConfiguration(objectObjectHashMap);
//        System.out.println(JSONObject.toJSONString(definition));
//        ScriptProtocolSupportLoader scriptProtocolSupportLoader = new ScriptProtocolSupportLoader();
//
//        RenameProtocolSupport renameProtocolSupport = new RenameProtocolSupport(definition.getId(), definition.getName(), definition.getDescription(), scriptProtocolSupportLoader.load(definition));
//
//        Protocol messageCodec = renameProtocolSupport.getMessageCodec(definition.getId());
//
//
//        ScriptMetricReportRequest reportRequest = new ScriptMetricReportRequest();
//
//        reportRequest.setTimeStamp(System.currentTimeMillis());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("a1", "sssss");
//        jsonObject.put("b1", "sssss222");
//        reportRequest.setMetrics(jsonObject);
//        reportRequest.setDeviceId("ddddd111");
//
//        System.out.println(JSONObject.toJSONString(reportRequest));
//
//        Object decode = messageCodec.decode(JSONObject.toJSONBytes(reportRequest));
//
//        String as ="{\"messageType\":\"DEVICE_REPORT_REQ\",\"metrics\":[{\"code\":\"a1\",\"value\":\"sssss\"},{\"code\":\"b1\",\"value\":\"sssss222\"}],\"timeStamp\":1705996049155}";
//
//        MetricReportRequest metricReportRequest = JSONObject.parseObject(as, MetricReportRequest.class);
//
//        System.out.println("执行结果：" + JSONObject.toJSONString(decode));


    }
}
