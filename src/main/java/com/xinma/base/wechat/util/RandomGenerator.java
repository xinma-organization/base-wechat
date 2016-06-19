package com.xinma.base.wechat.util;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数获取类 RandomGenerator
 */
public class RandomGenerator {

	/**
	 * 获取一定长度的随机字符串
	 * 
	 * @param length
	 *            指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStringByLength(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成一个不长于32位不包含"-"字符的字符串
	 * 
	 * @return 结果字符串
	 */
	public static String create_nonce_str() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 32);
	}

	/**
	 * 获取指定长度的数值型随机字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return 结果字符串
	 */
	public static String randomNumericString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(10);
			sb.append(number);
		}
		return sb.toString();
	}
}
