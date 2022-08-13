package com.wuzh.blog.Service;

import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.LoginUserParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther :Wuzh
 * @date :2022/7/14
 */
public interface LoginService {
    Result login(LoginUserParam loginUserParam, HttpServletRequest servletRequest);

    Result loginout(String token);

    SysUser checkToken(String token);
    //登录
   
}
