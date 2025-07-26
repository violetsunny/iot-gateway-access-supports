package cn.enncloud.iot.gateway.datacenter;

import cn.enncloud.iot.gateway.datacenter.dto.Common;
import cn.enncloud.iot.gateway.datacenter.dto.Data;
import cn.enncloud.iot.gateway.datacenter.dto.Function;
import cn.enncloud.iot.gateway.datacenter.dto.Meter;
import cn.enncloud.iot.gateway.datacenter.enums.DeviceReqEnum;
import cn.enncloud.iot.gateway.datacenter.enums.FunctionMetricEnum;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.LoginRequest;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.MetricReportRequest;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.XML;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Deflater;

import static cn.enncloud.iot.gateway.datacenter.enums.DeviceReqEnum.CONTINUOUS_END;

@Slf4j
public class DataCenterTcpProtocol extends AbstractProtocol {


    @Override
    public String getId() {
        return "data-center-tcp";
    }

    @Override
    public String getName() {
        return "data-center-tcp";
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        return parseMessage(messageBytes);
    }


    public static final ConcurrentHashMap<String, String> MD5_MAP = new ConcurrentHashMap<>();

    private List<? extends Message> parseMessage(byte[] messageBytes) {

        String message = new String(messageBytes, StandardCharsets.UTF_8);


        JSONObject jsonObject = XML.toJSONObject(message);
//

        log.info("gateway网关上报消息：{}", jsonObject.toString());
        Common common = jsonObject.getByPath("root.common", Common.class);
        DeviceReqEnum requestEnum = DeviceReqEnum.getRequestEnum(common.getType());
        if (Objects.isNull(requestEnum)) {
            log.warn("请求类型错误，info：{}", message);
        }
        JSONObject respObj = null;
        List<Message> messageList = null;
        switch (requestEnum) {
            case REQUEST:
                String respData = IdUtil.fastSimpleUUID();
                if (MD5_MAP.contains(common.getBuilding_id() + common.getGateway_id())) {
                    respData = MD5_MAP.get(common.getBuilding_id() + common.getGateway_id());
                } else {
                    MD5_MAP.put(common.getBuilding_id() + common.getGateway_id(), respData);
                }

                respObj = buildRespObj(common, respData, requestEnum.getResp(), requestEnum.getRespName());
                break;
            case MD5:

                String seq = MD5_MAP.get(common.getBuilding_id() + common.getGateway_id());
                String salt = "12345";
                String seqMD5 = MD5.create().setSalt(salt.getBytes()).digestHex(seq);
                log.info("gateway:{}生成 MD5：{},上报MD5", common.getGateway_id(), seqMD5);
                String md5 = jsonObject.getByPath("root." + requestEnum.getRespName() + "." + requestEnum.getReq()).toString();
                String result = "fail";
                if (md5.equals(seqMD5)) {
                    MD5_MAP.remove(common.getBuilding_id() + common.getGateway_id());
                    result = "pass";
                }
                respObj = buildRespObj(common, result, requestEnum.getResp(), requestEnum.getRespName());
                break;
            case NOTIFY:

                String time = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
                respObj = buildRespObj(common, time, requestEnum.getResp(), requestEnum.getRespName());
                break;

            case REPORT:
                // 数据处理
                Data data = jsonObject.getByPath("root.data", Data.class);
                messageList = reportDataProcess(common, data);

                log.info("数据中心解析上报数据：{}", JSONUtil.toJsonStr(messageList));

                respObj = buildRespObj(common, null, requestEnum.getResp(), requestEnum.getRespName());
                break;
            case AUTO_HISTORY:

                // 默认同意
                respObj = buildRespObj(common, 1, requestEnum.getResp(), requestEnum.getRespName());
                break;

            case CONTINUOUS:

                // 数据处理
                Data data1 = jsonObject.getByPath("root.data", Data.class);
                messageList = reportDataProcess(common, data1);

                log.info("数据中心解析续传数据：{}", JSONUtil.toJsonStr(messageList));

                String total = String.valueOf(jsonObject.getByPath("root.data.total"));
                String current = String.valueOf(jsonObject.getByPath("root.data.current"));
                if (total.equals(current)) {
                    respObj = buildRespObj(common, null, CONTINUOUS_END.getResp(), CONTINUOUS_END.getRespName());
                } else {
                    respObj = buildRespObj(common, null, requestEnum.getResp(), requestEnum.getRespName());
                }
                break;
            default:
                log.warn("请求类型错误，info：{}", message);

        }

        String respStr = JSONUtil.toJsonStr(respObj);
        log.info("数据中心回复消息：{}", respStr);
        String deviceIdBySn = deviceContext.getDeviceIdBySn(null, common.getGateway_id());
        if (StringUtils.isBlank(deviceIdBySn)) {
            deviceIdBySn = common.getGateway_id();
        }
        if (Objects.isNull(messageList)) {
            MetricReportRequest metricReportRequest = new MetricReportRequest();

            metricReportRequest.setDeviceId(deviceIdBySn);
            metricReportRequest.setResponse(respStr);
            return Collections.singletonList(metricReportRequest);
        } else {
            MetricReportRequest metricReportRequest = new MetricReportRequest();
            metricReportRequest.setDeviceId(deviceIdBySn);
            metricReportRequest.setResponse(respStr);

            messageList.add(metricReportRequest);
        }

        return messageList;
    }


