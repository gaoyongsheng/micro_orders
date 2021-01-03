package com.shopping.micro.orders.configuration.rabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author ldc
 * @Date 2020/12/25 14:55
 * @Version 1.0
 */

@Configuration
@Slf4j
@PropertySource(value = {"classpath:constant.properties"}, encoding = "utf-8")
public class RabbitConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbit.queue.name}")
    public String queueName;

    @Value("${rabbit.exchange.name}")
    public String exchangeName;

    @Value("${rabbit.key}")
    public String key;

    // 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。
    // 通常我们会是在Spring框架中使用到@PostConstruct注解 该注解的方法在整个Bean初始化中的执行顺序：
    //Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    //此主要用于检查交换机（exChange），当 ack=false，交换机可能错误
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        //在发送消息的时候correlationData传入的为进件编号
        if (ack) {
            log.info("消息发送成功：correlationData = " + correlationData);
        } else {
            //如果有多个交换机，这里日志需要优化
            log.error("消息发送失败,交换机可能错误：correlationData = " + correlationData + ",exchange:" + exchangeName);
        }
    }

    //次方法用于检查队列（queue），当此方法执行时，队列可能错误
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        //如果有多个队列，这里日志需要优化
        log.error("消息发送失败,队列可能错误：correlationData = " + message.getMessageProperties().getCorrelationId() + ",queue:" + queueName);
    }

    // 声明队列
    @Bean
    public Queue queue() {
        return new Queue(queueName, true);//表示持久化
    }

    // 声明交换机,注意交换机的类别
    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(exchangeName);
        //return new DirectExchange(exchang);
        //return new TopicExchange(exchang);
    }

    // 绑定交换机和队列，如果是fanout，就不需要key
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange());
        //return BindingBuilder.bind(queue()).to(exchange()).with(key);
    }

}
