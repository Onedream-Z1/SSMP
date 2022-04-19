package cn.xz.springboot.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(RuntimeException.class)
    public Result handleException(Exception ex){
        ex.printStackTrace();
        System.out.println("服务器异常，请稍后重试!");
        return Result.fail("服务器异常，请稍后重试!");
    }

}
