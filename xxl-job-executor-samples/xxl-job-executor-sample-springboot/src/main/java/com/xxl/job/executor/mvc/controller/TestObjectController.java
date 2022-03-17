package com.xxl.job.executor.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class TestObjectController {

    @Autowired
    private BeanFactory beanFactory;

    Logger logger = LoggerFactory.getLogger(TestObjectController.class);

    @PostMapping("/testInvokeMethod.do")
    public String invokeMethod(@RequestBody(required = false) String comment,
                               HttpServletRequest request
                               ) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        TestObjectController clazz = TestObjectController.class.newInstance();
        Object obj =beanFactory.getBean(TestObjectController.class);
        Method method = obj.getClass().getMethod("testInvokeMethod",Object.class);
        method.invoke(obj,comment);
        return comment;
    }

    public <T> T testInvokeMethod(T t){
        if (t instanceof String){
            logger.info(t.toString());
        }
        return t;
    }
}
