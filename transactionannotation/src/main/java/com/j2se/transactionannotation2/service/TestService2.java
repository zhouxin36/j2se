package com.j2se.transactionannotation2.service;

import com.j2se.transactionannotation.bean.User;
import com.j2se.transactionannotation.dao.UserMapper;
import com.j2se.transactionannotation2.Tran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService2 {

    @Autowired
    UserMapper userMapper;


    @Tran
    public void test(){
        User user = new User();
        user.setName("zhouxin");
        user.setPassword("12345");
        userMapper.insert(user);
        System.out.println("sdfsd");
        int i = 1/0;
    }
}