    public static final String buildingId = "buildingId";
    public static final String sampleTime = "sampleTime";
    public static final String coding = "coding";
    public static final String error = "error";

    private List<Message> reportDataProcess(Common common, Data data) {

        List<Message> reportRequests = new ArrayList<>();

        String meterStr = data.getMeter();
        if (JSONUtil.isTypeJSONObject(meterStr)) {
            Meter meter = JSONUtil.toBean(meterStr, Meter.class);

            MetricReportRequest metricReportRequest = buildMetricReportRequest(common, meter);

            if (Objects.nonNull(metricReportRequest)) {
                reportRequests.add(metricReportRequest);
            }
        } else if (JSONUtil.isTypeJSONArray(meterStr)) {

            List<Meter> meters = JSONUtil.toList(meterStr, Meter.class);

            meters.forEach(meter -> {
                MetricReportRequest metricReportRequest = buildMetricReportRequest(common, meter);
                if (Objects.nonNull(metricReportRequest)) {
                    reportRequests.add(metricReportRequest);
                }
            });
        }

        return reportRequests;
    }

    private MetricReportRequest buildMetricReportRequest(Common common, Meter meter) {

        Map<String, Object> functions;
        if (common.getBuilding_id().equals("0731")) {
            // 定制特殊设备解析
            functions = CustomGatewayMetricHandler.customMetricTrans(common, meter);
            if (Objects.isNull(functions)) {
                log.warn("定制新威盛网关数据解析异常,common：{}，meter：{}", common, meter);
                return null;
            }
        } else {
            functions = parseFunction(meter.getFunction());
        }

        functions.put(buildingId, common.getBuilding_id());

        MetricReportRequest metricReportRequest = new MetricReportRequest();

        // 设备sn：网关id+meterId
        String sn = common.getGateway_id() + meter.getId();
        String deviceIdBySn = deviceContext.getDeviceIdBySn(null, sn);
        if (StringUtils.isBlank(deviceIdBySn)){
            log.warn("恩牛设备id为空，build_id:{},gateway_id:{},sn：{}",common.getBuilding_id(),common.getGateway_id(),sn);
        }

        metricReportRequest.setDeviceId(deviceIdBySn);

        DateTime dateTime = null;
        if (Objects.nonNull(functions.get(sampleTime))) {
            String time = String.valueOf(functions.get(sampleTime));
            dateTime = DateUtil.parse(time, DatePattern.PURE_DATETIME_PATTERN);
        } else {
            dateTime = new DateTime();
        }

        long time = dateTime.getTime();
        metricReportRequest.setTimeStamp(time);
        metricReportRequest.setIngestionTime(System.currentTimeMillis());

        List<Metric> metrics = new ArrayList<>(functions.size());
        functions.forEach((k, v) -> {

            Metric metric = new Metric();
            metric.setCode(k);
            metric.setValue(v);
            metric.setTs(time);
            metrics.add(metric);
        });
        metricReportRequest.setMetrics(metrics);
        return metricReportRequest;
    }

    private Map<String, Object> parseFunction(String functionStr) {

        HashMap<String, Object> funcMap = new HashMap<>();
        if (JSONUtil.isTypeJSONObject(functionStr)) {

            Function function = JSONUtil.toBean(functionStr, Function.class);
            buildMetric(funcMap, function);


        } else if (JSONUtil.isTypeJSONArray(functionStr)) {

            List<Function> functions = JSONUtil.toList(functionStr, Function.class);
            functions.forEach(function -> buildMetric(funcMap, function));
        }
        return funcMap;
    }

    private static void buildMetric(HashMap<String, Object> funcMap, Function function) {
        int id = function.getId();
        FunctionMetricEnum functionMetricEnum = FunctionMetricEnum.getFunctionMetricEnum(String.valueOf(id));
        if (id <= 16) {
            funcMap.put(sampleTime, function.getSample_time());
            funcMap.put(coding, function.getCoding());
            funcMap.put(error, function.getError());
        }
        //TODO:使用 metric key
        String metric = functionMetricEnum.getMetric();
        if (StringUtils.isBlank(metric)) {
            metric = functionMetricEnum.getCode();
        }
        funcMap.put(metric, function.getContent());
//        funcMap.put(functionMetricEnum.name().toLowerCase(), function.getContent());
    }


