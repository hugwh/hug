package com.hug.gateway.controller;

import com.hug.common.constant.ResultConstants;
import com.hug.common.dto.Result;
import com.hug.common.exception.ClientException;
import com.hug.common.model.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务降级
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:56
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public void fallback() {
        throw new ClientException(ResultConstants.TYPE_UNVARNISHED_TRANSMISSION, "连接异常");
    }
}
