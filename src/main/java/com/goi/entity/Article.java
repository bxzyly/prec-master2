package com.goi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Article {

    /**
     * 文章
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int authorId;//作者id

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String labelIds;//表示这个文章基本标签

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String commentIds = "0";//评论者的id

    private long hot = 0;//热度

    public Article(){

    }

    public Article(int authorId, String content, String labelIds, Date time) {
        this.authorId = authorId;
        this.content = content;
        this.labelIds = labelIds;
        this.time = time;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(String commentIds) {
        this.commentIds = commentIds;
    }

    public long getHot() {
        return hot;
    }

    public void setHot(long hot) {
        this.hot = hot;
    }
}
