package com.cheng.eric.john.springboot.springboot01_introduction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IntroductionController
 * @Author Cheng.dongdong
 * @Date Create in 14:34 2019/3/25
 * @Version 1.0
 * @Description:
 */
@RestController
public class IntroductionController {
    @RequestMapping("/test")
    public String index() {
        return "Hello World! yeah!";
    }
}
