package com.wuzh.blog.vo.params;

import lombok.Data;

/**
 * @auther :Wuzh
 * @date :2022/7/14
 */
@Data
public class LoginUserParam {
    private String account;
    private String password;
    private String nickname;
    private String vcode;
    private String key;
    private String  registrationCode;
}
