package com.zx.server.model;

import com.zx.common.Message;
import com.zx.common.ResultDTO;
import com.zx.common.SocketMap;
import com.zx.common.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyQQServer {
    public MyQQServer() {
        try {
            System.out.println("服务器启动");
            ServerSocket ss = new ServerSocket(9999);
            while(true) {
                Socket socket = ss.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                if (user.getPassword().equals("1")) {
                    List<String> list = new ArrayList<>();
                    SocketMap.map.forEach((x,y)->list.add(x));
                    System.out.println(list.toString());
                    Message message = new Message();
                    message.setOnline(list);
                    SocketMap.map.put(user.getUserId(),socket);
                    System.out.println(SocketMap.map.toString());
                    objectOutputStream.writeObject(ResultDTO.buildSuccessData(message));
                    ServerThread serverThread = new ServerThread(socket);
                    serverThread.start();
                } else {
                    objectOutputStream.writeObject(ResultDTO.error());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyQQServer myQQServer = new MyQQServer();
    }
}
