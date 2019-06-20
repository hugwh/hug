package com.hug.gateway.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.hug.common.constant.enums.result.CodeEnum;
import com.hug.common.constant.enums.result.ServiceEnum;
import com.hug.common.model.dto.ResultBaseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * jwt校验
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-06-20 17:25
 */
@Slf4j
@Component
public class JwtAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            //return chain.filter(exchange);
            String jwtToken = exchange.getRequest().getHeaders().getFirst("Authorization");

            log.info(jwtToken);

            //校验jwtToken的合法性
            if (StrUtil.equals(jwtToken, "test_token")) {
                //合法
                return chain.filter(exchange);
            }

            //不合法
            ServerHttpResponse response = exchange.getResponse();
            //设置headers
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
            //设置body
            ResultBaseDto resultBaseDto = new ResultBaseDto(CodeEnum.AUTH_ERR, "未登录或者登陆超时", ServiceEnum.HUG_GATEWAY);

            DataBuffer bodyDataBuffer = response.bufferFactory().wrap(JSONUtil.toJsonPrettyStr(resultBaseDto).getBytes());

            return response.writeWith(Mono.just(bodyDataBuffer));
        };
    }
}
