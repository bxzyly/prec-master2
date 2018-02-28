package com.goi.service;

import com.goi.bean.UserBean;
import com.goi.entity.User;
import com.goi.repository.UserRepository;
import com.goi.result.Result;
import com.goi.result.ReturnData;
import com.goi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * 用户注册
     * @param user
     * @return
     */
    @Transactional
    public ReturnData<User> register_user(User user){
        ReturnData<User> returnData = new ReturnData<>();
        try{
            User u = (User)userRepository.findByName(user.getName());
            if(u == null){//表示没有此用户则添加用户
                SimpleDateFormat bartDateFormat = new SimpleDateFormat
                        ("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                user.setTime(date);
                MD5Util md5Util = new MD5Util();
                String psd =  md5Util.md5Password(user.getPassword());
                user.setPassword(psd);
                userRepository.save(user);
                int id = userRepository.findByName(user.getName()).getId();
                user.setId(id);
                String username = "7768"+(int)Math.random()*50+id;
                //System.out.println(name);
                user.setUsername(username);
                returnData.setData(user);
                returnData.setResultCode(1);
                returnData.setResultInfo("注册成功！你的账号为:"+username+"!");
            }
        }catch(Exception e){

        }
        return returnData;
    }

    @Transactional
    public Result<User> updateUser(User u){
        Result<User> result = new Result<>();
        result.setFlag("修改失败！");
        try{
            userRepository.save(u);
            result.setFlag("修改成功！");
            result.setContent(u);
        }catch (Exception e){

        }
        return result;
    }

//    @Transactional
//    public Result<UserLogin> updatePassword(String username,String password){
//        Result<UserLogin> result = new Result<>();
//        result.setFlag("修改失败");
//        try{
//            UserLogin userLogin = userLoginRepository.findByUsername(username);
//            userLogin.setPassword(password);
//            result.setFlag("修改成功！");
//        }catch (Exception e){
//
//        }
//        return result;
//    }

    @Transactional
    public Result<UserBean> loginByUsername(String username,String password){
        Result<UserBean> userBeanResult = new Result<>();
        return userBeanResult;
    }

    @Transactional
    public ReturnData<UserBean> loginByUsername2(String username,String password){
        ReturnData<UserBean> returnData = new ReturnData<>();
        try{
            User user = userRepository.findByUsername(username);
            if(user==null){//没有此用户
                returnData.setData(null);
                returnData.setResultInfo("没有此用户！");
            }else{
                if(!password.equals(user.getPassword())){
                    returnData.setData(null);
                    returnData.setResultInfo("密码错误！");
                }else{
                    returnData.setResultCode(1);
                    returnData.setResultInfo("成功！");
                    UserBean userBean = new UserBean();
                    userBean.setUser(user);
                    returnData.setData(userBean);
                }
            }
        }catch (Exception e){

        }
        return returnData;
    }
}
