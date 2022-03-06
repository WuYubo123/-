package cn.flight.page.admini;

import javax.swing.*;

import cn.flight.domain.Flight;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

/**
 * 添加信息成功提示狂
 * 12.9 已完善
 * @author 59353
 */
public class AddFinish extends JFrame {

	public AddFinish addFinish;
	public Flight flight;

	public AddFinish(Flight flight) {
		this.flight = flight;
		initComponents(flight);
		this.setVisible(true);
	}

	private void initComponents(Flight flight) {
		this.setLocation(400,200);
    	this.setSize(930, 550);
		
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
		
		
		jLabel1 = new JLabel();
		jButton1 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// System.out.println("sfdsdf"+flight);

		jLabel1.setFont(new Font("微软雅黑", 0, 24)); // NOI18N
		jLabel1.setText("从" + flight.getBegin_from() + "飞往"
				+ flight.getEnd_from() + "的" + flight.getFlight_id() + "添加成功");
		jLabel1.setForeground(new Color(255,255,255));
		jButton1.setText("返回");
		jButton1.setForeground(new Color(249,142,122));
		jButton1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				AdminiFlight.getAdminiFlight();
				addFinish.setVisible(false);
				

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(180, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(20, 20,
																		20)
																.addComponent(
																		jButton1)))
								.addGap(169, 169, 169)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(125, 125, 125)
						.addComponent(jLabel1).addGap(66, 66, 66)
						.addComponent(jButton1)
						.addContainerGap(73, Short.MAX_VALUE)));

		pack();
	}

	// Variables declaration - do not modify
	private JButton jButton1;
	private JLabel jLabel1;
	// End of variables declaration
}
