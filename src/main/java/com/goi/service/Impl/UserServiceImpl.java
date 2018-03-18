package com.goi.service.Impl;

import com.goi.bean.UserBean;
import com.goi.entity.Label;
import com.goi.entity.User;
import com.goi.exception.MyException;
import com.goi.repository.LabelRepository;
import com.goi.repository.UserRepository;
import com.goi.service.UserService;
import com.goi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LabelRepository labelRepository;


    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    @Override
    @Transactional
    public boolean checkUsername(String username)throws Exception{
        User u = userRepository.findByUsername(username);
        if(u==null)//不存在
            return false;
        else
            throw new MyException("用户已经存在！");
    }


    /**
     * 添加用户
     * @param u
     * @return
     */
    @Override
    @Transactional
    public boolean addUser(User u){
        boolean flag = false;
        try{
            Date date = new Date();
            u.setTime(date);
            MD5Util md5Util = new MD5Util();
            String psd =  md5Util.md5Password(u.getPassword());
            u.setPassword(psd);
            userRepository.save(u);
            String nickname= "用户_"+u.getId();
            u.setNickname(nickname);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 返回0为密码错误1为登录成功2为账号错误
     * @param username
     * @param password
     * @return
     */
    @Override
    @Transactional
    public User checkLoginByUsername (String username, String password) throws Exception{
        User u = userRepository.findByUsername(username);
        if(u==null){
            throw new MyException("账号错误或无此用户！");
        }else{
            MD5Util md5Util = new MD5Util();
            if(md5Util.md5Password(password).equals(u.getPassword())){
                return u;
            }else{
                throw new MyException("密码错误！");
            }
        }
    }

    /**
     * 注册一开始添加label标签
     * @param userId
     * @param labelList
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Object addLabelList(Long userId, List<Long> labelList)throws Exception{
        User u = userRepository.findOne(userId);
        List<Label> labelList1 = new ArrayList<>();
        for(Long labelId:labelList){
            Label label = labelRepository.findOne(labelId);
            labelList1.add(label);
        }
        u.setLabelList(labelList1);
        return null;
    }


    /**
     * 判断手机号是否注册过
     * @param telephone
     * @return
     */

    @Override
    public boolean checkLoginByTelephone(String telephone) {
        User u = userRepository.findByTelephone(telephone);
        if(u==null){
            return false;
        }else{//success
            return true;
        }
    }
}
