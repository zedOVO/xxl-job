package com.sunflower.project.web;
import com.sunflower.project.core.Result;
import com.sunflower.project.request.Request;
import com.sunflower.project.core.ResultGenerator;
import com.sunflower.project.model.Product;
import com.sunflower.project.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/24.
*/
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        productService.save(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Product product) {
        productService.deleteById(product.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail1(@RequestBody Product product) {
        Product productDb = productService.findById(product.getId());
        return ResultGenerator.genSuccessResult(productDb);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Product product) {
        productService.update(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Request request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Product> list = productService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
