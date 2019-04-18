package com.hug.wechat.server.service.impl;

import cn.hutool.http.HttpUtil;
import com.hug.common.dto.Result;
import com.hug.wechat.server.service.DialogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 对话服务 实现类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 14:55
 */
@Slf4j
@Service
public class DialogueServiceImpl implements DialogueService {
    private final String appId = "wxe4782be5853a0fea";
    private final String secret = "d0a83887d88da9b4c3fdb5118217afe3";

    @Override
    public Result getAccessToken() {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                appId, secret);
        String re = HttpUtil.get(url);
        log.debug(re);
        return new Result().successResult(re);
    }
}
