package com.cheng.eric.john.springboot.springboot01_introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WebController
 * @Author Cheng.dongdong
 * @Date Create in 15:03 2019/3/25
 * @Version 1.0
 * @Description:
 */
@Controller
public class WebController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}
