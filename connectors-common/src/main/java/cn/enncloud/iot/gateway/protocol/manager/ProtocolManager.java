package cn.enncloud.iot.gateway.protocol.manager;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.loader.ProtocolInitializer;
import cn.enncloud.iot.gateway.protocol.supports.ProtocolActionListener;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * 协议实例管理组件
 */
public interface ProtocolManager {


    /**
     * 协议是否已支持
     *
     * @param id 协议名称
     * @return True 已支持 False 未支持
     */
    boolean isSupported(String id);


    /**
     * 获取协议
     *
     * @param id 协议名称
     * @return 协议实例
     */
    Protocol get(String id);


    /**
     * 获取所有加载协议
     *
     * @return 协议实例列表
     */
    Collection<Protocol> getAll();

    /**
     * 注册协议
     *
     * @param protocolConfig 协议配置
     * @return 协议实例
     */
    Protocol register(ProtocolConfig protocolConfig);


    /**
     *
     * @param id 协议ID
     * @param mainClass main方法所在class名称
     * @param path 协议包路径
     * @param params 协议参数
     * @param flag useless
     * @return 协议实例
     */
    Protocol register(String id, String mainClass, String path, Map<String, Object> params, boolean flag);


    /**
     * 注册协议
     *
     * @param protocolConfig 协议配置
     * @param executor 执行器
     * @param timeout 超时时间，毫秒
     * @return 协议实例
     */
    Protocol register(ProtocolConfig protocolConfig, Executor executor, long timeout);


    /**
     * 注册协议
     *
     * @param protocol 协议实例
     * @return 协议实例对象
     */
    Protocol register(Protocol protocol);

    /**
     * 注销协议
     */
    void deregister(String id);


    void addProtocolInitializer(String type, ProtocolInitializer initializer);
}
