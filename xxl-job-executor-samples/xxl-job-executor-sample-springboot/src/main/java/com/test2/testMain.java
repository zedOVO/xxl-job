package com.test2;

public class testMain {

    public static void main(String[] args) {
        String s = "123!123!";
        String[] ss = s.split("!");
        System.out.println(ss[0]);
        System.out.println(ss[1]);
        System.out.println(ss.length);
//        System.out.println(ss[2] == null ? "" : ss[2]);
    }
}
