package com.cheng.eric.john.springboot.springboot02_restfulapi.entity;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author Cheng.dongdong
 * @Date Create in 16:01 2019/3/25
 * @Version 1.0
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1982279099194702085L;

    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
