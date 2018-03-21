package com.goi.controller;

import com.goi.entity.Label;
import com.goi.service.Impl.LabelServiceImpl;
import com.goi.service.LabelService;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class LabelController {

    @Autowired
    private LabelServiceImpl labelService;

    @GetMapping("/getLabels")
    public Object getLabels(){
        List<Label>  list = labelService.getLabels();
        return ResultUtil.success(list);
    }
}
