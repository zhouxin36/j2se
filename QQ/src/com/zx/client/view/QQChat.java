package com.zx.client.view;

import com.zx.client.model.MyQQClient;
import com.zx.common.ClientMap;
import com.zx.common.Message;
import com.zx.common.ResultDTO;

import javax.swing.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class QQChat extends JFrame implements ActionListener{
    JTextArea jta;
    JTextField jtf;
    JButton jb;
    JPanel jp;
    String friendNo;
    String userId;


    public QQChat(String friendNo,String userId) {
        this.friendNo = friendNo;
        this.userId = userId;
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("发送");
        jb.addActionListener(this);
        jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setSize(300,200);
        this.setTitle("你正在和"+friendNo+"聊天");
        this.setIconImage((new ImageIcon("QQ/images/qq.gif").getImage()));
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int i = JOptionPane.showConfirmDialog(null,
                        "要关闭吗", "choose one", JOptionPane.YES_NO_CANCEL_OPTION);
                if(i==0){
                    ClientMap.map.remove(friendNo);
                    System.out.println(ClientMap.map);
                    super.windowClosing(e);
                }else{
                    QQChat.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    public static void main(String[] args){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb){
            Message message = new Message();
            message.setFrom(this.userId);
            message.setTo(this.friendNo);
            message.setData(this.jtf.getText());
            message.setDate(new Date());
            try {

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(MyQQClient.socket.getOutputStream());
                objectOutputStream.writeObject(ResultDTO.buildSuccessData(message));
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }



    public void addMessage(String message){
        this.jta.append(message);
    }
}
