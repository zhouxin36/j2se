package com.socketdemo.socket;


import com.socketdemo.entity.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    //传递字符串
//    public static void main(String[] args) {
////        try {
////            //1、建立一个服务器Socket(ServerSocket)绑定指定端口并开始监听
////            ServerSocket serverSocket = new ServerSocket(8800);
////            //2、使用accept()方法阻塞等待监听，获得新的连接
////            Socket socket = serverSocket.accept();
////            //3、获得输入流
////            InputStream inputStream = socket.getInputStream();
////            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
////            //4、读取用户输入信息
////            String info = null;
////            while ((info = br.readLine()) != null){
////                System.out.println("我是服务器，信息是="+info);
////            }
////            //关闭资源
////            br.close();
////            inputStream.close();
////            socket.close();
////            serverSocket.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
    public static void main(String[] args) {
        try {
            //1、建立一个服务器Socket(ServerSocket)绑定指定端口并开始监听
            ServerSocket serverSocket = new ServerSocket(8800);
            //2、使用accept()方法阻塞等待监听，获得新的连接
            Socket socket = serverSocket.accept();
            //3、获得输入流
            InputStream inputStream = socket.getInputStream();
            //获得流可以对对象反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            //获得流
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            //4、读取用户输入信息
            User user = (User)objectInputStream.readObject();
            System.out.println(user.toString());
            //给客户端发消息
            printWriter.write("收到");
            //关闭资源
            printWriter.flush();
            printWriter.close();
            objectInputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
