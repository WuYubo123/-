package cn.flight.page.user;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import cn.flight.domain.Flight;
import cn.flight.domain.User;
import cn.flight.service.admini.AdminiLoginService;
import cn.flight.service.user.UserService;
/**
 *  输入订票信息
 * @author Administrator
 */
public class InputDestineView extends JFrame {
	private static InputDestineView inputDestineView;
	private UserService service = new UserService();
	private AdminiLoginService adservice = new AdminiLoginService();
	private String fid;
	
    public InputDestineView() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}
	public InputDestineView(String fid) {
		this.fid=fid;
    	this.setLocation(400,200);
    	this.setSize(930, 650);
        initComponents();
        this.setVisible(true);
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
    	//*********************12.8 新添加*****************************************
    	//创建字体
    	Font ft=new Font("微软雅黑",0,14);
    	//字色
    	Color fc=new Color(255, 255, 255);
 
    	//*********************************************************
    	
    	
    	

        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jTextField2 = new JTextField();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jLabel4 = new JLabel();
        jTextField4 = new JTextField();
        jLabel5 = new JLabel();
        jTextField5 = new JTextField();
        jLabel6 = new JLabel();
        jTextField6 = new JTextField();
        jLabel7 = new JLabel();
        jTextField7 = new JTextField();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new Font("微软雅黑", 1, 18)); 
        jButton1.setForeground(new Color(249,142,122));
        jButton1.setText("提交");
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
				User user = new User();
				user.setDestine_name(jTextField1.getText());
				user.setDestine_id(jTextField2.getText());
				System.out.println("fid"+fid);
				user.setFlight_id(fid);
				user.setDestine_sex(jTextField4.getText());
				user.setDestine_age(jTextField5.getText());
				user.setDestine_phone(Integer.parseInt(jTextField6.getText()));
				user.setDestine_address(jTextField7.getText());
				List<User> users = service.seleUserByNameId(user.getDestine_id(),user.getDestine_name());
				int s=users.size();
				if(s==0){
					user.setDestine_count(1);
				}else{
					user.setDestine_count(users.get(users.size()-1).getDestine_count()+1);
				}
				user.setDestine_status("否");
				service.inserDestine(user);
				Flight flight = adservice.seleFlightByFid(user.getFlight_id());
				OrderInformationViem orderin = new OrderInformationViem(flight);
				
				
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
     
        jLabel1.setFont(ft); 
        jLabel1.setForeground(fc);
        jLabel1.setText("订票人 *");

        jLabel2.setFont(ft); 
        jLabel2.setForeground(fc);

        jLabel2.setText("身份证号 *");

        jLabel3.setFont(ft); 
        jLabel3.setForeground(fc);

        jLabel3.setText("邮箱");

        jLabel4.setFont(ft); 
        jLabel4.setForeground(fc);

        jLabel4.setText("性别");

        jLabel5.setFont(ft); 
        jLabel5.setForeground(fc);

        jLabel5.setText("年龄");

        jLabel6.setFont(ft); 
        jLabel6.setForeground(fc);

        jLabel6.setText("联系电话 *");

        jTextField6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(ft); 
        jLabel7.setForeground(fc);
        
        jLabel7.setText("地址");

        jButton3.setFont(new Font("微软雅黑", 0, 15)); 
        jButton3.setText("返回");
        jButton3.setForeground(new Color(249,142,122));
        
        jButton4.setFont(new Font("微软雅黑", 0, 15)); 
        jButton4.setText("重置");
        jButton4.setForeground(new Color(249,142,122));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 134, Short.MAX_VALUE)
                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 111, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );

        pack();
    }                        

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
      
    }                                        

    private void jTextField6ActionPerformed(ActionEvent evt) {                                            
      
    }                                           
         
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;                 
}
