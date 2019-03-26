package com.cheng.eric.john.springboot.springboot03_swagger2.controller;

import com.cheng.eric.john.springboot.springboot03_swagger2.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
/**通过这里配置使下面的映射都在/user下，可去除*/
@RequestMapping(value = "/users")
public class UserController {
    /**
     * 创建线程安全的Map
     */
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 1、查询用户列表。
     *
     * @return
     */
    @ApiOperation(value = "查询用户列表", notes = "")
    @GetMapping("/")
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> userList = new ArrayList<>(users.values());
        return userList;
    }

    /**
     * 2、创建一个用户。
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/")
    public String postUser(@RequestBody User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 3、 获取指定id的用户。
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户信息", notes = "根据url的id来获取用户的详细信息")
    @ApiImplicitParam(name = "id", value = "用户的唯一序列号", required = true, dataType = "Long")
    public User getUser(@PathVariable("id") Long id) {
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
    @ApiOperation(value = "修改指定用户信息", notes = "根据用户的唯一id修改指定用户的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的唯一序列号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        users.put(id, user);
        return "success";
    }

    /**
     * 删除指定用户。
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除指定用户", notes = "根据用户的唯一标识id删除该用户信息")
    @ApiImplicitParam(name = "id", value = "用户的唯一标识", required = true, dataType = "Long")
    public String delUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }

}
