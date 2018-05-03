package com.huat.searchengine.pageprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.huat.searchengine.entity.TblColumn;
import com.huat.searchengine.entity.TblColumnCategory;
import com.huat.searchengine.enums.UrlEnum;
import com.huat.searchengine.utils.DocumentUtil;
import com.huat.searchengine.utils.StringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ColumnPageProcessor implements PageProcessor {
	@Override
	public void process(Page page) {
		if (page.getUrl().regex(UrlEnum.BLOG_COLUMN.toString()).match()) {
			// 进入到博客专栏的页面
			parseBlogColumnPage(page);
		} else if (page.getUrl().regex(UrlEnum.BLOG_COLUMN_LIST.toString()).match()) {
			// 进入到博客专栏翻页的页面
			parseBlogColumnListPage(page);
		} else if (page.getUrl().regex(UrlEnum.COLUMN_CATEGORY_MAIN.toString()).match()) {
			// 进入博客专栏分类主页页面
			parseColumnCategoryMainPage(page);
		} else if (page.getUrl().regex(UrlEnum.COLUMN_CATEGORY.toString()).match()) {
			// 进入博客专栏分类页面
			parseColumnCategoryPage(page);
		} else if (page.getUrl().regex(UrlEnum.BLOG_ADDRESS.toString()).match()) {
			// 进入到专家的博客首页
			parseBlogAddressPage(page);
		}
	}

	/**
	 * 解析博客专栏分类页面
	 * 
	 * @param page
	 */
	private void parseColumnCategoryPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 专栏分类地址
		String categoryAddress = page.getUrl().toString();
		// 专栏分类ID
		String categoryId = StringUtil.substringBetween(categoryAddress, "https://blog.csdn.net/", "/column.html", "");
		// 专栏分类名称
		String cssQuery = "body > div.blog_home_main.clearfix > div.blog_l.fl > div.col_secItem > div.col_secItem_c > em";
		String categoryName = DocumentUtil.selectText(document, cssQuery);
		// 分类中包含的专栏数量
		cssQuery = "body > div.blog_home_main.clearfix > div.blog_l.fl > div.page_nav > span";
		// <span> 2661条 共127页</span>
		String span = DocumentUtil.selectText(document, cssQuery);
		String columnQuantity = span.substring(0, span.indexOf("条"));

		TblColumnCategory columnCategory = new TblColumnCategory();
		columnCategory.setCategoryId(categoryId);
		columnCategory.setCategoryName(categoryName);
		columnCategory.setCategoryAddress(categoryAddress);
		columnCategory.setColumnQuantity(Integer.parseInt(columnQuantity));

		page.putField("columnCategory", columnCategory);
	}

	/**
	 * 解析博客专栏分类主页页面
	 * 
	 * @param page
	 */
	private void parseColumnCategoryMainPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());

		String cssQuery = "body > div.blog_home_main.clearfix > div.blog_r.fr > div:nth-child(3) > div.blog_category > ul > li";
		Elements liElements = DocumentUtil.selectElements(document, cssQuery);

		List<String> columnCategoryAddressList = new ArrayList<>();
		for (Element li : liElements) {
			Elements aElements = li.select("a");
			for (Element a : aElements) {
				String columnCategoryAddress = UrlEnum.CSDN_MAIN_URL.toString() + a.attr("href");
				columnCategoryAddressList.add(columnCategoryAddress);
			}
		}

		page.addTargetRequests(columnCategoryAddressList);
	}

	/**
	 * 解析博客文章首页
	 * 
	 * @param page
	 */
	private void parseBlogAddressPage(Page page) {
		// 解析博主的博客专栏
		parseBlogColumnElements(page);
	}

	/**
	 * 解析博主的博客专栏
	 * 
	 * @param page
	 */
	private void parseBlogColumnElements(Page page) {

		Document document = Jsoup.parse(page.getHtml().toString());
		// 专栏地址
		String cssQuery = "#asideColumn > div > ul > li > div.info > p > a";
		Elements elements = document.select(cssQuery);
		List<String> columnAddressList = elements.stream().map(ele -> ele.attr("href")).collect(Collectors.toList());
		//添加到请求队列
		page.addTargetRequests(columnAddressList);
	}

	/**
	 * 解析博客的专栏翻页页面
	 * 
	 * @param page
	 */
	private void parseBlogColumnListPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 解析文章地址
		parseColumnArticleAddress(page);

		// 得到总页数
		String cssQuery = "body > div.column_detail.clearfix > div > div.blog_l.fl > div.page_nav > a:nth-last-child(1)";
		String href = DocumentUtil.selectAttr(document, "href", cssQuery);
		String maxPageNum = href.substring(href.lastIndexOf("=") + 1);
		int maxPage = 1;
		if (StringUtils.isNotBlank(maxPageNum)) {
			maxPage = Integer.parseInt(maxPageNum);
		}
		// 得到当前页号
		String pageUrl = page.getUrl().toString();
		int currentPage = Integer.parseInt(pageUrl.substring(pageUrl.lastIndexOf("=") + 1));
		int targetPage = currentPage + 1;
		// 如何目标页号大于总页数，就停止
		if (targetPage > maxPage) {
			return;
		}
		// 向URL队列中添加一个新的目标URL
		String targetUrl = pageUrl.substring(0, pageUrl.lastIndexOf("=") + 1) + targetPage;
		page.addTargetRequest(targetUrl);

	}

	/**
	 * 解析博客的专栏页面
	 * 
	 * @param page
	 */
	private void parseBlogColumnPage(Page page) {
		// 解析文章地址
		parseColumnArticleAddress(page);
		// 解析博客专栏信息
		parseColumnElement(page);

		int currentPage = 1;
		int targetPage = currentPage + 1;
		// 得到下一页文章的URL
		String targetUrl = page.getUrl().toString() + "?&page=" + targetPage;
		// 将文章的下一页URL添加到请求队列
		page.addTargetRequest(targetUrl);
	}

	/**
	 * 解析博客专栏
	 * 
	 * @param page
	 */
	private void parseColumnElement(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		String url = page.getUrl().toString();
		// 专栏ID
		int start = url.lastIndexOf("/") + 1;
		int end = url.lastIndexOf(".html");
		String columnId = url.substring(start, end);
		// 专栏标题
		String cssQuery = "body > div.column_banner > div.column_ba_con > h3 > a";
		String columnTitle = DocumentUtil.selectText(document, cssQuery);
		// 专栏描述
		cssQuery = "body > div.column_banner > div.column_ba_con > p";
		String columnDesc = DocumentUtil.selectText(document, cssQuery);
		// 专栏地址
		String columnAddress = url;
		// 专栏头像
		cssQuery = "body > div.column_banner";
		String columnAvatar = DocumentUtil.selectAttr(document, "style", cssQuery);
		columnAvatar = StringUtil.substringBetween(columnAvatar, "(", ")", "");
		// 专栏浏览量
		cssQuery = "body > div.column_banner > div.column_ba_con > div.ba_c > label:nth-child(2) > span";
		String browseQuantity = DocumentUtil.selectText(document, cssQuery);
		// 专栏关注量
		cssQuery = "body > div.column_banner > div.column_ba_con > div.ba_statistics > span";
		String focusQuantity = DocumentUtil.selectText(document, cssQuery);
		// 专栏包含的文章数
		cssQuery = "body > div.column_detail.clearfix > div > div.blog_l.fl > div.statistics_t > span";
		String articleQuantity = DocumentUtil.selectText(document, cssQuery);
		// 所属专家
		cssQuery = "body > div.column_banner > div.column_ba_con > div.ba_c > label:nth-child(1) > span > a";
		String expertId = DocumentUtil.selectText(document, cssQuery);
		// 所属专栏分类
		// "/mobile/column.html"
		cssQuery = "body > div.col_location > a:nth-child(3)";
		String herf = DocumentUtil.selectAttr(document, "href", cssQuery);
		String categoryId = StringUtil.substringBetween(herf, "/", "/", "");

		// 封装成对象
		TblColumn column = new TblColumn();
		column.setColumnId(columnId);
		column.setColumnTitle(columnTitle);
		column.setColumnDesc(columnDesc);
		column.setColumnAddress(columnAddress);
		column.setColumnAvatar(columnAvatar);
		column.setBrowseQuantity(Integer.parseInt(browseQuantity));
		column.setFocusQuantity(Integer.parseInt(focusQuantity));
		column.setArticleQuantity(Integer.parseInt(articleQuantity));
		column.setExpertId(expertId);
		column.setCategoryId(categoryId);

		page.putField("column", column);
	}

	/**
	 * 解析专栏中文章的所有地址
	 * 
	 * @param page
	 */
	private void parseColumnArticleAddress(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 专栏ID
		// https://blog.csdn.net/column/details/17169.html
		String url = page.getUrl().toString();
		String columnId = url.substring(url.lastIndexOf("/") + 1);
		columnId = columnId.substring(0, columnId.indexOf(".html"));
		// 文章地址
		String cssQuery = "body > div.column_detail.clearfix > div > div.blog_l.fl > ul > li > h4 > a";
		Elements elements = DocumentUtil.selectElements(document, cssQuery);
		List<String> columnArticleIdList = elements.stream().map(ele -> {
			String href = ele.attr("href");
			href = href.substring(href.lastIndexOf("/") + 1);
			return href;
		}).collect(Collectors.toList());
		page.putField("columnArticleIdList", columnArticleIdList);
		page.putField("columnId", columnId);
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(8).setSleepTime(500).setTimeOut(10000);
	}
}
