package com.sunflower.project.service;
import com.sunflower.project.model.News;
import com.sunflower.project.core.Service;


/**
 * Created by CodeGenerator on 2019/11/21.
 */
public interface NewsService extends Service<News> {
    News findNextById(Integer id);
    News findBeforeById(Integer id);
}
