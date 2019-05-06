package com.hug.demo.client.config;

import com.sun.jmx.snmp.Timestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Date;

/**
 * swagger2配置类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-06 14:33
 */
@Configuration
public class Swagger2Config {
    @Value("${swagger.basePackage}")
    private String basePackage;
    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .directModelSubstitute(Timestamp.class, Long.class)
                .directModelSubstitute(Date.class, Long.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger RESTful APIs")
                .description("Swagger api 服务")
                .termsOfServiceUrl("http://swagger.io")
                .contact(new Contact("Swagger", "127.0.0.1", "hwh2coding@163.com"))
                .version("1.0")
                .build();
    }
}
