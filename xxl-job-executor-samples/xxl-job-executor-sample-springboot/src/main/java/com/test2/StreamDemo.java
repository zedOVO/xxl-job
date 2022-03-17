package com.test2;

import java.io.*;

public class StreamDemo {
    public static void main(String[] args) throws IOException {
        //文件中的内容为0123456789
        InputStream input = new FileInputStream("/Users/zed/Java/logs/1.txt");
        File file = new File("/Users/zed/Java/logs/2.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream out = new FileOutputStream(file);
        byte[] buffer = new byte[3];
        int count = 0;
        while ((count = input.read(buffer)) != -1){
            System.out.println(new String(buffer,"UTF-8"));
            //写入文件的数字为124578 从读取数组中的第二位起，写入两个单位
            out.write(buffer,1,2);
        }
        input.close();
        out.close();
    }
}
