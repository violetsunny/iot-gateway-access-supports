package cn.enncloud.iot.gateway.protocol.std.energy.msg.report;

import cn.enncloud.iot.gateway.protocol.std.energy.bean.CommonBackData;
import cn.enncloud.iot.gateway.protocol.std.energy.dto.CommandReceiptDTO;
import cn.enncloud.iot.gateway.protocol.std.energy.msg.base.DataPacket;
import cn.enncloud.iot.gateway.protocol.std.energy.utils.IacPortalApiUtil;
import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;


/**
 * @author DongLi
 */
@Slf4j
@Data
public class SecretReportMsg extends DataPacket {
    /**
     * 秘钥是否接收成功
     * 00 成功 01 失败
     */
    private CommandReceiptDTO commandBack;

    private Boolean isFalse;

    public SecretReportMsg(ByteBuf payload) {
        super(payload);
    }

    @Override
    public void parseBody() {
        ByteBuf bb =  this.payload;
        setCommandBack(new CommandReceiptDTO());
        commandBack.setDeviceId(this.getHeader().getDeviceId());
        commandBack.setCmdType(this.getHeader().getCmdType());
        isFalse = bb.readBoolean();
        try {
            commandBack.setData(IacPortalApiUtil.convertCmdBackMapToJson(PropertyUtils.describe(new CommonBackData(bb.readBoolean()))));
        } catch (Exception e) {
            log.error("解析指令回执错误:{}",e.getMessage());
        }
    }
}
