package com.huat.searchengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.entity.TblArticle;
import com.huat.searchengine.pageprocessor.ArticleCategoryPageProcessor;
import com.huat.searchengine.pageprocessor.ArticlePageProcessor;
import com.huat.searchengine.pipeline.ArticleCategoryPipeline;
import com.huat.searchengine.pipeline.ArticlePipeline;
import com.huat.searchengine.service.ArticleCategoryService;
import com.huat.searchengine.service.ArticleService;
import com.huat.searchengine.service.ExpertService;
import com.huat.searchengine.utils.SpiderUtil;

import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ExpertService expertService;
	@Autowired
	private ArticlePipeline articlePipeline;

	/**
	 * 启动爬虫下载文章数据保存到数据库
	 * 
	 * @param tc
	 * @return
	 */
	@RequestMapping("/import")
	@ResponseBody
	public JsonResult importArticle(@RequestParam(required = false, defaultValue = "10") Integer tc) {
		// 从数据库中查询出所有专家的博客地址
		List<String> urlList = expertService.selectAllBlogAddress();
		// 创建一个爬虫
		Spider spider = SpiderUtil.createSpider(new ArticlePageProcessor(), articlePipeline);
		// list集合转数组
		String[] urls = urlList.toArray(new String[0]);
		if (spider != null) {
			spider.addUrl(urls).thread(tc).start();
			return JsonResult.build(200, "爬虫已经启动，开始下载专家文章数据");
		} else {
			return JsonResult.build(400, "爬虫已经启动，无法开启多个任务");
		}
	}
	/**
     * 关闭爬虫
     * @return
     */
    @RequestMapping("/stop")
    @ResponseBody
    public JsonResult stop() {
        SpiderUtil.closeSpider();
        return JsonResult.build(200, "关闭爬虫成功");
    }
	
	@Autowired
	private ArticleService articleService;

	/**
	 * 对数据库中的博客数据建立索引数据
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	@ResponseBody
	public JsonResult indexBlog() {
		articleService.indexArticle();
		return JsonResult.build(200, "开始对博客文章数据建立索引");
	}

	@RequestMapping("/{expertid}")
	@ResponseBody
	public List<TblArticle> blogs(@PathVariable String expertid) {
		List<TblArticle> blogs = articleService.findFirst10ByExpertIdAndBrowseQuantity(expertid);
		return blogs;
	}
}
