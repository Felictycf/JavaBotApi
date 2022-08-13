package com.wuzh.blog.Service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.Service.RegisterService;
import com.wuzh.blog.dao.mapper.RegisterCodeMapper;
import com.wuzh.blog.dao.mapper.SysUserMapper;
import com.wuzh.blog.dao.pojo.RegisterCode;
import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.utils.JWTUtils;
import com.wuzh.blog.vo.ErrorCode;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.LoginUserParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @auther :Wuzh
 * @date :2022/7/15
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RegisterCodeMapper registerCodeMapper;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Override
    @Transactional
    public Result register(LoginUserParam loginUserParam) {
//
        List<RegisterCode> codes = registerCodeMapper.findcode();
        RegisterCode registerCode=new RegisterCode();
        registerCode.setNum(loginUserParam.getRegistrationCode());
        boolean contains = codes.contains(registerCode);
        if (!contains){
            return Result.fail(200,"注册码错误");
        }
        String account= loginUserParam.getAccount();
        String password= loginUserParam.getPassword();
        String nickname= loginUserParam.getNickname();
        if (StringUtils.isBlank(account)||
            StringUtils.isBlank(password)||
            StringUtils.isBlank(nickname)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        LambdaQueryWrapper<SysUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.last("limit 1");
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        if (sysUser!=null){
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        String salt= RandomStringUtils.randomAlphanumeric(10);
        System.out.println("salt:"+salt);
        password= DigestUtils.md2Hex(password+salt);
        sysUser=new SysUser();
        sysUser.setAccount(account);
        sysUser.setNickname(nickname);
        sysUser.setPassword(password);
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("static/img/logo.b3a48c0.png");
        sysUser.setAdmin(1);
        sysUser.setDeleted(0);
        sysUser.setSalt(salt);
        sysUser.setStatus("");
        sysUser.setEmail("");
        sysUserMapper.insert(sysUser);
        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),30, TimeUnit.MINUTES);
        System.out.println(sysUser);
        return Result.success(token);
    }
}
