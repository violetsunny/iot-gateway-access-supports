package cn.enncloud.iot.gateway.protocol.loader.jar;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.exception.BizException;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.enums.ProtocolTypeEnum;
import cn.enncloud.iot.gateway.protocol.loader.ProtocolInitializer;
import cn.hutool.json.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class JarProtocolInitializer implements ProtocolInitializer {

    /**
     * URLConnection 连接默认超时时间
     */
    private static final int DEFAULT_URL_CONNECTION_CONNECT_TIMEOUT = 10000;

    /**
     * URLConnection 读操作默认超时时间
     */
    private static final int DEFAULT_URL_CONNECTION_READ_TIMEOUT = 10000;

    ProtocolClassLoader loader;

    private final Map<String, ProtocolClassLoader> protocolLoaders = new ConcurrentHashMap<>();

    @Override
    public ProtocolTypeEnum type() {
        return ProtocolTypeEnum.JAR;
    }
    @Override
    @SneakyThrows
    public Protocol init(ProtocolConfig protocolConfig) {
        String protocolName = protocolConfig.getName();
        String location = Optional
                .ofNullable(protocolConfig.getPath())
                .map(String::valueOf)
                .orElseThrow(() -> new BizException("configuration中没有location信息"));
        URL url;
        if (!location.contains("://")) {
            //本地文件
            File file = new File(location);
            if (file.exists()) {
                url = file.toURI().toURL();
            } else {
                throw new BizException("File does not exist:" + location);
            }
        } else {
            try {
                url = new URL("jar:" + location + "!/");
                URLConnection urlConnection = url.openConnection();
                urlConnection.setConnectTimeout(DEFAULT_URL_CONNECTION_CONNECT_TIMEOUT);
                urlConnection.setReadTimeout(DEFAULT_URL_CONNECTION_READ_TIMEOUT);
                urlConnection.connect();
            } catch (Exception e) {
                throw new BizException("url File does not exist:" + location,e);
            }
        }

        URL fLocation = url;

        loader = protocolLoaders.compute(protocolName, (key, old) -> {
            if (null != old) {
                try {
                    closeLoader(old);
                } catch (Exception ignore) {

                }
            }
            return createClassLoader(fLocation);
        });
//        ProtocolSupportProvider supportProvider;
        Protocol protocol;
        log.debug("load protocol support from : {}", location);
        String provider = Optional
                .ofNullable(protocolConfig.getMainClass())
                .map(String::valueOf)
                .map(String::trim)
                .orElse(null);
        if (provider != null) {
            //直接从classLoad获取,防止冲突
            @SuppressWarnings("all")
            Class<Protocol> providerType = (Class) loader.loadSelfClass(provider);
            protocol = providerType.getDeclaredConstructor().newInstance();
        } else {
            //没有指定provider，则通过SPI来获取
            protocol = ServiceLoader.load(Protocol.class, loader).iterator().next();
        }
        JSONObject params = Optional
                .ofNullable(protocolConfig.getParams())
                .map(JSONObject::new).orElse(null);
        if (Objects.nonNull(params)) {
            protocol.setParams(params);
        }
        return protocol;
    }


    protected ProtocolClassLoader createClassLoader(URL location) {
        return new ProtocolClassLoader(new URL[]{location}, this.getClass().getClassLoader());
    }

    @SneakyThrows
    protected void closeLoader(ProtocolClassLoader loader) {
        loader.close();
    }
}
