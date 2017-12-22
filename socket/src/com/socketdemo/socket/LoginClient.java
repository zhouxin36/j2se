package com.socketdemo.socket;


import com.socketdemo.entity.User;

import java.io.*;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) {
        try {
            //1.建立客户端Socket连接，指定服务器的位置以及端口
            Socket socket = new Socket("127.0.0.1",8800);
            //2.得到Socket的读写流
            OutputStream outputStream = socket.getOutputStream();
            //对象序列化流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //输入流
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //3.利用流按照一定的协议对Socket进行读/写操作
            User user = new User("1","zhouxin", "password",
                    18,"男","1561578781@qq.com");
            objectOutputStream.writeObject(user);
            socket.shutdownOutput();
            //接受服务器的响应并打印显示
            String reply = null;
            while ((reply = bufferedReader.readLine()) != null){
                System.out.println("我是客户端，响应为="+reply);
            }
            bufferedReader.close();
            inputStream.close();
            objectOutputStream.close();





            //传递字符串
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            String request = "hello server";
//            printWriter.write(request);
//            printWriter.flush();
//            printWriter.close();
            outputStream.close();
            socket.close();
            //4.关闭资源
        } catch (IOException e) {
        }
    }
}
