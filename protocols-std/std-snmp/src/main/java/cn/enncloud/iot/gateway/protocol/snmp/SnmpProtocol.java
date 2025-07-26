package cn.enncloud.iot.gateway.protocol.snmp;

import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class SnmpProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "200";
    }

    @Override
    public String getName() {
        return "UPS设备协议解析";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) {
        try {
            //加载配置文件数据
            Yaml yaml = new Yaml();
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("application.yml");
            Map<String, Object> data = yaml.load(is);
            Map<String, Object> ennew = (Map<String, Object>) data.get("ennew");
            Map<String, Object> iot = (Map<String, Object>) ennew.get("iot");
            List<Map<String, Object>> devices = (List<Map<String, Object>>) iot.get("devices");
            Map<String, Object> values = (Map<String, Object>) JsonUtil.jsonBytes2Object(messageBytes, Map.class);
            List<MetricReportRequest> metricReportRequests = new ArrayList<>();
            devices.forEach(device -> {
                MetricReportRequest metricReportRequest = new MetricReportRequest();
                String deviceId = String.valueOf(device.get("id"));
                metricReportRequest.setDeviceId(deviceId);
                metricReportRequest.setIngestionTime(System.currentTimeMillis());
                metricReportRequest.setTimeStamp(System.currentTimeMillis());
                List<Map<String, Object>> attributes = (List<Map<String, Object>>) device.get("metrics");
                List<Metric> metrics = new ArrayList<>();
                attributes.forEach(attribute -> {
                    String oid = (String) attribute.get("oid");
                    String name = (String) attribute.get("name");
                    String value = values.containsKey(oid) ? (String) values.get(oid) : null;
                    Metric metric = new Metric(System.currentTimeMillis(), name, value);
                    metrics.add(metric);
                });
                metricReportRequest.setMetrics(metrics);
                metricReportRequests.add(metricReportRequest);
            });
            return metricReportRequests;
        } catch (Exception e) {
            log.warn("Snmp协议解析数据失败{}", e.getMessage());
            return null;
        }

    }

    @Override
    public byte[] encode(Message message, Object... params) {
        return JsonUtil.object2JsonBytes(message);
    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        return true;
    }
}
