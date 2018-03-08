package com.goi.exception;

import com.goi.enums.ResultEnum;

public class MyException extends RuntimeException{

    private Integer code;

    public MyException(String message){
        super(message);
    }

    public MyException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
