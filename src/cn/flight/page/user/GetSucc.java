package cn.flight.page.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.flight.domain.User;

public class GetSucc extends javax.swing.JFrame {
	private static GetSucc getsucc;
	private List<User> users;
    public GetSucc(List<User> users) {
    	this.users=users;
    	this.setLocation(400,200);
    	this.setSize(930, 650);
        initComponents();
        this.setVisible(true);
    }
    public void falses(){
    	this.setVisible(false);
    	
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
    	

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
        jLabel1.setText("操作成功！");

        jButton1.setText("返回");
        jButton1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				try {
					UserDestineView user = new UserDestineView(users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				falses();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton1)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addGap(96, 96, 96)
                .addComponent(jButton1)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }
  

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
}

