package com.spring.reflect;

import com.spring.reflect.classloader.MyClassLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassLoaderTest {
    private  static final Logger logger = LoggerFactory.getLogger(ReflectApplicationTests.class);

    @Test
    public void test(){
        logger.info("-------------->"+ClassLoaderTest.class.getClassLoader());
        logger.info("-------------->"+ClassLoaderTest.class.getClassLoader().getParent());
    }

    @Test
    public void test2() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = myClassLoader.loadClass("java.util.Date");
        Object object = loadClass.newInstance();
        logger.info("---------------->"+object.toString());
    }
}
