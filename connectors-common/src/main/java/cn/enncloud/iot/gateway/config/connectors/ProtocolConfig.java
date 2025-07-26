package cn.enncloud.iot.gateway.config.connectors;


import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Map;

@Data
@ToString
public class ProtocolConfig {
    /**
     * 协议名称
     */
    String name;

    /**
     * Jar文件路径
     */
    String path;

    /**
     * cn.enncloud.iot.gateway.protocol.Protocol接口实现类
     */
    String mainClass;

    /**
     * 协议参数
     */
    Map<String, Object> params;


    /**
     * 协议类型 Jar 或者 Script, 默认 Jar
     * 如协议包类型为 JavaScript 脚本需显式配置为 type="script"
     */
    String type = "jar";

    /**
     * 脚本内容
     */
    String script;


    /**
     * 开始协议监听，监听编码，解码方法执行结果
     */
    boolean actionListenerEnabled = false;


    /**
     * 二进制报文log编码格式， hex 或 string
     */
    String binaryLogType = "string";
}
