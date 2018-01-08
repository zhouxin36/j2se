package com.zx.client.view;

import javax.swing.*;

public class QQChat extends JFrame{
    JTextArea jta;
    JTextField jtf;
    JButton jb;
    JPanel jp;

    public QQChat(String friendNo) {
        jta = new JTextArea();
        jtf = new JTextField(15);
        jb = new JButton("发送");
        jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setSize(300,200);
        this.setTitle("你正在和"+friendNo+"聊天");
        this.setIconImage((new ImageIcon("QQ/images/qq.gif").getImage()));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        QQChat qqChat = new QQChat("1");
    }
}
