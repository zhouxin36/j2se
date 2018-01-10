package com.zx.server.model;

import com.zx.common.Message;
import com.zx.common.ResultDTO;
import com.zx.common.SocketMap;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
        while (true){
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ResultDTO<Message> resultDTO = (ResultDTO)objectInputStream.readObject();
            if(resultDTO.getData().isOver()){
                System.out.println(resultDTO.getData().getFrom()+"关闭服务器socket");
                SocketMap.map.remove(resultDTO.getData().getFrom());
                System.out.println(SocketMap.map.toString());
                break;
            }
            if(SocketMap.map.get(resultDTO.getData().getTo()) != null) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(SocketMap.map.get(resultDTO.getData().getTo()).getOutputStream());
                objectOutputStream.writeObject(resultDTO);
            }
            System.out.println("you message:"+resultDTO.getData().getData());
            System.out.println("from:"+resultDTO.getData().getFrom());
            System.out.println("to:"+resultDTO.getData().getTo());
            System.out.println("data:"+ Message.simpleDateFormat.format(resultDTO.getData().getDate()));
        }

        socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
