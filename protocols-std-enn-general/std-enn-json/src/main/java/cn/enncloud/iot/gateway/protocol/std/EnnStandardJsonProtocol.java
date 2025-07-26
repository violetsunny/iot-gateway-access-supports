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
import java.util.Collections;
import java.util.List;

@Slf4j
public class EnnStandardJsonProtocol extends AbstractProtocol {

    @Override
    public String getId() {
        return "enn-standard-json";
    }

    @Override
    public String getName() {
        return "enn-standard-json";
    }

    @Override
    public Message decode(byte[] messageBytes, Object... params) throws DecodeMessageException {
        return null;
    }

    @Override
    public List<? extends Message> decodeMulti(byte[] messageBytes, Object... params) throws DecodeMessageException {

        return null;
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
