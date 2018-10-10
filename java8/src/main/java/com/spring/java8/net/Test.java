package com.spring.java8.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        getHtml();
    }

    private static void getHtml() throws IOException{
        String str = "http://www.baidu.com";
        URL url = new URL(str);
        InputStream inputStream = url.openStream();
        Scanner in = new Scanner(inputStream,"UTF-8");
        for (;in.hasNext();){
            System.out.println(in.nextLine());
        }

        URLConnection urlConnection = url.openConnection();
        System.out.println(urlConnection.getDate());
        System.out.println(urlConnection.getContentType());
        System.out.println(urlConnection.getContentEncoding());
    }

}
