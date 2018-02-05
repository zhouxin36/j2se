package com.j2se.transactionannotation;

import com.j2se.transactionannotation.bean.User;
import com.j2se.transactionannotation.dao.UserMapper;
import com.j2se.transactionannotation.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionannotationApplicationTests {

    @Autowired
    TestService testService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        testService.test();
    }

    @Test
    public void tew(){
        User user = new User();
        user.setPassword("123456789");
        user.setName("zh");
        userMapper.insert(user);
    }

}
