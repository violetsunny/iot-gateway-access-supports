package cn.enncloud.iot.gateway.protocol.std.energy.bean;

import cn.enncloud.iot.gateway.protocol.std.energy.utils.HexUtils;
import lombok.Data;

import java.nio.ByteOrder;

/**
 * @Author: DongLi
 * @Date: 2021/12/13 16:20
 * @Description: 读取上报周期
 */
@Data
public class ReadReportingCycleDTO {
    /**
     * 上报方式
     */
    private String reportType;
    /**
     * 定时上报日次数
     */
    private Integer reportingTimes;
    /**
     * 定时上报时间 BCD 以-组装 一共12组
     */
    private String reportTimeStr;
    /**
     * 间隔上报的间隔时间
     */
    private Integer intervalReportingTime;
    /**
     * 间隔上报首次上报时间
     */
    private String intervalReportingFirstTime;
    /**
     * 采集的间隔时间
     */
    private Integer collectionInterval;

    public ReadReportingCycleDTO parseBody(String payload){
        String reportType = payload.substring(0, 2);
        String reportingTimesHex = payload.substring(2, 4);
        String times = payload.substring(4,52);
        String intervalReportingTimeHex = payload.substring(52, 56);
        String intervalReportingFirstTime = payload.substring(56,60);
        String collectionIntervalHex = payload.substring(60,64);
        this.setReportType(reportType);
        this.setReportingTimes(HexUtils.hex2int(reportingTimesHex,ByteOrder.LITTLE_ENDIAN));
        this.setReportTimeStr(times);
        this.setIntervalReportingTime(HexUtils.hex2int(intervalReportingTimeHex,ByteOrder.LITTLE_ENDIAN));
        this.setIntervalReportingFirstTime(intervalReportingFirstTime);
        this.setCollectionInterval(HexUtils.hex2int(collectionIntervalHex,ByteOrder.LITTLE_ENDIAN));
        return this;
    }
}