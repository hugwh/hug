package com.hug.wechat.client.Controller;

import com.hug.wechat.client.service.ServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对话服务controller
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 18:02
 */
@RestController
@RequestMapping("/wechat")
public class DialogueController {
    @Autowired
    private ServiceFeign serviceFeign;

    @GetMapping("/accessToken")
    public String getAccessToken() {
        return serviceFeign.getAccessToken();
    }
}
