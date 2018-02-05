package com.j2se.transactionannotation2.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {
    private Logger log = LoggerFactory.getLogger(MyCglibProxy.class);

    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        log.info("调用的方法是：" + method.getName());
        log.info("实际调用者是： " + object.getClass());
        for (Object obj : objects) {
            log.info("方法参数类型为：" + obj.getClass());
        }
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation annotation:
             declaredAnnotations) {
            log.info("---------->"+annotation);
        }

        Object result = methodProxy.invokeSuper(object, objects);
        System.out.println("这是方法后");
        return result;
    }
}
