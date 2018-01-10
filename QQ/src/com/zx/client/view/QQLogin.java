package com.zx.client.view;

import com.zx.client.model.ClientThread;
import com.zx.client.model.MyQQClient;
import com.zx.common.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QQLogin extends JFrame implements ActionListener{
    //上部
    JLabel jbl1;

    //中部
    JTabbedPane jtp;
    JPanel jp2,jp3,jp4;
    JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
    JButton jp2_jb1;
    JTextField jp2_jtf;
    JPasswordField jp2_jpf;
    JCheckBox jp2_jcb1,jp2_jcb2;

    //下部
    JPanel jpl;
    JButton jpl_jb1,jpl_jb2,jpl_jb3;

    public static void main(String[] args) {
        QQLogin qqLogin = new QQLogin();
    }

    public QQLogin(){
        //上部
        jbl1 = new JLabel(new ImageIcon("QQ/images/tou.gif"));

        //中部
        jp2 = new JPanel(new GridLayout(3,3));

        jp2_jbl1 = new JLabel("QQ号码",JLabel.CENTER);
        jp2_jbl2 = new JLabel("QQ密码",JLabel.CENTER);
        jp2_jbl3 = new JLabel("忘记密码",JLabel.CENTER);
        jp2_jbl3.setForeground(Color.blue);
        jp2_jbl4 = new JLabel("申请密码保护",JLabel.CENTER);
        jp2_jb1 = new JButton(new ImageIcon("QQ/images/clear.gif"));
        jp2_jtf = new JTextField();
        jp2_jpf = new JPasswordField();
        jp2_jcb1 = new JCheckBox("隐身登陆");
        jp2_jcb2 = new JCheckBox("记住密码");

        jp2.add(jp2_jbl1);
        jp2.add(jp2_jtf);
        jp2.add(jp2_jb1);
        jp2.add(jp2_jbl2);
        jp2.add(jp2_jpf);
        jp2.add(jp2_jbl3);
        jp2.add(jp2_jcb1);
        jp2.add(jp2_jcb2);
        jp2.add(jp2_jbl4);

        jtp = new JTabbedPane();
        jtp.add("QQ号码",jp2);
        jp3 = new JPanel(new GridLayout(3,3));
        jtp.add("手机号码",jp3);
        jp4 = new JPanel(new GridLayout(3,3));
        jtp.add("电子邮件",jp4);

        //下部
        jpl = new JPanel();
        jpl_jb1 = new JButton(new ImageIcon("QQ/images/denglu.gif"));
        jpl_jb1.addActionListener(this);
        jpl_jb2 = new JButton(new ImageIcon("QQ/images/quxiao.gif"));
        jpl_jb3 = new JButton(new ImageIcon("QQ/images/xiangdao.gif"));
        jpl.add(jpl_jb1);
        jpl.add(jpl_jb2);
        jpl.add(jpl_jb3);

        this.add(jbl1,"North");
        this.add(jpl,"South");
        this.add(jtp,"Center");
        this.setSize(350,240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jpl_jb1){
            boolean b = MyQQClient.sendLogin(new User(jp2_jtf.getText().trim(), new String(jp2_jpf.getPassword())));
            if(b == true){
                new QQFriendList(jp2_jtf.getText().trim());
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"用户名或密码错误");
            }
        }
    }
}
