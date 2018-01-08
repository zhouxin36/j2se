package com.zx.server.view;

import com.zx.server.model.MyQQServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyServerFrame extends JFrame implements ActionListener{

    JPanel jp1;
    JButton jb1,jb2;

    public MyServerFrame() throws HeadlessException {
        jp1 = new JPanel();
        jb1 = new JButton("关闭");
        jb2 = new JButton("启动");
        jb2.addActionListener(this);
        jp1.add(jb1);
        jp1.add(jb2);

        this.add(jp1);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyServerFrame myServerFrame = new MyServerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb2){
            new MyQQServer();
        }
    }
}
