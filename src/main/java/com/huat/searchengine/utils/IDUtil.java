package com.huat.searchengine.utils;

import java.util.Random;
import java.util.UUID;

public class IDUtil {

	/**
	 * 生成4位手机验证码
	 * @return
	 */
	public static String generateVerifyNo() {
		Random random = new Random();
		String result = "";
		for(int i=0;i<4;i++) {
			int next = random.nextInt(9) + 1;
			result += next;
		}
		return result;
	}
	
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	public static void main(String[] args) {
		System.out.println(generateVerifyNo());
	}
}
