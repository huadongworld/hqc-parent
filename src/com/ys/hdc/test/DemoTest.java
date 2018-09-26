package com.ys.hdc.test;

import com.ys.hdc.test.misc.CompanyDistanceInfoResponse;
import com.ys.hdc.test.misc.ResponseResult;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author HD
 * @date 2018/8/13 14:33
 */
public class DemoTest {

    @Test
    public void demo01() {
        String name = "abner chai";
        //String name = null;
        assert (name != null) : "变量name为空null";
        System.out.println(name);
    }

    @Test
    public void demo02() {
        ResponseResult companyDistanceInfoResponse = new CompanyDistanceInfoResponse(
                "true",
                "666",
                "调用成功",
                "结果"
        );
        isVisitSuccess(companyDistanceInfoResponse);
    }

    private Boolean isVisitSuccess(ResponseResult responseResult) {
        if (!"666".equals(responseResult.getCode())) {
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }

    @Test
    public void demo03() {
        String pwd = "888888";
        System.out.println("明文：" + pwd);
        System.out.println("密文：" + SHA1(pwd));
    }

    public final static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
