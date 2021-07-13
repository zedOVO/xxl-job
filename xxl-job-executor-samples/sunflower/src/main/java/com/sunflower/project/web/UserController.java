package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.User;
import com.sunflower.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody User user) {
        userService.deleteById(user.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody User user) {
        User userDb = userService.findById(user.getId());
        return ResultGenerator.genSuccessResult(userDb);
    }

    /*@PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }*/

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
