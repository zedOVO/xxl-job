package com.xxl.job.executor.core.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {



    /**
     * 构建mybatisSqlSessionFactory工厂
     * @return sqlSessionFactory
     * @throws Exception 异常
     */
    @Bean(name = "sqlSessionFactoryA")
    public SqlSessionFactory GenSqlSessionFactory(@Autowired HikariDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xxl.job.executor.mvc.pojo");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml")
        );
        return sqlSessionFactoryBean.getObject();
    }


    /**
     * 配置mapper接口的动态代理扫描
     * @return 
     */
    @Bean("mapperScannerConfigurerA")
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.xxl.job.executor.mvc.dao");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryA");
        return configurer;
    }

}
