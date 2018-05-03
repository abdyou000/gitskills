package com.huat.searchengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.pageprocessor.ArticleCategoryPageProcessor;
import com.huat.searchengine.pipeline.ArticleCategoryPipeline;
import com.huat.searchengine.service.ExpertService;
import com.huat.searchengine.utils.SpiderUtil;

import us.codecraft.webmagic.Spider;

/**
 * 文章分类Controller
 * @author 史振忠
 *
 */
@Controller
@RequestMapping("/article/category")
public class ArticleCategoryController {

	@Autowired
	private ExpertService expertService;
	@Autowired
	private ArticleCategoryPipeline articleCategoryPipeline;
	
	/**
	 * 启动爬虫下载文章分类信息，同时更新文章属性
	 * 
	 * @return
	 */
	@RequestMapping("/import")
	@ResponseBody
	public JsonResult importArticleCategory(@RequestParam(required = false, defaultValue = "10") Integer tc) {
		// 从数据库中查询出所有专家的博客地址
		List<String> blogAddressList = expertService.selectAllBlogAddress();
		// 创建一个爬虫
		Spider spider = SpiderUtil.createSpider(new ArticleCategoryPageProcessor(), articleCategoryPipeline);
		// list集合转数组
		String[] urls = blogAddressList.toArray(new String[0]);
		if (spider != null) {
			spider.addUrl(urls).thread(tc).start();
			return JsonResult.build(200, "爬虫已经启动，开始下载文章分类数据");
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

}
