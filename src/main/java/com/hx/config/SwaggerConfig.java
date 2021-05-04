package com.hx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("dev");
        System.out.println(profiles);
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .groupName("hx")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))// 配置要扫描接口的方式
                .build();// 工厂模式
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("hx", "http://blog.hx.com", "1548973853@qq.com");
        return new ApiInfo("hx movies API"
                , "电影网站系统的 API "
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }
}
