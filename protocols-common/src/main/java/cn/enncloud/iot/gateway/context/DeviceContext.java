package cn.enncloud.iot.gateway.context;

import cn.enncloud.iot.gateway.entity.Device;
import cn.enncloud.iot.gateway.entity.Product;
import cn.enncloud.iot.gateway.entity.cloud.ModbusPointMapping;
import cn.enncloud.iot.gateway.entity.tsl.ProductTsl;
import cn.enncloud.iot.gateway.message.Message;
import cn.enncloud.iot.gateway.message.Metric;

import java.util.List;
import java.util.Map;

public interface DeviceContext {

    ProductTsl getTslByDeviceId(String deviceId);

    ProductTsl getTslByProductId(String productId);

    ProductTsl getTslByCode(String tslCode);

    String getDeviceIdBySn(String projectId, String sn);

    boolean authDevice(String deviceId, String password);

    Metric getLastDevcieMetric(String deviceId, String metric);

    void storeMessage(Message message);

    List<Device> getSnByProductId(String productId);

    List<String> getImeiByProductId(String productId);

    List<String> getDeviceIdByProductId(String productId);

    Product getProductByDeviceId(String deviceId);

    String getSnByDeviceId(String deviceId);

    String getDeviceIdByImei(String imei);

    void updateImei(List<Device> sns);

    String registerDevice(Device sn);

    String getProductProtocolBySn(String sn);

    Map<String,String> modelRef(String pCode, String productId,Object modelRefObj);

    String modelRefMetric(String orgMetric, Map<String,String> modelRef);

    void putDeviceProtocol(String device, String protocol);

    boolean validSnBelongProduct(String sn,String productId);

    List<ModbusPointMapping> getModbusPoint(String gatewayCode);
}