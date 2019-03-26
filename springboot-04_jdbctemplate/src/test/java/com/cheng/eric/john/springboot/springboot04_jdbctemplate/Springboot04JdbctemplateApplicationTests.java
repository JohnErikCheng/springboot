package com.cheng.eric.john.springboot.springboot04_jdbctemplate;

import com.cheng.eric.john.springboot.springboot04_jdbctemplate.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04JdbctemplateApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        //清空数据库的所有数据
        userService.deleteAllUser();
    }

    @Test
    public void test() {
        //插入数据
        userService.createUser("aaa", 20);
        userService.createUser("bbb", 21);
        userService.createUser("ccc", 22);
        userService.createUser("ddd", 23);
        userService.createUser("eee", 24);

        //获取用户的总量
        Integer count = userService.getAllUserIntegers();
        System.out.println("总用户量：" + count);

        //删除用户
        userService.deleteByName("bbb");
        System.out.println("用户被删除成功！");

    }

}
