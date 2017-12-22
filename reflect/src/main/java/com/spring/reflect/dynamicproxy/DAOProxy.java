package com.spring.reflect.dynamicproxy;

import com.spring.reflect.proxy.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DAOProxy implements InvocationHandler {
    private final static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    private Object target;
    public void log(String methodName){
        logger.info("-------------->进行日志记录："+methodName);
    }
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.log(method.getName());
        Object retObj = method.invoke(this.target,args);
//        if(method.getName().matches("do[a-zA-Z0-9]+"))
        return retObj;
    }

}
