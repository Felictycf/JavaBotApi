package com.wuzh.blog.utils;

import com.wuzh.blog.dao.pojo.SysUser;

/**
 * @auther :Wuzh
 * @date :2022/7/17/13:07
 */
public class UserThreadLocal {
    private UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL =new ThreadLocal<>();
    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static  SysUser get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}
