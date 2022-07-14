package com.zahar.regex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcDAOImpl implements JdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public String performQuery(String query) {
        return jdbcTemplate.queryForObject("select name from city where id=1", String.class);
    }
}
