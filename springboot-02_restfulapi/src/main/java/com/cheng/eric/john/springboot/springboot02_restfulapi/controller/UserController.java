package com.cheng.eric.john.springboot.springboot02_restfulapi.controller;

import com.cheng.eric.john.springboot.springboot02_restfulapi.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName UserController
 * @Author Cheng.dongdong
 * @Date Create in 16:08 2019/3/25
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    /**
     * 创建线程安全的Map
     */
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 查询用户列表。
     *
     * @return
     */
    @GetMapping("/")
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> userList = new ArrayList<>(users.values());
        return userList;
    }

    /**
     * 创建一个用户。
     *
     * @param user
     * @return
     */
    @PostMapping("/users")
    public String putUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        return "success";
    }

    /**
     * 获取指定id的用户。
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    /**
     * 修改指定用户信息。
     *
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User user = users.get(id);
        user.setName(user.getName());
        user.setAge(user.getAge());
        users.put(id, user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }

}
