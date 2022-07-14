package com.zahar.regex;

import com.zahar.regex.config.AppConfig;
import com.zahar.regex.dao.JdbcDAO;
import com.zahar.regex.dao.JdbcDAOImpl;
import com.zahar.regex.model.City;
import com.zahar.regex.model.Resolver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        Resolver resolver = (Resolver) ctx.getBean(Resolver.class);
        resolver.setQuery("city#name#id:1");
        JdbcDAOImpl dao = (JdbcDAOImpl) ctx.getBean(JdbcDAO.class);
        String s = dao.performQuery(resolver.toString());
        System.out.println(s);
        //System.out.println(jdbc.performQuery(resolver.toString()));
    }
}
