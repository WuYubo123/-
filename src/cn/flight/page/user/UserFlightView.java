package cn.flight.page.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.corba.se.pept.transport.InboundConnectionCache;

import cn.flight.domain.Flight;
import cn.flight.domain.SelePojo;
import cn.flight.page.admini.TableTest;
import cn.flight.service.user.UserService;
/**
 * 用户查询要求的航班
 * @author MI
 *
 */

public class UserFlightView extends javax.swing.JFrame {
	private UserService service=new UserService();
	private SelePojo sele;
	private List<Flight> flights ; 
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

	public String[] getString() {
		String[] str = new String[] { "航班号", "起飞地点", "降落地点", "起飞时间", "降落时间",
				"余票", "价格" };
		return str;
	}
    public UserFlightView(SelePojo sele) {
    	this.sele=sele;
    	flights=service.seleAllFlightByInput(sele);
        initComponents(sele);
        this.setLocation(400,200);
    	this.setSize(930, 650);
        this.setVisible(true);
    }      
    public void flish1(){
    	this.setVisible(false);
    	
    }
    private void initComponents(SelePojo sele) {
    	uis();
    	
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
    	//*********************12.8 新添加*****************************************
    	//创建字体
    	Font ft=new Font("微软雅黑",0,14);
    	//字色
    	Color fc=new Color(255, 255, 255);
 
    	//*********************************************************
    	
    	
    	
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("微软雅黑", 1, 24)); // NOI18N
        jLabel1.setForeground(fc);
        jLabel1.setText("符合您要求的航班信息如下所示");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel2.setForeground(fc);
        jLabel2.setText("请您在以下航班中进行选择");

        jTable1.setModel(new TableTest(getObject(flights), getString()));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("预定");
        jButton1.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N

        jButton1.setForeground(new Color(249,142,122));
        jButton1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				String destineFid= jTextField1.getText();
				service.destineUpFlight(destineFid);
				InputDestineView input = new InputDestineView(destineFid);
				flish1();
				
				
				
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
        jButton2.setFont(new java.awt.Font("微软雅黑", 1, 16)); // NOI18N

        jButton2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				DestineView.getDestineView();
				
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
        jButton2.setForeground(new Color(249,142,122));
        jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(249,142,122));
        jLabel3.setText("请输入想要预定的航班号：");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(jScrollPane1)
                        .addComponent(jSeparator1)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }
 
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
                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
