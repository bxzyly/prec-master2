package com.goi.result;

public class ReturnData<T> {

    private int resultCode = 0;
    private String resultInfo ;
    private T data;

    public ReturnData() {
    }

    public ReturnData(int resultCode, String resultInfo, T data) {
        this.resultCode = resultCode;
        this.resultInfo = resultInfo;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
