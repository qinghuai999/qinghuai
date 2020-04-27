package com.ssq.demo.jdauto.util.utils.random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * @author 王守钰
 * @program jdauto-common
 * @date 2020年04月15日 13:56
 * @description: 随机数辅助类
 */
public class UuIdUtils {

	private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();

	/**
	 * 获取UUID去除横线
	 * @return
	 */
	public static String uuId(){
		String randomStr = UUID.randomUUID().toString();
		return randomStr.replaceAll("-", "");
	}
	
	/**
	 * 随机获取字符串
	 * @param length 随机长度
	 * @return
	 */
	public static String randomString(int length) {
		String base = "0a1b2c3d4e5f6g7h8i9j0k1lL2m3n4o5p6q7r8s9t0u1v2w3x4y5z6";
		return randomStr(length, base);
	}
	
	/**
	 * 随机获取数字字符串
	 * @param length 字符串长度
	 * @return
	 */
	public static String randomInt(int length){
		String base = "0123456789";
		return randomStr(length, base);
	}
	
	/**
	 * 随机获取字符串内的值
	 * @param length 要获取随机串的长度
	 * @param base 要随机的字符串
	 * @return
	 */
	public static String randomStr(int length,String base){
		if(length <= 0){
			throw new RuntimeException("随机串长度小于等于0");
		}
		Random random = new Random();   
		StringBuffer sb = new StringBuffer();   
		for (int i = 0; i < length; i++) {   
			int number = random.nextInt(base.length());   
			sb.append(base.charAt(number));   
		}
		return sb.toString();
	}

    /**
     * 获取随机字符串
     *
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        char[] nonceChars = new char[32];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}
