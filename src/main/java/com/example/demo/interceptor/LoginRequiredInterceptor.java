package com.example.demo.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nowcoder on 2016/7/3.
 */
@Component
@Slf4j
public class LoginRequiredInterceptor implements HandlerInterceptor {

   /* @Autowired
    private HostHolder hostHolder;*/

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("开始拦截.........");
        Object usercode=httpServletRequest.getSession().getAttribute("userCode");
        log.info("Usercode:"+usercode);
        if (StrUtil.isBlankIfStr(usercode)){
            httpServletRequest.setAttribute("msg","没有权限请先登陆");
           // httpServletRequest.getRequestDispatcher("/user/error").forward(httpServletRequest, httpServletResponse);
            httpServletRequest.getRequestDispatcher("/login/gologin").forward(httpServletRequest, httpServletResponse);

            return  false;
        }else{
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
