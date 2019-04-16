package com.hug.gateway.limit;

import com.hug.gateway.entity.LimitKey;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;

import reactor.core.publisher.Mono;

/**
 * 限流key
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:24
 */
public class CustomKeyResolver implements KeyResolver {
    public static final String BEAN_NAME = "customKeyResolver";

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(getKey(exchange));
    }

    /**
     *
     * @param exchange
     * @return
     */
    private String getKey(ServerWebExchange exchange) {

        LimitKey limitKey = new LimitKey();

        limitKey.setApi(exchange.getRequest().getPath().toString());
        limitKey.setBiz(exchange.getRequest().getQueryParams().getFirst("biz"));

        return JSON.toJSONString(limitKey);
    }
}
