package com.cheng.eric.john.springboot.springboot05_jpa.repository;

import com.cheng.eric.john.springboot.springboot05_jpa.entity.User;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName UserRepository
 * @Author Cheng.dongdong
 * @Date Create in 17:04 2019/3/26
 * @Version 1.0
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {
/*    User findByUserName(String userName);

    User findByUserNameAndAndUserAge(String userName, Integer userAge);*/

    @Query("from User u where u.userName=:userName")
    User findUser(@Param("userName") String userName);

    @Query("from User u where u.userAge=:userAge")
    User findSomeoneByUserAge(@Param("userAge") Integer userAge);

}
