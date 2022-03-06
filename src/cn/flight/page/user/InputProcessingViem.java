package cn.flight.page.user;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import cn.flight.domain.User;
import cn.flight.service.user.UserService;
/**
 *	输入身份证号查看订单
 * @author Administrator
 */
public class InputProcessingViem extends javax.swing.JFrame {
	public static InputProcessingViem inputPro;
	private UserService service = new UserService();
    public InputProcessingViem() {
    	
        initComponents();
        this.setLocation(400,200);
    	this.setSize(930, 650);
    }
                         
    private void initComponents() {
    	
    	
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
    	//***************************************************************************
    	
    	
    	
    	//*********************12.8 新添加*****************************************
    	//创建字体
    	Font ft=new Font("微软雅黑",0,14);
    	//字色
    	Color fc=new Color(255, 255, 255);
 
    	//*********************************************************
    	
    	
    	
        jButton1 = new JButton();
        jLabel2 = new JLabel();
        jTextField2 = new JTextField();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new Font("微软雅黑", 0, 18)); 
        jButton1.setForeground(new Color(249,142,122));
        jButton1.setText("返回");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				DestineView.getDestineView();
				inputPro.setVisible(false);
				
				
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

        jLabel2.setFont(new Font("微软雅黑", 0, 18)); 
        jLabel2.setForeground(fc);
        jLabel2.setText("姓名");

        jLabel3.setFont(new Font("微软雅黑", 0, 18)); 
        jLabel3.setForeground(fc);
        jLabel3.setText("身份证号");

        jButton2.setFont(new Font("微软雅黑", 0, 18)); 
        jButton2.setForeground(new Color(249,142,122));
        jButton2.setText("查询");
        jButton2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				String userName = jTextField2.getText();
				String userId = jTextField3.getText();
				java.util.List<User> users =  service.seleUserByNameId(userId,userName);
				if(users==null){
					JOptionPane.showMessageDialog(null, "输入客户名与身份证号不匹配，请重新输入！",
							"输入错误", JOptionPane.ERROR_MESSAGE);
				}else{
					UserDestineView userDestine = new UserDestineView(users);
					inputPro.setVisible(false);
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }                      

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
    }                                        

    public static void getInputProcessingViem() {
    	inputPro = new InputProcessingViem();
    	inputPro.setVisible(true);
    	inputPro.setLocation(400,200);
    	inputPro.setSize(930, 650);
    }
                   
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField2;
    private JTextField jTextField3;
                 
}
