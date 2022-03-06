package cn.flight.page.admini;

import java.awt.event.*;

import javax.swing.*;

import cn.flight.domain.Flight;
import cn.flight.service.admini.AdminiLoginService;

import java.awt.*;

/**
 * 添加航班信息
 * 12.9 已完善
 */
public class AddFlight extends JFrame {
	private static AddFlight addFlight;
	AdminiLoginService service = new AdminiLoginService();

	public AddFlight() {
		initComponents();
	}

	private void initComponents() {
		this.setLocation(400,200);
    	this.setSize(930, 650);
		
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

		jDialog1 = new JDialog();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jLabel8 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jTextField4 = new JTextField();
		jTextField5 = new JTextField();
		jTextField6 = new JTextField();
		jTextField7 = new JTextField();
		jButton1 = new JButton();
		jButton2 = new JButton();

		GroupLayout jDialog1Layout = new GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		 //*********************************12.8 创建字体字色对象*******************************************
        Font ft=new Font("微软雅黑", 0, 16);
        Color fc=new Color(255,255,255);
        //*************************************
		
		jLabel1.setFont(new Font("微软雅黑", 1, 36)); // NOI18N
		jLabel1.setForeground(fc);
		jLabel1.setText("添加航班信息");

		jLabel2.setText("航班号：");

		jLabel3.setText("起飞地点：");

		jLabel4.setText("降落地点：");

		jLabel5.setText("起飞时间：");

		jLabel6.setText("降落时间：");

		jLabel7.setText("余票：");

		jLabel8.setText("价格");

		
		//*********************************12.8 调用*******************************************************
        jLabel2.setFont(ft); 
        jLabel2.setForeground(fc);
        jLabel3.setFont(ft); 
        jLabel3.setForeground(fc);
        
        jLabel4.setFont(ft); 
        jLabel4.setForeground(fc);
        
        jLabel5.setFont(ft); 
        jLabel5.setForeground(fc);
        jLabel6.setFont(ft); 
        jLabel6.setForeground(fc);
        jLabel7.setFont(ft); 
        jLabel7.setForeground(fc);
        jLabel8.setFont(ft); 
        jLabel8.setForeground(fc);
        //********************************************************************************************
        jButton1.setForeground(new Color(249,142,122));
        jButton2.setForeground(new Color(249,142,122));

        
		
		
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jTextField7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField7ActionPerformed(evt);
			}
		});

		jButton1.setText("添加");
		
		jButton1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				Flight flight = new Flight();
				flight.setFlight_id(jTextField1.getText());
				flight.setBegin_from(jTextField2.getText());
				flight.setEnd_from(jTextField3.getText());
				flight.setBegin_time(jTextField4.getText());
				
				flight.setEnd_time(jTextField5.getText());
				flight.setRemain(Integer.parseInt(jTextField6.getText()));
				flight.setTicket_price(Float.parseFloat(jTextField7.getText()));
				service.addFlight(flight);
				addFlight.setVisible(false);
				AddFinish finish = new AddFinish(flight);
				

				

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

		jButton2.setText("取消");
		jButton2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(58, 58,
																		58)
																.addComponent(
																		jButton1)
																.addGap(105,
																		105,
																		105)
																.addComponent(
																		jButton2))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(25, 25,
																		25)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel5)
																				.addComponent(
																						jLabel7)
																				.addComponent(
																						jLabel8)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel3))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField1)
																				.addComponent(
																						jTextField2)
																				.addComponent(
																						jTextField3)
																				.addComponent(
																						jTextField4)
																				.addComponent(
																						jTextField5)
																				.addComponent(
																						jTextField6)
																				.addComponent(
																						jTextField7))))
								.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(54, 54, 54)
								.addComponent(jLabel1)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														jTextField1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														jTextField2,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														jTextField3,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														jTextField4,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel6)
												.addComponent(
														jTextField5,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(
														jTextField6,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel8)
												.addComponent(
														jTextField7,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(35, 35, 35)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap(49, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jTextField1ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField3ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField7ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2MouseClicked(MouseEvent evt) {
		// TODO add your handling code here:

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void getAddFlight() {
		
		addFlight = new AddFlight();
		addFlight.setLocation(400,200);
		addFlight.setSize(930, 550);
		addFlight.setVisible(true);
	}

	// Variables declaration - do not modify
	JButton jButton1;
	JButton jButton2;
	JDialog jDialog1;
	JLabel jLabel1;
	JLabel jLabel2;
	JLabel jLabel3;
	JLabel jLabel4;
	JLabel jLabel5;
	JLabel jLabel6;
	JLabel jLabel7;
	JLabel jLabel8;
	JTextField jTextField1;
	JTextField jTextField2;
	JTextField jTextField3;
	JTextField jTextField4;
	JTextField jTextField5;
	JTextField jTextField6;
	JTextField jTextField7;
	// End of variables declaration
}
