package com.goi.service;

import com.goi.entity.Label;
import com.goi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserService {
    @Transactional
    boolean checkUsername(String username) throws Exception;//判断用户是否存在

    @Transactional
    boolean addUser(User u);//添加用户

    @Transactional
    User checkLoginByUsername(String username,String password) throws Exception;//账号密码登录

    @Transactional
    Object addLabelList(Long userId, List<Long> labelList)throws Exception;

    @Transactional
    Object getUserByTelephone(String telephone)throws Exception;

    @Transactional
    boolean checkLoginByTelephone(String telephone);//手机登录
}
