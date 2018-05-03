package com.huat.searchengine.mapper;

import com.huat.searchengine.entity.TblColumn;
import com.huat.searchengine.entity.TblColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblColumnMapper {
    long countByExample(TblColumnExample example);

    int deleteByExample(TblColumnExample example);

    int deleteByPrimaryKey(String columnId);

    int insert(TblColumn record);

    int insertSelective(TblColumn record);

    List<TblColumn> selectByExample(TblColumnExample example);

    TblColumn selectByPrimaryKey(String columnId);

    int updateByExampleSelective(@Param("record") TblColumn record, @Param("example") TblColumnExample example);

    int updateByExample(@Param("record") TblColumn record, @Param("example") TblColumnExample example);

    int updateByPrimaryKeySelective(TblColumn record);

    int updateByPrimaryKey(TblColumn record);
}