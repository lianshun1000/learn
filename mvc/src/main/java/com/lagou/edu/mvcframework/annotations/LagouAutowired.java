package com.lagou.edu.mvcframework.annotations;

import java.lang.annotation.*;

/**
 * @author lianshun
 * @date 2021/8/11 11:10 下午
 * @description
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LagouAutowired {
    String value() default "";
}
