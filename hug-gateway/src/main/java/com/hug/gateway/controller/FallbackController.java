package com.hug.gateway.controller;

import com.hug.common.dto.Result;
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
    public Result fallback() {
        Result response = new Result();
        response.setStatus(100);
        response.setMessage("服务暂时不可用");
        return response;
    }
}
