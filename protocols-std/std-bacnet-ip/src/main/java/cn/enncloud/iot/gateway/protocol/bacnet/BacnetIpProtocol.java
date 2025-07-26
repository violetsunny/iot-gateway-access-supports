package cn.enncloud.iot.gateway.protocol.bacnet;

import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class BacnetIpProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "bacnet";
    }

    @Override
    public String getName() {
        return "bacnet协议解析";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) {
        return null;
    }


    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) {
        //加载数据
        JSONArray values = JSONArray.parseArray(new String(messageBytes, StandardCharsets.UTF_8));
        if (CollectionUtil.isEmpty(values)) {
            log.warn("BacnetIp 数据为空");
            return null;
        }
        //加载点表
        Map<String, String> dataMapper;
        if (params.length >= 1 && (params[0] instanceof Map)) {
            //通过excel初始化电表，以后可以通过网关平台获取，params[0]以后改为pCode
            dataMapper = (Map<String, String>) params[0];
        } else {
            log.warn("BacnetIp 获取点表数据失败 {}", params);
            return null;
        }

        if (MapUtil.isEmpty(dataMapper)) {
            log.warn("BacnetIp 获取点表数据失败 {}", params);
            return null;
        }

        List<MetricReportRequest> metricReportRequestList = new ArrayList<>();
        //数据替换点表信息
        List<Map<String, Object>> metricReportList = new ArrayList<>();
        values.forEach(data -> {
            JSONObject dataObj = JSONObject.parseObject(JSONObject.toJSONString(data));
            String objectKey = dataObj.getString("object_type") + " " + dataObj.get("object_address");
            String deviceId_measure = dataMapper.get(objectKey);
            if (StringUtils.isNotBlank(deviceId_measure)) {
                log.info("BacnetIp objectKey:{},deviceId_measure:{}", objectKey, deviceId_measure);
                String[] split = deviceId_measure.split("\\|");
                if(split.length>1 && StringUtils.isNotBlank(split[0])&& StringUtils.isNotBlank(split[1])){
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("deviceId", split[0]);//excel可以直接写恩牛设备id
                    dataMap.put("measure", split[1]);//可以恩牛模型测点
                    dataMap.put("value", dataObj.get("value"));
                    metricReportList.add(dataMap);
                }
            }
        });

        if (CollectionUtil.isEmpty(metricReportList)) {
            log.warn("BacnetIp 转换数据失败 metricReportList为空");
            return null;
        }

        //按设备分组
        Map<String, List<Map<String, Object>>> groupedByDeviceId = metricReportList.stream().filter(map -> map.containsKey("deviceId")) // 过滤掉没有 "deviceId" 键的 Map
                .collect(Collectors.groupingBy(map -> (String) map.get("deviceId")));

        groupedByDeviceId.forEach((deviceId, group) -> {
            MetricReportRequest metricReportRequest = new MetricReportRequest();
            metricReportRequest.setDeviceId(deviceId);
            metricReportRequest.setMessageId(String.format("%s%s", deviceId, CommonUtils.getUUID()));
            metricReportRequest.setIngestionTime(System.currentTimeMillis());
            metricReportRequest.setTimeStamp(System.currentTimeMillis());

            List<Metric> metrics = new ArrayList<>();
            group.forEach(value -> {
                Object v = value.get("value");
                if ("inactive".equalsIgnoreCase(String.valueOf(v))) {
                    v = 0;
                }
                if ("active".equalsIgnoreCase(String.valueOf(v))) {
                    v = 1;
                }
                Metric metric = new Metric(System.currentTimeMillis(), (String) value.get("measure"), v);
                metrics.add(metric);
            });
            metricReportRequest.setMetrics(metrics);
            metricReportRequestList.add(metricReportRequest);
        });
        return metricReportRequestList;
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        return true;
    }

}
