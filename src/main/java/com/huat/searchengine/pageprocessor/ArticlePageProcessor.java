package com.huat.searchengine.pageprocessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.huat.searchengine.entity.TblArticle;
import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.enums.UrlEnum;
import com.huat.searchengine.utils.DateUtil;
import com.huat.searchengine.utils.DocumentUtil;
import com.huat.searchengine.utils.StringUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class ArticlePageProcessor implements PageProcessor {
	@Override
	public void process(Page page) {
		if (page.getUrl().regex(UrlEnum.EXPERT_SCORE.toString()).match()) {
			// 得到ajax获得的json数据
			parseExpertJson(page);
		} else if (page.getUrl().regex(UrlEnum.BLOG_LIST.toString()).match()) {
			// 进入专家的博客列表页面
			parseBlogListPage(page);
		}  else if (page.getUrl().regex(UrlEnum.EXPERT_DETAIL.toString()).match()) {
			// 进入到专家个人中心页面
			parseExpertDetailPage(page);
		} else if (page.getUrl().regex(UrlEnum.BLOG_ADDRESS.toString()).match()) {
			// 进入到专家的博客首页
			parseBlogAddressPage(page);
		}
	}

	/**
	 * 解析ajax获得的关于专家的积分，等级，徽章的json数据
	 * 
	 * @param page
	 */
	private void parseExpertJson(Page page) {
		// 博客等级
		String blogGrade = page.getJson().jsonPath("$.result.score.blog.level").get();
		// 博客积分
		String blogScore = page.getJson().jsonPath("$.result.score.blog.score").get();
		// 下载等级
		String downloadGrade = page.getJson().jsonPath("$.result.score.download.level").get();
		// 下载积分
		String downloadScore = page.getJson().jsonPath("$.result.score.download.score").get();
		// 论坛等级
		String bbsGrade = page.getJson().jsonPath("$.result.score.bbs1.level").get();
		// 论坛积分
		String bbsScore = page.getJson().jsonPath("$.result.score.bbs1.score").get();
		// 专家获得的徽章
		List<String> medalList = page.getJson().jsonPath("$.result.medal.blog[*].codename").all();
		String expertMedals = medalList.stream().map(x -> x.substring(3)).reduce((x, y) -> x + "," + y).get();
		// 专家ID
		String url = page.getUrl().toString();
		String expertId = url.substring(url.lastIndexOf("=") + 1);
		TblExpert expert = new TblExpert();
		expert.setExpertId(expertId);
		expert.setBlogGrade(Integer.parseInt(blogGrade));
		expert.setBlogScore(Integer.parseInt(blogScore));
		expert.setDownloadGrade(Integer.parseInt(downloadGrade));
		expert.setDownloadScore(Integer.parseInt(downloadScore));
		expert.setBbsGrade(Integer.parseInt(bbsGrade));
		expert.setBbsScore(Integer.parseInt(bbsScore));
		expert.setExpertMedals(expertMedals);

		// System.out.println(expert);
		page.putField("expert", expert);
	}

	/**
	 * 解析博客文章首页
	 * 
	 * @param page
	 */
	private void parseBlogAddressPage(Page page) {
		// 解析文章
		parseArticleElements(page);
		// 解析博客专家
		parseExpertElement(page);
		// 将博主个人主页加入请求队列
		String personalCenter = page.getUrl().toString().replaceFirst("blog", "my");
		page.addTargetRequest(personalCenter);

		int currentPage = 1;
		int targetPage = currentPage + 1;
		// 得到下一页文章的URL
		String targetUrl = page.getUrl().toString() + "/article/list/" + targetPage;
		// 将文章的下一页URL添加到请求队列
		page.addTargetRequest(targetUrl);
	}

	
	/**
	 * 解析博客页面上专家的信息
	 * 
	 * @param page
	 */
	private void parseExpertElement(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		TblExpert expert = new TblExpert();
		// 博主昵称
		String cssQuery = "#uid";
		String nickName = document.select(cssQuery).text();
		// 博客标题
		cssQuery = "body > header > div > div.title-box > h6 > a";
		String blogTitle = document.select(cssQuery).text();
		// 博主原创文章数
		cssQuery = "#asideProfile > div.data-info.d-flex.item-tiling > dl:nth-child(1)";
		String articleOriginal = document.select(cssQuery).attr("title");
		// 博主粉丝数
		cssQuery = "#asideProfile > div.data-info.d-flex.item-tiling > dl:nth-child(2)";
		String fansQuantity = document.select(cssQuery).attr("title");
		// 博主喜欢数（点赞数）
		cssQuery = "#asideProfile > div.data-info.d-flex.item-tiling > dl:nth-child(3)";
		String likeQuantity = document.select(cssQuery).attr("title");
		// 文章总评论数
		cssQuery = "#asideProfile > div.data-info.d-flex.item-tiling > dl:nth-child(4)";
		String commentQuantity = document.select(cssQuery).attr("title");
		// 博主排名
		cssQuery = "#asideProfile > div.grade-box.clearfix > dl:nth-child(2) > dd";
		String expertRanking = document.select(cssQuery).attr("title");
		// 博主签名
		cssQuery = "body > header > div > div.title-box > p";
		String expertSign = document.select(cssQuery).text();
		// 从URL中获得专家ID
		String url = page.getUrl().toString();
		String expertId = url.substring(url.lastIndexOf("/") + 1);
		// 将博主各项信息封装成对象
		expert.setNickName(nickName);
		expert.setArticleOriginal(Integer.parseInt(articleOriginal));
		expert.setFansQuantity(Integer.parseInt(fansQuantity));
		expert.setLikeQunatity(Integer.parseInt(likeQuantity));
		expert.setCommentQuantity(Integer.parseInt(commentQuantity));
		expert.setExpertSign(expertSign);
		expert.setExpertRanking(Integer.parseInt(expertRanking));
		expert.setBlogTitle(blogTitle);
		expert.setExpertId(expertId);

		page.putField("expert", expert);
	}

	

	/**
	 * 解析博客文章列表页面
	 * 
	 * @param page
	 */
	private void parseBlogListPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		//解析文章
		parseArticleElements(page);
		// 得到文章总页数，csdn改版之后需要解析script标签中的变量得到总记录数
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

	/**
	 * 解析出各种文章属性并保存到结果域
	 * 
	 * @param page
	 */
	private void parseArticleElements(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 保存文章集合
		List<TblArticle> articleList = new ArrayList<>();
		// CSDN对博客地址有两种类型的页面，要分别进行解析 ，改版之后页面就统一了
		String cssQuery = "#mainBox > main > div.article-list > div.article-item-box";
		//#mainBox > main > div.article-list > div:nth-child(1)
		Elements elements = document.select(cssQuery);
		for (Element ele : elements) {
			TblArticle article = new TblArticle();
			// 文章详情地址
			// 如https://blog.csdn.net/analogous_love/article/details/69481542
			cssQuery = "h4 > a";
			String articleAddress = ele.select(cssQuery).attr("href");
			// 文章ID
			String articleId = articleAddress.substring(articleAddress.lastIndexOf("/") + 1);
			// 文章标题
			cssQuery = "h4 > a";
			String articleTitle = ele.select(cssQuery).text();
			articleTitle = articleTitle.substring(1);
			// 文章评论数量
			cssQuery = "div > p:nth-child(3) > span";
			String commentQuantity = ele.select(cssQuery).text().substring(4);
			// 文章浏览量
			cssQuery = "div > p:nth-child(2) > span";
			String browseQuantity = ele.select(cssQuery).text().substring(4);
			// 文章发布时间
			cssQuery = "div > p:nth-child(1) > span";
			String publishDate = ele.select(cssQuery).text();
			// 文章描述
			cssQuery = "p > a";
			String articleDesc = ele.select(cssQuery).text();
			// 文章类型 0原创 1转载 2翻译
			cssQuery = "h4 > a > span";
			String type = ele.select(cssQuery).text();
			Integer articleType = 0;
			if(type.equals("原")) {
				articleType = 0;
			} else if(type.equals("转")) {
				articleType = 1;
			} else if(type.equals("译")) {
				articleType = 2;
			}
			// 是否为置顶
			//TODO
			cssQuery = "svg.icon.settop";
			Elements svgEles = ele.select(cssQuery);
			Boolean sticky = false;
			if(CollectionUtils.isEmpty(svgEles)) {
				sticky = false;
			} else {
				sticky = true;
			}
			// 文章所属专家ID
			// https://blog.csdn.net/10km/article/details/79719592
			String expertId = StringUtils.substringBetween(articleAddress, "blog.csdn.net/", "/article");
			// 封装到对象，添加到集合
			article.setArticleId(articleId);
			article.setArticleTitle(articleTitle);
			article.setArticleAddress(articleAddress);
			article.setCommentQuantity(Integer.parseInt(commentQuantity));
			article.setBrowseQuantity(Integer.parseInt(browseQuantity));
			article.setPublishDate(DateUtil.string2date(publishDate));
			article.setArticleDesc(articleDesc);
			article.setArticleType(articleType.byteValue());
			article.setSticky(sticky);
			article.setExpertId(expertId);
			articleList.add(article);
		}

		// 存到结果域中
		page.putField("articleList", articleList);
	}

	/**
	 * 
	 * 解析专家个人中心页面
	 * 
	 * @param page
	 */
	private void parseExpertDetailPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		TblExpert expert = new TblExpert();
		// 得到关注别人的个数
		String cssQuery = "body > div.main.clearfix > div.persion_article > div.mod_relations > div > div:nth-child(1) > div.num > span";
		String focusQuantity = DocumentUtil.selectText(document, cssQuery);
		// 得到专家签名
		cssQuery = "body > div.main.clearfix > div.persional_property > div > dl.person-info > dd.person-sign";
		String expertSign = DocumentUtil.selectText(document, cssQuery);
		if(StringUtils.isBlank(expertSign)) {
			expertSign = "没有内容可显示";
		}
		// 从URL中获得专家ID
		String url = page.getUrl().toString();
		String expertId = url.substring(url.lastIndexOf("/") + 1);

		// 封装成对象
		expert.setFocusQuantity(Integer.parseInt(focusQuantity));
		expert.setExpertSign(expertSign);
		expert.setExpertId(expertId);

		// 保存到结果域
		page.putField("expert", expert);

		// 添加ajax请求等级，积分，徽章的URL
		String targetUrl = UrlEnum.EXPERT_SCORE_URL.toString() + expertId;
		page.addTargetRequest(targetUrl);
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(8).setSleepTime(500).setTimeOut(10000);
	}
}
