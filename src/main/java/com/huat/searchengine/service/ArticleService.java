package com.huat.searchengine.service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections.CollectionUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.huat.searchengine.entity.TblArticle;
import com.huat.searchengine.entity.TblArticleExample;
import com.huat.searchengine.entity.TblArticleExample.Criteria;
import com.huat.searchengine.lucene.Index;
import com.huat.searchengine.mapper.TblArticleMapper;
import com.huat.searchengine.utils.LuceneUtil;

@Service
public class ArticleService {

	@Autowired
	private TblArticleMapper articleMapper;

	/**
	 * 对数据库中所有文章建立索引
	 */
	public void indexArticle() {
		new Thread(new InnerClass()).start();
	}

	private class InnerClass implements Runnable {

		public final FieldType TYPE_NOT_INDEX = new FieldType();
		public final FieldType TYPE_INDEX = new FieldType();
		public final FieldType TYPE_INDEX_TERM = new FieldType();

		private Logger logger = LoggerFactory.getLogger(getClass());

		private InnerClass() {
			TYPE_NOT_INDEX.setIndexOptions(IndexOptions.NONE);
			TYPE_NOT_INDEX.setTokenized(false);
			TYPE_NOT_INDEX.setStored(true);
			TYPE_NOT_INDEX.freeze();

			TYPE_INDEX.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
			TYPE_INDEX.setTokenized(true);
			TYPE_INDEX.setStored(true);
			TYPE_INDEX.freeze();

			TYPE_INDEX_TERM.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
			TYPE_INDEX_TERM.setTokenized(true);
			TYPE_INDEX_TERM.setStored(true);
			TYPE_INDEX_TERM.setStoreTermVectors(true);
			TYPE_INDEX_TERM.freeze();
		}

		private final ReentrantLock lock = new ReentrantLock();
		private Index index;

		@Override
		public void run() {
			if (index == null) {
				lock.lock();
				try {
					if (index == null) {
						index = LuceneUtil.newBlogIndex();
					}
				} finally {
					lock.unlock();
				}
			}
			long startTime = System.currentTimeMillis();
			// 使用pagehelper分页插件，每次查询1000条记录
			int pageNum = 1;
			while (true) {
				PageHelper.startPage(pageNum, 2000);
				List<TblArticle> articles = articleMapper.selectByExample(null);
				if (CollectionUtils.isEmpty(articles)) {
					break;
				}
				for (int i = 0; i < articles.size(); i++) {
					TblArticle article = articles.get(i);
					Document doc = new Document();
					doc.add(new Field("title", article.getArticleTitle(), TYPE_NOT_INDEX));
					doc.add(new Field("url", article.getArticleAddress(), TYPE_INDEX_TERM));
					doc.add(new Field("desc", article.getArticleDesc(), TYPE_INDEX));
					index.update(article.getArticleAddress(), doc);
					logger.info("{} create index successful", article.getArticleAddress());
				}
				pageNum++;
			}
			if (index != null) {
				LuceneUtil.closeIndex();
			}
			logger.info("all blog create index successful");
			long endTime = System.currentTimeMillis();
			logger.info("共花费时间 " + (endTime - startTime) + "ms");//共花费时间 1583457ms 26min
		}
	}

	/**
	 * 批量插入
	 * 
	 * @param articleList
	 */
	public void insertBatch(List<TblArticle> articleList) {
		articleMapper.insertBatch(articleList);
	}

	/**
	 * 更新文章为热门文章
	 * 
	 * @param article
	 * @param example
	 */
	public void updateHot(List<String> hotArticleAddressList) {
		TblArticle article = new TblArticle();
		article.setHot(true);
		TblArticleExample example = new TblArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andArticleIdIn(hotArticleAddressList);
		articleMapper.updateByExampleSelective(article, example);
	}

	/**
	 * 更新文章所属分类
	 * 
	 * @param categoryArticleAddressList
	 */
	public void updateCategory(List<String> categoryArticleAddressList, String categoryId) {
		TblArticle article = new TblArticle();
		article.setCategoryId(categoryId);
		TblArticleExample example = new TblArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andArticleIdIn(categoryArticleAddressList);
		articleMapper.updateCategory(article, example);
	}

	/**
	 * 更新文章所属专栏
	 * 
	 * @param columnArticleAddressList
	 * @param columnId
	 */
	public void updateColumn(List<String> columnArticleAddressList, String columnId) {
		TblArticle article = new TblArticle();
		article.setColumnId(columnId);
		TblArticleExample example = new TblArticleExample();
		Criteria criteria = example.createCriteria();
		criteria.andArticleIdIn(columnArticleAddressList);
		articleMapper.updateByExampleSelective(article, example);
	}

	public List<TblArticle> selectFirst10ByBrowseQuantity() {
		return articleMapper.selectFirst10ByBrowseQuantity();
	}

	public List<TblArticle> findFirst10ByExpertIdAndBrowseQuantity(String expertId) {
		return articleMapper.selectByExpertIdLimit(expertId);
	}
}
