package com.zahar.regex.config;

import com.zahar.regex.model.Resolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zahar.regex")
public class AppConfig {

    @Bean
    Resolver resolver(){
        return new Resolver();
    }
}
