package com.huat.searchengine.utils;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

public class SpiderUtil {

	private static Spider spider = null;

	/**
	 * 根据指定解析器和管道创建一个爬虫
	 * @param pageProcessor
	 * @param pipeline
	 * @return
	 */
    public static Spider createSpider(PageProcessor pageProcessor, Pipeline pipeline) {
        if (spider == null) {
            spider = Spider.create(pageProcessor).setScheduler(new QueueScheduler()
                    .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
            		.addPipeline(pipeline);
            return spider;
        } else {
            return null;
        }
    }

    /**
     * 关闭爬虫
     */
    public static void closeSpider() {
        if (spider != null) {
            try {
                spider.close();
            } finally {
                spider = null;
            }
        }
    }
}
