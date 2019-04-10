package com.hug.demo.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-10 14:58
 */
@RestController
public class ServerController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "admin") String name) {
        return name +"test ,i am from port:" + port;
    }
}
