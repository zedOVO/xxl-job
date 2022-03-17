package com.test;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.util.Assert;

public class MqSample {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection con = null;
        Channel channel = null;
        try{
            con = factory.newConnection();
            channel = con.createChannel();
            channel.queueDeclare("渠道1",false,false,false,null);
            String message = "Hello MQ!Rel";
            channel.basicPublish("","渠道1",null,message.getBytes("UTF-8"));
            System.out.println("sent"+message+".");
            channel.close();
            con.close();
        }catch (Exception e){}



    }
}
