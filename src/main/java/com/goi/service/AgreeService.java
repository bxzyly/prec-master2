package com.goi.service;

import com.goi.entity.Agree;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AgreeService {
    @Transactional
    Object addAgree(Agree agree)throws Exception;
}
