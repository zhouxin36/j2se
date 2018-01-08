package com.zx.common;


import java.io.Serializable;

public class ResultDTO<T> implements Serializable{

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResultDTO error() {
        return error(002, "系统出现异常");
    }

    public static ResultDTO error(String msg) {
        return error(002, msg);
    }

    public static ResultDTO error(int code, String msg) {
        ResultDTO r = new ResultDTO();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static ResultDTO ok() {
        ResultDTO r = new ResultDTO();
        r.setCode(200);
        return r;
    }

    public static ResultDTO ok(String msg) {
        ResultDTO r = ok();
        r.setMsg(msg);
        return r;
    }

    public static ResultDTO buildSuccessData(Object data) {
        ResultDTO r = ok();
        r.setData(data);
        return r;
    }
}
