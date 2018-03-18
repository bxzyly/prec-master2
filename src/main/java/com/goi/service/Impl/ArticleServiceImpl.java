package com.goi.service.Impl;


import com.goi.entity.*;
import com.goi.repository.*;
import com.goi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AgreeRepository agreeRepository;

    @Autowired
    private DisagreeRepository disagreeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LabelRepository labelRepository;


    @Override
    @Transactional
    public Object getArticles(Long userId){
//        User user = userRepository.findOne(userId);//获得用户
//        List<Label> userLabel = user.getLabelUserList();//获得用户标签
//        List<Article> articleList = new ArrayList<>();//目标文章列表
//        for(Label label:userLabel){
//            List<Article> articleList1 = label.getLabelfromArticle();
//            articleList1 =  sort(articleList1);
//            if(articleList1.size()>=3){//超过三个加三个
//                for(int i = 0;i<3;i++){
//                    Article article = articleList1.get(i);
//                    if(!articleList.contains(article))
//                        articleList.add(article);
//                }
//            }else{//没有三个全加
//                for(Article article:articleList1){
//                    if(!articleList.contains(article))
//                        articleList.add(article);
//                }
//            }
//        }
//        List<Article> articles = articleRepository.getArticles();
//        for(Article article:articles){
//            if(!articleList.contains(article)){
//                articleList.add(article);
//            }
//        }
//        return articleList;
        return null;
    }

    @Override
    @Transactional
    public List<Article> getArticleById(Long labelId) throws Exception{
        Label label = labelRepository.findOne(labelId);
       // List<Article> articleList = label.getLabelfromArticle();
        List<Article> list = new ArrayList<>();
        for(int i = 0;i<20;i++){
          //  list.add(articleList.get(i));
        }
        return sort(list);
    }

    public List<Article> sort(List<Article> list){
        Collections.sort(list, new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return (int)(o2.getHot()-o1.getHot());
            }
        });
        return list;
    }
}
