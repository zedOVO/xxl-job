package com.sunflower.project.configurer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import com.sunflower.project.Application;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 不使用嵌入式servlet
 * 使用外部web容器启动项目
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //此处的Application.class为带有@SpringBootApplication注解的启动类
        return builder.sources(Application.class);
    }

}
