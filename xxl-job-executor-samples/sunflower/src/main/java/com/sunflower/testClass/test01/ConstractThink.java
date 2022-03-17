package com.sunflower.testClass.test01;


import java.util.HashMap;
import java.util.Map;

/**
 * 构造器和构造方法的区别
 */
public class ConstractThink {

    //构造方法
    public ConstractThink(String param){
        System.out.println("有参构造方法被创建");
    }


    /**
     * 有返回值的方法
     * @return
     */
    public String getConstract(String parms){
        System.out.println("getConstract方法被调用");
        return null;
    }

    /**
     * 无返回值方法
     */
    public void getConstractT(String params){
        System.out.println("无返回值方法别调用");
    }

    /**
     * 泛型的定义  public <T> 返回值类型  方法名 (参数类型 参数名)
     * @param params
     * @param <T>
     * @return
     */
    public <T extends String> T getKey(T params){
        return params;
    }

    public static void main(String[] args) {
//        ConstractThink ct  = new ConstractThink(    "1");
//        String s = ct.getKey("");
//        System.out.println(s);
    }


}
