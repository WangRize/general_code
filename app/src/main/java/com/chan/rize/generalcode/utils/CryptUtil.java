package com.chan.rize.generalcode.utils;

import java.security.MessageDigest;

public class CryptUtil {

    private static final String DEFAULT_STRING = "";

    public static String getMd5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            return StringUtil.toHexString(md5.digest());
        } catch (Exception e) {
            return DEFAULT_STRING;
        }
    }
}
