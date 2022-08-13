package com.wuzh.blog.common.cache;

import java.lang.annotation.*;

/**
 * @auther :Wuzh
 * @date :2022/7/26/12:07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {
    long expire() default 1*60*1000;
    //缓存标识key
    String name() default "";
}
