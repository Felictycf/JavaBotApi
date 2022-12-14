package com.wuzh.blog.common.aop;

import com.alibaba.fastjson.JSON;
import com.wuzh.blog.utils.HttpContextUtils;
import com.wuzh.blog.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @auther :Wuzh
 * @date :2022/7/24/12:07
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(com.wuzh.blog.common.aop.LogAnnotation)")
    public void pt() {
    }

    @Around("pt()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime=System.currentTimeMillis();
        Object result=joinPoint.proceed();
        long time=System.currentTimeMillis()-beginTime;
        recordLog(joinPoint,time);
        return result;

    }
    private void recordLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("=====================log start================================");
        log.info("module:{}",logAnnotation.module());
        log.info("operation:{}",logAnnotation.operater());

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}",className + "." + methodName + "()");

//        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JSON.toJSONString(args[0]);
        log.info("params:{}",params);

        //获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IPUtil.getIpAddr(request));


        log.info("excute time : {} ms",time);
        log.info("=====================log end================================");
    }
}
