package com.huat.searchengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.enums.UrlEnum;
import com.huat.searchengine.pageprocessor.ColumnPageProcessor;
import com.huat.searchengine.pipeline.ColumnPipeline;
import com.huat.searchengine.service.ExpertService;
import com.huat.searchengine.utils.SpiderUtil;

import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/column")
public class ColumnController {

	@Autowired
	private ExpertService expertService;
	@Autowired
	private ColumnPipeline columnPipeline;
	
	/**
	 * 启动爬虫下载博客专栏信息，更新文章属性
	 * 
	 * @return
	 */
	@RequestMapping("/import")
	@ResponseBody
	public JsonResult importColumn(@RequestParam(required = false, defaultValue = "10") Integer tc) {
		// 从数据库中查询出所有专家的博客地址
		List<String> blogAddressList = expertService.selectAllBlogAddress();
		//博客专栏分类首页地址
		String columnCategoryAddress = UrlEnum.COLUMN_CATEGORY_MAIN_URL.toString();
		// 创建一个爬虫
		Spider spider = SpiderUtil.createSpider(new ColumnPageProcessor(), columnPipeline);
		// list集合转数组
		String[] urls = blogAddressList.toArray(new String[0]);
		if (spider != null) {
			spider.addUrl(urls).addUrl(columnCategoryAddress).thread(tc).start();
			return JsonResult.build(200, "爬虫已经启动，开始下载博客专栏数据");
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
