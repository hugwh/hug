package com.hug.wechat.server.service.impl;

import com.hug.wechat.api.Utils.WechatUtils;
import com.hug.wechat.api.dto.WechatAuth;
import com.hug.wechat.server.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器认证实现类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:09
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void authServer(HttpServletResponse response, WechatAuth wechatAuth) throws IOException {
        log.info("params:{}", wechatAuth.toString());
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        PrintWriter out = response.getWriter();
        if(WechatUtils.checkSignature(wechatAuth.getSignature(), wechatAuth.getTimestamp(), wechatAuth.getNonce())){
            System.out.println("=======请求校验成功======" + wechatAuth.getEchostr());
            out.print(wechatAuth.getEchostr());
        }
        out.close();
        out = null;
    }
}
