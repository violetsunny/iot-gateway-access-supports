package cn.enncloud.iot.gateway.config;

import cn.enncloud.iot.gateway.config.connectors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties({ConnectorProperties.class, CoapConfig.class, CtwingMqConfig.class, AliMqConfig.class, DTUConfig.class, HttpConfig.class, HttpRequestConfig.class
        , MqttConfig.class, TcpConfig.class, UdpConfig.class,ModbusConfig.class, SnmpConfig.class, OpcuaConfig.class, OpcuaAsyncioConfig.class,BacnetConfig.class})
@Slf4j
public class Configuration {

}