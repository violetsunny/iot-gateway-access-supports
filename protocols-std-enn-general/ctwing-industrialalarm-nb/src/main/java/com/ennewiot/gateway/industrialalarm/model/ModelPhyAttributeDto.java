package com.ennewiot.gateway.industrialalarm.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ModelPhyAttributeDto {
    private String depict;
    private String shortName;
    private ModelDto model;
    private DataDictionaryDto dataType;
    private int index;
    private DataDictionaryDto unit;
    private DataDictionaryDto protocolDataType;
    private int byteLen;
    private boolean controlFlag;
    private int funCode;
    private String byteOrder;
    private String registerSite;
    private String maskCode;
    private int frequency;
    private String attrGroup;
    private String targetPath;
    private String anylinkAddress;
    private Integer channel;
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

    public ModelPhyAttributeDto() {
    }

    public String getDepict() {
        return this.depict;
    }

    public String getShortName() {
        return this.shortName;
    }

    public ModelDto getModel() {
        return this.model;
    }

    public DataDictionaryDto getDataType() {
        return this.dataType;
    }

    public int getIndex() {
        return this.index;
    }

    public DataDictionaryDto getUnit() {
        return this.unit;
    }

    public DataDictionaryDto getProtocolDataType() {
        return this.protocolDataType;
    }

    public int getByteLen() {
        return this.byteLen;
    }

    public boolean isControlFlag() {
        return this.controlFlag;
    }

    public int getFunCode() {
        return this.funCode;
    }

    public String getByteOrder() {
        return this.byteOrder;
    }

    public String getRegisterSite() {
        return this.registerSite;
    }

    public String getMaskCode() {
        return this.maskCode;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String getAttrGroup() {
        return this.attrGroup;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getAnylinkAddress() {
        return this.anylinkAddress;
    }

    public Integer getChannel() {
        return this.channel;
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

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public void setModel(final ModelDto model) {
        this.model = model;
    }

    public void setDataType(final DataDictionaryDto dataType) {
        this.dataType = dataType;
    }

    public void setIndex(final int index) {
        this.index = index;
    }

    public void setUnit(final DataDictionaryDto unit) {
        this.unit = unit;
    }

    public void setProtocolDataType(final DataDictionaryDto protocolDataType) {
        this.protocolDataType = protocolDataType;
    }

    public void setByteLen(final int byteLen) {
        this.byteLen = byteLen;
    }

    public void setControlFlag(final boolean controlFlag) {
        this.controlFlag = controlFlag;
    }

    public void setFunCode(final int funCode) {
        this.funCode = funCode;
    }

    public void setByteOrder(final String byteOrder) {
        this.byteOrder = byteOrder;
    }

    public void setRegisterSite(final String registerSite) {
        this.registerSite = registerSite;
    }

    public void setMaskCode(final String maskCode) {
        this.maskCode = maskCode;
    }

    public void setFrequency(final int frequency) {
        this.frequency = frequency;
    }

    public void setAttrGroup(final String attrGroup) {
        this.attrGroup = attrGroup;
    }

    public void setTargetPath(final String targetPath) {
        this.targetPath = targetPath;
    }

    public void setAnylinkAddress(final String anylinkAddress) {
        this.anylinkAddress = anylinkAddress;
    }

    public void setChannel(final Integer channel) {
        this.channel = channel;
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


    protected boolean canEqual(final Object other) {
        return other instanceof ModelPhyAttributeDto;
    }


    public String toString() {
        return "ModelPhyAttributeDto(depict=" + this.getDepict() + ", shortName=" + this.getShortName() + ", model=" + this.getModel() + ", dataType=" + this.getDataType() + ", index=" + this.getIndex() + ", unit=" + this.getUnit() + ", protocolDataType=" + this.getProtocolDataType() + ", byteLen=" + this.getByteLen() + ", controlFlag=" + this.isControlFlag() + ", funCode=" + this.getFunCode() + ", byteOrder=" + this.getByteOrder() + ", registerSite=" + this.getRegisterSite() + ", maskCode=" + this.getMaskCode() + ", frequency=" + this.getFrequency() + ", attrGroup=" + this.getAttrGroup() + ", targetPath=" + this.getTargetPath() + ", anylinkAddress=" + this.getAnylinkAddress() + ", channel=" + this.getChannel() + ", id=" + this.getId() + ", version=" + this.getVersion() + ", deleted=" + this.isDeleted() + ", createTime=" + this.getCreateTime() + ", createUser=" + this.getCreateUser() + ", updateTime=" + this.getUpdateTime() + ", updateUser=" + this.getUpdateUser() + ")";
    }
}
