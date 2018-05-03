package com.huat.searchengine.pipeline;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huat.searchengine.entity.TblArticle;
import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.service.ArticleCategoryService;
import com.huat.searchengine.service.ArticleService;
import com.huat.searchengine.service.ExpertService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class ArticlePipeline implements Pipeline {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ExpertService expertService;
	

	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		// 得到作用域中的所有值
		TblExpert expert = (TblExpert) map.get("expert");
		List<TblArticle> articleList = (List<TblArticle>) map.get("articleList");
		

		if (expert != null) {
			// 进入到这里表示是专家个人中心页面或博客首页，更新专家数据
			expertService.updateByPrimaryKeySelective(expert);
		}
		if (CollectionUtils.isNotEmpty(articleList)) {
			articleService.insertBatch(articleList);
		}
		
		
	}
}
