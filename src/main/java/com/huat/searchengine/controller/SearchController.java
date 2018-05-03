package com.huat.searchengine.controller;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huat.searchengine.dto.PageInfo;
import com.huat.searchengine.entity.TblSearchHistory;
import com.huat.searchengine.entity.TblUser;
import com.huat.searchengine.service.ArticleService;
import com.huat.searchengine.service.ExpertService;
import com.huat.searchengine.service.SearchHistoryService;
import com.huat.searchengine.utils.IDUtil;
import com.huat.searchengine.utils.LuceneUtil;

/**
 * 搜索服务提供类
 * 
 * @author 史振忠
 *
 */
@Controller
public class SearchController {

	@Autowired
	private ExpertService expertService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SearchHistoryService searchHistoryService;

	/**
	 * 根据关键字和类型查询
	 * 
	 * @param q
	 *            查询关键字
	 * @param type
	 *            查询类型 博客或专家
	 * @param page
	 *            第几页
	 * @param rows
	 *            每页大小
	 * @param model
	 *            存放数据的对象
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/query")
	public String query(String q, @RequestParam(required = false, defaultValue = "article") String type,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows, Model model,HttpSession session) throws Exception {
		String result = "";
		if (StringUtils.isNotBlank(q)) {
			if(page.intValue() != 1) {
				q = new String(q.getBytes("ISO-8859-1"),"UTF-8");
			}
			if ("article".equals(type)) {
				PageInfo pageInfo = LuceneUtil.queryByArticle(q, page, rows);
				model.addAttribute("page", pageInfo);
				model.addAttribute("articles", articleService.selectFirst10ByBrowseQuantity());
				result = "article_result";
			} else if ("expert".equals(type)) {
				PageInfo pageInfo = LuceneUtil.queryByExpert(q, page, rows);
				model.addAttribute("page", pageInfo);
				model.addAttribute("experts", expertService.selectFirst10ByReadingQuantity());
				result = "expert_result";
			}
			//如果用户已经登录了，就保存到数据库
			TblUser user = (TblUser) session.getAttribute("user");
			if(user != null) {
				TblSearchHistory history = new TblSearchHistory();
				history.setSearchId(IDUtil.generateUUID());
				history.setSearchContent(q);
				history.setSearchTime(System.currentTimeMillis());
				history.setSearchType(type.equals("expert"));
				history.setUserId(user.getUserId());
				searchHistoryService.insert(history );
			}
		}
		model.addAttribute("q", q);
		model.addAttribute("type", type);
		return result;
	}
	
	/**
	 * 去主页
	 * @return
	 */
	@RequestMapping({ "", "index"})
	public String index() {
		return "index";
	}
	@RequestMapping("*")
	public ModelAndView to404() {
		ModelAndView result = new ModelAndView();
		result.setViewName("404");
		return result;
	}

}
