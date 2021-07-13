package com.sunflower.project.service.impl;

import com.sunflower.project.dao.ContactMapper;
import com.sunflower.project.model.Contact;
import com.sunflower.project.service.ContactService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
@Service
@Transactional
public class ContactServiceImpl extends AbstractService<Contact> implements ContactService {
    @Resource
    private ContactMapper contactMapper;


}
