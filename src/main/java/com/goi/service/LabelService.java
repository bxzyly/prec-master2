package com.goi.service;

import com.goi.entity.Label;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface LabelService {
    @Transactional
    List<Label> getLabels();
}
