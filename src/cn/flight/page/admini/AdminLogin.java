package cn.flight.page.admini;

import javax.swing.*;

import cn.flight.domain.Admini;
import cn.flight.service.admini.AdminiLoginService;

import java.awt.event.*;
import java.awt.*;

/**
 * 管理员登陆界面
 * 12.9已完善
 */
public class AdminLogin extends JFrame {
	private static AdminLogin adminLogin;
	private AdminiLoginService loginService = new AdminiLoginService();

	public AdminLogin() {
		initComponents();
	}

	private void initComponents() {
		this.setLocation(400,200);
    	this.setSize(930, 650);
				
		GroupLayout layout = new GroupLayout(getContentPane());
		
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
    	
		JLabel title = new JLabel();
		title.setFont(new Font("微软雅黑", 0, 36)); 
		title.setForeground(new Color(255, 255, 255));
		title.setText("管理员登陆");

		JLabel userLabel = new JLabel();
		userLabel.setText("用户名");

		JLabel passwordLabel = new JLabel();
		passwordLabel.setText("密码");

		final JTextField userText = new JTextField();

		final JPasswordField passwordText = new JPasswordField();

		JButton loginButton = new JButton();
		loginButton.setText("Login");
		
		//用户名密码标签颜色和字体修改
    	userLabel.setFont(new Font("微软雅黑",0,18));
    	userLabel.setForeground(new Color(255, 255, 255));
    	passwordLabel.setFont(new Font("微软雅黑",0,18));
       	passwordLabel.setForeground(new Color(255, 255, 255));
       	loginButton.setFont(new Font("微软雅黑",0,18));
    	loginButton.setForeground(new Color(249,142,122));
		

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 400));
		//
		userText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userTextActionPerformed(evt);
			}
		});

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		loginButton.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String username = userText.getText();
				String password = passwordText.getText();
				Admini adminis = new Admini(username, password);
				// System.out.println(adminis.toString());
				boolean ta = loginService.getUser(adminis);
				if (ta == true) {
					adminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					AdminiFlight.getAdminiFlight();
					
				} else {
					JOptionPane.showMessageDialog(null, "输入用户名或密码不正确，请重新输入！",
							"输入错误", JOptionPane.ERROR_MESSAGE);
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

		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(

		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(70, 70,
																		70)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										passwordLabel)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										passwordText))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										userLabel)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										userText,
																										GroupLayout.PREFERRED_SIZE,
																										200,
																										GroupLayout.PREFERRED_SIZE))))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(70, 70,
																		70)
																.addComponent(
																		loginButton))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(70, 70,
																		70)
																.addComponent(
																		title)))
								.addContainerGap(200, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(40, 40, 40)
						.addComponent(title)
						.addGap(40, 40, 40)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(userLabel)
										.addComponent(userText,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(passwordLabel)
										.addComponent(passwordText,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40).addComponent(loginButton)
						.addContainerGap(60, Short.MAX_VALUE)));

		pack();
	}

	private void userTextActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void loginButtonActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	public static void getAdminLogin() {
		adminLogin = new AdminLogin();
		adminLogin.setLocation(400,200);
		adminLogin.setVisible(true);
	}

}
