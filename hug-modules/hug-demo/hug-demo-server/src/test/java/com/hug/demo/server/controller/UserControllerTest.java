package com.hug.demo.server.controller;

import com.hug.demo.api.entity.User;
import com.hug.demo.server.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-17 10:57
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User("1", "kay", 20);
        int id = userMapper.insert(user);
        log.info("new id:{}", id);
    }

    @Test
    public void get() {
        User user = userMapper.selectById("1");
        log.info("name:{}", user.getName());
    }
}
