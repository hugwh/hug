package com.hug.demo.server.service;

import com.hug.demo.api.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-11 14:31
 */
public interface UserService {
    @Cacheable(key="'user_'+#id",value="'user'+#id")
    User getUser(String id);

    @CacheEvict(key="'user_'+#id", value="users", condition="#id!=1")
    void deleteUser(String id);
}
