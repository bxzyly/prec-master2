package com.goi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int articleId;

    @Column(nullable = false)
    private String commentedIds="0";//被评论者id

    @Column(nullable = false)
    private int userId;//评论者id

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;//创建时间

    public Comment(){}

    public Comment(String content, int articleId, String commentedIds, int userId, Date time) {
        this.content = content;
        this.articleId = articleId;
        this.commentedIds = commentedIds;
        this.userId = userId;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getCommentedIds() {
        return commentedIds;
    }

    public void setCommentedIds(String commentedIds) {
        this.commentedIds = commentedIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
