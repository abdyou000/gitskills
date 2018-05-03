package com.huat.searchengine.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.entity.TblArticleCategoryExample;
import com.huat.searchengine.entity.TblArticleCategoryExample.Criteria;
import com.huat.searchengine.mapper.TblArticleCategoryMapper;

@Service
public class ArticleCategoryService {
	
	@Autowired
	private TblArticleCategoryMapper articleCategoryMapper;
	
	/**
	 * 批量插入
	 * @param articleCategoryList
	 */
	public void insertBatch(List<TblArticleCategory> articleCategoryList) {
		articleCategoryMapper.insertBatch(articleCategoryList);
	}
	
	/**
	 * 查询出所有分类地址
	 * @return
	 */
	public List<String> selectAllCategoryAddress() {
		return articleCategoryMapper.selectAllCategoryAddress();
	}
	
	public List<String> getAllCategoryNames(String expertId) {
		TblArticleCategoryExample example = new TblArticleCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andExpertIdEqualTo(expertId);
		List<TblArticleCategory> categoryList = articleCategoryMapper.selectByExample(example );
		List<String> categoryNameList = categoryList.stream().map(x -> x.getCategoryName()).collect(Collectors.toList());
	
		return categoryNameList;
	}
}
