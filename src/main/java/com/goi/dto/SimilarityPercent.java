package com.goi.dto;

public class SimilarityPercent {
    private Integer userId;
    private double percent;

    public SimilarityPercent(Integer userId,double percent){
        this.userId = userId;
        this.percent = percent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
