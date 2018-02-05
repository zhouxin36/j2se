package com.j2se.transactionannotation.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三"));
        service.create();
        log.info("------->"+service);

        log.info("我们得到的bean是：" + service.getClass());
        System.out.println("实际调用者的父类：" + service.getClass().getSuperclass());

    }

}