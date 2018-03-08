package com.goi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment {

    /**
     * 评论
     */


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "评论内容不能为空，content")
    @Column(nullable = false)
    private String content;

    @NotNull(message = "文章id不能为空，articleId")
    @Column(nullable = false)
    private Long articleId;

    @NotNull(message = "评论者id不能为空，userId")
    @Column(nullable = false)
    private Long userId; // 评论者id

    private Long pId; // 父评论

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date time; // 创建时间

    @Transient
    private List<Comment> comments; // 被评论

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", pId=" + pId +
                ", time=" + time +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(articleId, comment.articleId) &&
                Objects.equals(userId, comment.userId) &&
                Objects.equals(pId, comment.pId) &&
                Objects.equals(time, comment.time) &&
                Objects.equals(comments, comment.comments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, articleId, userId, pId, time, comments);
    }
}
