package com.sunflower.project.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 公共方法类
 */
@Component
public class PublicVoid {
//    public Object invokeSet(Object  o){
//        Class clazz = o.getClass();
//        Method[] methods =clazz.getMethods();
//        for (Method method : methods){
//
//        }
//        return  null;
//    }

    /**
     * 获取当前时间
     * @param pattern 时间格式
     * @return 当前时间字符串
     */
    public String getCurrentDate(String pattern){
        return new SimpleDateFormat().format(new Date());
    }
}
