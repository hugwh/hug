package com.hug.wechat.client.service;

import com.hug.wechat.client.fallback.ServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:20
 */
@FeignClient(value = "hug-wechat-server", fallback = ServiceFallback.class)
public interface ServiceFeign {
    @GetMapping("/wechat/auth")
    void authServer(@RequestParam(value = "signature") String signature,
                    @RequestParam(value = "timestamp") String timestamp,
                    @RequestParam(value = "nonce") String nonce,
                    @RequestParam(value = "echostr") String echostr);

    @GetMapping("/wechat/accessToken")
    String getAccessToken();
}
