package com.hug.wechat.client.Controller;

import com.hug.wechat.client.service.ServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:18
 */
@RestController
@RequestMapping("/wechat")
public class AuthController {
    @Autowired
    private ServiceFeign serviceFeign;

    @GetMapping("/auth")
    public void authServer(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr){
        serviceFeign.authServer(signature, timestamp, nonce, echostr);
    }
}
