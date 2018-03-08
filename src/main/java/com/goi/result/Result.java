package com.goi.result;

public class Result<T> {

    private T data;
    private Integer resultCode;
    private String resultInfo;

    public Result() {
    }

    public Result(T data, int resultCode, String resultInfo) {
        this.data = data;
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}
