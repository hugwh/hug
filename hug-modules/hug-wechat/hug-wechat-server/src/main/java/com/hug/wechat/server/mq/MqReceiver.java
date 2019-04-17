package com.hug.wechat.server.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 14:35
 */
@Component
@Slf4j
public class MqReceiver {
    /**
     * 接收并打印消息
     * 可以当队列不存在时自动创建队列，以及自动绑定指定的Exchange
     *
     * @param message message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        // @RabbitListener注解用于监听RabbitMQ，queuesToDeclare可以创建指定的队列
        log.info(message);
    }

    /**
     * 数码供应商服务 - 接收消息
     *
     * @param message message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "computer"  // 指定路由的key
    ))
    public void processComputer(String message) {
        log.info("computer message : {}", message);
    }

    /**
     * 水果供应商服务 - 接收消息
     *
     * @param message message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),
            key = "fruit"  // 指定路由的key
    ))
    public void processFruit(String message) {
        log.info("fruit message : {}", message);
    }
}
