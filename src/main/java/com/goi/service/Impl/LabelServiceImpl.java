package com.goi.service.Impl;

import com.goi.entity.Label;
import com.goi.repository.LabelRepository;
import com.goi.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Override
    @Transactional
    public List<Label> getLabels(){
        List<Label> list = (List<Label>)labelRepository.findAll();
        return list;
    }
}
