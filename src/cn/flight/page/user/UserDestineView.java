package cn.flight.page.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.flight.domain.Flight;
import cn.flight.domain.User;
import cn.flight.page.admini.TableTest;
import cn.flight.service.user.UserService;

/**
 * 用户的个人管理票务页面
 * @author MI
 * 
 */
public class UserDestineView extends javax.swing.JFrame {
	private UserService service = new UserService();
	private List<User> users;
	private List<Flight> flights;
	private String username;

	public UserDestineView() throws Exception {
		super();
		this.setVisible(true);
	}

	public Object[][] getObject(java.util.List<Flight> flights) {
		Object[][] f = new Object[flights.size()][6];
		int j = 0;
		int i = 0;
		for (Flight flight : flights) {
			f[i][j] = flight.getFlight_id();
			f[i][j + 1] = flight.getBegin_from();
			f[i][j + 2] = flight.getEnd_from();
			f[i][j + 3] = flight.getBegin_time();
			f[i][j + 4] = flight.getEnd_time();
			f[i][j + 5] = users.get(i).getDestine_status();
			i++;
		}
		return f;
	}

	public String[] getString() {
		String[] str = new String[] { "航班号", "起飞地点", "降落地点", "起飞时间", "降落时间",
				"是否取票" };
		return str;
	}

	public UserDestineView(List<User> users) {
		this.users = users;
		flights = service.seleUserFlight(users);
		initComponents();
		uis();
		this.setLocation(400, 200);
		this.setSize(930, 650);
		this.setVisible(true);
	}

	public int getStatusNumber() {
		int num = 0;
		for (User user : users) {
			if (user.getDestine_status().equals("否")) {
				num++;
			}
		}
		return num;
	}

	public void falses() {
		this.setVisible(false);

	}

	public void trues() {
		this.setVisible(true);

	}

	public void flis() {
		this.repaint();
	}

	private void initComponents() {
		// ********************************12.8
		// 新添加**********************************

		// 添加背景图
		// 开始
		ImageIcon image = new ImageIcon(
				"D:\\学习\\JavaEE\\MyEclipse\\航班管理系统\\src\\image\\bgi.jpg");
		JLabel bg = new JLabel(image);
		bg.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		getLayeredPane().add(bg, Integer.valueOf(Integer.MIN_VALUE));
		// 设置内容面板 getContentPane前面添加 这个JFrame的对象 由于这个图片是继承了JFrame 所以不需要对象
		// 或者使用this
		JPanel jp = (JPanel) this.getContentPane();

		// 设置内容面板未透明 true代表透明 透明之后的gui界面是看不到背景图像的
		jp.setOpaque(false);
		// 结束
		// ***************************************************************************

		// *********************12.8
		// 新添加*****************************************
		// 创建字体
		Font ft = new Font("微软雅黑", 0, 14);
		// 字色
		Color fc = new Color(255, 255, 255);

		// *********************************************************

		jDialog1 = new javax.swing.JDialog();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
		jLabel1.setText("尊敬的客户您好！请在此页面操作个人订单");

		jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel3.setForeground(new Color(249,000,000));
		jLabel3.setText(users.get(0).getDestine_name());

		jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel4.setForeground(new Color(249,000,000));
		jLabel4.setText("客户名：");

		jTable1.setModel(new TableTest(getObject(flights), getString()));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setText("取票");
		jButton1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton1.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {

				Object[] obj2 = new Object[flights.size()];
				int i = 0;
				for (Flight flight : flights) {
					obj2[i] = flight.getFlight_id();
					i++;
				}
				String fid = (String) JOptionPane.showInputDialog(null,
						"请选择要修改的航班号：\n", "选择修改", JOptionPane.PLAIN_MESSAGE,
						new ImageIcon("icon.png"), obj2, "足球");
				// userDestine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				service.upUserFlight(fid);
				falses();
				for (User user : users) {
					if (user.getFlight_id().equals(fid)) {
						user.setDestine_status("是");
					}
				}
				GetSucc get = new GetSucc(users);

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

		jButton2.setText("退票");
		jButton2.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N

		jButton2.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				Object[] obj2 = new Object[flights.size()];
				int i = 0;
				for (Flight flight : flights) {
					obj2[i] = flight.getFlight_id();
					i++;
				}
				String fid = (String) JOptionPane.showInputDialog(null,
						"请选择要退票的航班号：\n", "选择修改", JOptionPane.PLAIN_MESSAGE,
						new ImageIcon("icon.png"), obj2, "足球");
				service.deleUserFlight(fid, users.get(0));
				falses();
				int w = 0;
				for (User user : users) {
					if (user.getFlight_id().equals(fid)) {
						w++;
					}
				}
				users.remove(w);
				GetSucc get = new GetSucc(users);

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

		jButton3.setText("改签");
		jButton3.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N

		jButton3.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				Object[] obj2 = new Object[flights.size()];
				int i = 0;
				for (Flight flight : flights) {
					obj2[i] = flight.getFlight_id();
					i++;
				}
				String fid = (String) JOptionPane.showInputDialog(null,
						"请选择要改签的航班号：\n", "选择改签", JOptionPane.PLAIN_MESSAGE,
						new ImageIcon("icon.png"), obj2, "足球");
				falses();
				UserUpFlight userup = new UserUpFlight(users,fid,flights);
				

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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

		jButton4.setText("退出");
		jButton4.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N

		jButton4.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				InputProcessingViem.getInputProcessingViem();
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
		

		jLabel6.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel6.setText("订票总数：");

		jLabel7.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel7.setText(String.valueOf(users.size()));

		jLabel9.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
		jLabel9.setText(String.valueOf(getStatusNumber()));

		jLabel10.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel10.setText("张未取票");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										15,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(167, 167, 167)
								.addComponent(jLabel4)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel5)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(156, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		98,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton2)
																.addGap(92, 92,
																		92)
																.addComponent(
																		jButton3)
																.addGap(104,
																		104,
																		104)
																.addComponent(
																		jButton4))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel1)
												.addComponent(jSeparator1))
								.addGap(119, 119, 119))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel6)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel7,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(102,
																		102,
																		102)
																.addComponent(
																		jLabel8,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		0,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(41, 41,
																		41)
																.addComponent(
																		jLabel9,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		24,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel10)))
								.addGap(162, 162, 162)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(76, 76, 76)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSeparator1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(11, 11,
																		11)
																.addComponent(
																		jLabel2))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel5))))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		247,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jLabel6)
																				.addComponent(
																						jLabel7)
																				.addComponent(
																						jLabel9)
																				.addComponent(
																						jLabel10)))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel8,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		0,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(24, 24,
																		24)))
								.addGap(19, 19, 19)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton4)
												.addComponent(jButton3)
												.addComponent(jButton2)
												.addComponent(jButton1))
								.addContainerGap(112, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void uis() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UserDestineView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UserDestineView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UserDestineView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UserDestineView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	// End of variables declaration
}
