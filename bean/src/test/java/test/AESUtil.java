package test;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author wangxiaohu
 * @version Id: AESUtil.java, v0.1 2022年03月21日 15:34:32 wangxiaohu Exp $
 */
public class AESUtil {
    // 44
    private static final String key = "4GB7X0bK9B1Vxka6bvgnLGm4eql9btLr0vEWkgUrHGD=";
    // 16
    private static final String initVector = "fNRJDLaHCK30bqbE";

    public static String encrypt(String value) throws Exception{

        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(value.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);

    }

    public static String decrypt(String encrypted) throws Exception{
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

        return new String(original);

    }

    public static void main(String[] args) throws Exception{
        String v = "CdNA3nUJ7EgrvddB";
        String s1 = encrypt(v);
        String s2 = decrypt(s1);
        System.out.println(s1);
        System.out.println("Encrypted:{"+s1+"}");
        System.out.println(v.equals(s2));
    }
}
