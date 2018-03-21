package com.goi.controller;


import com.goi.entity.Article;
import com.goi.result.Result;
import com.goi.service.ArticleService;
import com.goi.service.Impl.ArticleServiceImpl;
import com.goi.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @return
     */

    @PostMapping("/getArticles")
    public Object getArticles(@RequestParam("userId") Long userId){
        List<Article> articleList = (List<Article>)articleService.getArticles(userId);
        return ResultUtil.success(articleList);
    }

    @GetMapping("/getArticles/{labelId}")
    public Object getArticleById(@PathParam("labelId") Long labelId) throws Exception {
        return ResultUtil.success(articleService.getArticleById(labelId));
    }
}
