package com.wuzh.blog.Service.impl;

import com.alibaba.fastjson.JSON;
import com.wuzh.blog.Service.LoginService;
import com.wuzh.blog.Service.SysUserService;
import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.utils.JWTUtils;
import com.wuzh.blog.vo.ErrorCode;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.LoginUserParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @auther :Wuzh
 * @date :2022/7/14
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserService sysUserService;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    //private static final String salt="wuzh666!@#@!^%#^&^*$%$#^%$&%^@$%$#^%$&$#@!$@#$%";
    @Override
    public Result login(LoginUserParam loginUserParam, HttpServletRequest request){
        String usn=loginUserParam.getAccount();
        String pwd= loginUserParam.getPassword();
        //先验证验证码是否正确
        String key=loginUserParam.getKey();
        String code=loginUserParam.getVcode();
        String keyCode = (String) request.getServletContext().getAttribute(key);
        if (!code.equalsIgnoreCase(keyCode)) {
            return Result.fail(200,"验证码错误");
        }


        if (StringUtils.isBlank(usn)||StringUtils.isBlank(pwd)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), "参数不合法");
        }
        String salt=sysUserService.findSalt(usn);
        pwd= DigestUtils.md2Hex(pwd+salt);
        SysUser sysUser=sysUserService.findUsers(usn,pwd);
 //       System.out.println("测试"+sysUser);
        if (sysUser==null){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), "参数不合法");
        }

//        System.out.println(666);
        String token = JWTUtils.createToken(sysUser.getId());
        System.out.println(token+"登录token");
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);

//        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
//        System.out.println(stringObjectMap);
//        Object id = stringObjectMap.get("userId");
//        System.out.println("object类型："+id);
//        try {
//            Long a= new Long(id.toString());
//            System.out.println(a+"=======");
//        }catch (Exception e){
//            System.out.println("转换异常1");
//        }
//        try {
//            System.out.println( Integer.parseInt(id.toString())+"=======");
//        }catch (Exception e){
//            System.out.println("转换异常2");
//        }

        return Result.success(token);


    }

    @Override
    public Result loginout(String token) {
        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);

    }

    @Override
    public SysUser checkToken(String token) {

        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);

        Object id = stringObjectMap.get("userId");
        Long a= new Long(id.toString());
        SysUser userById = sysUserService.findUserById(a);
        return userById;
    }

//    public static void main(String[] args) {
//        String p=DigestUtils.md2Hex("666"+salt);
//        System.out.println(p);
//    }
}
