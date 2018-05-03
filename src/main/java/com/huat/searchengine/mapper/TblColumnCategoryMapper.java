package com.huat.searchengine.mapper;

import com.huat.searchengine.entity.TblColumnCategory;
import com.huat.searchengine.entity.TblColumnCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblColumnCategoryMapper {
    long countByExample(TblColumnCategoryExample example);

    int deleteByExample(TblColumnCategoryExample example);

    int deleteByPrimaryKey(String categoryId);

    int insert(TblColumnCategory record);

    int insertSelective(TblColumnCategory record);

    List<TblColumnCategory> selectByExample(TblColumnCategoryExample example);

    TblColumnCategory selectByPrimaryKey(String categoryId);

    int updateByExampleSelective(@Param("record") TblColumnCategory record, @Param("example") TblColumnCategoryExample example);

    int updateByExample(@Param("record") TblColumnCategory record, @Param("example") TblColumnCategoryExample example);

    int updateByPrimaryKeySelective(TblColumnCategory record);

    int updateByPrimaryKey(TblColumnCategory record);
}