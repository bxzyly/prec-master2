package com.goi.repository;

import com.goi.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Integer> {

    @Query("select commentIds from Article where id = ?1")
    String findCommentIdsById(int id);


}
