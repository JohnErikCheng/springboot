package com.cheng.eric.john.springboot.springboot04_jdbctemplate.service;

/**
 * @ClassName UserService
 * @Author Cheng.dongdong
 * @Date Create in 11:17 2019/3/26
 * @Version 1.0
 * @Description:
 */
public interface UserService {
    /**
     * 创建用户。
     *
     * @param name
     * @param age
     */
    public void createUser(String name, Integer age);

    /**
     * 根据用户名删除用户。
     *
     * @param name
     * @return
     */
    public Integer deleteByName(String name);

    /**
     * 获取用户总量。
     *
     * @return
     */
    public Integer getAllUserIntegers();

    /**
     * 删除所有用户。
     */
    public void deleteAllUser();
}
