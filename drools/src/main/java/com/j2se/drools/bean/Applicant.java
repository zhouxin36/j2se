package com.j2se.drools.bean;

public class Applicant {
    private String name;
    private int age;
    private boolean valid;

    public Applicant(String name, int age) {
        this.name = name;
        this.age = age;
        this.valid = true;
    }

    public Applicant() {
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", valid=" + valid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
