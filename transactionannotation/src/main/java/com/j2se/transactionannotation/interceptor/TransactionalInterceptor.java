package com.j2se.transactionannotation.interceptor;

import com.j2se.transactionannotation.annotation.Transactional;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class TransactionalInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TransactionalInterceptor.class);

    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {
    }

//    @Qualifier("")
    @Autowired
    DataSource dataSource;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;


    @Around("anyPublicMethod()&&@annotation(transactional)")
    public void proceed(ProceedingJoinPoint pjp, Transactional transactional){
        logger.info("-------------------------进来啦！！");
//        MethodSignature signature = (MethodSignature) pjp.getSignature();
//        Method method = signature.getMethod(); //获取被拦截的方法
//        String methodName = method.getName(); //获取被拦截的方法名
//        logger.info("------->"+methodName);
        dataSourceTransactionManager.setDataSource(dataSource);
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = dataSourceTransactionManager.getTransaction(transactionDefinition);
//        TransactionStatus status = new DefaultTransactionStatus(dataSourceTransactionManager
//                                                                ,true,true
//                                                                ,false,false,null);
        try {
            System.out.println("前置通知");
            pjp.proceed();
            System.out.println("后置通知");
            dataSourceTransactionManager.commit(status);
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            dataSourceTransactionManager.rollback(status);
            throwable.printStackTrace();
        }
        System.out.println("返回通知");
    }
}
