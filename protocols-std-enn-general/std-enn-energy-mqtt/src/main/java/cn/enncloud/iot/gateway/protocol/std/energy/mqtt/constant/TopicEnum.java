package cn.enncloud.iot.gateway.protocol.std.energy.mqtt.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

@Getter
public enum TopicEnum {


    /** 设备端上报主题 **/
    EDGE_INFO_REPORT(Pattern.compile("/edge/single/.+/.+/info")),

    EDGE_REALTIME_DATA_REPORT(Pattern.compile("/edge/single/.+/.+/rtg")),

    EDGE_DATA_CALL_REPORT(Pattern.compile("/edge/single/.+/.+/call")),

    EDGE_CMD_RESPONSE(Pattern.compile("/edge/single/.+/.+/set")),

    EDGE_PARAM_UPDATE_REPORT(Pattern.compile("/edge/single/.+/.+/change "))


    /** 服务端下行主题 **/

    ;

    private final Pattern pattern;

    TopicEnum(Pattern pattern) {
        this.pattern = pattern;
    }

    public static Optional<TopicEnum> parse(String topic){
        return Arrays.stream(TopicEnum.values())
                .filter(e -> e.pattern.matcher(topic).matches())
                .findFirst();
    }

}
