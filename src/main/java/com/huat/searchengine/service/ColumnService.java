package com.huat.searchengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huat.searchengine.entity.TblColumn;
import com.huat.searchengine.mapper.TblColumnMapper;

@Service
public class ColumnService {

	@Autowired
	private TblColumnMapper columnMapper;

	public void insertSelective(TblColumn column) {
		columnMapper.insertSelective(column);
	}

}
