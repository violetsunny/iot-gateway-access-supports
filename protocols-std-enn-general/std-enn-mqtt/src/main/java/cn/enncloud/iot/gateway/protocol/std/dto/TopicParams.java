/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.protocol.std.dto;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kanglele
 * @version $Id: TopicParams, v 0.1 2024/4/17 18:10 kanglele Exp $
 */
@Data
public class TopicParams {

    public TopicParams(String topic) {
        this.topic = topic;
        String[] strings = topic.split("/");
        if(strings.length >= 5){
            this.pKey = strings[3];
            this.sn = strings[4];
        }
    }
    String topic;
    String pKey;
    String sn;

    private static String upType(String topic){
        // 定义正则表达式，这里我们使用".*/"来匹配任意字符直到最后一个斜杠"/"
        // 然后使用"(.+)$"来捕获斜杠后面直到字符串末尾的部分
        String regex = ".*/(.+)$";
        // 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);
        // 创建Matcher对象
        Matcher matcher = pattern.matcher(topic);
        // 查找匹配的部分
        if (matcher.find()) {
            // 输出捕获的组，即我们想要提取的部分
            return matcher.group(1);
        }
        return "";
    }
}
