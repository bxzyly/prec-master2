package com.goi.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserKeyWords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int  keyWordId;

    private int userId;

    public UserKeyWords(){

    }

    public UserKeyWords(int keyWordId, int userId) {
        this.keyWordId = keyWordId;
        this.userId = userId;
    }

    public int getKeyWordId() {
        return keyWordId;
    }

    public void setKeyWordId(int keyWordId) {
        this.keyWordId = keyWordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
