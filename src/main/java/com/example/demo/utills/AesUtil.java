package com.example.demo.utills;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
public class AesUtil {

    private static final String KEY = "abcdefghijklmnop";
    /*****************************************************
     * AES加密
     * @param content 加密内容
    此方法使用AES-128-ECB加密模式，key需要为16位
    加密解密key必须相同，如：abcd1234abcd1234
     * @return 加密密文
     ****************************************************/

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @return
     */
    public static String  unicodeToAes128(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(KEY.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            String result1 = parseByte2HexStr(result);
            return result1;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /*****************************************************
     * AES解密
     * @param content 加密密文
    此方法使用AES-128-ECB加密模式，key需要为16位
    加密解密key必须相同
     * @return 解密明文
     ****************************************************/

    /**解密
     * @param content  待解密内容
     * @return
     */
    public static byte[] getCode1(byte[] content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(KEY.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //2 to 16
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    //16 to 2
    public static String Aes128ToUnicode(String hexStr) throws Exception {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        byte[] deResult = getCode1(result);
        String result1 = new String(deResult,"utf-8");
        return result1;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(AesUtil.unicodeToAes128("wangjin"));
        System.out.println(AesUtil.Aes128ToUnicode(AesUtil.unicodeToAes128("admin")));
    }
}