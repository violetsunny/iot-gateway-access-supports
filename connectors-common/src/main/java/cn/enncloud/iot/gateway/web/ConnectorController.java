package cn.enncloud.iot.gateway.web;

import cn.enncloud.iot.gateway.Connector;
import cn.enncloud.iot.gateway.ConnectorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gateway")
public class ConnectorController {

    @Autowired
    ConnectorManager connectorManager;

    @GetMapping("/connectors")
    public String connectors() {
        return connectorManager.getConnectors().toString();
    }

    @GetMapping("/connectors/stats")
    public List<Map<String, Object>> getStats() {
        List<Connector> connectors = connectorManager.getConnectors();
        List<Map<String, Object>> mapList = new ArrayList<>();
        connectors.forEach(connector -> {
            mapList.add(connector.getStatus());
        });
        return mapList;
    }

}
