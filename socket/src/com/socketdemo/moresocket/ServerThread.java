package com.socketdemo.moresocket;


import com.socketdemo.entity.User;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
