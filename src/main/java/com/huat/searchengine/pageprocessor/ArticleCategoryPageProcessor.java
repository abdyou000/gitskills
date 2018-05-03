package com.huat.searchengine.pageprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.enums.UrlEnum;
import com.huat.searchengine.utils.DocumentUtil;
import com.huat.searchengine.utils.StringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ArticleCategoryPageProcessor implements PageProcessor {

	@Override
	public void process(Page page) {

		if (page.getUrl().regex(UrlEnum.ARTICLE_CATEGORY_LIST.toString()).match()) {
			// 进入到文章分类翻页的页面
			parseArticleCategoryListPage(page);
		} else if (page.getUrl().regex(UrlEnum.ARTICLE_CATEGORY.toString()).match()) {
			// 进入到文章分类的页面
			parseArticleCategoryPage(page);
		} else if (page.getUrl().regex(UrlEnum.BLOG_ADDRESS.toString()).match()) {
			// 进入到专家的博客首页
			parseBlogAddressPage(page);
		}
	}

	/**
	 * 解析博客文章首页
	 * 
	 * @param page
	 */
	private void parseBlogAddressPage(Page page) {
		// 解析文章分类
		parseArticleCategoryElements(page);
		// 解析热门文章
		parseHotArticleElements(page);
	}

	/**
	 * 解析博客文章分类翻页页面
	 * 
	 * @param page
	 */
	private void parseArticleCategoryListPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 解析文章地址
		parseCategoryArticleAddress(page);

		// 得到文章总页数
		int maxPage = DocumentUtil.getMaxPageFromScript(document);
		// 得到下一页文章的URL
		String url = page.getUrl().toString();
		int currentPage = Integer.parseInt(url.substring(url.lastIndexOf("/") + 1));
		int targetPage = currentPage + 1;
		if (targetPage > maxPage) {
			return;
		}
		String targetUrl = url.substring(0, url.lastIndexOf("/") + 1) + targetPage;
		// 将文章的下一页URL添加到请求队列
		page.addTargetRequest(targetUrl);
	}

	private void parseHotArticleElements(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());

		// 博主的热门文章
		String cssQuery = "#asideHotArticle > div > ul > li > a";
		Elements hotArticleElements = document.select(cssQuery);
		List<String> hotArticleIdList = hotArticleElements.stream().map(ele -> {
			String href = ele.attr("href");
			href = href.substring(href.lastIndexOf("/") + 1);
			return href;
		}).collect(Collectors.toList());
		page.putField("hotArticleIdList", hotArticleIdList);
	}

	/**
	 * 解析博客中的文章分类
	 * 
	 * @param page
	 */
	private void parseArticleCategoryElements(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 博主的文章分类
		String cssQuery = "#asideCategory > div > ul > li";
		Elements categoryEles = document.select(cssQuery);
		List<TblArticleCategory> articleCategoryList = new ArrayList<>();
		for (Element ele : categoryEles) {
			TblArticleCategory articleCategory = new TblArticleCategory();
			cssQuery = "a";
			// 分类地址
			String categoryAddress = ele.select(cssQuery).attr("href");
			// 分类ID
			String categoryId = categoryAddress.substring(categoryAddress.lastIndexOf("/") + 1);
			// 分类名称
			String categoryName = ele.select(cssQuery).text();
			// 包含的文章数量
			cssQuery = "a span";
			String articleQuantity = ele.select(cssQuery).text();
			// 30篇 去掉"篇"
			articleQuantity = articleQuantity.substring(0, articleQuantity.length() - 1);
			// 从URL中获得专家ID
			String url = page.getUrl().toString();
			String expertId = url.substring(url.lastIndexOf("/") + 1);

			// 封装成对象
			articleCategory.setCategoryId(categoryId);
			articleCategory.setCategoryName(categoryName);
			articleCategory.setCategoryAddress(categoryAddress);
			articleCategory.setArticleQuantity(Integer.parseInt(articleQuantity));
			articleCategory.setExpertId(expertId);
			// 添加到集合中
			articleCategoryList.add(articleCategory);
		}
		page.putField("articleCategoryList", articleCategoryList);
		// 将所有分类页面的URL添加到请求队列
		List<String> categoryAddressList = articleCategoryList.stream().map(x -> x.getCategoryAddress())
				.collect(Collectors.toList());
		page.addTargetRequests(categoryAddressList);
	}

	/**
	 * 解析博客文章分类页面
	 * 
	 * @param page
	 */
	private void parseArticleCategoryPage(Page page) {
		// 解析文章地址
		parseCategoryArticleAddress(page);

		int currentPage = 1;
		int targetPage = currentPage + 1;
		// 得到下一页文章的URL
		String targetUrl = page.getUrl().toString() + "/" + targetPage;
		// 将文章的下一页URL添加到请求队列
		page.addTargetRequest(targetUrl);
	}

	/**
	 * 解析分类中文章的所有地址
	 * 
	 * @param page
	 */
	private void parseCategoryArticleAddress(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 分类ID
		String url = page.getUrl().toString();
		String categoryStr = "category/";
		String categoryId = url.substring(url.lastIndexOf(categoryStr) + categoryStr.length());
		int index = categoryId.lastIndexOf("/");
		if (index != -1) {
			categoryId = categoryId.substring(0, index);
		}
		// 文章地址
		String cssQuery = "#mainBox > main > div.article-list > div > h4 > a";
		Elements elements = document.select(cssQuery);
		// java8新特性 StreamAPI
		List<String> categoryArticleIdList = elements.stream().map(ele -> {
			String href = ele.attr("href");
			href = href.substring(href.lastIndexOf("/") + 1);
			return href;
		}).collect(Collectors.toList());
		page.putField("categoryArticleIdList", categoryArticleIdList);
		page.putField("categoryId", categoryId);
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(8).setSleepTime(500).setTimeOut(10000);
	}

}
