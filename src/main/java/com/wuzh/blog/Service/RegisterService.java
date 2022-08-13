package com.wuzh.blog.Service;

import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.LoginUserParam;

/**
 * @auther :Wuzh
 * @date :2022/7/15
 */
public interface RegisterService {
    Result register(LoginUserParam loginUserParam);
}
