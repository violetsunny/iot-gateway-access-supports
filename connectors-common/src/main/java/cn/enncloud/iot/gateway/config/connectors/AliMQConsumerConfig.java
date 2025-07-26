package cn.enncloud.iot.gateway.config.connectors;

import lombok.Data;

import java.util.List;

/**
 * ali RocketMQ配置
 */
@Data
public class AliMQConsumerConfig {

    private String groupId;

    private String accessKey;

    private String secretKey;

    private String nameSevAddr;

    private String suspendTimeMillis;

    private String maxReconsumeTimes;

    private List<TopicConfiguration> topics;

    @Data
    public static class TopicConfiguration {

        private String topic;

        private String tag;

        private String description;

        private ProtocolConfig protocol;

    }

}
