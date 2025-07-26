package cn.enncloud.iot.gateway.protocol.std.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

@Getter
public enum TopicEnum {


    /** 设备端上报主题 **/
    EDGE_INFO_REPORT(Pattern.compile("/edge/.+/.+/info")),

    EDGE_REALTIME_DATA_REPORT(Pattern.compile("/edge/.+/.+/rtg")),

    EDGE_DATA_STATUS_REPORT(Pattern.compile("/edge/.+/.+/status")),

    EDGE_DATA_EVENT_REPORT(Pattern.compile("/edge/.+/.+/event")),

    EDGE_DATA_HISTORY_REPORT(Pattern.compile("/edge/.+/.+/history")),

    EDGE_DATA_HISTORY_CACK_REPORT(Pattern.compile("/edge/.+/.+/history/cack")),

    EDGE_DATA_NTP_REPORT(Pattern.compile("/edge/.+/.+/ntp/request")),

    EDGE_DATA_NTP_CACK_REPORT(Pattern.compile("/edge/.+/.+/ntp/set/ack")),

    EDGE_CMD_SET_CACK(Pattern.compile("/edge/.+/.+/cmd/set/cack")),

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
