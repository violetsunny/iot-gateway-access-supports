package com.ennewiot.gateway.industrialalarm.protocol.encrypt;

import io.netty.buffer.ByteBuf;

/**
 * Created by sunhongqiang on 2018/03/13.
 */
public interface EncryptService {

    /**
     * 加密数据
     *
     * @param meterCode
     * @param keyIndex
     * @param data
     * @return
     * @throws Exception
     */
    String encrypt(String meterCode, int keyIndex, String data) throws Exception;

    /**
     * 加密数据
     *
     * @param meterCode
     * @param keyIndex
     * @param data
     * @return
     * @throws Exception
     */
    void encrypt(String meterCode, int keyIndex, ByteBuf data) throws Exception;

    /**
     * 解密数据
     *
     * @param meterCode 表钢号
     * @param keyIndex
     * @param data
     * @return
     * @throws Exception
     */
    String decrypt(String meterCode, int keyIndex, String data) throws Exception;

    /**
     * 解密数据
     *
     * @param meterCode 表钢号
     * @param keyIndex
     * @param
     * @throws Exception
     */
    void decrypt(String meterCode, int keyIndex, ByteBuf buf) throws Exception;

//    /**
//     * 查询密钥
//     * from DB
//     * @param meterCode
//     * @return
//     */
//     String getKeyFromDatabase(String meterCode);

}
