### 功能模块（spring-data-jpa）
    * 添加pom依赖
        > mysql(mysql-connector-java)
        > jpa(spring-boot-starter-data-jpa)
    * yml文件
        > 数据源的配置（四大元素）
        > jpa的配置：
            spring.jpa.properties.hibernate.hbm2ddl.auto是hibernate的配置属性，
            其主要作用是：自动创建、更新、验证数据库表结构。该参数的几种配置如下：
                1、create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，
                            哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
                2、create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
                3、update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），
                            以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。
                            要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
                4、validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。‘
    * 实体类编写
        > 实体类上添加注解 @Entity
        > id字段添加注解 @Id 和 @GeneratedValue
        > 非id字段添加注解@Column(nullable = false)
        
    * repository接口的编写
        > 自定义接口继承JpaRepository<T, ID>
        > 该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，因此对于这些基础操作的数据访问就不需要开发者再自己定义。
        > 在我们实际开发中，JpaRepository接口定义的接口往往还不够或者性能不够优化，我们需要进一步实现更复杂一些的查询或操作。
          ① 通过解析方法名创建查询。
          ② 提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数，就像例子中的第三个findUser函数一样。