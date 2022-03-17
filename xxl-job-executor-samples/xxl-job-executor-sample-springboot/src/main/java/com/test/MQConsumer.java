package com.test;

import com.rabbitmq.client.*;

import java.io.IOException;

public class MQConsumer {
    public static void main(String[] args) throws IOException {
        MQFactory factory = MQFactory.getInstance();
        Channel channel = factory.getChannel();
        channel.queueDeclare("渠道1",false,false,false,null);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("received"+message+"");
            }
        };
        channel.basicConsume("渠道1",false,consumer);
    }
}
