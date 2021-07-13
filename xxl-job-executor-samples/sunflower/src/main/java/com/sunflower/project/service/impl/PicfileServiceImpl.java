package com.sunflower.project.service.impl;

import com.sunflower.project.dao.PicfileMapper;
import com.sunflower.project.model.Picfile;
import com.sunflower.project.service.PicfileService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/24.
 */
@Service
@Transactional
public class PicfileServiceImpl extends AbstractService<Picfile> implements PicfileService {
    @Resource
    private PicfileMapper picfileMapper;

}
