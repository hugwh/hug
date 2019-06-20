package com.hug.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class HugCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugCommonApplication.class, args);
    }

}
