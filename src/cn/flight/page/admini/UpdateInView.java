package cn.flight.page.admini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.flight.domain.Flight;
import cn.flight.service.admini.AdminiLoginService;

/**
 * 修改航班信息
 * 12.9已完善
 */
public class UpdateInView extends javax.swing.JFrame {
	public static UpdateInView inView;
	public static AdminiLoginService service = new AdminiLoginService();
	public static Flight flight;

	public UpdateInView() {
		initComponents();
	}

	private void initComponents() {
		this.setLocation(400,200);
    	this.setSize(930, 550);
		// ********************************12.8 新添加**********************************
		// 添加背景图
		// 开始
		ImageIcon image = new ImageIcon("D:\\学习\\JavaEE\\MyEclipse\\航班管理系统\\src\\image\\bgi.jpg");
		JLabel bg = new JLabel(image);
		bg.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		getLayeredPane().add(bg, Integer.valueOf(Integer.MIN_VALUE));
		// 设置内容面板 getContentPane前面添加 这个JFrame的对象 由于这个图片是继承了JFrame 所以不需要对象 或者使用this
		JPanel jp = (JPanel) this.getContentPane();

		// 设置内容面板未透明 true代表透明 透明之后的gui界面是看不到背景图像的
		jp.setOpaque(false);
		// 结束
		
		
		jLabel1 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		//*********************************12.8 创建字体字色对象*******************************************
        Font ft=new Font("微软雅黑", 0, 16);
        Color fc=new Color(255,255,255);
        //*************************************
		
		jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 24)); 
		jLabel1.setForeground(fc);
		jLabel1.setText("修改航班信息");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 14)); 
		jLabel2.setForeground(new Color(255,0,0));
		jLabel2.setText("信息如下所示，请选择修改！");

		jLabel3.setText("航班号：");
		jTextField1.setText(flight.getFlight_id());
		jLabel4.setText("起飞地点：");
		jTextField2.setText(flight.getBegin_from());
		jLabel5.setText("降落地点：");
		jTextField3.setText(flight.getEnd_from());
		jLabel6.setText("起飞时间：");
		jTextField4.setText(flight.getBegin_time());
		jLabel7.setText("降落时间：");
		jTextField5.setText(flight.getEnd_time());
		jLabel8.setText("余票：");
		jTextField6.setText(String.valueOf(flight.getRemain()));
		jLabel9.setText("价格：");
		jTextField7.setText(String.valueOf(flight.getTicket_price()));

		jLabel3.setFont(ft);
		jLabel5.setFont(ft);
		jLabel4.setFont(ft);
		jLabel6.setFont(ft);
		jLabel7.setFont(ft);
		jLabel8.setFont(ft);
		jLabel9.setFont(ft);

		jLabel3.setForeground(fc);
		jLabel4.setForeground(fc);
		jLabel5.setForeground(fc);
		jLabel6.setForeground(fc);
		jLabel7.setForeground(fc);
		jLabel8.setForeground(fc);
		jLabel9.setForeground(fc);
		
		
	    jButton1.setForeground(new Color(249,142,122));
	    jButton2.setForeground(new Color(249,142,122));

		
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jButton1.setText("修改");
		jButton1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
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
				service.upDateFlight(flight);
				JOptionPane.showMessageDialog(null, "恭喜你" + flight.getFlight_id() + "修改成功!");
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

		jButton2.setText("返回");
		jButton2.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				AdminiFlight.getAdminiFlight();
				inView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(82, 82, 82)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 504,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1).addComponent(jLabel2)).addContainerGap(77, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addComponent(jButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton2).addGap(115, 115, 115)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(69, 69, 69)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup().addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel8))
						.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(20, 20, 20)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
						.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1)
						.addComponent(jButton2))
				.addGap(32, 32, 32)));

		pack();
	}
	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {

	}
	public static void getUpdateInView(String fid) {
		flight = service.seleFlightByFid(fid);
		inView = new UpdateInView();
		inView.setVisible(true);
	}

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
	private javax.swing.JLabel jLabel9;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	// End of variables declaration
}
