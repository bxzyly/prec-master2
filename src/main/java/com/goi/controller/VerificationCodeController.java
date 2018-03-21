package com.goi.controller;

import com.goi.exception.MyException;
import com.goi.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理所有关于验证码请求
 */

@RestController
public class VerificationCodeController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("getVCodeForRegister")
    public Object getVCodeForRegister(@RequestParam("telephone") String telephone)throws Exception{
        boolean flag = CheckTelephoneUtil.isMobileNum(telephone);//判断手机号是否正确
        if(flag){
            String random = ((int)(Math.random()*89)+10)+""+((int)(Math.random()*89)+10)+""+((int)(Math.random()*89)+10);//验证码
            AliyunMessageUtil.sendSms(telephone,random);
            String vcode = MD5Util.md5Password(telephone+random);
            redisUtil.setex(telephone,60*5,vcode);
        }else{
            throw new MyException("手机号错误！");
        }
        return ResultUtil.success();
    }

}
