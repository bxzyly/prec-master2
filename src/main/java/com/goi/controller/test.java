package com.goi.controller;


import com.goi.entity.Label;
import com.goi.entity.User;
import com.goi.repository.LabelRepository;
import com.goi.repository.UserRepository;
import com.goi.service.Impl.RedisServiceImpl;
import com.goi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class test {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("/test")
    public Object test(){
//        User u = new User("123","123","18258851282");
//        Label label1 = labelRepository.findOne(Long.valueOf(1));
//        Label label2 = labelRepository.findOne(Long.valueOf(2));
//        List<Label> labelList = new ArrayList<>();
//        labelList.add(label1);
//        labelList.add(label2);
//        u.setLabelList(labelList);
//        Date date = new Date();
//        u.setTime(date);
//        userRepository.save(u);
//        User u = userRepository.findOne(Long.valueOf(1));
//        List<Label> labels = u.getLabelList();
//        return labels;
//        User user = new User("123","456","1",0);
        return "test";
    }

    @RequestMapping("/addre")
    public Object add(){
        redisService.put("key","1",6000);
        return "yes";
    }

    @RequestMapping("/getre")
    public Object get(){
        return redisService.get("key");
    }
}
