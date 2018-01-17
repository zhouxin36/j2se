package com.zx.enumdemo.exp1;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;

enum Explore {HERE,THERE}

public class Reflection {
    public static void analyze(Class<?> enumClass){
        System.out.println("-------------analyze"+enumClass+"-----------");
        for (Type type:
             enumClass.getGenericInterfaces()) {
            System.out.print(type+":"+"/n");
        }
        System.out.println("base:"+enumClass.getGenericSuperclass());
        System.out.println("---------method---------");
        for (Method m :
                enumClass.getMethods()) {
            System.out.println(m.toString());
        }
    }

    public static void main(String[] args) {
        Reflection.analyze(Explore.class);
    }
}
