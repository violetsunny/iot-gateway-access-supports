package cn.enncloud.iot.gateway.protocol.std;

import cn.enncloud.iot.gateway.entity.gateway.HttpEventDataCmd;
import cn.enncloud.iot.gateway.entity.gateway.HttpGatewayRtgCmd;
import cn.enncloud.iot.gateway.exception.AuthException;
import cn.enncloud.iot.gateway.exception.DecodeMessageException;
import cn.enncloud.iot.gateway.exception.EncodeMessageException;
import cn.enncloud.iot.gateway.message.*;
import cn.enncloud.iot.gateway.protocol.AbstractProtocol;
import cn.enncloud.iot.gateway.utils.CommonUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EnnStandardHttpProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "enn-standard-http";
    }

    @Override
    public String getName() {
        return "enn-standard-http";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {
        if(params!=null && (String.valueOf(params[0]).equals("/access/std/rtg") || String.valueOf(params[0]).equals("/access/std/history"))){
            return transformMessages(JSONObject.parseObject(new String(messageBytes, StandardCharsets.UTF_8),HttpGatewayRtgCmd.class));
        }
        if(params!=null && String.valueOf(params[0]).equals("/access/std/event")){
            return transformEventMessages(JSONObject.parseObject(new String(messageBytes, StandardCharsets.UTF_8),HttpEventDataCmd.class));
        }

        return null;
    }


    private List<? extends Message> transformEventMessages(HttpEventDataCmd eventDataCmd) {
        List<EventReportRequest> requests = new ArrayList<>();

        eventDataCmd.getDevs().forEach(dev->{
            if(dev.getTs()==null){
                dev.setTs(System.currentTimeMillis());
            }
            long time = String.valueOf(dev.getTs()).length() == 10 ? dev.getTs() * 1000 : dev.getTs();

            EventReportRequest reportRequest = new EventReportRequest();
            reportRequest.setDeviceId(dev.getDev());
            reportRequest.setMessageId(String.format("%s%s", dev.getDev(), CommonUtils.getUUID()));
            reportRequest.setTimeStamp(time);
            reportRequest.setIdentifier(dev.getIdentifier());
            reportRequest.setType(dev.getEventType());
            reportRequest.setVersion(eventDataCmd.getVersion());

            List<Metric> metrics = new ArrayList<>();
            dev.getValue().forEach((k,v)->{
                if(k!=null && v!=null){
                    Metric metric1 = new Metric(time,k,v);
                    metrics.add(metric1);
                }
            });
            reportRequest.setMetrics(metrics);

            requests.add(reportRequest);
        });

        return requests;
    }

    private List<? extends Message> transformMessages(HttpGatewayRtgCmd rtgCmd) {
        List<MetricReportRequest> requests = new ArrayList<>();
        rtgCmd.getDevs().forEach(dev ->{
            if(dev.getTs()==null){
                dev.setTs(System.currentTimeMillis());
            }
            long time = String.valueOf(dev.getTs()).length() == 10 ? dev.getTs() * 1000 : dev.getTs();

            MetricReportRequest reportRequest = new MetricReportRequest();
            reportRequest.setDeviceId(dev.getDev());
            reportRequest.setMessageId(String.format("%s%s", dev.getDev(), CommonUtils.getUUID()));
            reportRequest.setTimeStamp(time);
            reportRequest.setIngestionTime(System.currentTimeMillis());
            reportRequest.setResume(dev.getResume());

            List<Metric> metrics = new ArrayList<>();
            dev.getD().forEach(d->{
                if(d.getM()!=null && d.getV()!=null){
                    Metric metric = new Metric();
                    metric.setCode(d.getM());
                    metric.setValue(d.getV());
                    metric.setTs(d.getTs()!=null?d.getTs():time);
                    metrics.add(metric);
                }
            });
            reportRequest.setMetrics(metrics);

            requests.add(reportRequest);
        });

        return requests;
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
    public boolean login(LoginRequest loginRequest) throws AuthException {
        return false;
    }

}
