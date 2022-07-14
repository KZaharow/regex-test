package com.zahar.regex;

import com.zahar.regex.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        //System.out.println(jdbc.performQuery(resolver.toString()));
    }
}
