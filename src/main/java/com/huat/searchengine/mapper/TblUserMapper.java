package com.huat.searchengine.mapper;

import com.huat.searchengine.entity.TblUser;
import com.huat.searchengine.entity.TblUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserMapper {
    long countByExample(TblUserExample example);

    int deleteByExample(TblUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    List<TblUser> selectByExample(TblUserExample example);

    TblUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}