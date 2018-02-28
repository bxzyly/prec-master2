package com.goi.result;

public class Result<T> {

    private String flag;
    private T content;

    public Result() {
    }

    public Result(String flag, T content) {
        this.flag = flag;
        this.content = content;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
