package com.spring.java8.nativefunction.test1;

/**
 * hello world
 */
public class Test {
    public static void main(String[] args) {
        HelloNative.greeting();
    }

    static {
        System.loadLibrary("com_spring_java8_nativefunction_test1_HelloNative");
    }
}
