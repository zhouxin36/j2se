package com.zx.annotationdemo.test;

import com.zx.annotationdemo.annotation.UseCase;

public class PasswordUtrils {
    @UseCase(id = 1,description = "validate")
    boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }
}
