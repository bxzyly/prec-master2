package com.goi.controller;

import com.goi.entity.User;
import com.goi.exception.MyException;
import com.goi.result.Result;
import com.goi.service.UserService;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController{

    @Autowired
    private UserService userService;


    /**
     *用户注册
     * @return
     */
    @PostMapping("/userRegister")
    public Object register(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult);
        }
        User u = null;
        if(!userService.checkUsername(user.getUsername())){
            if(userService.addUser(u = new User(user.getUsername(),user.getPassword(),user.getTelephone()))){
                return ResultUtil.success(u);
            }else{
                return ResultUtil.fail("注册失败！");
            }
        }
        return ResultUtil.error();
    }


    @PostMapping("/userLoginByUsername")
    public Result loginByUsername(@RequestParam("username") String username,@RequestParam("password") String password)throws Exception{
        int loginFlag = userService.checkLoginByUsername(username,password);
        if(loginFlag == 1){//登录成功！
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
