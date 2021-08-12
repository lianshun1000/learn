package com.lagou.edu.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * @author lianshun
 * @date 2021/8/11 11:11 下午
 * @description
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LagouRequestMapping {
    String value() default "";
}
