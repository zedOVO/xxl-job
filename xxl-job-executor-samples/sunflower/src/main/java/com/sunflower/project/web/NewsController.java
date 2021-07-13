package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.News;
import com.sunflower.project.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    @PostMapping("/add")
    public Result add(@RequestBody News news) {
        newsService.save(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody News news) {
        newsService.deleteById(news.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody News news) {
        News newsDb = newsService.findById(news.getId());
        return ResultGenerator.genSuccessResult(newsDb);
    }

    @PostMapping("/update")
    public Result update(@RequestBody News news) {
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<News> list = newsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
