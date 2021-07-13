package com.sunflower.project.service.impl;

import com.sunflower.project.dao.UserMapper;
import com.sunflower.project.model.User;
import com.sunflower.project.service.UserService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
