package com.hug.wechat.client.controller;

import com.hug.wechat.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-10 14:26
 */
@RestController
@RequestMapping(value = "/demo")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/test")
    public String tset(@RequestParam String name) {
        return clientService.testFromClient(name);
    }

    @GetMapping("/user/{id}")
    public String queryUser(@PathVariable(value = "id") String id) {
        return clientService.queryUser(id);
    }
}
