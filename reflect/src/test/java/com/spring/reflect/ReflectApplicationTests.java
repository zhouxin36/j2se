package com.spring.reflect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectApplicationTests {

	private  static final Logger logger = LoggerFactory.getLogger(ReflectApplicationTests.class);

	//反射默认构造函数
	@Test
	public void defaultConstructor() throws Exception{
		Class<?> cls = Class.forName("com.spring.reflect.entity.User");
		//相当于Object obj = new User();
		Object obj = cls.newInstance();
		logger.info("-------------->"+obj.toString());
	}

	//反射有参构造函数
	@Test
	public void testConstructor() throws Exception{
		Class<?> cls = Class.forName("com.spring.reflect.entity.User");
		Constructor<?> constructor = cls.getConstructor(String.class,String.class,
				String.class,Integer.class,String.class,String.class);
		Object obj = constructor.newInstance(Math.random()+"",
				"zhouxin","123456",18,"男","1561578781@qq.com");
		logger.info("-------------->"+obj.toString());
	}

	//获得String的所有构造函数
	@Test
	public void getAllConstructor() throws Exception{
        Class<?> cls = Class.forName("java.lang.String");
        Constructor<?> [] constructors = cls.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            logger.info("-------------->"+constructors[i].toString());
        }
    }

    //反射输出所有方法
    @Test
    public void testMethod() throws Exception{
        Class<?> cls = Class.forName("com.spring.reflect.entity.User");
        //取得包括父类的所有方法
        Method method [] = cls.getMethods();
        //取得本类所有方法
        Method method1 [] = cls.getDeclaredMethods();
        for (int i = 0; i < method.length; i++) {
            logger.info("-------------->"+method[i].toString());
        }
        logger.info("====================我是分割线============================");
        for (int i = 0; i < method1.length; i++) {
            logger.info("-------------->"+method1[i].toString());
        }
    }

    //反射输出所有方法(拼凑版)
    @Test
    public void testMethod1() throws Exception{
        Class<?> cls = Class.forName("com.spring.reflect.entity.User");
        //取得包括父类的所有方法
        Method method [] = cls.getMethods();
        //拼凑方法修饰符
        logger.info("=====================修饰符===============================");
        for (int i = 0; i < method.length; i++) {
            logger.info("-------------->"+ Modifier.toString(method[i].getModifiers()));
        }
        //拼凑方法返回值
        logger.info("=====================返回值===============================");
        for (int i = 0; i < method.length; i++) {
            logger.info("-------------->"+ method[i].getReturnType().getSimpleName());
        }

        //拼凑方法参数
        logger.info("=====================参数===============================");
        for (int i = 0; i < method.length; i++) {
            if (method[i].getParameterTypes().length>0){
                String str = "";
                for (int j = 0; j < method[i].getParameterTypes().length; j++) {
                    if (j != 0){
                        str += ",";
                    }
                    str += method[i].getParameterTypes()[j].getSimpleName();
                }
                logger.info("-------------->"+str);

            }else {
                logger.info("-------------->没有参数");
            }

        }

        //拼凑方法抛出
        logger.info("=====================异常===============================");
        for (int i = 0; i < method.length; i++) {
            if (method[i].getExceptionTypes().length>0){
                String str = "";
                for (int j = 0; j < method[i].getExceptionTypes().length; j++) {
                    if (j != 0){
                        str += ",";
                    }
                    str += method[i].getExceptionTypes()[j].getSimpleName();
                }
                logger.info("-------------->"+str);
            }else {
                logger.info("-------------->不抛异常");
            }
//            logger.info("-------------->"+ method[i].getReturnType().getSimpleName());
        }
    }


    //通过反射调用函数
    @Test
    public void callFunction() throws Exception{
        Class<?> cls = Class.forName("com.spring.reflect.entity.User");
        Object object = cls.newInstance();
        Method setUserNameMethod = cls.getMethod("setUsername",String.class);
        Method getUserNameMethod = cls.getMethod("getUsername");
        setUserNameMethod.invoke(object,"zhouxin");
        logger.info("-------------------->"+getUserNameMethod.invoke(object));
    }

    //通过反射取得属性(不建议使用)
    @Test
    public void getFields() throws Exception{
        Class<?> cls = Class.forName("com.spring.reflect.entity.User");
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            logger.info("-------------------->"+fields[i].toString());
        }
//        cls.getSuperclass().getDeclaredFields()获得父类属性
    }

    //通过反射设置属性(不建议使用)
    @Test
    public void setAndGetField() throws Exception{
        Class<?> cls = Class.forName("com.spring.reflect.entity.User");
        Object object = cls.newInstance();
        Field field = cls.getDeclaredField("username");
        //取消类属性封装，否则报异常
        field.setAccessible(true);
        field.set(object,"zhouxin");
        logger.info("--------------->"+field.get(object));
    }
}
