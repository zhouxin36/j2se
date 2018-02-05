package com.j2se.transactionannotation.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.util.Date;

public class BookServiceFactory {
    private BookServiceFactory() {

    }
    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
        Enhancer enhancer = new Enhancer();
        // 将Enhancer中的superclass属性赋值成BookServiceBean
        enhancer.setSuperclass(BookServiceBean.class);
        // 将Enhancer中的callbacks属性赋值成myProxy
        enhancer.setCallback(myProxy);
        Class[] classes = {String.class, Date.class};
        Object[] objects = {"zhouxin",new Date()};
        return (BookServiceBean) enhancer.create(classes,objects);
    }
}
