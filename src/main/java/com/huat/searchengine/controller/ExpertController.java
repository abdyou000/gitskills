package com.huat.searchengine.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.pageprocessor.ExpertPageProcessor;
import com.huat.searchengine.pipeline.ExpertPipeline;
import com.huat.searchengine.service.ArticleCategoryService;
import com.huat.searchengine.service.ExpertService;
import com.huat.searchengine.utils.SpiderUtil;

import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/expert")
public class ExpertController {

	@Autowired
	private ExpertPipeline expertPipeline;
	@Autowired
	private ArticleCategoryService articleCategoryService;
	/**
	 * 下载博客专家数据保存到数据库
	 * @return
	 */
	@RequestMapping("/import")
	@ResponseBody
    public JsonResult importExpert(@RequestParam(required = false, defaultValue = "10") Integer tc,
                                 @RequestParam(required = false, defaultValue = "https://blog.csdn.net/peoplelist.html?&page=1") String url) {
        Spider spider = SpiderUtil.createSpider(new ExpertPageProcessor(),expertPipeline);
        if (spider != null) {
            spider.addUrl(url).thread(tc).start();
            return JsonResult.build(200, "爬虫已经启动，开始下载博客专家数据");
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
    private ExpertService expertService;
    
    /**
     * 对数据库中的博客专家数据建立索引
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public JsonResult indexExpert() {
        expertService.indexExpert();
        return JsonResult.build(200, "开始对博客专家数据建立索引数据");
    }
	
    /**
     * 查询指定专家的详细信息
     * @param expertid
     * @return
     */
    @RequestMapping("/{expertid}")
    public String detail(@PathVariable String expertid,Model model) {
        TblExpert expert = expertService.getExpertById(expertid);
        model.addAttribute("expert", expert);
        return "detail";
    }
    
    /**
     * 生成词云
     * @param expertid
     * @return
     */
    @RequestMapping("/wordcloud/{expertid}")
    @ResponseBody
    public List<String> generatorWordCloud(@PathVariable String expertid) {
        List<String> categoryNames = articleCategoryService.getAllCategoryNames(expertid);
        return categoryNames;
    }
    
    @RequestMapping("/related")
    @ResponseBody
    public List<TblExpert> related(String expertid,String address) throws Exception {
    	address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
        List<TblExpert> experts = expertService.selectExpertByEqualsAddress(expertid,address);
        return experts;
    }

}
