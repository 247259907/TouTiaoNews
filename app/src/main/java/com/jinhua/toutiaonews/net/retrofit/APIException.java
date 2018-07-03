package com.jinhua.toutiaonews.net.retrofit;

public class APIException extends Throwable{
    private int code;
    private String msg;

    public APIException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
