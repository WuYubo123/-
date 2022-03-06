package cn.flight.page.admini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.flight.domain.Flight;
import cn.flight.service.admini.AdminiLoginService;

/**
 * 删除航班 12.9已完善
 * 
 */
public class DeleFlight extends javax.swing.JFrame {
	public static DeleFlight deleFlight;
	private AdminiLoginService service = new AdminiLoginService();
	java.util.List<Flight> flights = service.seleAllFlight();

	public Object[][] getObject(java.util.List<Flight> flights) {
		Object[][] f = new Object[flights.size()][5];
		int j = 0;
		int i = 0;
		for (Flight flight : flights) {

			f[i][j] = flight.getFlight_id();
			f[i][j + 1] = flight.getBegin_from();
			f[i][j + 2] = flight.getEnd_from();
			f[i][j + 3] = flight.getBegin_time();
			f[i][j + 4] = flight.getEnd_time();
			i++;
		}

		return f;
	}

	public String[] getString() {
		String[] str = new String[] { "航班号", "起飞地点", "降落地点", "起飞时间", "降落时间" };
		return str;
	}

	/**
	 * Creates new form DeleFlight
	 */
	public DeleFlight() {
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
		jLabel2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jTextField1 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		
		Color c1=new Color(255,255,255);
		
		jLabel1.setFont(new Font("微软雅黑", 1, 18)); // NOI18N
		jLabel1.setText("请直接输入航班号以便删除");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
		jLabel2.setText("删除航班");

		jLabel1.setForeground(c1);
		jLabel2.setForeground(c1);
		
		jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
		jLabel3.setForeground(new Color(255, 0, 0));
		jLabel3.setText("注意：删除后不可撤销，请慎重");

		jTable1.setModel(new TableTest(getObject(flights), getString()));
		jScrollPane1.setViewportView(jTable1);

		jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
		jLabel4.setForeground(new Color(255,255,255));
		jLabel4.setText("航班号：");

		jButton1.setForeground(new Color(249,142,122));
		jButton2.setForeground(new Color(249,142,122));
		
		
		
		jButton1.setText("删除");
		jButton1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				String inId = jTextField1.getText();
				int s = service.deleFlight(inId);
				if (s == 1) {
					JOptionPane.showMessageDialog(null, "成功删除");
				} else {
					JOptionPane.showMessageDialog(null, "没有找到该航班号请重新输入！", "删除失败", JOptionPane.ERROR_MESSAGE);
				}

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

		jLabel5.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
		jLabel5.setText("目前实时航班信息如下所示");
		jLabel5.setForeground(c1);
		jButton2.setText("返回");
		jButton2.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				AdminiFlight.getAdminiFlight();
				deleFlight.setVisible(false);

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
				.createSequentialGroup().addGap(98, 98, 98)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addComponent(jLabel2)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 549,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGap(1, 1, 1)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(33, 33, 33).addComponent(jButton1).addGap(39, 39, 39)
												.addComponent(jButton2))
										.addComponent(jLabel3).addComponent(jLabel5,
												javax.swing.GroupLayout.PREFERRED_SIZE, 204,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(51, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addComponent(jLabel2).addGap(10, 10, 10)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabel1).addGap(27, 27, 27).addComponent(jLabel5)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4).addComponent(jButton1).addComponent(jButton2))
						.addGap(18, 18, 18).addComponent(jLabel3).addContainerGap(71, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	/**
	 * @param args the command line arguments
	 */
	public static void getDeleFlight() {
		deleFlight = new DeleFlight();
		deleFlight.setVisible(true);
		// java.awt.EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// new DeleFlight().setVisible(true);
		// }
		// });
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration
}
