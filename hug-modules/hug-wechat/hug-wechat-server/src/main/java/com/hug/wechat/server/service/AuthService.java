package com.hug.wechat.server.service;

import com.hug.wechat.api.vo.WechatAuthVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务器认证service
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 11:08
 */
public interface AuthService {

    void authServer(HttpServletResponse response, WechatAuthVO wechatAuthVO) throws IOException;
}
