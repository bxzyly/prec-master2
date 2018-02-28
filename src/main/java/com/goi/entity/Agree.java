package com.goi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agree {

    /**
     * 同意
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int articleId;

    private int userId;

    public Agree(){

    }

    public Agree(int articleId, int userId) {
        this.articleId = articleId;
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
