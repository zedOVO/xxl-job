package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.Picfile;
import com.sunflower.project.service.PicfileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/picfile")
public class PicfileController {
    @Resource
    private PicfileService picfileService;

    @PostMapping("/add")
    public Result add(@RequestBody Picfile picfile) {
        picfileService.save(picfile);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Picfile picfile) {
        picfileService.deleteById(picfile.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody Picfile picfile) {
        Picfile picfileDb = picfileService.findById(picfile.getId());
        return ResultGenerator.genSuccessResult(picfileDb);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Picfile picfile) {
        picfileService.update(picfile);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Picfile> list = picfileService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
