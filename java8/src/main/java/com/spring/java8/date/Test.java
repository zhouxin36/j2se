package com.spring.java8.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {
        long until = LocalDateTime.MIN.until(LocalDateTime.MAX, ChronoUnit.YEARS);
        System.out.println(until);
    }
}
