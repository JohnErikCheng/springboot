  #### 功能描述（Swagger的使用）
    * 添加swagger依赖
    * 创建User类
    * 创建swagger配置类（@Configuration、@EnableSwagger2）
    * 创建UserController,注意一下三个注解：
         [@ApiOperation]
         [@ApiImplicitParam]
         [@ApiImplicitParams]
        ```java
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
        ```
    * 访问： http://localhost:8888/swagger-ui.html