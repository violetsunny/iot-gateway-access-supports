package cn.enncloud.iot.gateway.protocol.std.energy.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class IacPortalApiUtil {
    public IacPortalApiUtil() {
    }

    public static JSONArray convertCmdMapToJsonWithoutTime(Map cmdMap) {
        JSONArray jsonArray = new JSONArray();
        cmdMap.forEach((key, value) -> {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("metric", key);
            jsonObj.put("value", value);
            jsonObj.put("time", (Object)null);
            jsonArray.add(jsonObj);
        });
        return jsonArray;
    }

    public static JSONArray convertCimDataListToJson(List cimMetricDataList) {
        JSONArray cimMetricJsonArray = JSONArray.parseArray(JSONObject.toJSONString(cimMetricDataList));
        JSONArray jsonArray = new JSONArray();
        cimMetricJsonArray.stream().forEach((sourceJson) -> {
            JSONObject jsonObj = new JSONObject();
            String sourceMetric = ((JSONObject)sourceJson).get("metric").toString();
            jsonObj.put("metric", sourceMetric.substring(sourceMetric.lastIndexOf("_") + 1));
            jsonObj.put("value", ((JSONObject)sourceJson).get("value"));
            jsonObj.put("time", ((JSONObject)sourceJson).get("time"));
            jsonArray.add(jsonObj);
        });
        return jsonArray;
    }

    public static JSONArray convertCmdBackMapToJson(Map cmdBackMap) {
        JSONArray jsonArray = new JSONArray();
        cmdBackMap.forEach((key, value) -> {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", key);
            jsonObj.put("value", value);
            jsonArray.add(jsonObj);
        });
        return jsonArray;
    }
}
