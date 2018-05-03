package com.huat.searchengine.pipeline;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huat.searchengine.entity.TblColumn;
import com.huat.searchengine.entity.TblColumnCategory;
import com.huat.searchengine.service.ArticleService;
import com.huat.searchengine.service.ColumnCategoryService;
import com.huat.searchengine.service.ColumnService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class ColumnPipeline implements Pipeline {
	@Autowired
	private ColumnService columnService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ColumnCategoryService columnCategoryService;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		// 得到作用域中的所有值
		List<String> columnArticleIdList = (List<String>) map.get("columnArticleIdList");
		String columnId = (String) map.get("columnId");
		TblColumn column = (TblColumn) map.get("column");
		TblColumnCategory columnCategory = (TblColumnCategory) map.get("columnCategory");
		
		if(column != null) {
			columnService.insertSelective(column);
		}
		if (CollectionUtils.isNotEmpty(columnArticleIdList)) {
			articleService.updateColumn(columnArticleIdList, columnId);
		}
		if(columnCategory != null) {
			columnCategoryService.insertSelective(columnCategory);
		}
	}
}
