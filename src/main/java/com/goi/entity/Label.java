package com.goi.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "标签名称不能为空，labelName")
    @Column(nullable = false)
    private String labelName; // 标签名称

    public Label() {
    }

    public Label(String labelName) {
        this.labelName = labelName;
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

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                '}';
    }
}
