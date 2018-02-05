package com.j2se.transactionannotation2.proxy;

import com.j2se.transactionannotation2.service.TestService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.j2se.transactionannotation2.proxy.Factory.getProxyInstance;


public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
//        Class[] classes = {String.class, Date.class};
//        BookServiceBean service = (BookServiceBean) getProxyInstance(BookServiceBean.class,classes,"zhouxin",new Date());
//        service.create();
//        log.info("------->"+service);
//
//        log.info("我们得到的bean是：" + service.getClass());
//        System.out.println("实际调用者的父类：" + service.getClass().getSuperclass());

        TestService2 proxyInstance = (TestService2) getProxyInstance(TestService2.class);
        proxyInstance.test();

    }
}