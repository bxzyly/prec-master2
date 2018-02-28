package com.goi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KeyWords {

    /**
     *关键字
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String keyword;

    public KeyWords(){

    }

    public KeyWords(String keyword) {
        super();
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
