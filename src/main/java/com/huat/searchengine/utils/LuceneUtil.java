package com.huat.searchengine.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.springframework.util.ResourceUtils;

import com.huat.searchengine.dto.PageInfo;
import com.huat.searchengine.lucene.IKAnalyzer5x;
import com.huat.searchengine.lucene.Index;


public class LuceneUtil {
    public static final String INDEX_PATH = "D:/lucene/index";
    private static final Analyzer ANALYZER = new IKAnalyzer5x(true);
    private static int count = 0;
    private static Index index = null;


    /**
     * 索引数据
     */
    public synchronized static Index newBlogIndex() {
        try {
            count++;
            if (index != null) {
                return index;
            }
            String path = ResourceUtils.getFile(INDEX_PATH + "/article").getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            Directory dictionary = new SimpleFSDirectory(FileSystems.getDefault().getPath(path));
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(ANALYZER);
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            IndexWriter indexWriter = new IndexWriter(dictionary, indexWriterConfig);
            index = new Index(indexWriter, dictionary);
            return index;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 索引数据
     */
    public synchronized static Index newExpertIndex() {
        try {
            count++;
            if (index != null) {
                return index;
            }
            String path = ResourceUtils.getFile(INDEX_PATH + "/expert").getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            Directory dictionary = new SimpleFSDirectory(FileSystems.getDefault().getPath(path));
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(ANALYZER);
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            IndexWriter indexWriter = new IndexWriter(dictionary, indexWriterConfig);
            index = new Index(indexWriter, dictionary);
            return index;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 关闭索引
     */
    public synchronized static void closeIndex() {
        if (index != null) {
            count--;
            if (count < 1) {
                index.close();
                index = null;
                count = 0;
            }
        }
    }

    /**
     * 查询博客
     *
     * @param q
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static PageInfo queryByArticle(String q, int pageNum, int pageSize) {
        try {
            String path = ResourceUtils.getFile(INDEX_PATH + "/article").getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            Directory dictionary = new SimpleFSDirectory(FileSystems.getDefault().getPath(path));
            DirectoryReader reader = DirectoryReader.open(dictionary);
            IndexSearcher searcher = new IndexSearcher(reader);
            //多字段查询
            QueryParser parser = new MultiFieldQueryParser(new String[]{"title","desc"},ANALYZER);
            Query query = parser.parse(q);
            TopDocs topDocs = searcher.search(query, (pageNum + 1) * pageSize);
            //以下代码对查询结果进行高亮显示
            //此处加入的是搜索结果的高亮部分
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>","</font>"); //如果不指定参数的话，默认是加粗，即<b><b/>
            QueryScorer scorer = new QueryScorer(query);//计算得分，会初始化一个查询结果最高的得分
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer); //根据这个得分计算出一个片段
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter); //设置一下要显示的片段

            ScoreDoc[] hits = topDocs.scoreDocs;
            Integer total = topDocs.totalHits;
            List<Map<String, String>> result = new ArrayList<Map<String, String>>();
            int start = (pageNum - 1) * pageSize;
            int end = start + pageSize;
            for (int i = start; i < end && i < total; i++) {
                Map<String, String> map = new HashMap<String, String>();
                Document hitDoc = searcher.doc(hits[i].doc);

                String title = hitDoc.get("title");
                String desc = hitDoc.get("desc");
                // 1. 关键词添加高亮
//                TokenStream tokenStream1 = ANALYZER.tokenStream("title", new StringReader(title));
//                TokenStream tokenStream2 = ANALYZER.tokenStream("content", new StringReader(content));
                String titleHighLight = highlighter.getBestFragment(ANALYZER,"title", title);
                String descHighLight = highlighter.getBestFragment(ANALYZER,"desc", desc);
                // 2. 将高亮的结果再次封装到document对象中
                if (StringUtils.isNotBlank(titleHighLight)) {
                    ((Field)hitDoc.getField("title")).setStringValue(titleHighLight);
                }
                if (StringUtils.isNotBlank(descHighLight)) {
                    ((Field)hitDoc.getField("desc")).setStringValue(descHighLight);
                }

                for (Iterator<IndexableField> iter = hitDoc.iterator(); iter.hasNext(); ) {
                    IndexableField field = iter.next();
                    String value = field.stringValue();
                    if (field.name().equals("desc")) {
                        value = value
                                .replaceAll("&", "&amp;")
                                .replaceAll(">", "&gt;")
                                .replaceAll("<", "&lt;")
                                .replaceAll("&lt;font color='red'&gt;","<font color='red'>")
                                .replaceAll("&lt;/font&gt;","</font>");
                    }
                    map.put(field.name(), value);
                }
                result.add(map);
            }
            reader.close();
            dictionary.close();
            return new PageInfo(result, pageNum, pageSize, total, 8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询博客
     *
     * @param q
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static PageInfo queryByExpert(String q, int pageNum, int pageSize) {
        try {
            String path = ResourceUtils.getFile(INDEX_PATH + "/expert").getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            Directory dictionary = new SimpleFSDirectory(FileSystems.getDefault().getPath(path));
            DirectoryReader reader = DirectoryReader.open(dictionary);
            IndexSearcher searcher = new IndexSearcher(reader);
//            QueryParser parser = new QueryParser("content", ANALYZER);
            //多字段查询
            QueryParser parser = new QueryParser("name",ANALYZER);
            Query query = parser.parse(q);
            TopDocs topDocs = searcher.search(query, (pageNum + 1) * pageSize);
            //以下代码对查询结果进行高亮显示
            //此处加入的是搜索结果的高亮部分
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>","</font>"); //如果不指定参数的话，默认是加粗，即<b><b/>
            QueryScorer scorer = new QueryScorer(query);//计算得分，会初始化一个查询结果最高的得分
            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer); //根据这个得分计算出一个片段
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
            highlighter.setTextFragmenter(fragmenter); //设置一下要显示的片段

            ScoreDoc[] hits = topDocs.scoreDocs;
            Integer total = topDocs.totalHits;
            List<Map<String, String>> result = new ArrayList<Map<String, String>>();
            int start = (pageNum - 1) * pageSize;
            int end = start + pageSize;
            for (int i = start; i < end && i < total; i++) {
                Map<String, String> map = new HashMap<String, String>();
                Document hitDoc = searcher.doc(hits[i].doc);

                String nickName = hitDoc.get("name");
                // 1. 关键词添加高亮
                String nickNameHighLight = highlighter.getBestFragment(ANALYZER,"name", nickName);
                // 2. 将高亮的结果再次封装到document对象中
                if (StringUtils.isNotBlank(nickNameHighLight)) {
                    ((Field)hitDoc.getField("name")).setStringValue(nickNameHighLight);
                }

                for (Iterator<IndexableField> iter = hitDoc.iterator(); iter.hasNext(); ) {
                    IndexableField field = iter.next();
                    String value = field.stringValue();
                    map.put(field.name(), value);
                }
                result.add(map);
            }
            reader.close();
            dictionary.close();
            return new PageInfo(result, pageNum, pageSize, total, 8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
