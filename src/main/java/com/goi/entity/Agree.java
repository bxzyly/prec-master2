package com.goi.entity;

import org.hibernate.validator.constraints.NotEmpty;

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
    private Long id;

    @NotEmpty(message = "咨询id不能为空！")
    private Long articleId;

    @NotEmpty(message = "用户id不能为空！")
    private Long userId;

    public Agree(){

    }

    public Agree(Long articleId, Long userId) {
        this.articleId = articleId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Agree{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId=" + userId +
                '}';
    }
}
