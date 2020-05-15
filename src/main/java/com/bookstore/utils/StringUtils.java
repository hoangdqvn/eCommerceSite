package com.bookstore.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {
    public static String stringToSHA256(String originalString) {
        return DigestUtils.sha256Hex(originalString);
    }
}