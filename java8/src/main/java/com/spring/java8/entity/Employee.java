package com.spring.java8.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Employee implements Serializable {
    public final static int NAME_SIZE = 30;
    public final static int RECORD_SIZE = 50;

    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year,month,day);
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "@"+ Integer.toHexString(hashCode()) + "[", "]")
                .add("name='" + name + "'")
                .add("salary=" + salary)
                .add("hireDate=" + hireDate)
                .toString();
    }

}
