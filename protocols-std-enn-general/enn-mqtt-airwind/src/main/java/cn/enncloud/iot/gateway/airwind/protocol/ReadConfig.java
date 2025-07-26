package cn.enncloud.iot.gateway.airwind.protocol;

import cn.enncloud.iot.gateway.airwind.dto.DeviceConfigDTO;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.text.csv.CsvReadConfig;
import cn.hutool.core.text.csv.CsvReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ReadConfig {


    private static volatile ConcurrentHashMap<String, DeviceConfigDTO> METRIC_MAP;

    private static volatile ConcurrentHashMap<String, DeviceConfigDTO> CMD_METRIC_MAP;


    private static ReadConfig readConfig;

    public static ReadConfig getReadConfig() {

        if (Objects.isNull(readConfig)) {
            synchronized (ReadConfig.class) {
                if (Objects.isNull(readConfig)) {
                    readConfig = new ReadConfig();
                }
            }
        }


        return readConfig;
    }

    public ConcurrentHashMap<String, DeviceConfigDTO> getCMD_METRIC_MAP() {

        if (Objects.isNull(CMD_METRIC_MAP)) {
            synchronized (ReadConfig.class) {
                if (Objects.isNull(CMD_METRIC_MAP)) {
                    CMD_METRIC_MAP = initDeviceConfig("Down");
                }
            }
        }


        return CMD_METRIC_MAP;
    }

    public ConcurrentHashMap<String, DeviceConfigDTO> getMETRIC_MAP() {

        if (Objects.isNull(METRIC_MAP)) {
            synchronized (ReadConfig.class) {
                if (Objects.isNull(METRIC_MAP)) {
                    METRIC_MAP = initDeviceConfig("up");
                }
            }
        }


        return METRIC_MAP;
    }

    public ConcurrentHashMap<String, DeviceConfigDTO> initDeviceConfig(String type) {

        ConcurrentHashMap<String, DeviceConfigDTO> dtoConcurrentHashMap = new ConcurrentHashMap<>();
        String csvFile = "deviceMetric_1.csv";
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        csvReadConfig.setContainsHeader(true); // 设置CSV文件包含表头
        CsvReader csvReader = new CsvReader(csvReadConfig);
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(csvFile);
        String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        List<DeviceConfigDTO> csvData = csvReader.read(read, DeviceConfigDTO.class);
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        csvData.forEach(row -> {
            if (type.equals("up")) {
                dtoConcurrentHashMap.put(row.getOrgMetric(), row);
            } else {
                dtoConcurrentHashMap.put(row.getProductCode() + row.getDeviceId() + row.getMetric(), row);
            }
        });

        return dtoConcurrentHashMap;
    }
}
