package com.wuzh.blog.Service;

import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUsers(String usn, String pwd);

    Result findUserByToken(String token);

    String findSalt(String usn);

    UserVo findUserVoById(Long authorId);
}
