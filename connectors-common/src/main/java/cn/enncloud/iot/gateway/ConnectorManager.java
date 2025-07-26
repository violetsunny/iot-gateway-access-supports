package cn.enncloud.iot.gateway;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanyilong@enn.cn
 */
@Data
@Component
public class ConnectorManager {

    List<Connector> connectors = new ArrayList<>();

    public void addConnector(Connector connector){
        connectors.add(connector);
    }

}
