package cn.enncloud.iot.gateway.entity.cloud;


import lombok.Data;

@Data
public class ModbusPointMapping {

    /**
     * 点位id
     */
    private Long pointId;

    /**
     * 读写标识（r-读，w-写）
     */
    private String rw;


    private String deviceId;


    private String metric;


    private String productCode;

    private String productId;

    /**
     * 站点地址
     */
    private Integer slaveAddr;
    /**
     * 功能码，冗余存储，支持单元测试用例
     */
    private Integer functionCode;
    /**
     * 寄存器地址，从0开始
     */
    private Integer registerAddress;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 字节序
     */
    private String byteOrder;

    public ModbusPointMapping() {
        super();
    }

    public ModbusPointMapping(long pointId, int slaveAddr, int functionCode, int registerAddress, String dataType, String byteOrder) {
        this.pointId = pointId;
        this.slaveAddr = slaveAddr;
        this.functionCode = functionCode;
        this.registerAddress = registerAddress;
        this.dataType = dataType;
        this.byteOrder = byteOrder;
    }
}
