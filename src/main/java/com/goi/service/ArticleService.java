package com.goi.service;

import com.goi.entity.Article;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface ArticleService {

    @Transactional
    Object getArticles(Long userId);
}
