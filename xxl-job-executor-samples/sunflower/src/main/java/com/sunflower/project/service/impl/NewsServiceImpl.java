package com.sunflower.project.service.impl;

import com.sunflower.project.dao.NewsMapper;
import com.sunflower.project.model.News;
import com.sunflower.project.service.NewsService;
import com.sunflower.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
@Service
@Transactional
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public News findNextById(Integer id) {
        return newsMapper.findNextById(id);
    }

    @Override
    public News findBeforeById(Integer id) {
        return newsMapper.findBeforeById(id);
    }
}
