package com.spring.java8.nativefunction.test3;

/**
 * 字符串参数传递，返回
 */
public class Printf2 {

    public static native String sprint(String format, double x);

    static {
        System.loadLibrary("com_spring_java8_nativefunction_test3_Printf2");
    }

    public static void main(String[] args) {
        double price = 44.95;
        double tax = 7.75;
        double amountDue = price * (1 + tax / 100);
        String s = sprint("Amount due = %8.2f", amountDue);
        System.out.println(s);
    }
}
