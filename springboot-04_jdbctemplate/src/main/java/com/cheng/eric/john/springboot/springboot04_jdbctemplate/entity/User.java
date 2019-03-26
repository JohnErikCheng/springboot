package com.cheng.eric.john.springboot.springboot04_jdbctemplate.entity;

/**
 * @ClassName User
 * @Author Cheng.dongdong
 * @Date Create in 11:18 2019/3/26
 * @Version 1.0
 * @Description:
 */
public class User {
    private Long userID;
    private String userName;
    private Integer userAge;

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
}
