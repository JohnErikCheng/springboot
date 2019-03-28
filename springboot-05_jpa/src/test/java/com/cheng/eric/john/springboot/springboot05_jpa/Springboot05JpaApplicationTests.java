package com.cheng.eric.john.springboot.springboot05_jpa;

import com.cheng.eric.john.springboot.springboot05_jpa.entity.User;
import com.cheng.eric.john.springboot.springboot05_jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot05JpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {

        userRepository.saveAndFlush(new User("aaa", 20));
        userRepository.saveAndFlush(new User("aaa", 21));
        userRepository.saveAndFlush(new User("ccc", 22));
        userRepository.saveAndFlush(new User("ddd", 23));
        userRepository.saveAndFlush(new User("eee", 24));

        User who = userRepository.findByUserName("ccc");
        System.out.println("findByUserName aaa is" + who.toString());

        User smo = userRepository.findByUserNameAndAndUserAge("aaa", 21);
        System.out.println("findByUserNameAndAndUserAge is" + smo);

        User eee = userRepository.findUser("eee");
        System.out.println("findSomeone is" + eee);

        User someoneByUserAge = userRepository.findSomeoneByUserAge(23);
        System.out.println("someoneByUserAge is"+ someoneByUserAge);
    }
}
