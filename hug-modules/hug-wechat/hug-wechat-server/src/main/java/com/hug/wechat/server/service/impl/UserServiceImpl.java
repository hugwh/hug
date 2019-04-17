package com.hug.wechat.server.service.impl;

import com.hug.demo.server.mapper.UserMapper;
import com.hug.wechat.api.entity.User;
import com.hug.wechat.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 14:32
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        System.out.println(id+"进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("香菇,难受");
        user.setAge(18);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        System.out.println(id+"进入实现类删除数据！");
    }

    @Override
    public User queryUser(String id) {
        return userMapper.selectById(id);
    }
}
