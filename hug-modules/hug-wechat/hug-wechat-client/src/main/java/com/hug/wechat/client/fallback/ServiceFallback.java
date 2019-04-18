package com.hug.wechat.client.fallback;

import com.hug.wechat.client.service.ServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:20
 */
@Slf4j
@Component
public class ServiceFallback implements ServiceFeign {
    @Override
    public void authServer(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr) {
        log.error("fallback!");
    }

    @Override
    public String getAccessToken() {
        return "server fallback";
    }
}
