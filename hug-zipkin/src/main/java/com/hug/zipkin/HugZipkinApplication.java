package com.hug.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class HugZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(HugZipkinApplication.class, args);
    }

}
