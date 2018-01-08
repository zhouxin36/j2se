package com.zx.server.model;

import com.zx.common.ResultDTO;
import com.zx.common.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyQQServer {
    public MyQQServer() {
        try {
            System.out.println("服务器启动");
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User)objectInputStream.readObject();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            if(user.getUserId().equals("1") ||user.getUserId().equals("2")){
                objectOutputStream.writeObject(ResultDTO.ok());
            }else {
                objectOutputStream.writeObject(ResultDTO.error());
            }
            socket.close();
            ss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyQQServer myQQServer = new MyQQServer();
    }
}
