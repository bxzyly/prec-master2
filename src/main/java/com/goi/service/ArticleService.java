package com.goi.service;


import com.goi.entity.Agree;
import com.goi.entity.Article;
import com.goi.entity.Disagree;
import com.goi.repository.AgreeRepository;
import com.goi.repository.ArticleRepository;
import com.goi.repository.DisagreeRepository;
import com.goi.result.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

    @Autowired
    private AgreeRepository agreeRepository;

    @Autowired
    private DisagreeRepository disagreeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public String addAgree(String userId,String articleId){
        agreeRepository.save(new Agree(Integer.valueOf(articleId),Integer.valueOf(userId)));
        return "添加成功！";
    }

    @Transactional
    public String addDisagree(String userId,String articleId){
      disagreeRepository.save(new Disagree(Integer.valueOf(articleId),Integer.valueOf(userId)));
      return "添加成功！";
    }

    /**
     * 添加文章
     */
    @Transactional
    public String addArticle(Article article){
        articleRepository.save(article);
        return "添加成功";
    }

    @Transactional
    public ReturnData<Article> getArticleById(int articleId){
        ReturnData<Article> returnData = new ReturnData<>();
        returnData.setData(articleRepository.findOne(articleId));
        returnData.setResultCode(1);
        returnData.setResultInfo("成功！");
        return returnData;

    }
}
