package com.hug.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.hug.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 验证过滤器
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:14
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入认证");
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if ("token".equals(token)) {
            return chain.filter(exchange);
        }
        ServerHttpResponse response = exchange.getResponse();
        Result data = new Result();
        data.setStatus(401);
        data.setMessage("非法请求");
        byte[] datas = JSON.toJSONString(data).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
