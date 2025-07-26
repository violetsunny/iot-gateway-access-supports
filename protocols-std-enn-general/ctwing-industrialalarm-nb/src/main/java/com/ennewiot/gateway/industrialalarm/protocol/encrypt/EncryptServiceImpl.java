package com.ennewiot.gateway.industrialalarm.protocol.encrypt;


import com.ennewiot.gateway.industrialalarm.utils.AESUtils;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author DongLi
 */
//@Service
@Slf4j
public class EncryptServiceImpl implements EncryptService {

    //    @Resource
//    private StandardRedisTemplate redis;
//    @Resource
//    private FeignIotStandardCommandApi feignIotStandardCommandApi;
//    @Resource
//    private FeignDevStandardCacheService feignDevStandardCacheService;
    //固定密钥
    @Value("${application.encrypt.key:86CAD727DEB54263B73960AA79C5D9B7}")
    private static final String key = "86CAD727DEB54263B73960AA79C5D9B7";

    /**
     * 使用表号为meterCode的对应key值对data加密
     *
     * @param meterCode 表号
     * @param keyNum    密钥号1或（2-9随机数）
     * @param data      要加密的数据
     * @return 加密后的数据
     */
    @Override
    public String encrypt(String meterCode, int keyNum, String data) throws Exception {
        String key = getKeyGPRS(meterCode, keyNum);
        if (key == null) {
            throw new Exception("密钥信息不存在!");
        }
        return AESUtils.encrypt(data, key);
    }

    /**
     * 使用表号为meterCode的对应key值对data加密
     *
     * @param meterCode 表号
     * @param keyNum    密钥号1或（2-9随机数）
     * @param data      要加密的数据
     * @return 加密后的数据
     */
    @Override
    public void encrypt(String meterCode, int keyNum, ByteBuf data) throws Exception {
        String key = getKeyGPRS(meterCode, keyNum);
        if (key == null) {
            throw new Exception("密钥信息不存在!");
        }
        AESUtils.encrypt(data, key);
    }

    /**
     * 使用表号为meterCode的对应key值对data解密
     *
     * @param meterCode 表号
     * @param keyNum    密钥号1或（2-9随机数）
     * @param data      要解密的数据
     * @return 解密后的数据
     */
    @Override
    public String decrypt(String meterCode, int keyNum, String data) throws Exception {
        String key = getKeyGPRS(meterCode, keyNum);
        if (key == null) {
            throw new Exception("密钥信息不存在!");
        }
        return AESUtils.decrypt(data, key);
    }

    /**
     * 使用表号为meterCode的对应key值对data解密
     *
     * @param meterCode 表号
     * @param keyNum    密钥号1或（2-9随机数）
     * @return 解密后的数据
     */
    @Override
    public void decrypt(String meterCode, int keyNum, ByteBuf buf) throws Exception {
        String key = getKeyGPRS(meterCode, keyNum);
        if (key == null) {
            throw new Exception("密钥信息不存在!");
        }
        AESUtils.decrypt(buf, key);
    }

    private String getKeyGPRS(String meterCode, int keyNum) throws Exception {
        //固定密钥
        if (keyNum == 1) {
            return key;
        }
        return key;
//        String key = (String) redis.getKey(meterCode);
//        if (key == null) {
//           key= this.getKeyFromDatabase(meterCode);
//           if(key == null){
//               log.info("表：{}密钥查询不到不能解析",meterCode);
//               return null;
//           }
//          //缓存密钥
//            redis.saveKey(meterCode,key);
//        }
//        String[] keys = key.split(",");
//        if (keyNum - 2 >= keys.length) {
//            return null;
//        }
//        return keys[keyNum - 2];
    }

    /**
     * 通过数据库获取keys
     *
     * @param meterCode
     * @return
     */
//    @Override
//    public String getKeyFromDatabase(String meterCode) {
//        //去数据库拉取最新密钥信息
//        DevDtuInfoDTO devDtuInfoDTO = feignDevStandardCacheService.findDtuInfoCached(meterCode);
//        DevInfoDevNoDTO devInfoDevNoDTO = feignDevStandardCacheService.findDevInfoCached(devDtuInfoDTO.getDevs().get(0).getDevId());
//        String categoryCode = devInfoDevNoDTO.getIotAtts().getDevType();
//        String commandDeviceType = DeviceTypeEnum.getCommandDeviceType(categoryCode).getCommandDeviceType();
//        ResponseResult<JSONObject> responseResult = feignIotStandardCommandApi.getSecretCommand(commandDeviceType, meterCode);
//        if (responseResult.isSuccess()) {
//            JSONObject jsonObject = responseResult.getData();
//            return jsonObject.getString("codeKey");
//        }
//        log.info("数据库中没有查询到密钥，表钢号{}", meterCode);
//        return null;
//
//    }
}
