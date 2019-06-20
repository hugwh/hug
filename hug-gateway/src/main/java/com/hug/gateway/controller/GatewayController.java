package com.hug.gateway.controller;

import com.hug.common.constant.enums.result.DisplayEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import com.hug.common.exception.ClientException;
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
public class GatewayController {
    @GetMapping("/fallback")
    public void fallback() {
        throw new ClientException("网关服务降级", ServiceEnum.HUG_GATEWAY, DisplayEnum.NONE);
    }
}
