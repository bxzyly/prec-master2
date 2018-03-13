package com.goi.controller;

import com.goi.exception.MyException;
import com.goi.util.AliyunMessageUtil;
import com.goi.util.CheckTelephoneUtil;
import com.goi.util.MD5Util;
import com.goi.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 处理所有关于验证码请求
 */

@RestController
public class VerificationCodeController {


    @RequestMapping("getVCodeForRegister")
    public Object getVCodeForRegister(@RequestParam("telephone") String telephone, HttpSession session)throws Exception{
        boolean flag = CheckTelephoneUtil.isMobileNum(telephone);//判断手机号是否正确
        if(flag){
            String random = ((int)Math.random()*89+10)+""+((int)Math.random()*89+10)+""+((int)Math.random()*89+10);//验证码
            System.out.println("验证码"+random);
            AliyunMessageUtil.sendSms(telephone,random);
            String vcode = MD5Util.md5Password(telephone+random);
            session.setAttribute("VCodeTelephone",telephone);
            session.setAttribute("VCodeForTelephone",vcode);
        }else{
            throw new MyException("手机号错误！");
        }
        return ResultUtil.success();
    }

}
