package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * @Auther: DELL
 * @Date: 2020/3/26 10:17
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {
    String value() default "";
}
