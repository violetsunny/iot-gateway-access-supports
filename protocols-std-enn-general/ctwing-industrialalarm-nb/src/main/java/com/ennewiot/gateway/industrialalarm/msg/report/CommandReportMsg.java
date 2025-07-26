package com.ennewiot.gateway.industrialalarm.msg.report;


import com.alibaba.fastjson.JSONArray;
import com.ennewiot.gateway.industrialalarm.bean.CommonBackData;
import com.ennewiot.gateway.industrialalarm.bean.ReadAlarmValue;
import com.ennewiot.gateway.industrialalarm.bean.ReadICCID;
import com.ennewiot.gateway.industrialalarm.bean.ReadReportingCycleDTO;
import com.ennewiot.gateway.industrialalarm.dto.CommandReceiptDTO;
import com.ennewiot.gateway.industrialalarm.enums.CommandStatusEnum;
import com.ennewiot.gateway.industrialalarm.utils.IacPortalApiUtil;
import com.ennewiot.gateway.industrialalarm.msg.base.DataPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;


/**
 * @author DongLi
 */
@Slf4j
@EqualsAndHashCode(callSuper = true)
@Data
public class CommandReportMsg extends DataPacket {

    private CommandReceiptDTO commandBack;

    public CommandReportMsg(ByteBuf payload) {
        super(payload);
    }

    @Override
    public void parseBody() {
        ByteBuf bb = this.payload;
        setCommandBack(new CommandReceiptDTO());
        commandBack.setDeviceId(this.getHeader().getDeviceId());
        commandBack.setCmdType(this.getHeader().getCmdType());
        JSONArray dataArray = null;
        String payloadHex;
        try {
            switch (this.getHeader().getCmdType()) {
                case "09H":
                    String ICCID = readString(20);
                    dataArray = IacPortalApiUtil.convertCmdBackMapToJson(Objects.requireNonNull(obj2Map(new ReadICCID(ICCID))));
                    commandBack.setStatus(CommandStatusEnum.EXE_SUCCESS);
                    break;
                case "4AH":
                    payloadHex = ByteBufUtil.hexDump(readBytes(this.header.getLength()));
                    dataArray = IacPortalApiUtil.convertCmdBackMapToJson(Objects.requireNonNull(obj2Map(new ReadReportingCycleDTO().parseBody(payloadHex))));
                    commandBack.setStatus(CommandStatusEnum.EXE_SUCCESS);
                    break;
                case "6AH":
                    payloadHex = ByteBufUtil.hexDump(readBytes(this.header.getLength()));
                    dataArray = IacPortalApiUtil.convertCmdBackMapToJson(Objects.requireNonNull(obj2Map(new ReadAlarmValue().parseBody(payloadHex))));
                    commandBack.setStatus(CommandStatusEnum.EXE_SUCCESS);
                    break;
                default:
                    boolean isFalse = bb.readBoolean();
                    dataArray = IacPortalApiUtil.convertCmdBackMapToJson(obj2Map(new CommonBackData(isFalse)));
                    commandBack.setStatus(isFalse ? CommandStatusEnum.EXE_FAIL : CommandStatusEnum.EXE_SUCCESS);
            }
        } catch (Exception e) {
            commandBack.setStatus(CommandStatusEnum.EXE_FAIL);
            log.error("解析指令回执错误:{}",e.getMessage());
        }
        commandBack.setData(dataArray);
    }

//
    public static Map<String, Object> obj2Map(Object obj) {
        try {
            Map<String, Object> returnMap = PropertyUtils.describe(obj);
            returnMap.remove("class");
            return returnMap;
        } catch (Exception e) {
            log.error("解析指令回执错误:{}",e.getMessage());
        }
        return Collections.emptyMap();
    }

}
