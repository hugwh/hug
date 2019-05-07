package com.hug.wechat.server.controller;

import com.hug.common.dto.Result;
import com.hug.wechat.server.annotation.Log;
import com.hug.wechat.server.service.DialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对话服务 controller
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 14:53
 */
@RestController
@RequestMapping("/wechat")
public class DialogueController {
    @Autowired
    private DialogueService dialogueService;

    @Log
    @GetMapping("/accessToken")
    public Result getAccessToken() {
        return dialogueService.getAccessToken();
    }
}
