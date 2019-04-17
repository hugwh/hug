package com.hug.wechat.client.service;

import com.hug.wechat.client.fallback.ClientServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-10 14:21
 */
@FeignClient(value = "hug-demo-server", fallback = ClientServiceFallback.class)
public interface ClientService {
    @GetMapping(value="/test")
    String testFromClient(@RequestParam(value = "name") String name);

    @GetMapping(value="/user/{id}")
    String queryUser(@PathVariable(value = "id") String id);
}
