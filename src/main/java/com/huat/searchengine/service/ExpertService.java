package com.huat.searchengine.service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.IndexOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.lucene.Index;
import com.huat.searchengine.mapper.TblExpertMapper;
import com.huat.searchengine.utils.LuceneUtil;

/**
 * 博客专家Service
 * @author 史振忠
 *
 */
@Service
public class ExpertService {

	@Autowired
	private TblExpertMapper expertMapper;
    
    public void indexExpert() {
    	//另外开启一个线程来对数据建立索引
        new Thread(new InnerClass()).start();
    }
    private class InnerClass implements Runnable {

        public final FieldType TYPE_NOT_INDEX = new FieldType();
        public final FieldType TYPE_INDEX = new FieldType();
        public final FieldType TYPE_INDEX_TERM = new FieldType();

        private Logger logger = LoggerFactory.getLogger(getClass());

        private InnerClass() {
            TYPE_NOT_INDEX.setIndexOptions(IndexOptions.NONE);
            //是否分词
            TYPE_NOT_INDEX.setTokenized(false);
            //是否存储
            TYPE_NOT_INDEX.setStored(true);
            //阻止以后的改变
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
        	//查询出所有专家数据
            List<TblExpert> experts = expertMapper.selectByExample(null);
            if (index == null) {
                lock.lock();
                try {
                    if (index == null) {
                        index = LuceneUtil.newExpertIndex();
                    }
                } finally {
                    lock.unlock();
                }
            }

            long startTime = System.currentTimeMillis();
            for (int i=0;i<experts.size();i++) {
            	TblExpert expert = experts.get(i);
                Document doc = new Document();
                //字段名，字段值，字段类型
                doc.add(new Field("image", expert.getExpertAvatar(), TYPE_INDEX_TERM));
                //专家名称
                doc.add(new Field("name", expert.getExpertName(), TYPE_INDEX));
                //专家签名
                doc.add(new Field("sign", expert.getExpertSign(), TYPE_INDEX));
                //专家博客地址
                doc.add(new Field("url", expert.getBlogAddress(), TYPE_INDEX_TERM));
                //专家ID
                doc.add(new Field("expertid", expert.getExpertId(), TYPE_INDEX_TERM));
                index.update(expert.getBlogAddress(), doc);
                logger.info("{} create index successful",expert.getBlogAddress());
            }
            //关闭索引解析器
            if (index != null) {
                LuceneUtil.closeIndex();
            }
            logger.info("all expert create index successful");
            long endTime = System.currentTimeMillis();
            logger.info("共花费时间 " + (endTime - startTime) + "ms");
        }
    }
    
    public List<TblExpert> selectFirst10ByReadingQuantity() {
    	return expertMapper.selectFirst10ByReadingQuantity();
    }
    
    public TblExpert getExpertById(String expertId) {
    	return expertMapper.selectByPrimaryKey(expertId);
    }
    
    public List<TblExpert> selectExpertByEqualsAddress(String expertId,String address) {
    	return expertMapper.selectExpertByEqualsAddress(expertId, address);
    }
    
    /**
     * 查询出所有专家的博客地址
     * @return
     */
    public List<String> selectAllBlogAddress() {
    	return expertMapper.selectAllBlogAddress();
    }
    
    /**
     * 批量插入
     * @param expertList
     */
    public void insertBatch(List<TblExpert> expertList) {
    	expertMapper.insertBatch(expertList);
    }
    
    /**
     * 根据专家ID选择性的更新
     * @param expert
     */
    public void updateByPrimaryKeySelective(TblExpert expert) {
    	expertMapper.updateByPrimaryKeySelective(expert);
    }
}