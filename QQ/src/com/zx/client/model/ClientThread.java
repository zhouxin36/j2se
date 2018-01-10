package com.zx.client.model;

import com.zx.client.view.QQChat;
import com.zx.common.ClientMap;
import com.zx.common.Message;
import com.zx.common.ResultDTO;

import java.io.ObjectInputStream;

public class ClientThread implements Runnable{
    private String userId;

    public ClientThread(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        while(true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(MyQQClient.socket.getInputStream());
                ResultDTO<Message> resultDTO = (ResultDTO)objectInputStream.readObject();
                String info = resultDTO.getData().getFrom()+" "+Message.simpleDateFormat.format(resultDTO.getData().getDate())+"\r\n"
                        +resultDTO.getData().getData()+"\r\n";
                QQChat qqChat = ClientMap.map.get(resultDTO.getData().getFrom());
                if(qqChat == null){
                    qqChat = new QQChat(resultDTO.getData().getFrom(),userId);
                    ClientMap.map.put(resultDTO.getData().getFrom(),qqChat);
                }
                qqChat.addMessage(info);
                System.out.println(ClientMap.map.toString());

            } catch (Exception e) {
            }
        }
    }
}
