package com.sunflower.project.configurer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //mysql数据库
    @Bean(name = "MysqlDataSource")
    @Qualifier("MysqlDataSource")
    //使用指定前缀的数据库参数
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        //使用springboot中的DataSourceBuilder构建数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("MysqlDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
