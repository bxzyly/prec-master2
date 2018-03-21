package com.goi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Article {

    /**
     * 文章
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "作者id不能为空，authorId")
    @Column(nullable = false)
    private Long authorId; // 作者id

    @NotEmpty(message = "文章内容不能为空，content")
    @Column(nullable = false,columnDefinition = "TEXT")
    private String content; // 文章内容

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date time;

    private Long hot = (long)0; // 热度

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Article_Label",joinColumns = {@JoinColumn(name = "aid")},inverseJoinColumns = {@JoinColumn(name = "lid")})
    private List<Label> labelList;

    @OneToMany(mappedBy = "article",fetch = FetchType.LAZY)
    private List<Article_Label> article_labels;

    @Transient
    private List<Comment> comments; // 评论

    @Transient
    private List<Label> labels; // 文章标签

    public Article() {
    }

    public Article(Long authorId, String content, Date time, Long hot, List<Label> labelList, List<Article_Label> article_labels, List<Comment> comments, List<Label> labels) {
        this.authorId = authorId;
        this.content = content;
        this.time = time;
        this.hot = hot;
        this.labelList = labelList;
        this.article_labels = article_labels;
        this.comments = comments;
        this.labels = labels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getHot() {
        return hot;
    }

    public void setHot(Long hot) {
        this.hot = hot;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    public List<Article_Label> getArticle_labels() {
        return article_labels;
    }

    public void setArticle_labels(List<Article_Label> article_labels) {
        this.article_labels = article_labels;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
