package cn.enncloud.iot.gateway.entity.cloud;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: alec
 * Description:
 * @date: 下午3:35 2023/5/25
 */
@Getter
@AllArgsConstructor
public enum CloudDockingTypeEnum {

    /**
     * 请求的类型
     * */

    AUTH("Auth"),
    PULL_DATA("PullData"),
    SEND_CMD("SendCmd"),

    ;

    private final String code;


    @Getter
    @AllArgsConstructor
    public enum RequestType {

        FORM("form"),
        JSON("json"),
        ;
        private final String code;
    }

    @Getter
    @AllArgsConstructor
    public enum RequestMethod {

        GET("GET"),
        POST("POST"),
        ;
        private final String code;
    }

    @Getter
    @AllArgsConstructor
    public enum CloudDockingParamsType {

        /**
         * 请求参数的类型
         * */
        HEADER("header"),
        //@RequestParam:/data?code=${code}
        PARAMS("params"),
        //@PathVariable:/${code}/data
        PATH("path"),
        //JSON
        BODY("body"),

        ;

        private final String code;
    }

    @Getter
    @AllArgsConstructor
    @Deprecated
    public enum ExpireType {

        REF("REF"),
        CON("CON"),
        ;
        private final String code;
    }

    @Getter
    @AllArgsConstructor
    public enum Updown {
        //上行
        UP("up"),
        //下行
        DOWN("down"),
        ;
        private final String code;
    }

    @Getter
    @AllArgsConstructor
    public enum Model {
        //推送
        PUSH("push"),
        //拉取
        PULL("pull"),
        ;
        private final String code;
    }
}
