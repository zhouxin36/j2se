package com.zx.enumdemo.exp3;

public enum OzWitch {
    WEST{
        @Override
        String getInfo() {
            return "wesyt";
        }
    };
    abstract String getInfo();


    public static void main(String[] args) {
        for (OzWitch o :
                values()) {
            System.out.println(o.getInfo());
        }
    }
}
