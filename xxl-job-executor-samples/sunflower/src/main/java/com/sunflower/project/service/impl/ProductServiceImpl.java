package com.sunflower.project.service.impl;

import com.sunflower.project.dao.ProductMapper;
import com.sunflower.project.model.Product;
import com.sunflower.project.service.ProductService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;

}
