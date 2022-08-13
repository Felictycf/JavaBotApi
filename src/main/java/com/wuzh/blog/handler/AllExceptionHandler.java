package com.wuzh.blog.handler;

import com.wuzh.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @auther :Wuzh
 * @date :2022/7/14
 */
@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-999,"系统异常");
    }
}
