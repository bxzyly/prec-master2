package com.goi.controller;

import com.goi.entity.Label;
import com.goi.entity.User;
import com.goi.exception.MyException;
import com.goi.result.Result;
import com.goi.service.Impl.RedisServiceImpl;
import com.goi.service.UserService;
import com.goi.util.MD5Util;
import com.goi.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private RedisServiceImpl redisService;


    /**
     *用户注册
     * @return
     */
    @ApiOperation(value = "注册",notes = "注册")
    @PostMapping("/userRegister")
    public Object register(@Valid User user, BindingResult bindingResult, @RequestParam("VCode") String vcode) throws Exception {
        if(bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult);
        }
        String tempvcode = String.valueOf(redisService.get(user.getTelephone()));
        if(tempvcode==null){
            throw new MyException("验证码失效！");
        }else if(!MD5Util.md5Password(user.getTelephone()+vcode).equals(tempvcode)){
            throw new MyException("验证码错误!");
        }
        User u = null;
        if(!userService.checkUsername(user.getUsername())){
            if(userService.addUser(u = new User(user.getUsername(),user.getPassword(),user.getTelephone(),0))){
                return ResultUtil.success(u);
            }else{
                return ResultUtil.fail("注册失败！");
            }
        }
        return ResultUtil.error();
    }

    @ApiOperation(value = "注册时添加标签",notes = "标签")
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
            return ResultUtil.success(u);
        }else{
            return ResultUtil.error();
        }
    }

    @PostMapping("/userLoginByTelephone")
    public Result loginByTelephone(@RequestParam("telephone") String telephone,@RequestParam("verificationCode") String verificationCode) throws Exception {
        String tempvcode = String.valueOf(redisService.get(telephone));
        if(tempvcode==null){
            throw new MyException("验证码失效！");
        }else if(!MD5Util.md5Password(telephone+verificationCode).equals(tempvcode)){
            throw new MyException("验证码错误!");
        }
        boolean loginFlag = userService.checkLoginByTelephone(telephone);
        if(loginFlag){
            return ResultUtil.success();
        }else{
            User u = null;
            userService.addUser(u = new User("用户_"+telephone,"123456",telephone,1));
            u = userService.checkLoginByUsername(u.getUsername(),"123456");
            return ResultUtil.success(u,"注册并登录成功");
        }
    }
}
