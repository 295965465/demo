package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Created by CodeGenerator on 2019/05/16.
*/
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/hello")
    public String show(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

}
