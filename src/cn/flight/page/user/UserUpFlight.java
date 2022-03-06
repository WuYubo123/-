package cn.flight.page.user;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.flight.domain.Flight;
import cn.flight.domain.User;
import cn.flight.service.user.UserService;

/**
 * 改签服务
 * @author MI
 */

public class UserUpFlight extends javax.swing.JFrame {
	private UserService service = new UserService();
	private List<User> users;
	private List<Flight> flights;
	private List<Flight> timeFlights;
	private Flight oidFlight = new Flight();
	private String fid;
	String begFrom = null;
	String endFrom = null;
	String begTime = null;  

	public String[] getString() {
		timeFlights= service.seleBeginTimeByFromandEnd(begFrom,endFrom);
		String[] str = new String[timeFlights.size()];
		int i=0;
		for(Flight flight:timeFlights){
			str[i]=flight.getBegin_time();
			i++;
		}
		return str;
	}

	public UserUpFlight(List<User> users, String fid, List<Flight> flights) {
		this.users = users;
		this.fid = fid;
		this.flights = flights;
		for (Flight flight : flights) {
			if (flight.getFlight_id().equals(fid)) {
				begFrom = flight.getBegin_from();
				endFrom = flight.getEnd_from();
				begTime = flight.getBegin_time();
				oidFlight.setTicket_price(flight.getTicket_price());
			}
		}
		initComponents();
		this.setLocation(400, 200);
		this.setSize(930, 650);
		this.setVisible(true);
	}
	 public void falses(){
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
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		

		jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 36)); // NOI18N
		jLabel3.setText("改签服务");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
		jLabel4.setText("客户：");

		jLabel5.setText(users.get(0).getDestine_name());

		jLabel6.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 0, 0));
		jLabel6.setText("注意：改签服务只能变更出发时间，不可变更出发地和目的地。");

		jLabel7.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel7.setText("原出发时间：");

		jLabel8.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel8.setText("出发地：");

		jLabel9.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel9.setText("目的地：");

		jButton1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jButton1.setText("保存");
		jButton1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				String seleFidTime = (String)jComboBox1.getSelectedItem();
				Flight newflight = service.updataUserFlight(seleFidTime,begFrom,endFrom,users.get(0).getDestine_id(),fid);
				float oidprice = oidFlight.getTicket_price();
				float newprice = newflight.getTicket_price();
				String price;
				if(newprice-oidprice>0){
					price="已经续交额度："+(newprice-oidprice)+"元";//新的减去旧的则是要再续交额度。
				}else{
					price="已经退回额度："+(oidprice-newprice)+"元";
				}
				UpSucc upsucc = new UpSucc(newflight,price,users,oidFlight.getFlight_id());
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

		jButton2.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jButton2.setText("返回");

		jLabel10.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel10.setText("改签后出发时间：");

		jComboBox1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jComboBox1.setModel(new DefaultComboBoxModel(getString()));
	
		jLabel11.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel11.setText(begTime);

		jLabel12.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel12.setText(begFrom);

		jLabel13.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
		jLabel13.setText(endFrom);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jLabel4)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel5).addGap(172, 172, 172))
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(156,
																		156,
																		156)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																								.addGroup(
																										layout.createSequentialGroup()
																												.addComponent(
																														jButton1)
																												.addPreferredGap(
																														javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														jButton2))
																								.addComponent(
																										jLabel6))
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jSeparator1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						540,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(120,
																										120,
																										120)
																								.addComponent(
																										jLabel1))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(133,
																										133,
																										133)
																								.addComponent(
																										jLabel2)))
																.addGap(23, 23,
																		23)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel9,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel10,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel7,
																						javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel8,
																						javax.swing.GroupLayout.Alignment.TRAILING))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jComboBox1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						230,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jLabel11)
																				.addComponent(
																						jLabel12)
																				.addComponent(
																						jLabel13))))
								.addContainerGap(115, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(94, 94,
																		94)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jLabel1))
																.addGap(44, 44,
																		44))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jLabel3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
								.addComponent(jSeparator1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(jLabel5))
								.addGap(31, 31, 31)
								.addComponent(jLabel6)
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(jLabel11))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8)
												.addComponent(jLabel12))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9)
												.addComponent(jLabel13))
								.addGap(23, 23, 23)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel10)
												.addComponent(
														jComboBox1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(73, 73, 73)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap(101, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public void uis() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UserUpFlight.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UserUpFlight.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UserUpFlight.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UserUpFlight.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JSeparator jSeparator1;
	// End of variables declaration
}
