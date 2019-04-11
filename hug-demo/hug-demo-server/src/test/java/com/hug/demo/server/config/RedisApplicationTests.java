package com.hug.demo.server.config;

import com.hug.demo.api.entity.User;
import com.hug.demo.server.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void get() {
        redisTemplate.opsForValue().set("test", "我是地瓜");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }
    @Test
    public void contextLoads() {
        User user = new User();
        user.setId("1");
        user.setAge(12);
        user.setName("张三");
        redisTemplate.opsForValue().append("date", user.toString());
        System.out.println(redisTemplate.opsForValue().get("date"));
    }
    @Test
    public void getUser() {
        for (int i = 0; i < 10; i++) {
            User user = userService.getUser(String.valueOf(i));
            System.out.println(user);
        }
    }

    @Test
    public void set() {
        redisTemplate.opsForValue().set("test:set1", "testValue1");
        redisTemplate.opsForSet().add("test:set2", "asdf");
        redisTemplate.opsForHash().put("hash1", "name1", "lms1");
        redisTemplate.opsForHash().put("hash1", "name2", "lms2");
        redisTemplate.opsForHash().put("hash1", "name3", "lms3");
        System.out.println(redisTemplate.opsForValue().get("test:set"));
        System.out.println(redisTemplate.opsForHash().get("hash1", "name1"));
    }
}
