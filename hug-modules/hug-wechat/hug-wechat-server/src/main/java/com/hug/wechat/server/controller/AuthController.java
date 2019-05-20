package com.hug.wechat.server.controller;

import com.hug.wechat.api.vo.WechatAuthVO;
import com.hug.wechat.server.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务器认证
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:06
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping(value = "/auth")
    public void authServer(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr)
            throws IOException {
        WechatAuthVO wechatAuthVO = new WechatAuthVO(signature, timestamp, nonce, echostr);
        authService.authServer(response, wechatAuthVO);
    }
}
