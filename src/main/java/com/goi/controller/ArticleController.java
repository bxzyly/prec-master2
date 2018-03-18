package com.goi.controller;


import com.goi.entity.Article;
import com.goi.result.Result;
import com.goi.service.ArticleService;
import com.goi.service.Impl.ArticleServiceImpl;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 获得articles
     * @param httpSession
     * @return
     */

    @RequestMapping("/getArticles")
    public Object getArticles(HttpSession httpSession){
        Long userId =(Long) httpSession.getAttribute("userId");
        List<Article> articleList = (List<Article>)articleService.getArticles(userId);
//        for(Article article:articleList){
//            article.setArticleLabelList(null);
//        }
        return ResultUtil.success(articleList);
    }

    @RequestMapping("/getArticles/{labelId}")
    public Object getArticleById(@PathParam("labelId") Long labelId) throws Exception {
        return ResultUtil.success(articleService.getArticleById(labelId));
    }
}
