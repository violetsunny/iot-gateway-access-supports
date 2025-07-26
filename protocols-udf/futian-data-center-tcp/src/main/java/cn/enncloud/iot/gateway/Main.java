package cn.enncloud.iot.gateway;

import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.datacenter.DataCenterTcpProtocol;
import cn.enncloud.iot.gateway.entity.Device;
import cn.enncloud.iot.gateway.entity.Product;
import cn.enncloud.iot.gateway.entity.cloud.ModbusPointMapping;
import cn.enncloud.iot.gateway.entity.tsl.ProductTsl;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;
import cn.enncloud.iot.gateway.message.enums.MessageType;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.netty.buffer.ByteBufUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        String salt = "12345";
        String s = MD5.create().setSalt(salt.getBytes()).digestHex("d6843f6dbbb544358cf991a411ffa08e");
        String s1 = MD5.create().setSalt(salt.getBytes()).digestHex("b78e39221d9e4bf3bba8a7ec2db7a483");
        String message = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<root>\n" +
                "  <common>\n" +
                "    <building_id>111</building_id>\n" +
                "    <gateway_id>1111</gateway_id>\n" +
                "    <type>report</type>\n" +
                "  </common>\n" +
                "  <data operation=\"report\">\n" +
                "    <sequence>\n" +
                "      <!-- 采集器向数据中心发送数据的序号 -->\n" +
                "    </sequence>\n" +
                "    <parse>\n" +
                "      <!-- \n" +
                "        yes: 向数据中心发送的数据经过采集器解析;\n" +
                "        no:  向数据中心发送的数据未经过采集器解析;\n" +
                "      -->\n" +
                "    </parse>\n" +
                "    <time>\n" +
                "      <!-- 数据采集时间 -->\n" +
                "    </time>\n" +
                "    <!-- \n" +
                "      计量装置信息， 一个或多个\n" +
                "      meter元素属性： \n" +
                "        id: 计量装置的数据采集功能编号\n" +
                "        conn: 计量装置诊断信息，取值 conn: 计量装置连接正常 disconn: 计量装置连接断开\n" +
                "    -->\n" +
                "      <!--\n" +
                "        计量装置的具体采集功能，一个或多个\n" +
                "        function元素属性：\n" +
                "          id: 计量装置的具体采集功能编号（1：电表表头码， 2：水表表头码，具体可配置）\n" +
                "          coding: 能耗数据分类/分项编号\n" +
                "          error: 该功能出现错误的状态码，192表示没有错误\n" +
                "      -->\n" +
                "<meter id=\"1\" conn=\"conn\">\n" +
                "            <function id=\"1\" coding=\"01000\" error=\"192\" sample_time=\"20120329093003\">3.800</function>\n" +
                "            <function id=\"101\">3.800</function>\n" +
                "            <function id=\"102\">1.190</function>\n" +
                "            <function id=\"103\">1.370</function>\n" +
                "            <function id=\"104\">1.670</function>\n" +
                "        </meter>\n" +
                "\n" +
                "    \n" +
                " \n" +
                "      <!--\n" +
                "        计量装置的具体采集功能，一个或多个\n" +
                "        function元素属性：\n" +
                "          id: 计量装置的具体采集功能编号（1：电表表头码， 2：水表表头码，具体可配置）\n" +
                "          coding: 能耗数据分类/分项编号\n" +
                "          error: 该功能出现错误的状态码，192表示没有错误\n" +
                "      -->\n" +
                "  \n" +
                "        <!-- 具体数据 -->\n" +
                "  </data>\n" +
                "</root>\n";

        String message1 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<root>\n" +
                "  <common>\n" +
                "    <building_id><!-- 楼栋编号 --></building_id>\n" +
                "    <gateway_id><!-- 采集器编号 --></gateway_id>\n" +
                "    <type>notify</type>\n" +
                "  </common>\n" +
                "  <heart_beat operation=\"notify\" />\n" +
                "</root>\n";

        String aa = "<root>\n" +
                "    <common>\n" +
                "        <building_id>11111111111</building_id>\n" +
                "        <gateway_id>00090025</gateway_id>\n" +
                "        <type>auto_history</type>\n" +
                "    </common>\n" +
                "    <supcon operation=\"auto_history\" />\n" +
                "</root>";

        String a = "{\"root\":{\"common\":{\"building_id\":\"0731\",\"gateway_id\":9999,\"type\":\"continuous\"},\"data\":{\"operation\":\"continuous\",\"sequence\":1,\"parser\":\"yes\",\"time\":20240508151500,\"total\":1,\"current\":1,\"meter\":[{\"id\":1,\"conn\":\"conn\",\"function\":[{\"id\":1,\"content\":0},{\"id\":4,\"content\":454},{\"id\":5,\"content\":591},{\"id\":6,\"content\":137}]},{\"id\":2,\"conn\":\"conn\",\"function\":[{\"id\":1,\"content\":0},{\"id\":4,\"content\":119},{\"id\":5,\"content\":3},{\"id\":6,\"content\":123}]},{\"id\":3,\"conn\":\"conn\",\"function\":[{\"id\":1,\"content\":0.539},{\"id\":4,\"content\":1165},{\"id\":5,\"content\":1451},{\"id\":6,\"content\":285}]},{\"id\":4,\"conn\":\"conn\",\"function\":[{\"id\":1,\"content\":0},{\"id\":4,\"content\":6995},{\"id\":5,\"content\":8060},{\"id\":6,\"content\":1065}]},{\"id\":5,\"conn\":\"conn\",\"function\":[{\"id\":1,\"content\":22116},{\"id\":2,\"content\":52851},{\"id\":3,\"content\":0.001},{\"id\":4,\"content\":0},{\"id\":5,\"content\":0},{\"id\":6,\"content\":177.500003},{\"id\":7,\"content\":177.200003},{\"id\":8,\"content\":176.500003},{\"id\":9,\"content\":0.026},{\"id\":10,\"content\":0.011},{\"id\":11,\"content\":0.923},{\"id\":12,\"content\":0.026},{\"id\":13,\"content\":0},{\"id\":14,\"content\":0},{\"id\":15,\"content\":0.011},{\"id\":16,\"content\":0},{\"id\":17,\"content\":0},{\"id\":18,\"content\":0.923},{\"id\":19,\"content\":1},{\"id\":20,\"content\":1}]}]}}}";

        String a2 ="{\"root\":{\"common\":{\"building_id\":11111111111,\"gateway_id\":\"053611080\",\"type\":\"report\"},\"data\":{\"operation\":\"report\",\"sequence\":339822,\"parse\":\"yes\",\"time\":20240523183000,\"meter\":[{\"id\":1006,\"conn\":\"conn\",\"function\":[{\"id\":1,\"coding\":\"01000\",\"error\":192,\"sample_time\":20240523183008,\"content\":13362.2},{\"id\":101,\"content\":13362.2},{\"id\":102,\"content\":0},{\"id\":103,\"content\":8187.3},{\"id\":104,\"content\":0},{\"id\":5,\"error\":192,\"sample_time\":20240523183000,\"content\":233.7},{\"id\":501,\"content\":233.7},{\"id\":502,\"content\":233.8},{\"id\":503,\"content\":232.7},{\"id\":6,\"error\":192,\"sample_time\":20240523183000,\"content\":1.43},{\"id\":601,\"content\":1.43},{\"id\":602,\"content\":1.42},{\"id\":603,\"content\":1.33},{\"id\":7,\"error\":192,\"sample_time\":20240523183000,\"content\":0.469},{\"id\":701,\"content\":0},{\"id\":702,\"content\":0},{\"id\":703,\"content\":0},{\"id\":704,\"content\":0.469},{\"id\":8,\"error\":192,\"sample_time\":20240523183000,\"content\":0.83},{\"id\":801,\"content\":0},{\"id\":802,\"content\":0},{\"id\":803,\"content\":0},{\"id\":804,\"content\":0.83},{\"id\":9,\"error\":192,\"sample_time\":20240523183000,\"content\":0.491},{\"id\":901,\"content\":0},{\"id\":902,\"content\":0},{\"id\":903,\"content\":0},{\"id\":904,\"content\":0.491}]},{\"id\":1007,\"conn\":\"conn\",\"function\":[{\"id\":1,\"coding\":\"01000\",\"error\":192,\"sample_time\":20240523183009,\"content\":14312.2},{\"id\":101,\"content\":14312.2},{\"id\":102,\"content\":0},{\"id\":103,\"content\":8731.9},{\"id\":104,\"content\":0},{\"id\":5,\"error\":192,\"sample_time\":20240523183000,\"content\":233.3},{\"id\":501,\"content\":233.3},{\"id\":502,\"content\":233.4},{\"id\":503,\"content\":232.3},{\"id\":6,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":601,\"content\":0},{\"id\":602,\"content\":0},{\"id\":603,\"content\":0},{\"id\":7,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":701,\"content\":0},{\"id\":702,\"content\":0},{\"id\":703,\"content\":0},{\"id\":704,\"content\":0},{\"id\":8,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":801,\"content\":0},{\"id\":802,\"content\":0},{\"id\":803,\"content\":0},{\"id\":804,\"content\":0},{\"id\":9,\"error\":192,\"sample_time\":20240523183000,\"content\":1},{\"id\":901,\"content\":0},{\"id\":902,\"content\":0},{\"id\":903,\"content\":0},{\"id\":904,\"content\":1}]},{\"id\":1008,\"conn\":\"conn\",\"function\":[{\"id\":1,\"coding\":\"01000\",\"error\":192,\"sample_time\":20240523183010,\"content\":10028.6},{\"id\":101,\"content\":10028.6},{\"id\":102,\"content\":0},{\"id\":103,\"content\":6252.2},{\"id\":104,\"content\":0},{\"id\":5,\"error\":192,\"sample_time\":20240523183000,\"content\":233.7},{\"id\":501,\"content\":233.7},{\"id\":502,\"content\":233.9},{\"id\":503,\"content\":232.8},{\"id\":6,\"error\":192,\"sample_time\":20240523183000,\"content\":2.07},{\"id\":601,\"content\":2.07},{\"id\":602,\"content\":2.02},{\"id\":603,\"content\":1.93},{\"id\":7,\"error\":192,\"sample_time\":20240523183000,\"content\":1.178},{\"id\":701,\"content\":0},{\"id\":702,\"content\":0},{\"id\":703,\"content\":0},{\"id\":704,\"content\":1.178},{\"id\":8,\"error\":192,\"sample_time\":20240523183000,\"content\":0.77},{\"id\":801,\"content\":0},{\"id\":802,\"content\":0},{\"id\":803,\"content\":0},{\"id\":804,\"content\":0.77},{\"id\":9,\"error\":192,\"sample_time\":20240523183000,\"content\":0.837},{\"id\":901,\"content\":0},{\"id\":902,\"content\":0},{\"id\":903,\"content\":0},{\"id\":904,\"content\":0.837}]},{\"id\":1009,\"conn\":\"conn\",\"function\":[{\"id\":1,\"coding\":\"01000\",\"error\":192,\"sample_time\":20240523183011,\"content\":10209.3},{\"id\":101,\"content\":10209.3},{\"id\":102,\"content\":0},{\"id\":103,\"content\":6250.7},{\"id\":104,\"content\":0},{\"id\":5,\"error\":192,\"sample_time\":20240523183000,\"content\":233.8},{\"id\":501,\"content\":233.8},{\"id\":502,\"content\":234},{\"id\":503,\"content\":233.1},{\"id\":6,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":601,\"content\":0},{\"id\":602,\"content\":0},{\"id\":603,\"content\":0},{\"id\":7,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":701,\"content\":0},{\"id\":702,\"content\":0},{\"id\":703,\"content\":0},{\"id\":704,\"content\":0},{\"id\":8,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":801,\"content\":0},{\"id\":802,\"content\":0},{\"id\":803,\"content\":0},{\"id\":804,\"content\":0},{\"id\":9,\"error\":192,\"sample_time\":20240523183000,\"content\":1},{\"id\":901,\"content\":0},{\"id\":902,\"content\":0},{\"id\":903,\"content\":0},{\"id\":904,\"content\":1}]},{\"id\":1010,\"conn\":\"conn\",\"function\":[{\"id\":1,\"coding\":\"01000\",\"error\":192,\"sample_time\":20240523183012,\"content\":3.8},{\"id\":101,\"content\":3.8},{\"id\":102,\"content\":0},{\"id\":103,\"content\":0},{\"id\":104,\"content\":1.1},{\"id\":5,\"error\":192,\"sample_time\":20240523183000,\"content\":233.7},{\"id\":501,\"content\":233.7},{\"id\":502,\"content\":233.7},{\"id\":503,\"content\":232.9},{\"id\":6,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":601,\"content\":0},{\"id\":602,\"content\":0},{\"id\":603,\"content\":0},{\"id\":7,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":701,\"content\":0},{\"id\":702,\"content\":0},{\"id\":703,\"content\":0},{\"id\":704,\"content\":0},{\"id\":8,\"error\":192,\"sample_time\":20240523183000,\"content\":0},{\"id\":801,\"content\":0},{\"id\":802,\"content\":0},{\"id\":803,\"content\":0},{\"id\":804,\"content\":0},{\"id\":9,\"error\":192,\"sample_time\":20240523183000,\"content\":1},{\"id\":901,\"content\":0},{\"id\":902,\"content\":0},{\"id\":903,\"content\":0},{\"id\":904,\"content\":1}]}]}}}";
        JSONObject jsonObject = JSONUtil.parseObj(a2);
        DataCenterTcpProtocol dataCenterTcpProtocol = new DataCenterTcpProtocol();

        String xml = dataCenterTcpProtocol.createXml(jsonObject);
        dataCenterTcpProtocol.setDeviceContext(new DeviceContext() {
            @Override
            public ProductTsl getTslByDeviceId(String deviceId) {
                return null;
            }

            @Override
            public ProductTsl getTslByProductId(String productId) {
                return null;
            }

            @Override
            public ProductTsl getTslByCode(String tslCode) {
                return null;
            }

            @Override
            public String getDeviceIdBySn(String projectId, String sn) {
                return sn;
            }

            @Override
            public boolean authDevice(String deviceId, String password) {
                return false;
            }

            @Override
            public Metric getLastDevcieMetric(String deviceId, String metric) {
                return null;
            }

            @Override
            public void storeMessage(Message message) {

            }

            @Override
            public List<Device> getSnByProductId(String productId) {
                return null;
            }

            @Override
            public List<String> getImeiByProductId(String productId) {
                return null;
            }

            @Override
            public List<String> getDeviceIdByProductId(String productId) {
                return null;
            }

            @Override
            public Product getProductByDeviceId(String deviceId) {
                return null;
            }

            @Override
            public String getSnByDeviceId(String deviceId) {
                return null;
            }

            @Override
            public String getDeviceIdByImei(String imei) {
                return null;
            }

            @Override
            public void updateImei(List<Device> sns) {

            }

            @Override
            public String registerDevice(Device sn) {
                return null;
            }

            @Override
            public String getProductProtocolBySn(String sn) {
                return null;
            }

            @Override
            public Map<String,String> modelRef(String pCode, String productId, Object modelRefObj) {
                return null;
            }

            @Override
            public String modelRefMetric(String orgMetric, Map<String,String> modelRef) {
                return null;
            }

            @Override
            public void putDeviceProtocol(String device, String protocol) {

            }

            @Override
            public boolean validSnBelongProduct(String sn, String productId) {
                return false;
            }

            @Override
            public List<ModbusPointMapping> getModbusPoint(String gatewayCode) {
                return Collections.emptyList();
            }
        });
        byte[] bytes = xml.getBytes(StandardCharsets.UTF_8);
        byte[] bytes1 = dataCenterTcpProtocol.zLibCompressBytes(bytes);
        String s2 = ByteBufUtil.hexDump(bytes1);
        System.out.println("请求压缩报文："+s2);

        List<? extends Message> messages = dataCenterTcpProtocol.decodeMulti(xml.getBytes(StandardCharsets.UTF_8));System.out.println("协议解析结果：" + JSONUtil.toJsonStr(messages));

        for (Message messagex : messages) {
            if (StringUtils.isNotBlank(messagex.getResponse())) {
                messagex.setMessageType(MessageType.DEVICE_REPORT_RSP);
                byte[] encode = dataCenterTcpProtocol.encode(messagex);
            }
        }

    }
}