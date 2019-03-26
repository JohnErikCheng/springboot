package com.cheng.eric.john.springboot.springboot04_jdbctemplate.service.impl;

import com.cheng.eric.john.springboot.springboot04_jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author Cheng.dongdong
 * @Date Create in 11:18 2019/3/26
 * @Version 1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(String name, Integer age) {
        jdbcTemplate.update("insert into user(user_name,user_age) values(?,?)", name, age);
    }

    @Override
    public Integer deleteByName(String name) {
        return jdbcTemplate.update("delete from user where user_name = ?", name);
    }

    @Override
    public Integer getAllUserIntegers() {
        return Integer.valueOf(jdbcTemplate.queryForObject("select count(1) from user", Integer.class).toString());
    }

    @Override
    public void deleteAllUser() {
        jdbcTemplate.update("delete from user");
    }
}
