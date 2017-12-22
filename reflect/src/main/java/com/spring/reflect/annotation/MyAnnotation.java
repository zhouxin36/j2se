package com.spring.reflect.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name() default "zhouxin";
    public String value() ;
}
