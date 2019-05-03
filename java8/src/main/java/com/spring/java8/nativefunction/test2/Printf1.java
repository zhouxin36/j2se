package com.spring.java8.nativefunction.test2;

/**
 * -Djava.library.path=F:\ideaproject\j2se\java8\src\main\java\com\spring\java8\nativefunction\test2
 * 参数传递
 */
public class Printf1 {

    public static native int print(int width, int precision, double x);

    static {
        System.loadLibrary("com_spring_java8_nativefunction_test2_Printf1");
    }

    public static void main(String[] args) {
        int count = print(8,4,3.14);
        count += print(8,4,count);
        System.out.println("count:"+count);
        for (int i = 0; i < count; i++) {
            System.out.println("-");
        }
        System.out.println();
    }
}
