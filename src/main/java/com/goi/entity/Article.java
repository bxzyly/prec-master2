package com.goi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(nullable = false)
    private String content; // 文章内容

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date time;

    private Long hot = (long)0; // 热度

    @Transient
    private List<Comment> comments; // 评论

    @Transient
    private List<Label> labels; // 文章标签

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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", hot=" + hot +
                ", comments=" + comments +
                ", labels=" + labels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                authorId == article.authorId &&
                hot == article.hot &&
                Objects.equals(content, article.content) &&
                Objects.equals(time, article.time) &&
                Objects.equals(comments, article.comments) &&
                Objects.equals(labels, article.labels);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, authorId, content, time, hot, comments, labels);
    }
}
