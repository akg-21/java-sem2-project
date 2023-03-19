package projectpkg;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_user extends JFrame implements MouseListener
{  

	private JFrame frame;
	int uid;
	JLabel lblNewLabel_1,lblNewLabel;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home_user window = new Home_user();
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
	public Home_user(int id) {
		uid=id;
		System.out.println(id);
		addMouseListener(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("User Home");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(34, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		 lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(101, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(200, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from users where user_id='"+uid+"'");
			rs.next();
			lblNewLabel_1.setText(rs.getString(2));
			lblNewLabel_2.setText(rs.getString(3));
			
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JButton btnNewButton = new JButton("Reset password");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"haiii");
					new Resetpwd(uid).setVisible(true);
				}
			});
			menuBar.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Edit Profile");
			menuBar.add(btnNewButton_1);
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		try
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery("select * from users where user_id='"+uid+"'");
//			rs.next();
//			lblNewLabel_1.setText(rs.getString(6));
//		}catch(Exception e1)
//		{
//			System.out.println(e1);
//		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
