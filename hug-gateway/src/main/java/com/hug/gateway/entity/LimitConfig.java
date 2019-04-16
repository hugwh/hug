package com.hug.gateway.entity;

import lombok.Data;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;

import java.util.Map;

/**
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 15:43
 */
@Data
public class LimitConfig {
    private String routeId;
    private Integer burstCapacity;
    private Integer replenishRate;
    private Map<String, RedisRateLimiter.Config> tokenConfig;
}
