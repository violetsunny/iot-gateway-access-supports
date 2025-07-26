package cn.enncloud.iot.gateway.airwind.protocol;


import cn.enncloud.iot.gateway.airwind.dto.DeviceCommandDTO;
import cn.enncloud.iot.gateway.airwind.dto.DeviceConfigDTO;
import cn.enncloud.iot.gateway.airwind.dto.DeviceReportDTO;
import cn.enncloud.iot.gateway.airwind.dto.MetricDTO;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.JsonUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MqttAirWindMessageCodec extends AbstractProtocol {


    @Override
    public String getId() {
        return "enn-mqtt-airwind";
    }

    @Override
    public String getName() {
        return null;
    }


    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {

        DeviceReportDTO deviceReportDTO = null;
        try {
            deviceReportDTO = JsonUtil.jsonBytes2Object(messageBytes, DeviceReportDTO.class);
        } catch (Exception e) {
            throw new DecodeMessageException(DecodeMessageException.ErrorType_Unexpect_Receive, "接收消息解析对象异常!");
        }

        if (Objects.nonNull(deviceReportDTO)) {
            String ts = deviceReportDTO.getTs();
            long timeStamp = DateUtil.parse(ts, DatePattern.UTC_WITH_ZONE_OFFSET_PATTERN).getTime();

            List<MetricDTO> values = deviceReportDTO.getValues();


            HashMap<String, List<Metric>> deviceMetricMap = new HashMap<>();
            values.forEach(metricDTO -> {

                String tag = metricDTO.getTag();
                Object value = metricDTO.getValue();

                // 根据tag获取设备和测点定义-->json配置文件
                ConcurrentHashMap<String, DeviceConfigDTO> metricMap = ReadConfig.getReadConfig().getMETRIC_MAP();
                DeviceConfigDTO deviceConfigDTO = metricMap.get(tag);
                if (Objects.isNull(deviceConfigDTO)) {
                    log.warn("设备原始点位未配置！，tag:{},value:{}", tag, value);
                    return;
                }
                String sn = deviceConfigDTO.getProductCode() + deviceConfigDTO.getDeviceId();
                Metric metric = new Metric(timeStamp, deviceConfigDTO.getMetric(), value);
                if (deviceMetricMap.containsKey(sn)) {
                    List<Metric> metrics = deviceMetricMap.get(sn);
                    metrics.add(metric);
                } else {

                    List<Metric> objects = new ArrayList<>();
                    objects.add(metric);

                    deviceMetricMap.put(sn, objects);
                }
            });


            List<Message> messageList = new ArrayList<>();
            deviceMetricMap.forEach((key, value) -> {

                MetricReportRequest reportRequest = new MetricReportRequest();
                // 需要转化设备id
                String deviceIdBySn = deviceContext.getDeviceIdBySn(null, key);
                reportRequest.setDeviceId(deviceIdBySn);
                reportRequest.setMetrics(value);
                reportRequest.setTimeStamp(timeStamp);

                messageList.add(reportRequest);
            });


            return messageList;
        }

        return null;
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {


        OperationRequest cmdMessage = (OperationRequest) message;

        OperationRequest cmdMsgResult = new OperationRequest();

        cmdMsgResult.setTopic("cmd/KT150");


        String deviceId = cmdMessage.getDeviceId();
        Map<String, Object> param = cmdMessage.getParam();


        String sn;
        String snByDeviceId = deviceContext.getSnByDeviceId(deviceId);
        if (StringUtils.isNotBlank(snByDeviceId)) {
            sn = snByDeviceId;
        } else {
            sn = deviceId;
        }

        ConcurrentHashMap<String, DeviceConfigDTO> cmdMetricMap = ReadConfig.getReadConfig().getCMD_METRIC_MAP();


        DeviceCommandDTO commandDTO = new DeviceCommandDTO();
        commandDTO.setTs(cmdMessage.getTimeStamp());

        Map<String, Object> metricDTOS = new HashMap<>();
        param.forEach((k, v) -> {

            DeviceConfigDTO deviceConfigDTO = cmdMetricMap.get(sn + k);
            if (Objects.isNull(deviceConfigDTO)) {
                log.warn("测点下行配置不存在！sn：{}，metric:{}", sn, k);
                return;
            }

            if (deviceConfigDTO.getWr().contains("只读")) {
                log.warn("设备:{},测点读写属性为只读,跳过指令,tag:{}", sn, deviceConfigDTO.getOrgMetric());
                return;
            }

            metricDTOS.put(deviceConfigDTO.getOrgMetric(), v);

        });


        if (CollectionUtil.isNotEmpty(metricDTOS)) {
            commandDTO.setValues(metricDTOS);

            cmdMsgResult.setParam(JSONUtil.parseObj(commandDTO));
        }

        return JsonUtil.object2JsonBytes(cmdMsgResult);

    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) {
        return new byte[0];
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        return false;
    }


}
