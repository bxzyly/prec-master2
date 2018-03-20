package com.goi.service.Impl;

import com.goi.entity.Agree;
import com.goi.entity.Disagree;
import com.goi.exception.MyException;
import com.goi.repository.AgreeRepository;
import com.goi.repository.DisagreeRepository;
import com.goi.service.AgreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgreeServiceImpl implements AgreeService{

    @Autowired
    private AgreeRepository agreeRepository;

    @Autowired
    private DisagreeRepository disagreeRepository;

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

    @Override
    @Transactional
    public Object addDisagree(Disagree disagree)throws Exception{
        if(disagreeRepository.findByUserIdAndArticleId(disagree.getUserId(),disagree.getArticleId())!=null){
            disagreeRepository.save(disagree);
            return true;
        }else{
            throw new MyException("你已经点过踩了！");
        }
    }

}
