package com.goi.controller;


import com.goi.entity.Article;
import com.goi.service.Impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    /**
     * 点赞
     * @param userId
     * @param articleId
     * @return
     */
    @RequestMapping("/addAgree")
    public String addAgree(@RequestParam("userId") String userId,@RequestParam("articleId") String articleId){
       return   articleServiceImpl.addAgree(userId,articleId);
    }

    /**
     * 点踩
     * @param userId
     * @param articleId
     * @return
     */
    @RequestMapping("/addDisagree")
    public String addDisagree(@RequestParam("userId") String userId,@RequestParam("articleId") String articleId){
        return   articleServiceImpl.addDisagree(userId,articleId);
    }

    @RequestMapping("/addArticle")
    public String addArticel(Article article){
        return articleServiceImpl.addArticle(article);
    }

//    @RequestMapping("/getArticleById")
//    public ReturnData<Article> getArticleById(@RequestParam("id") int articleId){
//        return articleServiceImpl.getArticleById(articleId);
//    }
}
