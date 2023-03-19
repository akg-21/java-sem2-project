package projectpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
public class User_Registration extends JFrame  {

	private JFrame frame;
	private JTextField textField_fname;
	private JTextField textField_lname;
	private JTextField textField_email;
	private JTextField textField_phoneno;
	private JTextField textField_housename;
	private JLabel lblNewLabel_1_1_2;
	private JTextField textField_city;
	private JLabel lblNewLabel_1_1_3;
	private JLabel lblNewLabel_1_1_4;
	private JComboBox comboBox_idproof;
	private JComboBox comboBox_id;
	private JLabel lblNewLabel_1_1_5;
	private JTextField textField_idproofno;
	private JLabel lblNewLabel_1_1_6;
	private JTextField textField_username;
	private JLabel lblNewLabel_1_1_7;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirmpwd;
	PreparedStatement ps = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					User_Registration window = new User_Registration();
//					window.frame.setVisible(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public User_Registration() {
		setDefaultCloseOperation(javax.swing.  
		        WindowConstants.DISPOSE_ON_CLOSE);
//		setVisible(true);
		setTitle("Registration Form");
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Registration Form");
		frame.setBounds(100, 100, 621, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setBounds(267, 42, 110, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(106, 114, 77, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_fname = new JTextField();
		textField_fname.setBounds(411, 116, 96, 19);
		frame.getContentPane().add(textField_fname);
		textField_fname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(106, 156, 59, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_lname = new JTextField();
		textField_lname.setColumns(10);
		textField_lname.setBounds(411, 158, 96, 19);
		frame.getContentPane().add(textField_lname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1_1.setBounds(106, 198, 35, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(411, 200, 96, 19);
		frame.getContentPane().add(textField_email);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1_1.setBounds(106, 242, 96, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_phoneno = new JTextField();
		textField_phoneno.setColumns(10);
		textField_phoneno.setBounds(411, 244, 96, 19);
		frame.getContentPane().add(textField_phoneno);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("House Name / Apartment Name");
		lblNewLabel_1_1_1_1_1.setBounds(106, 284, 182, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		textField_housename = new JTextField();
		textField_housename.setColumns(10);
		textField_housename.setBounds(411, 286, 96, 19);
		frame.getContentPane().add(textField_housename);
		
		lblNewLabel_1_1_2 = new JLabel("City");
		lblNewLabel_1_1_2.setBounds(106, 325, 35, 22);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		textField_city = new JTextField();
		textField_city.setColumns(10);
		textField_city.setBounds(411, 327, 96, 19);
		frame.getContentPane().add(textField_city);
		
		lblNewLabel_1_1_3 = new JLabel("District");
		lblNewLabel_1_1_3.setBounds(106, 367, 59, 22);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JList list = new JList();
		list.setBounds(445, 371, 1, 1);
		frame.getContentPane().add(list);
		
		String s1[] = { "Select","Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod" , "Kollam", "Kottayam", "	Kozhikode", "Malappuram", "	Palakkad", "Pathanamthitta", "Thiruvananthapuram", "Thrissur", "Wayanad"};
		JComboBox comboBox_district = new JComboBox(s1);
		comboBox_district.setBounds(411, 368, 96, 21);
		frame.getContentPane().add(comboBox_district);
		
		lblNewLabel_1_1_4 = new JLabel("ID Proof");
		lblNewLabel_1_1_4.setBounds(106, 409, 46, 22);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		
		String s2[]= {"Select","Passport","Driving License","Election ID Card","PAN Card","Aadhaar Card"};
		comboBox_id  = new JComboBox(s2);
		comboBox_id.setBounds(411, 410, 96, 21);
		frame.getContentPane().add(comboBox_id);
		
		lblNewLabel_1_1_5 = new JLabel("ID Proof No");
		lblNewLabel_1_1_5.setBounds(106, 453, 77, 22);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		textField_idproofno = new JTextField();
		textField_idproofno.setColumns(10);
		textField_idproofno.setBounds(411, 455, 96, 19);
		frame.getContentPane().add(textField_idproofno);
		
		lblNewLabel_1_1_6 = new JLabel("User Name");
		lblNewLabel_1_1_6.setBounds(106, 497, 77, 22);
		frame.getContentPane().add(lblNewLabel_1_1_6);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(411, 499, 96, 19);
		frame.getContentPane().add(textField_username);
		
		lblNewLabel_1_1_7 = new JLabel("Password");
		lblNewLabel_1_1_7.setBounds(106, 541, 59, 22);
		frame.getContentPane().add(lblNewLabel_1_1_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(411, 543, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1_1_7_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1_7_1.setBounds(106, 585, 110, 22);
		frame.getContentPane().add(lblNewLabel_1_1_7_1);
		
		passwordField_confirmpwd = new JPasswordField();
		passwordField_confirmpwd.setBounds(411, 587, 96, 19);
		frame.getContentPane().add(passwordField_confirmpwd);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(411, 647, 96, 21);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					String query="select * from users where USER_USERNAME='"+textField_username.getText()+"'";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					if(rs!=null)
					{
						//JOptionPane.showMessageDialog(null,"Username is Available");
						if(passwordField.getText().equals(passwordField_confirmpwd.getText()))
						{
						ResultSet rsuid=stmt.executeQuery("select max(USER_ID) from users");
						rsuid.next();
						int uid=rsuid.getInt(1);
						int newuid=uid+1;
						String query2="insert into users values('"+newuid+"','"+textField_fname.getText()+"','"+textField_lname.getText()+"','"+textField_email.getText()+"','"+textField_phoneno.getText()+"','"+textField_housename.getText()+"','"+textField_city.getText()+"','"+comboBox_district.getSelectedItem().toString()+"','"+comboBox_id.getSelectedItem().toString()+"','"+textField_idproofno.getText()+"','"+textField_username.getText()+"','"+passwordField.getText()+"')";
						int result=stmt.executeUpdate(query2);
						if(result!=0)
						{
							JOptionPane.showMessageDialog(null,"Data Saved");
							try {
								setVisible(false);
								Gust_Home gh=new Gust_Home();
								
								gh.setVisible(true);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"error...");
						}
						}else
						{
							JOptionPane.showMessageDialog(null,"Password donot match");
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username is not Available");
						textField_username.setText("");
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Back");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				try {
					setVisible(false);
					Gust_Home gh=new Gust_Home();
					gh.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReset.setBounds(106, 647, 96, 21);
		frame.getContentPane().add(btnReset);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.setBounds(262, 647, 96, 21);
		btnReset.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnReset_1)
			{
				textField_fname.setText("");
				
			}
			}
		});
		frame.getContentPane().add(btnReset_1);
	}	
}