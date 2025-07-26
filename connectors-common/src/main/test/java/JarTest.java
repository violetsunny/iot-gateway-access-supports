import cn.enncloud.iot.gateway.exception.DecodeMessageException;

public class JarTest {


    public static void main(String[] args) throws DecodeMessageException {
//        ProtocolSupportDefinition definition = new ProtocolSupportDefinition();
//        definition.setId("111");
//        definition.setName("test");
//        definition.setProvider("jar");
//
////        String config = "{\n" +
////                "  \"provider\": \"com.ennewiot.gateway.protocol.NbAlarmProtocolProvider\",\n" +
////                "  \"location\": \"D:/enn/iot-gateway-new/protocols-std-enn-general/ctwing-industrialalarm-nb/target/ctwing-industrialalarm-nb.jar\"\n" +
////                " \n" +
////                "}";
//        String config = "{\n" +
//                "  \"provider\": \"com.ennewiot.gateway.protocol.NbAlarmDevMessageCodec\",\n" +
//                "  \"location\": \"D:/enn/iot-gateway-new/protocols-std-enn-general/ctwing-industrialalarm-nb/target/ctwing-industrialalarm-nb.jar\"\n" +
//                " \n" +
//                "}";
//
////        String config = "{\"provider\":\"com.ennewiot.gateway.protocol.NbAlarmProtocolProvider\",\"location\":\"http://minio.ennewiot.com:9000/protocol-prod/20231213fe319e1f546e42a5bda8653097ad9535.jar\"}";
//        definition.setConfiguration(JSONObject.parseObject(config));
//
//
//        SpringProtocolSupportLoader springProtocolSupportLoader = new SpringProtocolSupportLoader();
//        springProtocolSupportLoader.register(new JarProtocolSupportLoader());
//        ProtocolSupport protocolSupport = springProtocolSupportLoader.load(definition);
//
//        String input = "{\"IMEI\":\"862651061441405\",\"IMSI\":\"undefined\",\"assocAssetId\":\"\",\"deviceId\":\"517aa973319e44b982600d649239c0cf\",\"deviceType\":\"\",\"messageType\":\"dataReport\",\"payload\":{\"APPdata\":\"ZwEFATAFIWFEFAUBEhAA67FBLMPdbk1efQkx8+h495mE7Q==\"},\"productId\":\"17004655\",\"protocol\":\"lwm2m\",\"serviceId\":\"\",\"tenantId\":\"2000102221\",\"timestamp\":1702452300310,\"topic\":\"v1/up/ad\",\"upDataSN\":-1,\"upPacketSN\":-1}";
//
//
//        JSONObject jsonObject = JSONObject.parseObject(input);
//
//        MetricReportRequest message = (MetricReportRequest) protocolSupport.getMessageCodec(definition.getId()).decode(JSONObject.toJSONBytes(jsonObject));
//
//        System.out.println(message);
    }
}
