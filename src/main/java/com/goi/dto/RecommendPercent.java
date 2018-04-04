package com.goi.dto;

public class RecommendPercent {
    private Integer articleId;
    private double percent;

    public RecommendPercent(Integer articleId,double percent){
            this.articleId = articleId;
            this.percent = percent;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
