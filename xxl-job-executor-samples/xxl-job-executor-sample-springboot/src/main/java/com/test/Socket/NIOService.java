package com.test.Socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedList;

public class NIOService {
    //监听端口
    static int port = 9393;

    public static void main(String[] args) {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel socketChannel = null;

        try {
            socketChannel = ServerSocketChannel.open();
            socketChannel.bind(new InetSocketAddress(port));
            socketChannel.configureBlocking(true);

            while (true){
                SocketChannel client = socketChannel.accept();
                if (client == null){
                    return;
                }else{
                    client.configureBlocking(true);

                    int port = client.socket().getPort();

                    clients.add(client);
                }

                ByteBuffer buffer = ByteBuffer.allocate(2048);

                for (SocketChannel channel : clients){
                    int num = channel.read(buffer);
                    if (num > 0) {
                        //反转缓冲区 limit(限制位置)设为当前位置，然后将position（位置）设为0。
                        buffer.flip();
                        byte[] bytes = new byte[buffer.limit()];
                        buffer.get(bytes);
                        String txt = new String(bytes);
                        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
                        String s = "";
                        if ("time".equals(txt)){
                            long l = System.currentTimeMillis();
                            s = "time: "+new Date(1).toString();
                            System.out.println(s);
                        }else{
                            s = "非指定命令，无返回值 ";
                        }

                        byteBuffer.put(s.getBytes(StandardCharsets.UTF_8));
                        byteBuffer.flip();
                        channel.write(byteBuffer);
                    }
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
