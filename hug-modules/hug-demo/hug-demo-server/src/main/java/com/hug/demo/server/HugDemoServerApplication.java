package com.hug.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RefreshScope
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class HugDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugDemoServerApplication.class, args);
    }

}
