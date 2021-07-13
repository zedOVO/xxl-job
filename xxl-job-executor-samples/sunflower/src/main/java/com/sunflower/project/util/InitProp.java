package com.sunflower.project.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class InitProp {
   static  {
        init();
    }
    public static Map<String,String> allKey = new HashMap<>();



    public  static void init(){
        Properties properties = new Properties();
        Map<String,String> map = new HashMap<>();
        InputStream in = null;
        try {
            in = InitProp.class.getResourceAsStream("/application.properties");
            properties.load(in);
        }catch (FileNotFoundException e){
            System.out.println("未找到需要加载的配置文件"+InitProp.class.getPackage());
        }catch (IOException e ){
            e.printStackTrace();
        }
        Set<Object> propSet = properties.keySet();
        Iterator iterator = propSet.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            map.put(key,properties.getProperty(key));
        }
        allKey = map;
    }
}
