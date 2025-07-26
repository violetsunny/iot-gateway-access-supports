package cn.enncloud.iot.gateway.protocol.loader.script;

import cn.enncloud.iot.gateway.config.connectors.ProtocolConfig;
import cn.enncloud.iot.gateway.context.DeviceContext;
import cn.enncloud.iot.gateway.protocol.Protocol;
import cn.enncloud.iot.gateway.protocol.enums.ProtocolTypeEnum;
import cn.enncloud.iot.gateway.protocol.loader.ProtocolInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Component
public class ScriptProtocolInitializer implements ProtocolInitializer {

    @Autowired
    private DeviceContext deviceContext;


    @Override
    public ProtocolTypeEnum type() {
        return ProtocolTypeEnum.SCRIPT;
    }

    @Override
    public Protocol init(ProtocolConfig protocolConfig) throws Exception {
        String scriptContent = null;
        // 从配置加载
        if(StringUtils.hasText(protocolConfig.getScript())){
            scriptContent = protocolConfig.getScript();
        }
        // 从文件加载
        if(scriptContent == null && StringUtils.hasText(protocolConfig.getPath())){
            String path = protocolConfig.getPath();
            if(isRemoteFile(path)){
                scriptContent = loadRemoteFile(path);
            }else{
                scriptContent = loadLocalFile(path);
            }
        }
        ScriptProtocol scriptProtocol = new ScriptProtocol(scriptContent);
        Map<String, Object> params = protocolConfig.getParams();
        if(params != null){
            scriptProtocol.setParams(params);
        }
        scriptProtocol.setDeviceContext(deviceContext);
        return scriptProtocol;
    }

    private boolean isRemoteFile(String path){
        return path.startsWith("http://") || path.startsWith("https://");
    }



    private String loadRemoteFile(String path) throws IOException {
        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null){
            sb.append(line).append("\n");
        }
        return sb.toString();
    }



    private String loadLocalFile(String file) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(file));
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
