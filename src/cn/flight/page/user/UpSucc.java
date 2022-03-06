package cn.flight.page.user;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.flight.domain.Flight;
import cn.flight.domain.User;

public class UpSucc extends javax.swing.JFrame {
	private Flight upFlight;
	private String price;
	private List<User> users;
	private String oidfid;

	public UpSucc(Flight flight, String price, List<User> users,String oidfid) {
		this.upFlight = flight;
		this.price = price;
		this.users = users;
		this.oidfid=oidfid;
		this.setLocation(400, 200);
		this.setSize(930, 650);
		initComponents();
		this.setVisible(true);
	}

	public void falses() {
		this.setVisible(false);

	}

	private void initComponents() {
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

		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();

		jLabel3.setText("jLabel3");

		jTextField1.setText("jTextField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 0, 51));
		jLabel1.setText("恭喜您，改签成功！");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel2.setText("改签后的航班号为：");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel4.setText(upFlight.getFlight_id());

		jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel5.setText("登机时间改为：");

		jLabel6.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel6.setText(upFlight.getBegin_time());

		jLabel7.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel7.setText("费用情况：");

		jLabel8.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel8.setText(price);

		jButton1.setText("返回");
		jButton1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				DestineView.getDestineView();
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

		jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(255, 0, 102));
		jLabel9.setText("尊敬的用户，目的地和出发地没有修改！");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(125, 125, 125)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jButton1)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														333,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel7)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel8,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		223,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel5)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		159,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		112,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jSeparator1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														539,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel9,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														338,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(147, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(88, 88, 88)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jSeparator1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(42, 42, 42)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(jLabel4))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(jLabel6))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(jLabel8))
								.addGap(34, 34, 34).addComponent(jLabel9)
								.addGap(59, 59, 59).addComponent(jButton1)
								.addContainerGap(155, Short.MAX_VALUE)));

		pack();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration
}
