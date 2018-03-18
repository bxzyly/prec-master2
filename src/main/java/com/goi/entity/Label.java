package com.goi.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "标签名称不能为空，labelName")
    @Column(nullable = false)
    private String labelName; // 标签名称

    @Column(nullable = false)
    private Long parentId = Long.valueOf(0);//0表示第一级

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_label",joinColumns = {@JoinColumn(name = "lid")},inverseJoinColumns = {@JoinColumn(name="uid")})
    private List<User> userList;

    @OneToMany(mappedBy = "label",fetch = FetchType.LAZY)
    private List<User_Label> user_labels;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "article_label",joinColumns = {@JoinColumn(name = "lid")},inverseJoinColumns = {@JoinColumn(name="aid")})
    private List<Article> articleList;

    @OneToMany(mappedBy = "label",fetch = FetchType.LAZY)
    private List<Article_Label> article_labels;

    public Label() {
    }

    public Label(String labelName, Long parentId) {
        this.labelName = labelName;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article_Label> getArticle_labels() {
        return article_labels;
    }

    public void setArticle_labels(List<Article_Label> article_labels) {
        this.article_labels = article_labels;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User_Label> getUser_labels() {
        return user_labels;
    }

    public void setUser_labels(List<User_Label> user_labels) {
        this.user_labels = user_labels;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(labelName, label.labelName) &&
                Objects.equals(parentId, label.parentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, labelName, parentId);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                ", parentId=" + parentId +
                '}';
    }


}
