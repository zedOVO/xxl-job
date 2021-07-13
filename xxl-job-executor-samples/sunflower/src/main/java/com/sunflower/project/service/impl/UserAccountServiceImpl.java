package com.sunflower.project.service.impl;

import com.sunflower.project.dao.UserAccountMapper;
import com.sunflower.project.model.UserAccount;
import com.sunflower.project.service.UserAccountService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
@Service
@Transactional
public class UserAccountServiceImpl extends AbstractService<UserAccount> implements UserAccountService {
    @Resource
    private UserAccountMapper userAccountMapper;

}
