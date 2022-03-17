package com.sunflower.project.configurer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    //mysql数据库
    @Bean(name = "MysqlDataSource")
//    @Qualifier("MysqlDataSource")
    //使用指定前缀的数据库参数
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        //使用springboot中的DataSourceBuilder构建数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "MysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("MysqlDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

//    sunflower数据库
    //设置主连接 使用springboot的数据源构造器时多个数据源必须指定一个主数据源
    @Primary
    @Bean(name = "SunflowerDataSource")
//    @Qualifier("SunflowerDataSource")
    //使用指定前缀的数据库参数
    @ConfigurationProperties(prefix = "spring.datasource.mysql.sunflower")
    public DataSource sunflowerDataSource(){
        //使用springboot中的DataSourceBuilder构建数据源
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SunflowerJdbcTemplate")
    public JdbcTemplate sunflowerJdbcTemplate(@Qualifier("SunflowerDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }




}
