package com.goi.controller;

import com.goi.entity.Label;
import com.goi.entity.User;
import com.goi.exception.MyException;
import com.goi.result.Result;
import com.goi.service.UserService;
import com.goi.util.MD5Util;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController{

    @Autowired
    private UserService userService;


    /**
     *用户注册
     * @return
     */
    @PostMapping("/userRegister")
    public Object register(@Valid User user, BindingResult bindingResult, @RequestParam("VCode") String vcode, HttpSession httpSession) throws Exception {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult);
        }
        if(user.getTelephone().equals(String.valueOf(httpSession.getAttribute("VCodeTelephone")))){//手机号是否一致
            String random = MD5Util.md5Password(user.getTelephone()+vcode);
            if(!random.equals(String.valueOf(httpSession.getAttribute("VCodeForTelephone")))){
                throw new MyException("验证码错误!");
            }
        }else{
            throw new MyException("手机号与验证码手机不一致!");
        }
        User u = null;
        if(!userService.checkUsername(user.getUsername())){
            if(userService.addUser(u = new User(user.getUsername(),user.getPassword(),user.getTelephone()))){
                httpSession.removeAttribute("VCodeTelephone");
                httpSession.removeAttribute("VCodeForTelephone");
                httpSession.setAttribute("userId",u.getId());
                return ResultUtil.success(u);
            }else{
                return ResultUtil.fail("注册失败！");
            }
        }
        return ResultUtil.error();
    }

    @PostMapping("/userRegisterAddLabel")
    public Object userRegisterAddLabel (@RequestBody List<Long> labelIds, HttpSession httpSession)throws Exception{
        userService.addLabelList((Long)httpSession.getAttribute("userId"),labelIds);
        return ResultUtil.success();
    }



    @PostMapping("/userLoginByUsername")
    public Result loginByUsername(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession)throws Exception{
        User u = null;
        try {
           u = userService.checkLoginByUsername(username,password);
        }catch (Exception e){

        }
        if(u !=null){//登录成功！
            httpSession.setAttribute("userId",u.getId());
            return ResultUtil.success();
        }else{
            return ResultUtil.error();
        }
    }

    @PostMapping("/userLoginByTelephone")
    public Result loginByTelephone(@RequestParam("telephone") String telephone,@RequestParam("verificationCode") String erificationCode){
        if(true){//判断验证码
            return ResultUtil.fail("验证码错误！");
        }
        boolean loginFlag = userService.checkLoginByTelephone(telephone);
        if(loginFlag){
            return ResultUtil.success();
        }else{
            return ResultUtil.fail("无此用户！");
        }
    }
}
