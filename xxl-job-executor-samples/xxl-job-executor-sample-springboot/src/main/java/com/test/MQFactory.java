package com.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQFactory {
    public static MQFactory factory;
    public ConnectionFactory connectionFactory;

    public MQFactory(){};

    public static MQFactory getInstance(){
        if (factory == null){
            synchronized (MQFactory.class){
                if (factory == null){
                    MQFactory factory = new MQFactory();
                    ConnectionFactory connectionFactory = new ConnectionFactory();
                    connectionFactory.setHost("localhost");
                    connectionFactory.setPort(5672);
                    connectionFactory.setUsername("guest");
                    connectionFactory.setPassword("guest");
                    connectionFactory.setVirtualHost("/");
                    factory.connectionFactory = connectionFactory;
                    return factory;
                }
            }
        }
        return factory;
    }

    public Channel getChannel(){
        Channel channel = null;
        try {
            channel = connectionFactory.newConnection().createChannel();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }

    /**
     * 创建默认队列，默认不持久化，
     * 不排它（不同Connection和chanel可以访问）,
     * 不自动删除
     * @param channelName
     * @return
     */
    public Channel getDefaultQueue(String channelName){
        Channel channel = null;
        try {
            channel  = (Channel) connectionFactory.newConnection().createChannel().queueDeclare(channelName,false,false,false,null);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }

}
