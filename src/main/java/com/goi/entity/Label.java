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

    @ManyToMany(mappedBy = "labelUserList")
    private List<User> labelfromUser = new ArrayList<>();

    @ManyToMany(mappedBy = "articleLabelList")
    private List<Article> labelfromArticle = new ArrayList<>();

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

    public List<User> getLabelfromUser() {
        return labelfromUser;
    }

    public void setLabelfromUser(List<User> labelfromUser) {
        this.labelfromUser = labelfromUser;
    }

    public List<Article> getLabelfromArticle() {
        return labelfromArticle;
    }

    public void setLabelfromArticle(List<Article> labelfromArticle) {
        this.labelfromArticle = labelfromArticle;
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