    private JSONObject buildRespObj(Common common, Object respData, String respType, String respName) {
        common.setType(respType);

        JSONObject operation = new JSONObject();
        operation.set("operation", respType);

        if (Objects.nonNull(respData)) {
            if (respData.equals("auto_history_ack")) {
                operation.set("type", respData);
            } else {
                if (respType.equals(DeviceReqEnum.AUTO_HISTORY.getResp())) {
                    operation.set("type", respData);
                } else {
                    operation.set(respType, respData);
                }
            }
        }


        JSONObject root = new JSONObject();
        root.set("common", common);
        root.set(respName, operation);

        JSONObject respObj = new JSONObject();
        respObj.set("root", root);
        return respObj;
    }

    @Override
    public byte[] encode(Message message, Object... params) throws EncodeMessageException {


        if (message.getMessageType().equals(MessageType.DEVICE_REPORT_RSP)) {
            ByteBuf buffer = Unpooled.buffer();
            String response = message.getResponse();
            JSONObject jsonObject = JSONUtil.parseObj(response);

            byte[] bytes = zlibCompress(jsonObject);
            buffer.writeBytes(bytes);
            return ByteBufUtil.getBytes(buffer);
        } else {
            return null;
        }


    }

    @Override
    public byte[] encodeMulti(List<? extends Message> messages, Object... params) throws EncodeMessageException {

        ByteBuf buffer = Unpooled.buffer();

        messages.forEach(message -> {

            String response = message.getResponse();
            JSONObject jsonObject = JSONUtil.parseObj(response);

            byte[] bytes = zlibCompress(jsonObject);
            buffer.writeBytes(bytes);

        });
        return ByteBufUtil.getBytes(buffer);
    }

    @Override
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }


    /**
     * zlib压缩协议encode
     *
     * @param respData
     * @return
     */
    private byte[] zlibCompress(JSONObject respData) {


        String xml = createXml(respData);
        System.out.println(xml);
        log.info("xml data: {}", xml);
        byte[] data = xml.getBytes();
//        String s = ByteBufUtil.hexDump(data);
//        System.out.println(s);
//        String a ="3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d227574662d3822203f3e0a3c726f6f743e0a202020203c636f6d6d6f6e3e0a20202020202020203c6275696c64696e675f69643e303733313c2f6275696c64696e675f69643e0a20202020202020203c676174657761795f69643e31303030313c2f676174657761795f69643e0a20202020202020203c747970653e726571756573743c2f747970653e0a202020203c2f636f6d6d6f6e3e0a202020203c69645f76616c6964617465206f7065726174696f6e3d227265717565737422202f3e0a3c2f726f6f743e0a";
//        String a ="3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d227574662d3822203f3e0a3c726f6f743e0a202020203c636f6d6d6f6e3e0a20202020202020203c6275696c64696e675f69643e303733313c2f6275696c64696e675f69643e0a20202020202020203c676174657761795f69643e393939393c2f676174657761795f69643e0a20202020202020203c747970653e726571756573743c2f747970653e0a202020203c2f636f6d6d6f6e3e0a202020203c69645f76616c6964617465206f7065726174696f6e3d227265717565737422202f3e0a3c2f726f6f743e0a";
//
//        byte[] bytes = ByteBufUtil.decodeHexDump(a);
//        String s1 = new String(bytes);
//        System.out.println(s1);
        // 压缩数据
        return zLibCompressBytes(data);
    }

    public static byte[] zLibCompressBytes(byte[] data) {
        Deflater deflater = new Deflater(Deflater.DEFAULT_COMPRESSION);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        deflater.setInput(data);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] compressedData = outputStream.toByteArray();

        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeBytes(compressedData);
        log.info("compress byte data: {}", ByteBufUtil.hexDump(byteBuf));

        return ByteBufUtil.getBytes(byteBuf);
    }


    public String createXml(JSONObject jsonObject) {

        Document document = XmlUtil.createXml();
        document.setXmlStandalone(true);
        Element rootElement = document.createElement("root");
        document.appendChild(rootElement);

        Map<String, Object> rootMap = (Map<String, Object>) jsonObject.get("root");
        for (Map.Entry<String, Object> entry : rootMap.entrySet()) {
            Element element = document.createElement(entry.getKey());
            rootElement.appendChild(element);

            if (entry.getValue() instanceof Map) {
                Map<String, Object> subMap = (Map<String, Object>) entry.getValue();
                if (subMap.containsKey("operation")) {
                    element.setAttribute("operation", subMap.get("operation").toString());
                }
                for (Map.Entry<String, Object> subEntry : subMap.entrySet()) {
                    if (!subEntry.getKey().equals("operation")) {
                        Element subElement = document.createElement(subEntry.getKey());
                        if (subEntry.getValue() != null) {
                            subElement.setTextContent(subEntry.getValue().toString());
                        }
                        element.appendChild(subElement);
                    }
                }
            } else {
                if (entry.getValue() != null) {
                    element.setTextContent(entry.getValue().toString());
                }
            }
        }

        String xml = XmlUtil.toStr(document);
        return xml;
    }
}
