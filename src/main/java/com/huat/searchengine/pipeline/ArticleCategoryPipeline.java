package com.huat.searchengine.pipeline;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.service.ArticleCategoryService;
import com.huat.searchengine.service.ArticleService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class ArticleCategoryPipeline implements Pipeline {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleCategoryService articleCategoryService;
	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		// 得到作用域中的所有值
		List<String> hotArticleIdList = (List<String>) map.get("hotArticleIdList");
		List<String> categoryArticleIdList = (List<String>) map.get("categoryArticleIdList");
		List<TblArticleCategory> articleCategoryList = (List<TblArticleCategory>) map.get("articleCategoryList");

		String categoryId = (String) map.get("categoryId");
		
		if (CollectionUtils.isNotEmpty(articleCategoryList)) {
			articleCategoryService.insertBatch(articleCategoryList);
		}
		if (CollectionUtils.isNotEmpty(hotArticleIdList)) {
			articleService.updateHot(hotArticleIdList);
		}
		if (CollectionUtils.isNotEmpty(categoryArticleIdList)) {
			articleService.updateCategory(categoryArticleIdList, categoryId);
		}
		
	}
}
