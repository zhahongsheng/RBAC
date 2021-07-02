package com.example.user_access_management.utils;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 * @author zhahsh
 * @date 2021/7/2
 */
public class Md5Util {
    private Md5Util() {
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    /**
     * 判断输入的密码和数据库中保存的MD5密码是否一致
     * @param inputPassword 输入的密码
     * @param md5DB 数据库保存的密码
     * @return 比较结果
     */
    public static boolean passwordIsTrue(String inputPassword,String md5DB) {
        String md5 = string2MD5(inputPassword);
        return md5DB.equals(md5);
    }
}
