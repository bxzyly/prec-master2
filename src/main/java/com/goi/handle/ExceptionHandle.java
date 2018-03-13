package com.goi.handle;

import com.goi.exception.MyException;
import com.goi.result.Result;
import com.goi.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception e){

        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getMessage());
        }else {
            //将系统异常以打印出来
            logger.info("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}


