package com.example.controller;

import com.example.entity.ExceptionResult;
import com.example.entity.ResultBody;
import com.example.exception.MyExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lyl04
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyExceptionHandler.class)
    @ResponseBody
    public ResultBody exceptionHandler(MyExceptionHandler e){
        log.error("业务异常：{}",e.getMessage());
        return ResultBody.error(e.getErrorCode(),e.getErrorCode());
    }

    /**
     * 处理空指针的异常
     * @param e
     * @return
     */
    public ResultBody exceptionHandler(NullPointerException e){
        log.error("空指针异常：{}",e.getMessage());
        return ResultBody.error(ExceptionResult.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e){
        log.error("未知异常：{}",e.getMessage());
        return ResultBody.error(ExceptionResult.INTERNAL_SERVER_ERROR);
    }
}

