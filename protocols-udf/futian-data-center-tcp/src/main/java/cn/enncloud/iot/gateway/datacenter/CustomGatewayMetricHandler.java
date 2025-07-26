package cn.enncloud.iot.gateway.datacenter;


import cn.enncloud.iot.gateway.datacenter.dto.Function;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CustomGatewayMetricHandler {


    public static ConcurrentHashMap<String, JSONObject> Custom_Map;

    static {
        Custom_Map = CustomGatewayMetricHandler.initMap();
    }

    public static ConcurrentHashMap<String, JSONObject> initMap() {

        List<CustomInfo> customInfos = JSONUtil.toList(CustomMapStr, CustomInfo.class);
        ConcurrentHashMap<String, JSONObject> mappingInfo = new ConcurrentHashMap<>();
        customInfos.forEach(customInfo -> {
            String key = customInfo.getCommon().getBuilding_id() + customInfo.getCommon().getGateway_id();

            JSONObject jsonObject = new JSONObject();
            customInfo.getMeter().forEach(meter -> {
                jsonObject.put(String.valueOf(meter.getId()), meter.getFunctionMap());
            });

            mappingInfo.put(key, jsonObject);
        });
        return mappingInfo;
    }

    public static HashMap<String, Object> customMetricTrans(cn.enncloud.iot.gateway.datacenter.dto.Common common, cn.enncloud.iot.gateway.datacenter.dto.Meter meter) {


        String key = common.getBuilding_id() + common.getGateway_id();
        if (Custom_Map.containsKey(key)) {
            JSONObject configs = Custom_Map.get(key);

            Map<String, String> config = (Map<String, String>) configs.get(String.valueOf(meter.getId()));

            String functionStr = meter.getFunction();

            HashMap<String, Object> dataMap = new HashMap<>();
            if (JSONUtil.isTypeJSONObject(functionStr)) {

                Function function = JSONUtil.toBean(functionStr, Function.class);
                buildCustomMetric(config, dataMap, function);
            } else if (JSONUtil.isTypeJSONArray(functionStr)) {

                List<Function> functions = JSONUtil.toList(functionStr, Function.class);
                functions.forEach(function -> buildCustomMetric(config, dataMap, function));
            }

            return dataMap;
        }

        return null;

    }

    private static void buildCustomMetric(Map<String, String> config, HashMap<String, Object> dataMap, Function function) {
        String metricKey = null;
        if (Objects.nonNull(config)) {
            metricKey = config.get(String.valueOf(function.getId()));
        } else {
            metricKey = String.valueOf(function.getId());
        }
        if (StringUtils.isNotBlank(metricKey)) {
            dataMap.put(metricKey, function.getContent());
        }
    }


    public static final String CustomMapStr = "[{\"common\":{\"building_id\":\"0731\",\"gateway_id\":\"9999\"},\"meter\":[{\"id\":1,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":2,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":3,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":4,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":5,\"functionMap\":{\"1\":\"Eptp\",\"2\":\"Eqtp\",\"3\":\"Ia\",\"4\":\"Ib\",\"5\":\"Ic\",\"6\":\"Ua\",\"7\":\"Ub\",\"8\":\"Uc\",\"9\":\"P\",\"10\":\"Q\",\"11\":\"COS\"}},{\"id\":6,\"functionMap\":{\"1\":\"Eptp\",\"2\":\"Eqtp\",\"3\":\"Ia\",\"4\":\"Ib\",\"5\":\"Ic\",\"6\":\"Ua\",\"7\":\"Ub\",\"8\":\"Uc\",\"9\":\"P\",\"10\":\"Q\",\"11\":\"COS\"}}]},{\"common\":{\"building_id\":\"0731\",\"gateway_id\":\"10000\"},\"meter\":[{\"id\":1,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":2,\"functionMap\":{\"1\":\"FInt\"}},{\"id\":3,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":4,\"functionMap\":{\"1\":\"T\",\"2\":\"PA\",\"3\":\"Fgas\",\"4\":\"FgasInt\"}},{\"id\":5,\"functionMap\":{\"2\":\"oFInt\"}},{\"id\":6,\"functionMap\":{\"2\":\"oFInt\"}}]},{\"common\":{\"building_id\":\"0731\",\"gateway_id\":\"10001\"},\"meter\":[{\"id\":1,\"functionMap\":{\"4\":\"FInt\"}},{\"id\":2,\"functionMap\":{\"4\":\"FInt\"}},{\"id\":3,\"functionMap\":{\"4\":\"FInt\"}},{\"id\":4,\"functionMap\":{\"1\":\"T\",\"2\":\"PA\",\"3\":\"Fgas\",\"4\":\"FgasInt\"}},{\"id\":5,\"functionMap\":{\"4\":\"FInt\"}},{\"id\":6,\"functionMap\":{\"2\":\"oFInt\"}},{\"id\":7,\"functionMap\":{\"2\":\"oFInt\"}},{\"id\":8,\"functionMap\":{\"1\":\"T\",\"2\":\"PA\",\"3\":\"Fgas\",\"4\":\"FgasInt\"}}]},{\"common\":{\"building_id\":\"0731\",\"gateway_id\":\"10002\"},\"meter\":[{\"id\":2,\"functionMap\":{\"5\":\"FInt\"}},{\"id\":1,\"functionMap\":{\"1\":\"T\",\"2\":\"PA\",\"3\":\"Fgas\",\"4\":\"FgasInt\"}}]}]";


    public class Common {
        private String building_id;

        private String gateway_id;

        public void setBuilding_id(String building_id) {
            this.building_id = building_id;
        }

        public String getBuilding_id() {
            return this.building_id;
        }

        public void setGateway_id(String gateway_id) {
            this.gateway_id = gateway_id;
        }

        public String getGateway_id() {
            return this.gateway_id;
        }
    }


    public class Meter {
        private int id;

        private Map<String, String> functionMap;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public void setFunctionMap(Map<String, String> functionMap) {
            this.functionMap = functionMap;
        }

        public Map<String, String> getFunctionMap() {
            return this.functionMap;
        }
    }


    public class CustomInfo {
        private Common common;

        private List<Meter> meter;

        public void setCommon(Common common) {
            this.common = common;
        }

        public Common getCommon() {
            return this.common;
        }

        public void setMeter(List<Meter> meter) {
            this.meter = meter;
        }

        public List<Meter> getMeter() {
            return this.meter;
        }
    }
}
