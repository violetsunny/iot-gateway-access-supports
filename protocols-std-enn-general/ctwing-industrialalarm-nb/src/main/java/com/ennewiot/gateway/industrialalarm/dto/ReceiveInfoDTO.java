package com.ennewiot.gateway.industrialalarm.dto;

public class ReceiveInfoDTO {


    private String IMEI;
    private String IMSI;
    private String assocAssetId;
    private String deviceId;
    private String deviceType;
    private String messageType;
    private Payload payload;
    private String productId;
    private String protocol;
    private String serviceId;
    private String tenantId;
    private long timestamp;
    private String topic;
    private int upDataSN;
    private int upPacketSN;

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setAssocAssetId(String assocAssetId) {
        this.assocAssetId = assocAssetId;
    }

    public String getAssocAssetId() {
        return assocAssetId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setUpDataSN(int upDataSN) {
        this.upDataSN = upDataSN;
    }

    public int getUpDataSN() {
        return upDataSN;
    }

    public void setUpPacketSN(int upPacketSN) {
        this.upPacketSN = upPacketSN;
    }

    public int getUpPacketSN() {
        return upPacketSN;
    }

    public static class Payload {

        private String APPdata;

        public void setAPPdata(String APPdata) {
            this.APPdata = APPdata;
        }

        public String getAPPdata() {
            return APPdata;
        }

    }
}
