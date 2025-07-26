package cn.enncloud.iot.gateway.protocol.supports;

import cn.enncloud.iot.gateway.message.Message;

import java.util.List;

public abstract class ProtocolActionListener {


    protected abstract void onException(Throwable throwable);



    protected abstract void afterDecode(String binaryType, byte[] bytes, List<? extends Message> messages);


    protected abstract void afterEncode(String binaryType, List<? extends Message> messages, byte[] bytes);

}
