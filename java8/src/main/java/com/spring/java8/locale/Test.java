package com.spring.java8.locale;

import java.text.NumberFormat;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Locale locale =  Locale.GERMAN;
        NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);
        double amt = 123456.78;
        String result = currFmt.format(amt);
        System.out.println(result);
    }
}
