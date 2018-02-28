package com.goi.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {

    /**
     * 基本标签
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  type="0";//标签的父子关系,若有关系则表示为“数字/id”数字第几级

    private String labelname;

    public UserModel() {
    }

    public UserModel(String type, String labelname) {
        this.type = type;
        this.labelname = labelname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }
}
