package com.hug.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.hug.common.constant.ResultConstants;
import com.hug.common.model.dto.ResultDto;
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
 * 签名验证 全局过滤器
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:14
 */
@Slf4j
@Component
public class SignatureAuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入签名验证过滤器");
        String appId = exchange.getRequest().getHeaders().getFirst("appId");
        String signature = exchange.getRequest().getHeaders().getFirst("signature");
        exchange.getRequest().getBody();
        exchange.getFormData();
        if (true) {
            return chain.filter(exchange);
        }

        ResultDto result = new ResultDto();
        result.setCode(ResultConstants.CODE_AUTH_ERR);
        result.setMsg("签名验证失败");

        ServerHttpResponse response = exchange.getResponse();
        byte[] datas = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

        return response.writeWith(Mono.just(buffer));
    }
}
