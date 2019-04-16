package com.hug.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan(basePackages = {"org.springframework.http.codec"})
@SpringCloudApplication
public class HugGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugGatewayApplication.class, args);
    }
}
