package com.saick.base.controller.upload.mediastorage.util;

import java.security.MessageDigest;
import java.util.UUID;

public class Md5Util {
	static char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public final static String md5_32(final String s,boolean lower) {
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return lower?new String(str).toLowerCase():new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public final static String md5_16(final String s,boolean lower) {
        
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return lower?new String(str).substring(8,24).toLowerCase():new String(str).substring(8,24);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	public static void main(String[] args) {
		String s = "123";
		System.out.println(md5_16(s,true));
		System.out.println(md5_32(s,true));
		System.out.println(UUID.randomUUID());
	}
}
