### Swagger使用步骤小结：
#####一、描述
```text
1、通过配置类的形式，将要展示成API文档的接口暴露出去
2、通过访问地址：http://ip:port/swagger-ui.html可以直接查看文档
3、直接在线测试接口，不用采用第三方插件的方式如postman
2、当然也有缺点，最明显的就是代码移入性比较强
```
#####二、添加Swagger的依赖
```pom
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.2.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.2.2</version>
</dependency>
```

#####三、创建Swagger配置类
```java
//这是配置类
@Configuration

//启动Swagger2
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) //设置文档类型是Swagger2
                .apiInfo(apiInfo()) //加载 apiInfo()
                .select()   //select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .apis(RequestHandlerSelectors.basePackage("com.zone.base.swagger.controller"))  //包目录下的所有都暴露给swagger展示，除非被@ApiIgnore指定的请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {     //创建api基本信息
        return new ApiInfoBuilder()
                .title("Swagger2构建RESTful APIs")
                .description("调研Spring Boot中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("https://github.com/JohnErikCheng/")
                .contact("JohnEricCheng")
                .version("1.0")
                .build();
    }
}
```
#####四、在controller中使用
```java
@RestController
@RequestMapping("/users")
public class UserController {
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
}

/**
*  1、通过@ApiOperation注解来给API增加说明
*  2、通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
*/
```
