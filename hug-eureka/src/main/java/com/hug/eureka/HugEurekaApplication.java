package com.hug.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HugEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugEurekaApplication.class, args);
    }

}
