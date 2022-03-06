/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.flight.page.user;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import cn.flight.domain.Flight;
import cn.flight.domain.SelePojo;
import cn.flight.service.user.UserService;
/**
 * 热门城市：机票查询订单处理
 * @author MI
 *
 */
public class DestineView extends javax.swing.JFrame {
	private static DestineView destineView;
    public DestineView() {
        initComponents();
    }
                 
    private void initComponents() {
    	//********************************12.8 新添加**********************************

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
    	//结束
    	//***************************************************************************
    	
    	
    	
    	//*********************12.8 新添加*****************************************
    	//创建字体
    	Font ft=new Font("微软雅黑",0,14);
    	//字色
    	Color fc=new Color(255, 255, 255);
 
    	//*********************************************************

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jLabel4 = new JLabel();
        jTextField4 = new JTextField();
        jButton2 = new JButton();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(ft); 
        jLabel1.setText("出发地：");
        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N

        jLabel2.setFont(ft); 
        jLabel2.setText("目的地：");
        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N

        jButton1.setText("机票查询");

        jLabel3.setFont(ft); 
        jLabel3.setText("出发日期：");
        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N

        jLabel4.setFont(ft); 
        jLabel4.setText("出发时间：");
        jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N
        
        jButton1.setText("机票查询");
        jButton1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			
			public void mousePressed(MouseEvent e) {
				SelePojo sele = new SelePojo();
				sele.setBegin_from(jTextField1.getText());
		        sele.setEnd_from(jTextField2.getText());
		        sele.setBegin_date(jTextField3.getText());
		        sele.setBegin_time(jTextField4.getText());
				UserFlightView userFlight = new UserFlightView(sele);
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
        jButton2.setText("个人订单");
        jButton2.addMouseListener(new MouseListener() {
        	
			public void mouseReleased(MouseEvent e) {		
			}
			
			public void mousePressed(MouseEvent e) {
				InputProcessingViem.getInputProcessingViem();
				destineView.setVisible(false);
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

        jLabel5.setFont(new Font("微软雅黑", 1, 24)); 
        jLabel5.setForeground(new Color(255, 51, 102));
        jLabel5.setText("热门城市：");


        jLabel6.setFont(new Font("宋体", 1, 16)); 
        jLabel6.setForeground(new Color(51, 51, 255));
        jLabel6.setText("北京-上海");

        jLabel7.setFont(new java.awt.Font("宋体", 1, 16)); 
        jLabel7.setForeground(new Color(51, 51, 255));
        jLabel7.setText("上海-深圳");

        jLabel8.setFont(new java.awt.Font("宋体", 1, 16)); 
        jLabel8.setForeground(new Color(51, 51, 255));
        jLabel8.setText("深圳-北京");

        /**********************12.8 新添加**************************/
        jLabel1.setForeground(fc);
        jLabel2.setForeground(fc);
        jLabel3.setForeground(fc);
        jLabel4.setForeground(fc);
        
     	jButton1.setFont(new Font("微软雅黑",1,18));
    	jButton1.setForeground(new Color(249,142,122));
    	jButton2.setFont(new Font("微软雅黑",1,18));
    	jButton2.setForeground(new Color(249,142,122));
        /*********************************************************/


        GroupLayout  layout = new GroupLayout (getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout .Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout .Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addGroup(layout.createParallelGroup(GroupLayout .Alignment.LEADING, false)
                            .addComponent(jButton1, GroupLayout .DEFAULT_SIZE, GroupLayout .DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout .DEFAULT_SIZE, 241, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout .PREFERRED_SIZE, 116, GroupLayout .PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, GroupLayout .PREFERRED_SIZE, 116, GroupLayout .PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, GroupLayout .PREFERRED_SIZE, 80, GroupLayout .PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, GroupLayout .PREFERRED_SIZE, 107, GroupLayout .PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, GroupLayout .PREFERRED_SIZE, 91, GroupLayout .PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(GroupLayout .Alignment.LEADING)
                            .addComponent(jLabel5, GroupLayout .PREFERRED_SIZE, 292, GroupLayout .PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, GroupLayout .PREFERRED_SIZE, 85, GroupLayout .PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, GroupLayout .PREFERRED_SIZE, 85, GroupLayout .PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, GroupLayout .PREFERRED_SIZE, 85, GroupLayout .PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout .Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel5, GroupLayout .PREFERRED_SIZE, 28, GroupLayout .PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout .Alignment.BASELINE)
                    .addComponent(jLabel6, GroupLayout .PREFERRED_SIZE, 29, GroupLayout .PREFERRED_SIZE)
                    .addComponent(jLabel7, GroupLayout .PREFERRED_SIZE, 29, GroupLayout .PREFERRED_SIZE)
                    .addComponent(jLabel8, GroupLayout .PREFERRED_SIZE, 29, GroupLayout .PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(GroupLayout .Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout .PREFERRED_SIZE, GroupLayout .DEFAULT_SIZE, GroupLayout .PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, GroupLayout .PREFERRED_SIZE, GroupLayout .DEFAULT_SIZE, GroupLayout .PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, GroupLayout .PREFERRED_SIZE, GroupLayout .DEFAULT_SIZE, GroupLayout .PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, GroupLayout .PREFERRED_SIZE, GroupLayout .DEFAULT_SIZE, GroupLayout .PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jButton1, GroupLayout .PREFERRED_SIZE, 74, GroupLayout .PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, GroupLayout .PREFERRED_SIZE, 76, GroupLayout .PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        pack();
    }                       
    	public static void getDestineView() {
    	destineView = new DestineView();
    	destineView.setLocation(400,200);
    	destineView.setSize(930, 650);
    	destineView.setVisible(true);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DestineView().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   
}
