package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* Created by CodeGenerator on 2019/05/16.
*/
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/hello")
    public String show(Model model) {

        model.addAttribute("name", "Dear");
        model.addAttribute("yewu","DP"+DateUtil.format(new Date(),"yyMMdd"));
        return "hello";
    }
    @RequestMapping(value = "/mytest",method = RequestMethod.POST)
    @ResponseBody
    public void test(@RequestParam Map<String,Object> news){
        System.out.println("前台的数据是："+news);

    }
    @RequestMapping(value = "/initSelect",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> test(){
        Map<String,Object> test =new HashMap<>();
        test.put("11","one");
        test.put("2","two");
        test.put("3","three");
        return test;
    }
}
