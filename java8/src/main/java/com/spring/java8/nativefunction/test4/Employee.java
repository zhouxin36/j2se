package com.spring.java8.nativefunction.test4;

/**
 * 动态方法
 * 本地方法使用内部变量salary
 */
public class Employee {

    private String name;
    private double salary;

    public native void raiseSalary(double byPercent);

//    public void raiseSalary(double byPercent){
//        salary *= 1 + byPercent / 100;
//    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    static {
        System.loadLibrary("com_spring_java8_nativefunction_test4_Employee");
    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        for (Employee e :
                staff) {
            e.raiseSalary(5);
        }
        for (Employee e :
                staff) {
            System.out.println(e.name + " " + e.salary);
        }
    }
}
