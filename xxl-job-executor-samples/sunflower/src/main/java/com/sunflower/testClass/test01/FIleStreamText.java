package com.sunflower.testClass.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 2020 11。09 FileInputStream 熟悉
 * 过程 1。先创建一个需要读取的file文件对象,再去通过FileInputStream 的构造器转换成FileInputStream对象
 * 2.通过FileInputStream对象的read方法 读取文件中的字节  后续根据字节转换成String类型对象  再打印到控制台  这样就读取文本内容成功
 */
public class FIleStreamText {
    public static void main(String[] args) throws IOException {
        String filePath =  "E:\\test\\";
        String fileName = "in.txt";
        File file = new File(filePath+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte [] b = new byte[1 * 1024];
        int i = 0;
        // 变量i读取到的是每次读到的字节数    byte数组b是每次读到的字节
        while((i = inputStream.read(b) )!= -1){
            //转成String类型 byte字节
            System.out.println(new String(b,0,i));
        }
    }
}
