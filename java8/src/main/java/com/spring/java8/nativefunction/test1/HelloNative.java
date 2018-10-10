package com.spring.java8.nativefunction.test1;
//vcvarsall.bat amd64
//cl -I D:\common\jdk\include -I D:\common\jdk\include\win32 -LD com_spring_java8_nativefunction_HelloNative.c -Fecom_spring_java8_nativefunction_HelloNative.dll
public class HelloNative {

    public static native void greeting();
}
