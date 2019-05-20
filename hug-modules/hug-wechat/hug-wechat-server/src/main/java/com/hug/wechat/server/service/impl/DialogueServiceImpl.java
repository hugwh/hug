package com.hug.wechat.server.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hug.wechat.api.Constants.WechatUrlContants;
import com.hug.common.model.dto.ResultDto;
import com.hug.wechat.server.service.DialogueService;
import org.springframework.stereotype.Service;

/**
 * 对话服务 实现类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-18 14:55
 */
@Service
public class DialogueServiceImpl implements DialogueService {
    private final String appId = "wxe4782be5853a0fea";
    private final String secret = "d0a83887d88da9b4c3fdb5118217afe3";

    @Override
    public ResultDto getAccessToken() {
        String url = String.format(WechatUrlContants.TOKEN_URL_FORMAT, appId, secret);
        String re = HttpUtil.get(url);
        return new ResultDto(JSONUtil.parseObj(re));
    }
}
