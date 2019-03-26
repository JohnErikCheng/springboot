### 功能描述(JdbcTemplate的使用)
    * 添加pom依赖
        [JDBC](spring-boot-starter-jdbc)
        [嵌入式数据库](hsqldb)
        [mysql](mysql-connector-java)
     > 注意：
        1、mysql使用的是8.0.13版本。
        2、对于select count(*)语句，Long类型与数据库的bigint类型，需要做转换处理
          eg: Integer.valueOf(jdbcTemplate.queryForObject("select count(1) from user", Integer.class).toString());
    * 添加数据源
      ```yml
          spring:
              datasource:
                driver-class-name: com.mysql.jdbc.Driver
                url: jdbc:mysql://localhost:3306/springboot?serverTimezone=GMT%2B8
                username: root
                password: 123456
      ```
     * 创建数据库
     * 创建service
         ```java
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
         ```
     * 创建测试类，进行单元测试。