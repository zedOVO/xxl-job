package com.sunflower.project.dao;

import com.sunflower.project.core.Mapper;
import com.sunflower.project.model.News;

public interface NewsMapper extends Mapper<News> {
    News findNextById(Integer id);
    News findBeforeById(Integer id);
}