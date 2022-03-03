package com.aop;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {

    public static String getNowDate(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}
