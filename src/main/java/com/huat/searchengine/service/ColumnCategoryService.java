package com.huat.searchengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huat.searchengine.entity.TblColumnCategory;
import com.huat.searchengine.mapper.TblColumnCategoryMapper;

@Service
public class ColumnCategoryService {

	@Autowired
	private TblColumnCategoryMapper columnCategoryMapper;

	public void insertSelective(TblColumnCategory columnCategory) {
		columnCategoryMapper.insertSelective(columnCategory);
	}

}
