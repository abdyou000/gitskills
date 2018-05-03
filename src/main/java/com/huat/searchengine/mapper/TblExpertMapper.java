package com.huat.searchengine.mapper;

import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.entity.TblExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblExpertMapper {
	// 查询与指定专家相同地址的专家
	List<TblExpert> selectExpertByEqualsAddress(@Param("expertId") String expertId, @Param("address") String address);

	// 得到阅读量前十的博主
	List<TblExpert> selectFirst10ByReadingQuantity();

	// 查询出所有专家的博客地址
	List<String> selectAllBlogAddress();

	// 批量插入
	void insertBatch(List<TblExpert> experts);

	long countByExample(TblExpertExample example);

	int deleteByExample(TblExpertExample example);

	int deleteByPrimaryKey(String expertId);

	int insert(TblExpert record);

	int insertSelective(TblExpert record);

	List<TblExpert> selectByExample(TblExpertExample example);

	TblExpert selectByPrimaryKey(String expertId);

	int updateByExampleSelective(@Param("record") TblExpert record, @Param("example") TblExpertExample example);

	int updateByExample(@Param("record") TblExpert record, @Param("example") TblExpertExample example);

	int updateByPrimaryKeySelective(TblExpert record);

	int updateByPrimaryKey(TblExpert record);
}