package com.sunflower.project.service.impl;

import com.sunflower.project.dao.RecruitMapper;
import com.sunflower.project.model.Recruit;
import com.sunflower.project.service.RecruitService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/29.
 */
@Service
@Transactional
public class RecruitServiceImpl extends AbstractService<Recruit> implements RecruitService {
    @Resource
    private RecruitMapper recruitMapper;

}
