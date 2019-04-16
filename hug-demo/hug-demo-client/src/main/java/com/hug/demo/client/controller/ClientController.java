package com.hug.demo.client.controller;

import com.hug.demo.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @Value("${test.value}")
    private String value;

    @GetMapping("/test")
    public String tset(@RequestParam String name) {
        return clientService.testFromClient(name);
    }
}
