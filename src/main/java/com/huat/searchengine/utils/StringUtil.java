package com.huat.searchengine.utils; 

public class StringUtil {

	/**
	 * 替换一个字符串中的多个目标
	 * @param source
	 * @param replacement
	 * @param targets
	 * @return
	 */
	public static String replace(String source,String replacement,String... targets) {
		String result = null;
		for (String target : targets) {
			result = source.replace(target, replacement);
			source = new String(result);
		}
		return result;
	}
	
	/**
	 * 截取一个字符串中两个字符串之间的字符串，若取不到结果，返回默认值
	 * @param str
	 * @param open
	 * @param close
	 * @param defaultValue
	 * @return
	 */
	public static String substringBetween(String str,String open,String close,String defaultValue) {
		if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return defaultValue;
	}
}
