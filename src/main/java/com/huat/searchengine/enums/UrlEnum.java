package com.huat.searchengine.enums;

public enum UrlEnum {
	/**
	 * 博客文章首页的地址
	 */
	BLOG_ADDRESS("http(s?)://blog\\.csdn\\.net/.*$"),
	/**
	 * 博客文章翻页的地址
	 */
	BLOG_LIST("http(s?)://blog\\.csdn\\.net/.*/article/list/[\\d]+$"),
	/**
	 * 博主个人中心的地址
	 */
	EXPERT_DETAIL("http(s?)://my\\.csdn\\.net/.*$"),
	/**
	 * 博客专家的地址
	 */
	EXPERT_LIST("http(s?)://blog\\.csdn\\.net/peoplelist\\.html\\?channelid=0&page=[\\d]+$"),
	/**
	 * 博客文章分类的地址
	 */
	ARTICLE_CATEGORY("http(s?)://blog\\.csdn\\.net/.*/article/category/.*$"),
	/**
	 * 博客文章分类翻页的地址
	 */
	ARTICLE_CATEGORY_LIST("http(s?)://blog\\.csdn\\.net/.*/article/category/.*/[\\d]+$"),
	/**
	 * 博主的博客专栏地址
	 */
	BLOG_COLUMN("http(s?)://blog\\.csdn\\.net/column/details/.*\\.html$"),
	/**
	 * 博主的博客专栏翻页地址
	 */
	BLOG_COLUMN_LIST("http(s?)://blog\\.csdn\\.net/column/details/.*\\.html\\?&page=[\\d]+$"),
	
	/**
	 * 专家个人中心获得等级，积分和徽章的ajax的URL
	 */
	EXPERT_SCORE("http(s?)://my\\.csdn\\.net/service/main/getSorce\\?username=.*$"),
	
	/**
	 * 专家个人中心获得等级，积分和徽章的ajax的具体的URL
	 */
	EXPERT_SCORE_URL("https://my.csdn.net/service/main/getSorce?username="),
	/**
	 * 博客专栏分类主页地址
	 */
	COLUMN_CATEGORY_MAIN("http(s?)://blog\\.csdn\\.net/column\\.html"),
	
	/**
	 * 博客专栏分类主页具体地址
	 */
	COLUMN_CATEGORY_MAIN_URL("https://blog.csdn.net/column.html"),
	

	/**
	 * 博客专栏分类地址
	 */
	COLUMN_CATEGORY("http(s?)://blog\\.csdn\\.net/.*/column\\.html"),
	/**
	 * csdn博客主页
	 */
	CSDN_MAIN_URL("https://blog.csdn.net"),
	/**
	 * 用户注册时的默认头像
	 */
	USER_DEFAULT_AVATAR("https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portrait/hotitem/wildkid/1"),
	;
	
	private String value;
	
	private UrlEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
