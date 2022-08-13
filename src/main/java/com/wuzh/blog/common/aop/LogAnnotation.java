package com.wuzh.blog.common.aop;

import java.lang.annotation.*;

/**
 * @auther :Wuzh
 * @date :2022/7/24/12:07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";
    String operater() default "";
}
