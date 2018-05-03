package com.huat.searchengine.pipeline;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huat.searchengine.entity.TblExpert;
import com.huat.searchengine.service.ExpertService;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class ExpertPipeline implements Pipeline {
    @Autowired
    private ExpertService expertService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        //从结果域中取出博客专家的各种属性集合
        Map<String,Object> map = resultItems.getAll();
        List<TblExpert> expertList = (List<TblExpert>)map.get("expertList");
        //批量插入
        expertService.insertBatch(expertList);
    }
}
