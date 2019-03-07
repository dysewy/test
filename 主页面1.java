package kk;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
//import javax.swing.*;
//import java.applet.Applet;
//
//import java.applet.AudioClip;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.awt.event.KeyEvent;
//import java.util.Random;
import java.net.URL;

//import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import kk.music;

public class 主页面1  extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JMenuBar b=new JMenuBar();
	JMenu f1=new JMenu("学员管理");
	JMenu f2=new JMenu("教练管理");
	JMenu f3=new JMenu("财务管理"); 
    JMenu f4=new JMenu("退出");
    JMenu f5=new JMenu("实时时间");
	JMenuItem i1=new JMenuItem("报名注册");
	JMenuItem i2=new JMenuItem("学员信息修改");
	JMenuItem i3=new JMenuItem("学员信息删除");
	JMenuItem i4=new JMenuItem("增加教练");
	JMenuItem i5=new JMenuItem("教练信息修改");
	JMenuItem i6=new JMenuItem("教练信息删除");
	JMenuItem i7=new JMenuItem("学员学费入账");
	JMenuItem i8=new JMenuItem("学员学费修改");
	JMenuItem i9=new JMenuItem("学员学费退费");
    JMenuItem i14=new JMenuItem("退出系统");
	JMenuItem i15=new JMenuItem("点击查看");

	主页面1(){
	super("驾校管理系统");
	setSize(900,900);
	f1.setForeground(Color.blue);
	f2.setForeground(Color.blue);
	f3.setForeground(Color.blue);
	f4.setForeground(Color.blue);
	f5.setBackground(Color.blue);

    f1.add(i1);f1.addSeparator();f1.add(i2);f1.addSeparator();f1.add(i3);f1.addSeparator();
	f2.add(i4);f2.addSeparator();f2.add(i5);f2.addSeparator();f2.add(i6);f2.addSeparator();
	f3.add(i7);f3.addSeparator();f3.add(i8);f3.addSeparator();f3.add(i9);f3.addSeparator();
    f4.add(i14);f4.addSeparator();
	f5.add(i15);f5.addSeparator();
	b.add(f1);b.add(f2);b.add(f3);b.add(f4);b.add(f5);
	i1.addActionListener(this);
	i2.addActionListener(this);
	i3.addActionListener(this);
	i4.addActionListener(this);
	i5.addActionListener(this);
	i6.addActionListener(this);
	i7.addActionListener(this);
	i8.addActionListener(this);
	i9.addActionListener(this);
	
	i14.addActionListener(this);
	i15.addActionListener(this);
	this.getContentPane().add(new JLabel( new ImageIcon("D:\\Java图片\\l.jpg")), "Center");
	this.setJMenuBar(b);
	setVisible(true);}

	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==i1) {
		 new 报名注册();	}
	else if(e.getSource()==i2){
		new 学员信息修改();
	}else if(e.getSource()==i3) {
		new 学员信息删除();
	} if(e.getSource()==i4) {
		new 增加教练();
	}else if(e.getSource()==i5) {
		new 教练信息修改();	
	}else if(e.getSource()==i6){
		new 教练信息删除();
	}else if(e.getSource()==i7) {
		new 学员学费入账();
	}else if(e.getSource()==i8) {
		new 学员学费修改();
	}else if(e.getSource()==i9) {
	new 学员学费退费();
	}
	else if(e.getSource()==i14) {
	
		System.exit(0);}
else if(e.getSource()==i15) {
	new time();}
	}
 

	void Music(){               //注意，java只能播放无损音质，如.wav这种格式
		  try {      
			  URL cb;
				File f = new File("D:\\CloudMusic\\beijing.wav"); // 引号里面的是音乐文件所在的路径
				cb = f.toURL();
				AudioClip aau;
				aau = Applet.newAudioClip(cb);
			
				aau.play();	
				aau.loop();//循环播放
				System.out.println("可以播放");
		  } catch (Exception e) 
		  { e.printStackTrace();
		  } 
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new 主页面1();
new music();
music.playMusic();
	}}









