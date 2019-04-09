package com.hug.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class HugGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugGatewayApplication.class, args);
    }

}
