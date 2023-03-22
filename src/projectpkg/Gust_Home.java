package projectpkg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
public class Gust_Home extends javax.swing.JFrame {
	JTabbedPane jtp;
	JTextField username;
	JTextField usernameforget,phoneno;
	JPasswordField pwd;
	
	JButton regbtm,regbtmforget,loginbtm,getpwd;
	
	JPanel login;
	JPanel register;
	JPanel forget;
	JLabel u;
	JLabel p,L1,L2;
   Image img = Toolkit.getDefaultToolkit().getImage("E:\\MSC\\semester 2\\java\\Lab\\ProjectPic\\6345959.jpg");
   public Gust_Home() throws IOException {
      this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
         }
      });
      pack();
      setTitle("Gust Home");
      
      //login being
      u=new JLabel("Username");
      username=new JTextField(20);
      p=new JLabel("Password");
      pwd=new JPasswordField(20);
      loginbtm=new JButton("Login");
      login=new JPanel();
      login.add(u);
      login.add(username);
      login.add(p);
      login.add(pwd);
      login.add(loginbtm);
      //login ended
      //register being
      regbtm=new JButton("Register");
      register=new JPanel();
      register.add(regbtm);
      
      //register end
      //forgetpwd
      L1=new JLabel("Username");
      usernameforget=new JTextField(15);
      phoneno=new JTextField(10);
      
      phoneno.setVisible(false);
      regbtmforget=new JButton("find");
      forget=new JPanel();
      forget.add(L1);
      forget.add(usernameforget);
      L2=new JLabel("Phone Number");
      forget.add(L2);
      L2.setVisible(false);
      forget.add(regbtmforget);
      forget.add(phoneno);
      getpwd=new JButton("get Passowrd");
      forget.add(getpwd);
      
      
      getpwd.setVisible(false);
      L2.setVisible(false);
      
      
      
      
      
      regbtmforget.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
			Statement stmt=con.createStatement();
			String q1="select * from users where USER_USERNAME='"+usernameforget.getText()+"'";
			System.out.println(q1);
			ResultSet rsuname=stmt.executeQuery(q1);
			if(rsuname.next())
			{
				L1.setVisible(false);
				phoneno.setVisible(true);
				L2.setVisible(true);
				getpwd.setVisible(true);
				regbtmforget.setVisible(false);
				
				
			}else
			{
				JOptionPane.showMessageDialog(null,"No username Found"+username.getText());
			}
			}catch(Exception e4)
			{
				System.out.println(e4);
			}
			
			
			
		}
	});
      getpwd.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
			Statement stmt=con.createStatement();
			String q2="select * from users where USER_USERNAME='"+usernameforget.getText()+"'";
			System.out.println(q2);
			ResultSet rsphone=stmt.executeQuery(q2);
			if(rsphone.next())
			{
				if(phoneno.getText().equals(rsphone.getString("USER_PHONE")))
				{
					
					
					JOptionPane.showMessageDialog(null,rsphone.getString("USER_PASSWORD"));
				}
				
			}else
			{
				JOptionPane.showMessageDialog(null,"no password found"+rsphone.getString("USER_PHONE"));
			}
			}catch(Exception e4)
			{
				System.out.println(e4);
			}
  			
  		}
  	});
      
      
      //jtabbedpane being
      jtp=new JTabbedPane();
      jtp.setBackground(new Color(174, 250, 127));
      jtp.addTab("Login",login);
      jtp.addTab("Register",register);
      jtp.addTab("Forget Password",forget);
      jtp.setBounds(7, 6, 750, 505);
      add(jtp,BorderLayout.CENTER);
      //jtabbedpane ended
      
      regbtm.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
				
				User_Registration ur=new User_Registration();
				setVisible(false);
				ur.setVisible(true);
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
	});
      loginbtm.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
			Statement stmt=con.createStatement();
			
//			if(username.getText().equals("Admin") && pwd.getText().equals("Admin"))
//			{
//				JOptionPane.showMessageDialog(null,"Admin Login successfully");
//				
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null,"Admin Login Failed");
//			}
			int item=0;
			String query="select * from admin where ADMIN_UNAME='"+username.getText()+"' and ADMIN_PASSWORD='"+pwd.getText()+"'";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				if(rs.getString(3).equals("ajay"))
				{
				item++;	
				setVisible(false);
				JOptionPane.showMessageDialog(null,"Admin Login successfully ");
				Home_admin adminhome=new Home_admin();
				adminhome.setVisible(true);
			
				}
				else
				{
				JOptionPane.showMessageDialog(null,"Admin Login Failed");
				}
			}
			if(item==0)
			{
			String query1="select * from users where USER_USERNAME='"+username.getText()+"' and USER_PASSWORD='"+pwd.getText()+"'";
			ResultSet rsuser=stmt.executeQuery(query1);
			if(rsuser.next())
			{
				setVisible(false);
				JOptionPane.showMessageDialog(null,"Login successfully");
				Home_user hu=new Home_user(rsuser.getInt(1));
				hu.setVisible(true);
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Login Failed check username or password");
			}
			}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	});
      setVisible(true);
      setSize(400,400);  
   }
   public static void main(String[] args) throws Exception {
      new Gust_Home();
   }
}