package com.test.Socket;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        try {
            //建立客户端到服务端口的链接
            Socket client = new Socket("127.0.0.1",9393);

            //设置发送命令的长度
            client.setSendBufferSize(20);
            /**
             * 关闭Nagle算法：该算法是将多个命令打包一起发送给服务端，避免网络拥挤。
             * 但是现在网络宽松，随便发也没事。所以关闭。
             */
            client.setTcpNoDelay(false);

            OutputStream out = client.getOutputStream();
            InputStream input = client.getInputStream();
            InputStream in = System.in;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            Scanner scan = new Scanner(System.in);

            while (true){
                String line = scan.nextLine();

                if (line != null){
                    out.write(line.getBytes(StandardCharsets.UTF_8));
                }

                byte[] bytes = new byte[1024];

                int len = input.read(bytes);

                System.out.println(new String(bytes));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
