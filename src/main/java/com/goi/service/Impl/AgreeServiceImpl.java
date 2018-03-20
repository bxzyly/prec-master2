package com.goi.service.Impl;

import com.goi.entity.Agree;
import com.goi.exception.MyException;
import com.goi.repository.AgreeRepository;
import com.goi.service.AgreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AgreeServiceImpl implements AgreeService{

    @Autowired
    private AgreeRepository agreeRepository;

    @Override
    @Transactional
    public Object addAgree(Agree agree)throws Exception{
        if(agreeRepository.findByUserIdAndArticleId(agree.getUserId(),agree.getArticleId())!=null){
            agreeRepository.save(agree);
            return true;
        }else{
             throw new MyException("你已经点过赞了！");
        }
    }

}
