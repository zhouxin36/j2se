package com.zx.client.model;

import com.zx.common.ResultDTO;
import com.zx.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyQQClient {
    public static boolean sendLogin(User user){
        boolean type = false;
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ResultDTO<String> resultDTO = (ResultDTO) objectInputStream.readObject();
            if(resultDTO.getCode() == 200){
                type =true;
            }
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return type;
    }
}
