package com.example.demo.configurer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2020/3/12 14:27
 * @Description:
 */
@ControllerAdvice
public class myExcptionHandler {
/*    *//**1.................. 没有自实行效果
     * @ExceptionHandler 可以指定class如果不指定就是处理所有的
     * @param e
     * @return
     * 这种情况下游览器和服务器返回的都是json
     *//*
     @ResponseBody
     @ExceptionHandler(myException.class)
     public Map<String, Object> myexcptionC(Exception e){
         Map<String,Object> Object=new HashMap<>();
         Object.put("code","user don't have ");
         Object.put("message",e.getMessage());
         return  Object;
     }*/


    /**1..................
     * @ExceptionHandler 可以指定class如果不指定就是处理所有的
     * @param e
     * @return
     * 这种情况下游览器和服务器返回的都是json
     */

    @ExceptionHandler()
    public String myexcptionC(Exception e, HttpServletRequest request){
        Map<String,Object> Object=new HashMap<>();
        //必须传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        Object.put("code","SenCheng.Zhang@sh.de-well.com");
        Object.put("message",e.getMessage());
        request.setAttribute("ext",Object);
        return "forward:/error.html";
    }


}
