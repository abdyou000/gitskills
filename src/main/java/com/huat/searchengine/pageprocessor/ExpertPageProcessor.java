package com.huat.searchengine.pageprocessor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.utils.DocumentUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 启动爬虫获取CSDN上所有博客专家的信息
 */
public class ExpertPageProcessor implements PageProcessor {
	@Override
	public void process(Page page) {

		// 解析专家页面
		parseExpertListPage(page);

	}

	/**
	 * 解析专家页面
	 * 
	 * @param page
	 */
	private void parseExpertListPage(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());
		// 解析专家
		parseExpertElements(page);
		// 得到总页数
		//body > dl:nth-child(1) > dd > a
		String cssQuery = "body > div > a:nth-last-child(1)";
		String href = DocumentUtil.selectAttr(document, "href", cssQuery);
		String maxPageNum = href.substring(href.lastIndexOf("=") + 1);
		int maxPage = 1;
		if(StringUtils.isNotBlank(maxPageNum)) {
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
	 * 解析专家
	 * 
	 * @param page
	 */
	private void parseExpertElements(Page page) {
		Document document = Jsoup.parse(page.getHtml().toString());

		// 所有专家的元素
		String cssQuery = "body dl";
		Elements elements = DocumentUtil.selectElements(document, cssQuery);
		// 存放专家的集合
		List<TblExpert> expertList = new ArrayList<>();
		for (Element element : elements) {
			TblExpert expert = new TblExpert();
			// 专家地址
			cssQuery = "dd div.address em";
			String expertAddress = DocumentUtil.selectText(element, cssQuery);
			if (StringUtils.isBlank(expertAddress)) {
				expertAddress = "无";
			}
			// 专家工作
			cssQuery = "dd div.address span";
			String expertJob = DocumentUtil.selectText(element, cssQuery);
			// HTML中的&nbsp;到java中不是空格，(int)job.charAt(0)为160
			if (StringUtils.isBlank(expertJob) || expertJob.charAt(0) == 160) {
				expertJob = "无";
			}
			// 专家名称
			cssQuery = "dd a.expert_name";
			String expertName = DocumentUtil.selectText(element, cssQuery);
			// 专家博客地址
			cssQuery = "dd a";
			String blogAddress = DocumentUtil.selectAttr(element, "href", cssQuery);
			// 专家ID
			String expertId = blogAddress.substring(blogAddress.lastIndexOf("/") + 1);
			// 专家个人中心地址
			String personalCenter = blogAddress.replaceFirst("blog", "my");
			// 专家文章总数（包含原创和转发）
			cssQuery = "dd div.count div.count_l.fl b";
			String articleQuantity = DocumentUtil.selectText(element, cssQuery);
			// 专家所有文章的阅读量
			cssQuery = "dd div.count div.count_l.fr b";
			String readingQuantity = DocumentUtil.selectText(element, cssQuery);
			// http://avatar.csdn.net/1/0/7/2_weixin_36380516.jpg
			// http://avatar.csdn.net/1/8/8/2_tensorflowshizhan.jpg
			// 专家头像地址
			cssQuery = "dt a img";
			String expertAvatar = DocumentUtil.selectAttr(element, "src", cssQuery);

			//封装成对象
			expert.setExpertName(expertName);
			expert.setExpertId(expertId);
			expert.setBlogAddress(blogAddress);
			expert.setPersonalCenter(personalCenter);
			expert.setExpertAddress(expertAddress);
			expert.setExpertJob(expertJob);
			expert.setArticleQuantity(Integer.parseInt(articleQuantity));
			expert.setReadingQuantity(Integer.parseInt(readingQuantity));
			expert.setExpertAvatar(expertAvatar);
			//添加到集合
			expertList.add(expert);
		}
		page.putField("expertList", expertList);
		
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(8).setSleepTime(500).setTimeOut(10000);
	}

}
