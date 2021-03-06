package com.goi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accusation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private int reporterId;

    private int reportedId;

    public Accusation(){

    }

    public Accusation(String content, int reporterId, int reportedId) {
        this.content = content;
        this.reporterId = reporterId;
        this.reportedId = reportedId;
    }

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

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public int getReportedId() {
        return reportedId;
    }

    public void setReportedId(int reportedId) {
        this.reportedId = reportedId;
    }

    @Override
    public String toString() {
        return "Accusation{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", reporterId=" + reporterId +
                ", reportedId=" + reportedId +
                '}';
    }
}

