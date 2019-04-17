package com.hug.wechat.server.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * mq test
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 14:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        for (int i = 0; i < 100; i++) {
            amqpTemplate.convertAndSend("myQueue", "第" + i + "条消息");
        }
    }

    @Test
    public void sendOrder() {
        for (int i = 0; i < 100; i++) {
            // 第一个参数指定队列，第二个参数来指定路由的key，第三个参数指定消息
            amqpTemplate.convertAndSend("myOrder", "computer", "第" + i + "条消息");
        }
    }
}
