package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.UserAccount;
import com.sunflower.project.service.UserAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/user/account")
public class UserAccountController {
    @Resource
    private UserAccountService userAccountService;

    @PostMapping("/add")
    public Result add(@RequestBody UserAccount userAccount) {
        userAccountService.save(userAccount);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody UserAccount userAccount) {
        userAccountService.deleteById(userAccount.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody UserAccount userAccount) {
        UserAccount userAccountDb = userAccountService.findById(userAccount.getId());
        return ResultGenerator.genSuccessResult(userAccountDb);
    }

    /*@PostMapping("/update")
    public Result update(@RequestBody UserAccount userAccount) {
        userAccountService.update(userAccount);
        return ResultGenerator.genSuccessResult();
    }*/

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<UserAccount> list = userAccountService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
