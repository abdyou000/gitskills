package com.huat.searchengine.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentUtil {

	/**
	 * 根据多个css选择器从一个元素中得到指定元素的文本值，若第一次为空，换下一个选择器
	 * 
	 * @param document
	 * @param cssQuery
	 * @return
	 */
	public static String selectText(Element element, String... cssQuerys) {
		String result = null;
		for (String cssQuery : cssQuerys) {
			result = element.select(cssQuery).text();
			if (StringUtils.isNotBlank(result)) {
				return result;
			}
		}
		return result;
	}

	/**
	 * 根据多个css选择器从一个元素中得到指定元素的属性值，若第一次为空，换下一个选择器
	 * 
	 * @param document
	 * @param cssQuery
	 * @return
	 */
	public static String selectAttr(Element element, String attr, String... cssQuerys) {
		String result = null;
		for (String cssQuery : cssQuerys) {
			result = element.select(cssQuery).attr(attr);
			if (StringUtils.isNotBlank(result)) {
				return result;
			}
		}
		return result;
	}

	/**
	 * 根据多个css选择器从一个元素中得到指定元素的集合，若第一次为空，换下一个选择器
	 * 
	 * @param document
	 * @param cssQuerys
	 * @return
	 */
	public static Elements selectElements(Element element, String... cssQuerys) {
		Elements result = null;
		for (String cssQuery : cssQuerys) {
			result = element.select(cssQuery);
			if (CollectionUtils.isNotEmpty(result)) {
				return result;
			}
		}
		return result;
	}

	/**
	 * 解析script标签得到文章的总页数
	 * @param document
	 * @return
	 */
	public static int getMaxPageFromScript(Document document) {
		// 得到文章总页数，csdn改版之后需要解析script标签中的变量得到总记录数
		Element scriptEle = document.select("body > script").get(2);
		String scriptText = scriptEle.data();
		String[] vars = scriptText.split(";");
		// 每页记录数
		String pageSize = vars[2].split("=")[1].trim();
		// 总记录数
		String listTotal = vars[3].split("=")[1].trim();
		int total = Integer.parseInt(listTotal);
		int size = Integer.parseInt(pageSize);
		int maxPage = (total + size - 1) / size;
		return maxPage;
	}
}
