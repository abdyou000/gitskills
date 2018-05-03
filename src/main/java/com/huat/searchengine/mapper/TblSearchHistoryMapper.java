package com.huat.searchengine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.huat.searchengine.entity.TblSearchHistory;
import com.huat.searchengine.entity.TblSearchHistoryExample;

public interface TblSearchHistoryMapper {
	//根据用户搜索历史记录按时间排序去前十条
	List<TblSearchHistory> getHistoryByUserIdLimit10(@Param("userId")String userId,@Param("content")String content);
    long countByExample(TblSearchHistoryExample example);

    int deleteByExample(TblSearchHistoryExample example);

    int deleteByPrimaryKey(String searchId);

    int insert(TblSearchHistory record);

    int insertSelective(TblSearchHistory record);

    List<TblSearchHistory> selectByExample(TblSearchHistoryExample example);

    TblSearchHistory selectByPrimaryKey(String searchId);

    int updateByExampleSelective(@Param("record") TblSearchHistory record, @Param("example") TblSearchHistoryExample example);

    int updateByExample(@Param("record") TblSearchHistory record, @Param("example") TblSearchHistoryExample example);

    int updateByPrimaryKeySelective(TblSearchHistory record);

    int updateByPrimaryKey(TblSearchHistory record);
}