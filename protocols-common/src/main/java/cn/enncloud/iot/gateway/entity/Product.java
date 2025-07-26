package cn.enncloud.iot.gateway.entity;

import cn.enncloud.iot.gateway.protocol.Protocol;
import lombok.Data;

@Data
public class Product {
    String productId;
    String upProtocol;
    String downProtocol;
    ConnectorType connectorType;
}
