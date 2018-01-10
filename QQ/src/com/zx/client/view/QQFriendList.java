package com.zx.client.view;

import com.zx.client.model.ClientThread;
import com.zx.client.model.MyQQClient;
import com.zx.common.ClientMap;
import com.zx.common.Message;
import com.zx.common.ResultDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.util.Date;

public class QQFriendList extends JFrame implements MouseListener{

    JPanel jp1,jp2,jp3;
    JButton jp_jb1,jp_jb2,jp_jb3;
    JScrollPane jsp1;
    private String userId;
    public static void main(String[] args) {
        QQFriendList qqFriendList = new QQFriendList("1");
    }

    public QQFriendList(String userId) {
        this.userId = userId;
        jp1 = new JPanel(new BorderLayout());
        jp2 = new JPanel(new GridLayout(50,1,4,4));

        JLabel [] jbls = new JLabel[50];
        for (int i = 0; i < jbls.length; i++) {
            jbls[i] = new JLabel(i+1+"",new ImageIcon("QQ/images/mm.jpg"),JLabel.LEFT);
            jp2.add(jbls[i]);
            jbls[i].addMouseListener(this);
        }
        jp3 = new JPanel(new GridLayout(2,1));

        jp_jb1 = new JButton("我的好友");
        jp_jb2 = new JButton("陌生人");
        jp_jb3 = new JButton("黑名单");
        jp3.add(jp_jb2);
        jp3.add(jp_jb3);

        jsp1 = new JScrollPane(jp2);

        jp1.add(jp_jb1,"North");
        jp1.add(jsp1,"Center");
        jp1.add(jp3,"South");

        this.add(jp1,"Center");
        this.setTitle(userId);
        this.setSize(200,400);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int i = JOptionPane.showConfirmDialog(null,
                        "要关闭吗", "choose one", JOptionPane.YES_NO_CANCEL_OPTION);
                if(i==0){
                    Message message = new Message();
                    message.setOver(true);
                    message.setFrom(userId);
                    try {

                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(MyQQClient.socket.getOutputStream());
                        objectOutputStream.writeObject(ResultDTO.buildSuccessData(message));
                        System.out.println("关闭客户端socket");
                        MyQQClient.socket.close();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                    super.windowClosing(e);
                    System.exit(0);
                }else{
                    QQFriendList.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        Thread thread = new Thread(new ClientThread(userId));
        thread.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            String friendNo = ((JLabel)e.getSource()).getText();
            QQChat qqChat = ClientMap.map.get(friendNo);
            if(qqChat == null){
                qqChat =new QQChat(friendNo,userId);
                ClientMap.map.put(friendNo,qqChat);
            }
            qqChat.requestFocus();
            System.out.println(ClientMap.map);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel =(JLabel)e.getSource();
        jLabel.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel =(JLabel)e.getSource();
        jLabel.setForeground(Color.black);
    }
}
