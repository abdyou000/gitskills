package com.huat.searchengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huat.searchengine.entity.TblSearchHistory;
import com.huat.searchengine.entity.TblSearchHistoryExample;
import com.huat.searchengine.entity.TblSearchHistoryExample.Criteria;
import com.huat.searchengine.mapper.TblSearchHistoryMapper;

/** 
 * @date 2018年5月1日 
 * 
 * @author 史振忠 
 * 
 * @Description: TODO  
 * 
 **/
@Service
public class SearchHistoryService {

	@Autowired
	private TblSearchHistoryMapper searchHistoryMapper;
	
	public void insert(TblSearchHistory history) {
		searchHistoryMapper.insert(history);
	}
	
	public List<TblSearchHistory> getHistoryByExpertId(String userId,String content) {
		List<TblSearchHistory> historyList = searchHistoryMapper.getHistoryByUserIdLimit10(userId, content);
		return historyList;
	}
}
  