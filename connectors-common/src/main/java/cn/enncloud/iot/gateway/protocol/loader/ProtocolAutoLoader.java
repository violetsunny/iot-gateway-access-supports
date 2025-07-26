package cn.enncloud.iot.gateway.protocol.loader;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.protocol.cache.ProtocolCache;
import cn.enncloud.iot.gateway.protocol.enums.ProtocolTypeEnum;
import cn.enncloud.iot.gateway.protocol.manager.ProtocolManager;
import cn.enncloud.iot.gateway.protocol.supports.RedisTopicRegistry;
import cn.enncloud.iot.gateway.service.RedisService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * 工程启动后自动加载已添加协议
 */
@Slf4j
@Component
public class ProtocolAutoLoader implements MessageListener, InitializingBean {

    public static final String PROTOCOL_TOPIC = "ennew_protocol_changed";

    @Autowired
    private ProtocolCache protocolCache;

    @Autowired
    private ProtocolManager protocolManager;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTopicRegistry redisTopicRegistry;


    public void load() throws Exception {
        new Thread(() -> {
            protocolCache.getAll()
                    .stream()
                    .map(obj -> (String) obj)
                    .map(this::transform)
                    .filter(Objects::nonNull)
                    .forEach(config -> {
                        if (log.isDebugEnabled()) {
                            log.debug("load cached protocol, {}", config);
                        }
                        try {
                            protocolManager.register(config);
                        } catch (Throwable e) {
                            log.error("协议加载失败", e);
                        }
                    });
        }).start();
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String topic = redisService.getTemplate().getStringSerializer().deserialize(pattern);
        if (PROTOCOL_TOPIC.equals(topic)) {
            // String jsonStr = redisService.getTemplate().getStringSerializer().deserialize(message.getBody());
            String jsonStr = (String) redisService.getTemplate().getValueSerializer().deserialize(message.getBody());
            log.info("receive protocol change notification, {}", jsonStr);
            ProtocolConfig config = transform(jsonStr);
            protocolManager.register(config);
        }
    }


    private ProtocolConfig transform(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String type = jsonObject.getString("provider");
        if (!"script".equals(type) && !"jar".equals(type)) {
            return null;
        }
        String id = jsonObject.getString("id");
        if (id == null) {
            log.warn("pushed protocolId is null, {}", json);
            return null;
        }

        ProtocolConfig config = new ProtocolConfig();
        if("script".equals(type)){
            String script = Optional.ofNullable(jsonObject.getJSONObject("configuration"))
                    .map(obj -> obj.getString("script"))
                    .orElse(null);
            if (!StringUtils.hasText(script)) {
                log.warn("script is blank, {}", json);
                return null;
            }

            config.setScript(script);
            config.setName(id);
            config.setType(ProtocolTypeEnum.SCRIPT.getName());
        }
        if("jar".equals(type)){
            String mainClass = Optional.ofNullable(jsonObject.getJSONObject("configuration"))
                    .map(obj -> obj.getString("provider"))
                    .orElse(null);
            if (!StringUtils.hasText(mainClass)) {
                log.warn("mainClass is blank, {}", json);
                return null;
            }

            String path = Optional.ofNullable(jsonObject.getJSONObject("configuration"))
                    .map(obj -> obj.getString("location"))
                    .orElse(null);
            if (!StringUtils.hasText(path)) {
                log.warn("path is blank, {}", json);
                return null;
            }

            config.setMainClass(mainClass);
            config.setPath(path);
            config.setName(id);
            config.setType(ProtocolTypeEnum.JAR.getName());
        }

        return config;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        redisTopicRegistry.register(this, new PatternTopic(PROTOCOL_TOPIC));
    }
}
