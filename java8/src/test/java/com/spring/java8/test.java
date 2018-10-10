package com.spring.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class test {
    private  static final Logger logger = LoggerFactory.getLogger(test.class);

    @Test
    public void contextLoads() throws Exception{

    }

    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("PostTest.class");
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);
    }

}
