package cn.enncloud.iot.gateway.protocol.std.energy.dto;

import cn.enncloud.iot.gateway.protocol.std.energy.enums.CommandStatusEnum;
import com.alibaba.fastjson.JSONArray;

public class CommandReceiptDTO {

    private Long cmdId;
    private String deviceId;
    private String cmdType;
    private CommandStatusEnum status;
    private JSONArray data;
    private String source;

    public Long getCmdId() {
        return cmdId;
    }

    public void setCmdId(Long cmdId) {
        this.cmdId = cmdId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public CommandStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommandStatusEnum status) {
        this.status = status;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
