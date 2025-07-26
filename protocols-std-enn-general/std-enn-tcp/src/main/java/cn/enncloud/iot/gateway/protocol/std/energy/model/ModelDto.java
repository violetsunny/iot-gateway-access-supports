package cn.enncloud.iot.gateway.protocol.std.energy.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ModelDto {
    private static final long serialVersionUID = -8870504233243263383L;
    private String depict;
    private String parseMode;
    private String baudRate;
    private String checkBit;
    private String dataBit;
    private String stopBit;
    private String comNum;
    private String parseType;
    private List<LabelDto> busAttributes;
    private AlarmDto alarm;
    private String accessWay;
    private String byStation;
    private String orderCode;
    private String orderSign;
    private boolean status;
    private Long id;
    protected Long version;
    protected boolean deleted;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;
    private String createUser;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;
    private String updateUser;

    public ModelDto() {
    }

    public String getDepict() {
        return this.depict;
    }

    public String getParseMode() {
        return this.parseMode;
    }

    public String getBaudRate() {
        return this.baudRate;
    }

    public String getCheckBit() {
        return this.checkBit;
    }

    public String getDataBit() {
        return this.dataBit;
    }

    public String getStopBit() {
        return this.stopBit;
    }

    public String getComNum() {
        return this.comNum;
    }

    public String getParseType() {
        return this.parseType;
    }

    public List<LabelDto> getBusAttributes() {
        return this.busAttributes;
    }

    public AlarmDto getAlarm() {
        return this.alarm;
    }

    public String getAccessWay() {
        return this.accessWay;
    }

    public String getByStation() {
        return this.byStation;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public String getOrderSign() {
        return this.orderSign;
    }

    public boolean isStatus() {
        return this.status;
    }

    public Long getId() {
        return this.id;
    }

    public Long getVersion() {
        return this.version;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setDepict(final String depict) {
        this.depict = depict;
    }

    public void setParseMode(final String parseMode) {
        this.parseMode = parseMode;
    }

    public void setBaudRate(final String baudRate) {
        this.baudRate = baudRate;
    }

    public void setCheckBit(final String checkBit) {
        this.checkBit = checkBit;
    }

    public void setDataBit(final String dataBit) {
        this.dataBit = dataBit;
    }

    public void setStopBit(final String stopBit) {
        this.stopBit = stopBit;
    }

    public void setComNum(final String comNum) {
        this.comNum = comNum;
    }

    public void setParseType(final String parseType) {
        this.parseType = parseType;
    }

    public void setBusAttributes(final List<LabelDto> busAttributes) {
        this.busAttributes = busAttributes;
    }

    public void setAlarm(final AlarmDto alarm) {
        this.alarm = alarm;
    }

    public void setAccessWay(final String accessWay) {
        this.accessWay = accessWay;
    }

    public void setByStation(final String byStation) {
        this.byStation = byStation;
    }

    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    public void setOrderSign(final String orderSign) {
        this.orderSign = orderSign;
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateTime(final Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateUser(final String updateUser) {
        this.updateUser = updateUser;
    }

}
