package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.Contact;
import com.sunflower.project.service.ContactService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Resource
    private ContactService contactService;

    @PostMapping("/add")
    public Result add(@RequestBody Contact contact) {
        contactService.save(contact);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Contact contact) {
        contactService.deleteById(contact.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody Contact contact) {
        Contact contactDb = contactService.findById(contact.getId());
        return ResultGenerator.genSuccessResult(contactDb);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Contact contact) {
        contactService.update(contact);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Contact> list = contactService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
