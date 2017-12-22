package com.spring.reflect;

import com.spring.reflect.dynamicproxy.DAOProxy;
import com.spring.reflect.entity.User;
import com.spring.reflect.proxy.UserDAO;
import com.spring.reflect.proxy.UserDAOImpl;
import com.spring.reflect.proxy.UserDAOProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTest {
    private  static final Logger logger = LoggerFactory.getLogger(ReflectApplicationTests.class);

    //代理设计
    @Test
    public void test1(){
        UserDAO userDAO = new UserDAOProxy(new UserDAOImpl());
        userDAO.insert(new User());
    }

    //动态代理设计
    @Test
    public void test2(){
        UserDAO userDAO = (UserDAO) new DAOProxy().bind(new UserDAOImpl());
        userDAO.insert(new User());
    }

    //基于cgLIB的动态代理设计（需要导入cglib依赖包）
    @Test
    public void test3(){
        final User user = new User();
        user.setEmail("1561578781");
        Enhancer enhancer = new Enhancer();//代理类对象
        enhancer.setSuperclass(User.class);//为代理设置一个父类
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                logger.info("------------------------->");
                return method.invoke(user,args);
            }
        });
        User user1 = (User) enhancer.create();
        logger.info(user1.getEmail());
    }
}
