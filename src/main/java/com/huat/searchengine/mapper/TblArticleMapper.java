package com.huat.searchengine.mapper;

import com.huat.searchengine.entity.TblArticle;
import com.huat.searchengine.entity.TblArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblArticleMapper {
	//得到指定专家浏览量前十的文章
	List<TblArticle> selectByExpertIdLimit(String expertId);
		//得到浏览量前十的文章
	List<TblArticle> selectFirst10ByBrowseQuantity();
	void updateCategory(@Param("record") TblArticle record, @Param("example") TblArticleExample example);
	// 批量插入
	void insertBatch(List<TblArticle> articles);

	long countByExample(TblArticleExample example);

	int deleteByExample(TblArticleExample example);

	int deleteByPrimaryKey(String articleId);

	int insert(TblArticle record);

	int insertSelective(TblArticle record);

	List<TblArticle> selectByExample(TblArticleExample example);

	TblArticle selectByPrimaryKey(String articleId);

	int updateByExampleSelective(@Param("record") TblArticle record, @Param("example") TblArticleExample example);

	int updateByExample(@Param("record") TblArticle record, @Param("example") TblArticleExample example);

	int updateByPrimaryKeySelective(TblArticle record);

	int updateByPrimaryKey(TblArticle record);
}