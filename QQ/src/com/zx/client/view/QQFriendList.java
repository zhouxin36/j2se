package com.zx.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QQFriendList extends JFrame implements MouseListener{

    JPanel jp1,jp2,jp3;
    JButton jp_jb1,jp_jb2,jp_jb3;
    JScrollPane jsp1;
    public static void main(String[] args) {
        QQFriendList qqFriendList = new QQFriendList("1");
    }

    public QQFriendList(String userId) {
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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            String friendNo = ((JLabel)e.getSource()).getText();
            new QQChat(friendNo);
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
