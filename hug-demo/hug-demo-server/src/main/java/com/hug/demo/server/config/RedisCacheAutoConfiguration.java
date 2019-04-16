package com.hug.demo.server.config;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-04-16 14:12
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisCacheAutoConfiguration {
    @Bean

    public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Serializable> template = new RedisTemplate<>();

        //键的序列化方式

        template.setKeySerializer(new StringRedisSerializer());

        //值的序列化方式

        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);

        return template;

    }
}
