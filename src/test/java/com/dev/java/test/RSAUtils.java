package com.dev.java.test;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

public class RSAUtils {

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";


    public static void main(String[] args) {

        boolean doCheck = doCheck("\"userId\":9289914227", "rfAAxssEZ3rgrUSF1hUSh4ZHAl6sCi1DTpk/ZZwTyVvsdTMooxuZVPmtWdoSB6A+IkEkV0ok5/WN+M82sjmRF0gyMJvzk/ogmnDhbOCX2jtWASJCDFG9u3kJ4CJ8SOIyYX27Hyrhk9BaJLXXzTfhc9ZOJaEHlNsoarUKolebhVw=", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDdXTXQZMY8KBO7n4VGqlLz6B2wBl8xzyxvpnuSeqmDOhIONkl5w7mZufvj8sCWyp/eaeJ2py3ChOdA8kz81on8JirGhsd9pBFKZFIApq9cYQGgHqna0j5qHXtnC9IDvDGDSva+b1yd8AuTSz2x/8utqJC7gwLteU4lr8Ta5k1eoQIDAQAB", "UTF-8");
        System.out.println(doCheck);
    }

    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decodeBase64(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
