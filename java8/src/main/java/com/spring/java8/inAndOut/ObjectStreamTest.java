package com.spring.java8.inAndOut;

import com.spring.java8.entity.Employee;
import com.spring.java8.entity.Manager;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException ,ClassNotFoundException{
        Employee harry = new Employee("Harry Hacker",50000,1989,10,1);
        Manager carl = new Manager("Carl Cracker",75000,1987,12,15);
        Manager tony = new Manager("Tony Tester",40000,1990,3,15);
        carl.setSecretary(harry);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        System.out.println(staff[0]);
        System.out.println(staff[1]);
        System.out.println(staff[2]);

        String path = "E:/idea-project/j2se/java8/src/main/java/com/spring/java8/inAndOut/employee.dat";

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(staff);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Employee[] newStaff = (Employee[])in.readObject();
            for(Employee e : newStaff){
                System.out.println(e);
            }
        }
    }
}
