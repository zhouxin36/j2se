package com.zx.enumdemo.exp;

import static com.zx.enumdemo.exp.Spiciness.*;

public class Buttiro {
    Spiciness degree;

    public Buttiro(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Buttiro{" +
                "degree=" + degree +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Buttiro(NOT));
    }
}
