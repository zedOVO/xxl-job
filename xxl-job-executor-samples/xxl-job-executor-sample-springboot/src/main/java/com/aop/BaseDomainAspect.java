package com.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

@Aspect
@Repository
public class BaseDomainAspect {

    @Before("execution(public * com.aop.*.add*(..)) && args(baseDomain,..)" )
    public void appendCreateInfo(BaseDomain baseDomain){
        if (baseDomain == null){
            return;
        }

        System.out.println("添加创建人信息");
        baseDomain.setCreateDate();
        baseDomain.setCreateUser("操作员1");
        System.out.println(baseDomain.toString());
    }
}
