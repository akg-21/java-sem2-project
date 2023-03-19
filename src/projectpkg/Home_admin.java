package projectpkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Home_admin extends JFrame  {
	 JLabel lblNewLabel_1;
	  String names;
	  int uid;
	  String uid_2;
	  JButton btnNewButton;
	  JFrame frame1;
	  Vector v;
	  JTable table;
	  JComboBox comboBox;
	  JLabel lblNewLabel_3,lblNewLabel_4;
	  String[] columnNames = {"User id", "First Name", "Last Name", "phone number","district"};
	   JLabel lblNewLabel_5;
	   JLabel lblNewLabel_6;
	   JLabel lblNewLabel_7;
	   JLabel lblNewLabel_8;
	   JLabel lblNewLabel_9;
	   JLabel lblNewLabel_10;
	   JLabel lblNewLabel_11;
	   JLabel lblNewLabel_12;
	   JLabel lblNewLabel_13;
	   JLabel lblNewLabel_14;
	   private JMenuBar menuBar;
	   private JButton btnNewButton_1;
	   private JButton btnNewButton_2;
	   
	public void admin_name(String str) {
		System.out.println(str);
		lblNewLabel_1.setText(str);	
		}
	Home_admin()
	{
//				lblNewLabel_1.setText(str);
				setDefaultCloseOperation(javax.swing.  
		        WindowConstants.DISPOSE_ON_CLOSE);  
		        setTitle("Welcome");  
		        setSize(914, 674);  
		       
		        getContentPane().setLayout(null);
		        
		        JLabel lblNewLabel = new JLabel("Welcome");
		        lblNewLabel.setBounds(67, 72, 71, 13);
		        getContentPane().add(lblNewLabel);
		        
		        JLabel lblNewLabel_1 = new JLabel(" ");
		        lblNewLabel_1.setBounds(147, 72, 45, 13);
		        getContentPane().add(lblNewLabel_1);
		        try
		        {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from users");
					v=new Vector();
					while(rs.next())
					{
						names=rs.getString(2);
						uid=rs.getInt(1);
						v.add(uid);
					}
					
		        }catch (Exception e) {
		        	System.out.println(e);
		        }
		        
		         comboBox = new JComboBox(v);
		        comboBox.setBounds(206, 133, 148, 21);
		        getContentPane().add(comboBox);
		        comboBox.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try
						{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
						Statement stmt=con.createStatement();
						ResultSet rsuid=stmt.executeQuery("select * from users where USER_ID='"+comboBox.getSelectedItem()+"'");
						rsuid.next();
						lblNewLabel_3.setText(rsuid.getString(2));
						lblNewLabel_4.setText(rsuid.getString(3));
						}catch (Exception e2) {
				        	
				        }
						
					}
				});
		        
		        JLabel lblNewLabel_2 = new JLabel("User Id");
		        lblNewLabel_2.setBounds(121, 141, 45, 13);
		        getContentPane().add(lblNewLabel_2);
		        
		        
		        btnNewButton = new JButton("View");
		        btnNewButton.setBounds(569, 133, 85, 21);
		        getContentPane().add(btnNewButton);
		        btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
						Statement stmt=con.createStatement();
						ResultSet rsdata=stmt.executeQuery("select * from users where USER_ID='"+comboBox.getSelectedItem()+"'");
						if(rsdata.next())
						{
							lblNewLabel_6.setText(rsdata.getString("USER_PHONE"));
							lblNewLabel_8.setText(rsdata.getString("USER_MAIL"));
							lblNewLabel_10.setText(rsdata.getString("DISTRICT"));
							lblNewLabel_12.setText(rsdata.getString("ID_NAME"));
							lblNewLabel_14.setText(rsdata.getString("ID_NO"));
						}
					}catch (Exception e2) {
			        	
			        }
					}
				});
		        
		         lblNewLabel_3 = new JLabel("");
		        lblNewLabel_3.setBounds(375, 137, 45, 13);
		        getContentPane().add(lblNewLabel_3);
		        
		         lblNewLabel_4 = new JLabel("");
		        lblNewLabel_4.setBounds(430, 137, 85, 13);
		        getContentPane().add(lblNewLabel_4);
		        
		        lblNewLabel_5 = new JLabel("Phone Number");
		        lblNewLabel_5.setBounds(121, 205, 91, 13);
		        getContentPane().add(lblNewLabel_5);
		        
		        lblNewLabel_6 = new JLabel("No Data");
		        lblNewLabel_6.setBounds(250, 205, 104, 13);
		        getContentPane().add(lblNewLabel_6);
		        
		        lblNewLabel_7 = new JLabel("Email id");
		        lblNewLabel_7.setBounds(121, 245, 45, 13);
		        getContentPane().add(lblNewLabel_7);
		        
		        lblNewLabel_8 = new JLabel("No Data");
		        lblNewLabel_8.setBounds(250, 245, 159, 13);
		        getContentPane().add(lblNewLabel_8);
		        
		        lblNewLabel_9 = new JLabel("District");
		        lblNewLabel_9.setBounds(121, 281, 63, 13);
		        getContentPane().add(lblNewLabel_9);
		        
		        lblNewLabel_10 = new JLabel("No Data");
		        lblNewLabel_10.setBounds(250, 281, 116, 13);
		        getContentPane().add(lblNewLabel_10);
		        
		        lblNewLabel_11 = new JLabel("ID Proof");
		        lblNewLabel_11.setBounds(121, 311, 71, 13);
		        getContentPane().add(lblNewLabel_11);
		        
		        lblNewLabel_12 = new JLabel("No Data");
		        lblNewLabel_12.setBounds(250, 311, 116, 13);
		        getContentPane().add(lblNewLabel_12);
		        
		        lblNewLabel_13 = new JLabel("ID Number");
		        lblNewLabel_13.setBounds(121, 344, 71, 13);
		        getContentPane().add(lblNewLabel_13);
		        
		        lblNewLabel_14 = new JLabel("No Data");
		        lblNewLabel_14.setBounds(250, 344, 104, 13);
		        getContentPane().add(lblNewLabel_14);
		        
		        menuBar = new JMenuBar();
		        setJMenuBar(menuBar);
		        
		        btnNewButton_1 = new JButton("Add Place");
		        menuBar.add(btnNewButton_1);
		        
		        btnNewButton_2 = new JButton("Add Services");
		        menuBar.add(btnNewButton_2);
		        btnNewButton_1.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		Add_place ap=new Add_place();
		        		ap.setVisible(true);
		        	}
		        });
		        btnNewButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Add_Service as=new Add_Service();
						as.setVisible(true);
						
					}
				});
		        
		        
		    	        
	
	
	
