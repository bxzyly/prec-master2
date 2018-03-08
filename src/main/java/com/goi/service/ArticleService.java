package com.goi.service;

import com.goi.entity.Article;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface ArticleService {
    @Transactional
    String addAgree(String userId, String articleId);

    @Transactional
    String addDisagree(String userId, String articleId);

    @Transactional
    String addArticle(Article article);

    @Transactional
    String getArticleById(int articleId);
}
