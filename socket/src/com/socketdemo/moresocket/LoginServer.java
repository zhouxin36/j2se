package com.socketdemo.moresocket;

import com.socketdemo.moresocket.ServerThread;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) {
        try {
            //1、建立一个服务器
            // Socket(ServerSocket)绑定指定端口并开始监听
            ServerSocket serverSocket = new ServerSocket(8800);
            //2、使用accept()方法阻塞等待监听，获得新的连接
            Socket socket = null;
            int num = 0;
           while (true){
               socket = serverSocket.accept();
               ServerThread serverThread = new ServerThread(socket);
               serverThread.start();
               InetAddress inetAddress = socket.getInetAddress();
               num++;
               System.out.println("访问数量为："+num+";ip="+inetAddress.getHostAddress()+
                       ";主机名为="+inetAddress.getHostName());
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
