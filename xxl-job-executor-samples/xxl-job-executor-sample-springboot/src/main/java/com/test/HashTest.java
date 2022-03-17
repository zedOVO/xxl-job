package com.test;


import org.w3c.dom.Node;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;



public class HashTest {

//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("t1","v1");
//        map.put("t2","v1");
//        map.put("t3","v1");
//        System.out.println(map.hashCode());
//        System.out.println("======================");
//        Map<String, String> map2 = map;
//        map2.put("t4","v1");
//        System.out.println(map2.hashCode());
//        map.keySet().stream().forEach(System.out::println);
////        System.out.println(map == map2);
////        System.out.println(map.equals(map2));
//
//        List<Integer> arrays = Arrays.asList(100,200,300,400,-111,-222);
//        System.out.println(arrays.stream().max((a,b)-> a>b?1:-1).get());
//
//        List<Person> list = new ArrayList<>();
//        list.add(new Person(20,"test1","19990101",1));
//        list.add(new Person(30,"test2","19910101",1));
//        list.add(new Person(25,"test3","19380101",1));
//        list.add(new Person(35,"test4","19870101",1));
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
//        int year = Integer.parseInt(simpleDateFormat.format(new Date()));
//
//        List<Person> listFilter = new ArrayList<>();
//        list.stream().forEach((a)->{
//            if (year - Integer.parseInt(a.birthday.substring(0,4)) != a.age){
//                listFilter.add(a);
//            }
//        });
//        listFilter.stream().forEach((a) ->{
//            System.out.println("a.sex:"+(a.sex == 1 ? "男": "女"));
//            System.out.println("a.age:"+a.age);
//            System.out.println("a.birthday:"+a.birthday);
//            System.out.println("a.name:"+a.name);
//        });
//    }

    public static void main(String[] args) {
        String str = "333";
        String str1 = new String("222");
        String str2 = new String("222");
//        str1 = str;
//        str2 = str;
        //str1是重新构建的一个实例、而str2是个引用对象两个对象没有指向同一个内存地址，所以结果为false
        System.out.println(str2 == str1);
        //equals方法比对的是两个对象的值是否相同，所以结果为true
        System.out.println(str2.equals(str1));
    }

    public static int getMaxArray(Supplier<Integer> supplier){
        return supplier.get();
    }
}
