package com.spring.security.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author:chenssy
 * @date : 2016/7/27 16:54
 */
@Controller
@RequestMapping("/ch01/welcome")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring Security Hello World");
        return "ch01/hello";
    }
}
