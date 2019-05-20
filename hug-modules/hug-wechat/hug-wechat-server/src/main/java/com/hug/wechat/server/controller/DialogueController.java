package com.hug.wechat.server.controller;

import com.hug.common.model.dto.ResultDto;
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

    @GetMapping("/accessToken")
    public ResultDto getAccessToken() {
        return dialogueService.getAccessToken();
    }
}
