package cn.flight.page.admini;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import cn.flight.domain.Flight;
import cn.flight.service.admini.AdminiLoginService;

/**
 * 管理员-航班信息
 * 12.9 已完善
 * @author MI
 */
public class AdminiFlight extends JFrame {
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private static AdminiFlight adminiFlight;

	private AdminiLoginService service = new AdminiLoginService();
	java.util.List<Flight> flights = service.seleAllFlight();

	public AdminiFlight() {
		initComponents();
	}
	//遍历service层的所有航班然后添加到页面表格
	public Object[][] getObject(java.util.List<Flight> flights) {
		Object[][] f = new Object[flights.size()][7];
		int j = 0;
		int i = 0;
		for (Flight flight : flights) {
			f[i][j] = flight.getFlight_id();
			f[i][j + 1] = flight.getBegin_from();
			f[i][j + 2] = flight.getEnd_from();
			f[i][j + 3] = flight.getBegin_time();
			f[i][j + 4] = flight.getEnd_time();
			f[i][j + 5] = flight.getRemain();
			f[i][j + 6] = flight.getTicket_price();
			i++;
		}
		return f;
	}
	//设置表头
	public String[] getString() {
		String[] str = new String[] { "航班号", "起飞地点", "降落地点", "起飞时间", "降落时间", "价格", "余票" };
		return str;
	}
	//元素
	private void initComponents() {
		//设置位置
		this.setLocation(400,200);
    	this.setSize(930, 650);
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
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new JTable();
		jLabel1 = new JLabel();
		jSeparator1 = new JSeparator();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButton5 = new JButton();
		jButton6 = new JButton();
		// System.out.println(flights);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jTable1.setModel(new TableTest(getObject(flights), getString()));
		jScrollPane1.setViewportView(jTable1);
		// ************************************12.8
		// 添加****************************************************************
		jButton2.setFont(new Font("微软雅黑", 0, 16));
		jButton2.setForeground(new Color(249, 142, 122));
		jButton3.setFont(new Font("微软雅黑", 0, 16));
		jButton3.setForeground(new Color(249, 142, 122));
		jButton4.setFont(new Font("微软雅黑", 0, 16));
		jButton4.setForeground(new Color(249, 142, 122));
		jButton5.setFont(new Font("微软雅黑", 0, 16));
		jButton5.setForeground(new Color(249, 142, 122));
		jButton6.setFont(new Font("微软雅黑", 0, 16));
		jButton6.setForeground(new Color(249, 142, 122));
		// *****************************************************************************************************
		jLabel1.setFont(new Font("微软雅黑", 1, 24)); // NOI18N
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("实时航班信息");
		jButton2.setText("删除");
		jButton2.addMouseListener(new MouseListener() {//给删除添加鼠标事件

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				//获取删除模块窗体
				DeleFlight.getDeleFlight();
				adminiFlight.setVisible(false);//隐藏当前窗体

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

		jButton3.setText("添加");
		jButton3.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				//获取添加模块窗体
				AddFlight.getAddFlight();
				adminiFlight.setVisible(false);

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

		jButton4.setText("更新");
		jButton4.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				adminiFlight.setVisible(false);
				adminiFlight.setVisible(true);

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

		jButton5.setText("修改");
		jButton5.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				//依据航班的数量设置下拉菜单的禅读
				Object[] obj2 = new Object[flights.size()];//存放下来菜单中的值
				int i = 0;
				for (Flight flight : flights) {
					obj2[i] = flight.getFlight_id();//所有航班号添加到obj2
					i++;
				}
				//获取在下拉菜单中选择的航班
				String fid = (String) JOptionPane.showInputDialog(null, "请选择要修改的航班号：\n", "选择修改",
						JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), obj2, "航班");
				//根据获取的航班号进行修改航班信息
				UpdateInView.getUpdateInView(fid);

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

		jButton6.setText("退出系统");
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(150, 150, 150)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jButton3).addGap(50, 50, 50)
								.addComponent(jButton4).addGap(60, 60, 60).addComponent(jButton5).addGap(58, 58, 58)
								.addComponent(jButton2).addGap(86, 86, 86).addComponent(jButton6))
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
								.addComponent(jSeparator1)))
				.addContainerGap(221, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(53, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(57, 57, 57)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton3).addComponent(jButton4).addComponent(jButton5)
								.addComponent(jButton2).addComponent(jButton6))
						.addGap(165, 165, 165)));

		pack();
	}

	public static void getAdminiFlight() {
		
		adminiFlight = new AdminiFlight();
		adminiFlight.setLocation(400,200);
		adminiFlight.setSize(930, 550);
		adminiFlight.setVisible(true);

	}

}
