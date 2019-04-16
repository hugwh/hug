//package com.hug.gateway.limit;
//
//import com.alibaba.fastjson.JSON;
//import com.hug.gateway.entity.LimitConfig;
//import com.hug.gateway.entity.LimitKey;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.script.RedisScript;
//import org.springframework.validation.Validator;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.time.Instant;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicBoolean;
//
///**
// * redis限流实现
// *
// * @author: huangwh
// * @mail huangwh@txtws.com
// * @date: 2019-04-16 15:29
// */
//@Slf4j
//public class HugRedisRateLimiter extends RedisRateLimiter {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    private AtomicBoolean initialized = new AtomicBoolean(false);
//
//    public HugRedisRateLimiter(ReactiveRedisTemplate<String, String> redisTemplate, RedisScript<List<Long>> script, Validator validator) {
//        super(redisTemplate, script, validator);
//    }
//
//    public HugRedisRateLimiter(int defaultReplenishRate, int defaultBurstCapacity) {
//        super(defaultReplenishRate, defaultBurstCapacity);
//    }
//
//    @Override
//    public Mono<Response> isAllowed(String routeId, String id) {
//        if (!this.initialized.get()) {
//            throw new IllegalStateException("RedisRateLimiter is not initialized");
//        }
//
//        LimitConfig limitConfig = getLimitConfig(routeId);
//
//        if (limitConfig == null || limitConfig.getTokenConfig().size()==0) {
//            return Mono.just(new Response(true,null));
//        }
//
//        Map<String, Config> conf = limitConfig.getTokenConfig();
//
//        LimitKey limitKey = JSON.parseObject(id, LimitKey.class);
//        //api限流
//        String api = limitKey.getApi();
//        Config apiConf = conf.get(api);
//        //业务方限流
//        String biz = limitKey.getBiz();
//        Config bizConf = conf.get(biz);
//
//        if (apiConf!=null) {
//            return isSingleAllow(api,routeId,apiConf).flatMap(res -> {
//                if (res.isAllowed()) {
//                    if(bizConf!=null) {
//                        return isSingleAllow(biz, routeId, bizConf);
//                    }else {
//                        return Mono.just(new Response(true,new HashMap<>()));
//                    }
//                }else {
//                    return Mono.just(res);
//                }
//            } );
//        }else {
//            if (bizConf!=null) {
//                return isSingleAllow(biz, routeId, bizConf);
//            }else {
//                return Mono.just(new Response(true,new HashMap<>()));
//            }
//        }
//    }
//
//    /**
//     * 单级限流
//     * @param api
//     * @param routeId
//     * @param apiConf
//     * @return
//     */
//    private Mono<Response> isSingleAllow(String key, String routeId, Config config) {
//        // How many requests per second do you want a user to be allowed to do?
//        int replenishRate = config.getReplenishRate();
//
//        // How much bursting do you want to allow?
//        int burstCapacity = config.getBurstCapacity();
//
//        try {
//            List<String> keys = getKeys(routeId+"$"+key);
//
//            // The arguments to the LUA script. time() returns unixtime in seconds.
//            List<String> scriptArgs = Arrays.asList(replenishRate + "", burstCapacity + "",
//                    Instant.now().getEpochSecond() + "", "1");
//            // allowed, tokens_left = redis.eval(SCRIPT, keys, args)
//            Flux<List<Long>> flux = this.redisTemplate.execute(this.script, keys, scriptArgs);
//            // .log("redisratelimiter", Level.FINER);
//            return flux.onErrorResume(throwable -> Flux.just(Arrays.asList(1L, -1L)))
//                    .reduce(new ArrayList<Long>(), (longs, l) -> {
//                        longs.addAll(l);
//                        return longs;
//                    }) .map(results -> {
//                        boolean allowed = results.get(0) == 1L;
//                        Long tokensLeft = results.get(1);
//
//                        Response response = new Response(allowed, getHeaders(config, tokensLeft));
//
//                        if (log.isDebugEnabled()) {
//                            log.debug("response: " + response);
//                        }
//                        return response;
//                    });
//        }
//        catch (Exception e) {
//            /*
//             * We don't want a hard dependency on Redis to allow traffic. Make sure to set
//             * an alert so you know if this is happening too much. Stripe's observed
//             * failure rate is 0.01%.
//             */
//            log.error("Error determining if user allowed from redis", e);
//        }
//        return Mono.just(new Response(true, getHeaders(config, -1L)));
//    }
//
//    private LimitConfig getLimitConfig(String routeId) {
//        Map<String, LimitConfig> map = new HashMap<>();
//        LimitConfig limitConfig = new LimitConfig();
//        limitConfig.setRouteId("rateLimit_route");
//        Map<String, Config> tokenMap = new HashMap<>();
//        Config apiConfig = new Config();
//        apiConfig.setBurstCapacity(5);
//        apiConfig.setReplenishRate(5);
//
//        Config bizConfig = new Config();
//        bizConfig.setBurstCapacity(1);
//        bizConfig.setReplenishRate(1);
//
//        tokenMap.put("/hello/rateLimit", apiConfig);
//        tokenMap.put("jieyin", bizConfig);
//        limitConfig.setTokenConfig(tokenMap);
//        map.put("rateLimit_route", limitConfig);
//        return limitConfig;
//    }
//}
