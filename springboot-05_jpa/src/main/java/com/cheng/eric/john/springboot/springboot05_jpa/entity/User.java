package com.cheng.eric.john.springboot.springboot05_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName User
 * @Author Cheng.dongdong
 * @Date Create in 17:01 2019/3/26
 * @Version 1.0
 * @Description:
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userID;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Integer userAge;

    public User() {
    }

    public User(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
