package com.goi.dto;

public class UserMaping {
    private int userId;
    private int[] articleId;

    public UserMaping(int userId , int[] articleId){
        this.userId = userId;
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getArticleId() {
        return articleId;
    }

    public void setArticleId(int[] articleId) {
        this.articleId = articleId;
    }
}
