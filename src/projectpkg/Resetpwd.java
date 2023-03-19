package projectpkg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
public class Resetpwd {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	int uid;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Resetpwd window = new Resetpwd();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Resetpwd(int id) {
		uid=id;
		setVisible(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Reset Password");
		frame.setBounds(100, 100, 507, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reset PassWord");
		lblNewLabel.setBounds(191, 45, 100, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Current PassWord");
		lblNewLabel_1.setBounds(83, 101, 117, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(307, 101, 82, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("New PassWord");
		lblNewLabel_2.setBounds(83, 148, 117, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(307, 148, 82, 19);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm PassWord");
		lblNewLabel_3.setBounds(83, 192, 117, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(307, 189, 82, 19);
		frame.getContentPane().add(passwordField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(191, 244, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					String query="select * from admin";
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(query);
					if(rs.next())
					{
						if(passwordField.getText().equals(rs.getString("ADMIN_PASSWORD")))
						{
							if(passwordField_1.getText().equals(passwordField_2.getText()))
							{
								
							}
							else
							{
								JOptionPane.showMessageDialog(null,"new password and Confirm is not match");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"current password is not match");
						}
					}
					
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				frame.setVisible(true);
			}
		});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
