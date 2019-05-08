package com.hug.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
public class HugBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugBootAdminApplication.class, args);
    }

}
