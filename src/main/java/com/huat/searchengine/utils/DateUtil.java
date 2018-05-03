package com.huat.searchengine.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

	/**
	 * 将字符串转换成固定格式的时间格式的毫秒值
	 * @param text
	 * @return
	 */
	public static Long string2date(String text) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long result = null;
		try {
			result = dateFormat.parse(text).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
