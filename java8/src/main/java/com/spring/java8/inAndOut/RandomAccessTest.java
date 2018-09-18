package com.spring.java8.inAndOut;

import com.spring.java8.entity.Employee;

import java.io.*;
import java.time.LocalDate;

public class RandomAccessTest {

    private static String readFixedString(int size, DataInput in) throws IOException{

        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i <size){
            char ch = (char)in.readByte();
            i++;
            if(ch == 0){
                more = false;
            } else{
                b.append(ch);
            }
        }
        in.skipBytes(size - i);
        return b.toString();
    }

    private static void writeFixedString(String s,int size, DataOutput out) throws IOException{
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if(i<s.length()){
                ch = s.charAt(i);
            }
            out.write(ch);
        }
    }

    private static void writeData(DataOutput out, Employee e)throws IOException{
        writeFixedString(e.getName(),Employee.NAME_SIZE,out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay = e.getHireDate();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    private static Employee readDate(DataInput in) throws IOException{
        String name = readFixedString(Employee.NAME_SIZE,in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name,salary,y,m-1,d);
    }

    private static void readByte(DataInput in) throws IOException{
        byte[] bytes = new byte[150];
        in.readFully(bytes);
    }

    public static void main(String[] args) throws IOException{
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker",75000,1987,12,15);
        staff[1] = new Employee("Harry Hacker",50000,1989,10,1);
        staff[2] = new Employee("Tony Tester",40000,1990,3,15);


        String path = "E:/idea-project/j2se/java8/src/main/java/com/spring/java8/inAndOut/employee.dat";
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(path))){
            for(Employee e : staff){
                writeData(out,e);
            }
        }

        try(RandomAccessFile in = new RandomAccessFile(path,"r")){
            System.out.println(in.length());
            int n = (int)(in.length()/Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            for (int i = 0; i < n; i++) {
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readDate(in);
            }
            for(Employee e : newStaff){
                System.out.println(e);
            }
        }

    }
}
