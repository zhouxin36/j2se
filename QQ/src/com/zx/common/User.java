package com.zx.common;

import java.io.Serializable;

public class User implements Serializable{
    private String UserId;
    private String password;

    public User() {
    }

    public User(String userId, String password) {
        UserId = userId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
