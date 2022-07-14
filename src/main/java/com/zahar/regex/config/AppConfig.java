package com.zahar.regex.config;

import com.zahar.regex.model.Resolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.zahar.regex")
public class AppConfig {

    @Bean
    Resolver resolver(){
        return new Resolver();
    }

    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
       return new JdbcTemplate(postgresDataSource());
    }
}
