package com.goi.controller;

import com.goi.bean.UserBean;
import com.goi.entity.User;
import com.goi.result.Result;
import com.goi.result.ReturnData;
import com.goi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *用户注册
     * @return
     */
    @RequestMapping("/userRegister")
    public ReturnData<User> register_user(User u){
        return userService.register_user(u);
    }

    /**
     * 修改用户基本信息
     * @param u
     * @return
     */
    @RequestMapping("/update")
    public Result<User> updateUser(User u){
        return userService.updateUser(u);
    }


    /**
     * 修改密码
     * @return
     */
//    @RequestMapping("/updatePassword")
////    public Result<UserLogin> updatePassword(@RequestParam("username") String username,@RequestParam("password") String password){
////        return userService.updatePassword(username,password);
////    }

    /**
     * 通过账号登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/loginByUsername")
    public Result<UserBean> loginByUsername(@RequestParam("username") String  username,@RequestParam("password") String password){
        return userService.loginByUsername(username,password);
    }

    /**
     * 通过账号登录
     * @param username
     * @param password
     * 以ReturnData形式返回
     * @return
     */
    @RequestMapping("/loginByUsername2")
    public ReturnData<UserBean> loginByUsername2(@RequestParam("username") String  username, @RequestParam("password") String password){
        return userService.loginByUsername2(username,password);
    }

}
