package com.shopping.micro.orders.utils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author ldc
 * @Date 2020/12/23 17:44
 * @Version 1.0
 * 创建MQ连接的工具类
 */
public class ConnectionUtils {

    public static Connection getConnection() throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");//MQ的服务器
        connectionFactory.setPort(5672);//默认端口号
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("test");
        connectionFactory.setVirtualHost("/test");
        return connectionFactory.newConnection();
    }
}
