package com.spring.reflect;

import com.spring.reflect.classloader.MyClassLoader;
import com.spring.reflect.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {
    private  static final Logger logger = LoggerFactory.getLogger(ReflectApplicationTests.class);

    @Test
    public void test() throws Exception{
        Class<?> cls = User.class;
        Annotation annotation[] = cls.getAnnotations();
        for (int i = 0; i < annotation.length; i++) {
            logger.info("-------------->"+annotation[i].toString());
        }
    }


}
