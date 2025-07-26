/**
 * llkang.com Inc.
 * Copyright (c) 2010-2024 All Rights Reserved.
 */
package cn.enncloud.iot.gateway.utils;

import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.Objects;

/**
 * @author kanglele
 * @version $Id: SMUtil, v 0.1 2024/5/14 16:54 kanglele Exp $
 */
public class SmUtil {

    private static final BouncyCastleProvider PROVIDER = new BouncyCastleProvider();

    static {
        if (Objects.isNull(Security.getProvider(BouncyCastleProvider.PROVIDER_NAME))) {
            Security.addProvider(PROVIDER);
        }
    }

    /**
     * 签名
     *
     * @param plainText  待签名文本
     * @param privateKey 私钥
     * @return
     * @throws GeneralSecurityException
     */
    public static String sign(String plainText, String privateKey) throws Exception {
        return sign(plainText,new BigInteger(Hex.decode(privateKey)));
    }

    public static String sign(String plainText, BigInteger privateKey) throws GeneralSecurityException {
        X9ECParameters parameters = GMNamedCurves.getByOID(GMObjectIdentifiers.sm2p256v1);
        ECParameterSpec parameterSpec = new ECParameterSpec(parameters.getCurve(), parameters.getG(), parameters.getN());
        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(privateKey, parameterSpec);
        PrivateKey bcecPrivateKey = new BCECPrivateKey("EC", privateKeySpec, BouncyCastleProvider.CONFIGURATION);
        // 创建签名对象
        Signature signature = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(), PROVIDER);
        // 初始化为签名状态
        signature.initSign(bcecPrivateKey);
        // 传入签名字节
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        // 签名
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * 验签
     *
     * @param plainText 待签名文本
     * @param signText  签名
     * @param publicKey 公钥
     * @return
     * @throws GeneralSecurityException
     */
    public static boolean verify(String plainText, String signText, String publicKey) throws Exception {
        return verify(plainText,signText,Hex.decode(publicKey));
    }

    public static boolean verify(String plainText, String signText, byte[] publicKey) throws GeneralSecurityException {
        X9ECParameters parameters = GMNamedCurves.getByOID(GMObjectIdentifiers.sm2p256v1);
        ECParameterSpec parameterSpec = new ECParameterSpec(parameters.getCurve(), parameters.getG(), parameters.getN());
        ECPoint ecPoint = parameters.getCurve().decodePoint(publicKey);
        ECPublicKeySpec publicKeySpec = new ECPublicKeySpec(ecPoint, parameterSpec);
        PublicKey bcecPublicKey = new BCECPublicKey("EC", publicKeySpec, BouncyCastleProvider.CONFIGURATION);
        // 创建签名对象
        Signature signature = Signature.getInstance(GMObjectIdentifiers.sm2sign_with_sm3.toString(), PROVIDER);
        // 初始化为验签状态
        signature.initVerify(bcecPublicKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.getDecoder().decode(signText));
    }

    public static String encrypt(String data, String key) throws Exception {
        return encrypt(data,Hex.decode(key));
    }

    public static String encrypt(String data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("SM4/ECB/PKCS5Padding");
        Key sm4Key = new SecretKeySpec(key, "SM4");
        cipher.init(Cipher.ENCRYPT_MODE, sm4Key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String data, String key) throws Exception {
        return decrypt(data,Hex.decode(key));
    }

    public static String decrypt(String cipherText, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("SM4/ECB/PKCS5Padding");
        Key sm4Key = new SecretKeySpec(key, "SM4");
        cipher.init(Cipher.DECRYPT_MODE, sm4Key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
    }

    public static void main(String[] args) throws Exception {
        String privateKey = "60b8ec1b5548bb1f9099d7b778e9f229dd9d4b7a9fc8a3d1892f003fb9bb21aa";
        String publicKey = "046074553c6506a5ec1f1450cd26e75aa1f172aee6f958426ee57b0dfe92acc6db747e418f4b638c6063974c9581e446fa842ed7ea10ca94e6f17392b680c9bac0";
        String sm4Key = "4e61059c11bb27fa1e1584eecc83103b";

        String req = "{\'key1\':1,\'key2\':1}";
        String cipherText = encrypt(req, sm4Key);
        System.out.println("密文:" + cipherText);

        String res = "8rn44DvOiLlCy/TuiG8RKUDnXY8h4EenJRpDatRVkyI=";
        String deStr = decrypt(res, sm4Key);
        System.out.println("明文:" + deStr);

        String data = "appId=13aa18c0c39bf444&bizContent=hHTLHARHsNW5PIs2B/T5lycGMHT/cMt05XZNvjSDEoQ=&encryptType=SM4&requestId=bc66379-52d4-4d9d-91d7-c2f5b21e7e59&signType=SM2&timestamp=1640741365952";
        String sign2 = sign(data, new BigInteger(Hex.decode(privateKey)));
        System.out.println("签名 : " + sign2);
        boolean verify2 = verify(data, sign2, Hex.decode(publicKey));
        System.out.println("验签 : " + verify2);

    }
}
