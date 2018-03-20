package com.goi.controller;

import com.goi.entity.Agree;
import com.goi.entity.Disagree;
import com.goi.service.AgreeService;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/agree")
public class AgreeController {

    @Autowired
    private AgreeService agreeService;

    @PostMapping("/addAgree")
    public Object addAgree(@Valid Agree agree, BindingResult bindingResult)throws Exception{
        if(bindingResult.hasErrors())
            return ResultUtil.error(bindingResult);
        if( (boolean) agreeService.addAgree(agree)){
            return ResultUtil.success();
        }else{
            return ResultUtil.fail();
        }
    }

    @PostMapping("/addDisagree")
    public Object addAgree(@Valid Disagree  disAgree, BindingResult bindingResult)throws Exception{
        if(bindingResult.hasErrors())
            return ResultUtil.error(bindingResult);
        if( (boolean) agreeService.addDisagree(disAgree)){
            return ResultUtil.success();
        }else{
            return ResultUtil.fail();
        }
    }

}
