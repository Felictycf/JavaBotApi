package com.wuzh.blog.Service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.Service.SysUserService;
import com.wuzh.blog.dao.mapper.SysUserMapper;
import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.utils.JWTUtils;
import com.wuzh.blog.vo.ErrorCode;
import com.wuzh.blog.vo.LoginUserVo;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.UserVo;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser==null){
            sysUser=new SysUser();
            sysUser.setNickname("为空");
        }
        return sysUser;
    }
    @Override
    public UserVo findUserVoById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser==null){
            sysUser=new SysUser();
            sysUser.setId(1L);
            sysUser.setAvatar("/static/img/logo.b3a48c0.png");
            sysUser.setNickname("为空");
        }
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(sysUser,userVo);
        userVo.setId(String.valueOf(sysUser.getId()));
        return userVo;
    }

    @Override
    public SysUser findUsers(String usn, String pwd) {
        LambdaQueryWrapper<SysUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,usn);
        queryWrapper.eq(SysUser::getPassword,pwd);
        queryWrapper.select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        Map<String, Object> stringObjectMap=null;
        try {
            stringObjectMap = JWTUtils.checkToken(token);
        }catch (ExpiredJwtException e){
            return Result.fail(ErrorCode.Login_illegal.getCode(), "tokem过期");
        }

        String userjson=redisTemplate.opsForValue().get("TOKEN_"+token);
        if (token==null||stringObjectMap==null||StringUtils.isBlank(userjson)){
            return Result.fail(ErrorCode.Login_illegal.getCode(), ErrorCode.Login_illegal.getMsg());
        }
        SysUser sysUser = JSON.parseObject(userjson, SysUser.class);
        LoginUserVo loginUserVo=new LoginUserVo();
        loginUserVo.setAccount(sysUser.getAccount());
        loginUserVo.setAvatar(sysUser.getAvatar());
        loginUserVo.setId(String.valueOf(sysUser.getId()));
        loginUserVo.setNickname(sysUser.getNickname());
            return Result.success(loginUserVo);

    }

    @Override
    public String findSalt(String usn) {
        LambdaQueryWrapper<SysUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,usn);
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        String salt=sysUser.getSalt();
        return salt;
    }
}
