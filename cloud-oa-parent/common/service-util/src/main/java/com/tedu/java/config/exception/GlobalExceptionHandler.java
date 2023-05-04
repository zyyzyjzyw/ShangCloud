package com.tedu.java.config.exception;

import com.tedu.java.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName GlobalExceptionHandler.java
 * @Description TODO
 * @createTime 2023年03月08日 21:29:00
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常处理执行的方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("执行了全局异常");
    }
    // 特定异常
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail().message("执行了ArithmeticException异常");
    }
    // 自定义异常
    @ExceptionHandler(CustomException.class)
    public Result error(CustomException e){
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }
}
