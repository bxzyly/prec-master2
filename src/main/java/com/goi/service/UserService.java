package com.goi.service;

import com.goi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {
    @Transactional
    boolean checkUsername(String username);//判断用户是否存在

    @Transactional
    boolean addUser(User u);//添加用户

    @Transactional
    int checkLoginByUsername(String username,String password);//账号密码登录

    @Transactional
    boolean checkLoginByTelephone(String telephone);//手机登录
}
