package com.hug.demo.server.controller;

import com.hug.demo.server.mapper.UserMapper;
import com.hug.demo.server.service.UserService;
import com.hug.demo.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * demo
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-10 14:58
 */
@RestController
public class ServerController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    String port;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;


    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "admin") String name) {
        return name + "test ,i am from port:" + port;
    }

    @GetMapping(value = "/cache/user/cacheUser")
    @ResponseBody
    public Map<String, Object> cacheUser() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "000000");
        result.put("msg", "success");
        User u = new User();
        u.setId("1");
        u.setName("张三");
        u.setAge(23);

        result.put("body", u);
        redisCacheTemplate.opsForValue().set(String.valueOf(u.getId()), u);

        return result;
    }

    /**
     * 获取缓存信息
     *
     * @param id
     * @return
     */

    @GetMapping(value = "/cache/user/getCacheUser/{id}")
    @ResponseBody
    public Map<String, Object> getCacheUser(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", "000000");
        result.put("msg", "success");
        User u = (User) redisCacheTemplate.opsForValue().get(String.valueOf(1));
        System.out.println(u.getName());
        result.put("body", u);

        return result;

    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User queryUser(@PathVariable(value = "id") String id) {
        return userService.getUser(id);
    }
}
