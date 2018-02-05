package com.j2se.transactionannotation2.proxy;

import net.sf.cglib.proxy.Enhancer;

public class Factory {
    private  final  static MyCglibProxy myProxy = new MyCglibProxy();
    private Factory() {

    }
    public static Object getProxyInstance(Class clazz,Class[] clazzes,Object... args) {
        Enhancer enhancer = new Enhancer();
        // 将Enhancer中的superclass属性赋值成BookServiceBean
        enhancer.setSuperclass(clazz);
        // 将Enhancer中的callbacks属性赋值成myProxy
        enhancer.setCallback(myProxy);
        return enhancer.create(clazzes,args);
    }
    public static Object getProxyInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        // 将Enhancer中的superclass属性赋值成BookServiceBean
        enhancer.setSuperclass(clazz);
        // 将Enhancer中的callbacks属性赋值成myProxy
        enhancer.setCallback(myProxy);
        return enhancer.create();
    }
}
