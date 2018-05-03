package com.huat.searchengine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huat.searchengine.entity.TblArticleCategory;
import com.huat.searchengine.entity.TblArticleCategoryExample;

public interface TblArticleCategoryMapper {
	//查询出所有分类地址
	List<String> selectAllCategoryAddress();
	//批量插入
	void insertBatch(List<TblArticleCategory> articleCategoryList);
	
    long countByExample(TblArticleCategoryExample example);

    int deleteByExample(TblArticleCategoryExample example);

    int deleteByPrimaryKey(String categoryId);

    int insert(TblArticleCategory record);

    int insertSelective(TblArticleCategory record);

    List<TblArticleCategory> selectByExample(TblArticleCategoryExample example);

    TblArticleCategory selectByPrimaryKey(String categoryId);

    int updateByExampleSelective(@Param("record") TblArticleCategory record, @Param("example") TblArticleCategoryExample example);

    int updateByExample(@Param("record") TblArticleCategory record, @Param("example") TblArticleCategoryExample example);

    int updateByPrimaryKeySelective(TblArticleCategory record);

    int updateByPrimaryKey(TblArticleCategory record);
}