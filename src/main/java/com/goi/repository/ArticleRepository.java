package com.goi.repository;

import com.goi.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Query(nativeQuery = true,value = "select * from article ORDER by hot DESC  limit 0,50")
    List<Article> getArticles();
}
