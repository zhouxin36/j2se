package com.j2se.transactionannotation.service;

import com.j2se.transactionannotation.annotation.Transactional;
import com.j2se.transactionannotation.bean.User;
import com.j2se.transactionannotation.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;

    @Transactional
    public void test(){
        User user = new User();
        user.setName("zhouxin");
        user.setPassword("12345");
        userMapper.insert(user);
        System.out.println("testsets");
        int i = 1/0;
    }
}
