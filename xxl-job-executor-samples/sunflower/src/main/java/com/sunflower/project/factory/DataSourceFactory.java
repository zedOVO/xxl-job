package com.sunflower.project.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * JDBCTemplate对象初始化  注入枚举类中所有配置的数据源(AllDataSource.java)
 */
@Component
public class DataSourceFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    private Map<String,JdbcTemplate> templateMap ;


    /**
     * 只允许初始化调用,不允许私自调用
     */
    @PostConstruct
    private void init(){
        if (templateMap == null){
            templateMap = new HashMap<>();
            for (AllDataSource dataSource : AllDataSource.values()){
                JdbcTemplate o = (JdbcTemplate) applicationContext.getBean(dataSource.getSourceName());
                templateMap.put(dataSource.getSourceName(),o);
            }
            //去重
            this.templateMap = new LinkedHashMap<>(templateMap);
        }

    }

    public JdbcTemplate getJdbcTemplate(AllDataSource dataSource){
        return templateMap.get(dataSource.getSourceName());
    }


    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
