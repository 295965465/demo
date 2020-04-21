package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2019/12/27 16:21
 * @Description:
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserMapper UserMapper;
    @RequestMapping(value = "/gologin")
    public String login(Model model, String name, HttpSession session) {


            return "login";


    }
    @RequestMapping(value = "/goShow")
    public String goShow(Model model, String name, HttpSession session) {


        return "myshow";


    }
    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public ModelAndView loginin(String name, String password, HttpSession session,HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView =new ModelAndView();
        Map<String,Object> map= UserMapper.getUserByName(name);
        if (!StrUtil.isBlankIfStr(map)){
            String password1=map.get("PASSWORD").toString();
            if (password1.equals(SecureUtil.md5(password))){
               log.info("Usercode:->"+map.get("CARGOUSERCODE").toString());
               log.info("角色:->"+map.get("ROLE_IDS").toString());
               log.info("IP:->"+getIpAddress(httpServletRequest));
                session.setAttribute("userCode",map.get("CARGOUSERCODE").toString());
                session.setAttribute("roleid",map.get("ROLE_IDS").toString());
                //这里使用forward就是转发，使用redirect就是重定向
                //modelAndView.setViewName("redirect:/user/index");
                modelAndView.setViewName("redirect:/main.html");
                return modelAndView;
            }else{
                httpServletRequest.setAttribute("msg","密码错误");
                modelAndView.setViewName("login");
                return modelAndView;
            }
        }else{
            modelAndView.setViewName("login");
            return modelAndView;
        }



    }

    public static String getIpAddress(HttpServletRequest request) {
                 String ip = request.getHeader("x-forwarded-for");
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("Proxy-Client-IP");
                    }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("WL-Proxy-Client-IP");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("HTTP_CLIENT_IP");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                        ip = request.getRemoteAddr();
                 }
                 return ip;
             }

}
