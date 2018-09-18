package com.spring.java8.entity;

import java.util.StringJoiner;

public class Manager extends Employee{

    private Employee secretary;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public Manager(String harry_hacker, int i, int i1, int i2, int i3) {
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Manager.class.getSimpleName() + "@"+ Integer.toHexString(hashCode()) + "[", "]")
                .add("secretary=" + secretary)
                .toString();
    }
}