//	public void showData() {
//		 	frame1 = new JFrame("User Data");
//	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame1.getContentPane().setLayout(new BorderLayout());
//	        DefaultTableModel model = new DefaultTableModel();
//	        model.setColumnIdentifiers(columnNames);
//	        table = new JTable();
//	        table.setModel(model);
//	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//	        uid_2=comboBox.getSelectedItem().toString();
//	        String fname="";
//	        String lname="";
//	        int phone;
//	        String district="";
//	        try
//	        {
//	        	Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
//				Statement stmt=con.createStatement();
//				ResultSet rsdata=stmt.executeQuery("select * from users");
//				int rec=0;
//				if(rsdata.next())
//				{
//					fname=rsdata.getString("F_NAME");
//					lname=rsdata.getString("L_NAME");
//					phone=rsdata.getInt("USER_PHONE");
//					district=rsdata.getString("DISTRICT");
//					model.addRow(new Object[]{fname,lname,phone,district});
//					rec++;
//				}
//				if(rec<1)
//				{
//					JOptionPane.showMessageDialog(null, "No Record Found");
//				}
//	        }catch(Exception e3)
//	        {
//	        	System.out.println(e3);
//	        }
//	        frame1.setVisible(true);
//	        frame1.setSize(400, 300);
//		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}