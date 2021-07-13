package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.Recruit;
import com.sunflower.project.service.RecruitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/29.
*/
@RestController
@RequestMapping("/api/recruit")
public class RecruitController {
    @Resource
    private RecruitService recruitService;

    @PostMapping("/add")
    public Result add(@RequestBody Recruit recruit) {
        recruitService.save(recruit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Recruit recruit) {
        recruitService.deleteById(recruit.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody Recruit recruit) {
        Recruit recruitDb = recruitService.findById(recruit.getId());
        return ResultGenerator.genSuccessResult(recruitDb);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Recruit recruit) {
        recruitService.update(recruit);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Recruit> list = recruitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
