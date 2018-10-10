package com.spring.java8.nativefunction.test6;

import java.io.PrintWriter;

/**
 * 抛异常
 */
public class Printf4 {

    public static native void fprint(PrintWriter out, String format, double x);

    static {
        System.loadLibrary("com_spring_java8_nativefunction_test6_Printf4");
    }
    public static void main(String[] args) {
        double price = 44.95;
        double tax = 7.75;
        double amountDue = price * (1 + tax / 100);
        PrintWriter out = new PrintWriter(System.out);
        fprint(out, "Amount due = %8.j2f\n", amountDue);
        out.flush();
    }
}
