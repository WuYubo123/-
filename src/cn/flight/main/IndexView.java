/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.flight.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import cn.flight.main.admini.UIS;
import cn.flight.page.admini.AdminLogin;
import cn.flight.page.user.DestineView;
/*
 * 主页界面
 * 12.9已完善
 * 
 */

public class IndexView extends javax.swing.JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private static IndexView indexView;
    public IndexView() {
        initComponents();
    }
    private  void initComponents() {
    	UIS.uis();
    	//添加背景图
    	//开始
    	ImageIcon image = new ImageIcon("D:\\学习\\JavaEE\\MyEclipse\\航班管理系统\\src\\image\\bgi.jpg");
    	JLabel bg=new JLabel(image);
    	bg.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
    	getLayeredPane().add(bg, Integer.valueOf(Integer.MIN_VALUE));
    	//设置内容面板  getContentPane前面添加  这个JFrame的对象 由于这个图片是继承了JFrame  所以不需要对象 或者使用this
    	JPanel jp = (JPanel) this.getContentPane();
    	//设置内容面板未透明  true代表透明  透明之后的gui界面是看不到背景图像的
    	jp.setOpaque(false);
    	
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("首页");
        jButton1.setFont(new Font("宋体", 0, 18)); 
        jButton1.setText("购票者入口");
        jButton2.setText("机场管理员入口");
        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 48)); 
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("航空管理系统");
      //********************************12.8 新添加**********************************
        jButton1.setFont(new Font("微软雅黑",1,20));
        jButton1.setForeground(new Color(249,142,122));
        jButton2.setFont(new Font("微软雅黑",1,20));
        jButton2.setForeground(new Color(249,142,122));
        //***************************************************************************
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1,GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
        jButton1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {//鼠标按下
				DestineView.getDestineView();//获取输入订票信息
				indexView.setVisible(false);//把当前窗体隐藏

			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        jButton2.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {//鼠标按下
				AdminLogin.getAdminLogin();
				indexView.setVisible(false);
				
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }                 
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//            	new IndexView().setVisible(true);
//            }
//        });
    	indexView = new IndexView();
    	indexView.setLocation(400,200);
    	indexView.setVisible(true);
    }

                   
               
}
