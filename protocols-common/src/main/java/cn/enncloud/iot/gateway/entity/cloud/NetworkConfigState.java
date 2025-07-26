package cn.enncloud.iot.gateway.entity.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum NetworkConfigState {
    enabled(1, "已启动"),
    paused(0, "已暂停"),
    disabled(-1, "已停止");

    private final Integer code;
    private final String text;

    public static NetworkConfigState convert(String value) {
        return Stream.of(values()).filter(v -> v.getName().equals(value)).findFirst().orElse(null);
    }

    public String getName() {
        return name();
    }
}

