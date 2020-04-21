package com.example.demo.configurer;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2020/3/12 15:43
 * @Description:
 */
@Component
public class myErrorAttributes extends DefaultErrorAttributes {

    public myErrorAttributes() {
        super(true);
    }



    //返回值的map就是页面和json能获取的所有字段
        @Override
        public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
            Map<String, Object> map = super.getErrorAttributes( requestAttributes, includeStackTrace);
            map.put("company","Dewell");

            //我们的异常处理器携带的数据
            Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
            map.put("ext",ext);
            return map;
        }

}
