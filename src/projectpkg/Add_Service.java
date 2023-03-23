package projectpkg;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class Add_Service {

	private JFrame frame;
	private JTextField textField_phone;
	private JTextField textField_mail;
	private JTextField textField_Name;
	private JTextField textField_Coordinates;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Service window = new Add_Service();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Service() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Adding Service");
		frame.setBounds(100, 100, 470, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Service");
		lblNewLabel.setBounds(181, 27, 81, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type of  Service");
		lblNewLabel_1.setBounds(68, 66, 98, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		String s2[] = { "Select","Accommodations", "Airport", "Restaurants", "Police station", "Hospital" };
		JComboBox comboBox = new JComboBox(s2);
		comboBox.setBounds(258, 62, 96, 21);
		frame.getContentPane().add(comboBox);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(258, 141, 96, 19);
		frame.getContentPane().add(textField_phone);
		textField_phone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setBounds(68, 144, 98, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail ID");
		lblNewLabel_3.setBounds(68, 183, 98, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(258, 180, 96, 19);
		frame.getContentPane().add(textField_mail);
		textField_mail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("District ");
		lblNewLabel_4.setBounds(68, 230, 81, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		String s1[] = { "Select","Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod" , "Kollam", "Kottayam", "	Kozhikode", "Malappuram", "	Palakkad", "Pathanamthitta", "Thiruvananthapuram", "Thrissur", "Wayanad"};
		JComboBox comboBox_1 = new JComboBox(s1);
		comboBox_1.setBounds(258, 226, 96, 21);
		frame.getContentPane().add(comboBox_1);

		
		JLabel lblNewLabel_5 = new JLabel("Place");
		lblNewLabel_5.setBounds(68, 273, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(258, 269, 96, 21);
		frame.getContentPane().add(comboBox_2);
		frame.setVisible(true);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_admin ha=new Home_admin();
				ha.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(68, 371, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					Statement stmt=con.createStatement();
					ResultSet rssid=stmt.executeQuery("select max(SID) from services");
					rssid.next();
					int sid=rssid.getInt(1)+1;
					String query2="insert into services values('"+comboBox.getSelectedItem().toString()+"','"+textField_phone.getText()+"','"+textField_mail.getText()+"','"+comboBox_2.getSelectedItem().toString()+"','"+sid+"','"+textField_Name.getText()+"','"+textField_Coordinates.getText()+"')";
					
					System.out.println(query2);
					int result=stmt.executeUpdate(query2);
					if(result!=0)
					{
						
						
						JOptionPane.showMessageDialog(null,"Data Saved");
						setVisible(false);
						new Home_admin().setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Data not Saved");
					}
				}catch(Exception e3)
				{
					System.out.println(e3);
				}
				
			}
		});
		btnNewButton_1.setBounds(258, 371, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					Statement stmt=con.createStatement();
					String query2="select *from place where DISTRICT='"+comboBox_1.getSelectedItem().toString()+"'";
					ResultSet rs=stmt.executeQuery(query2);
					while(rs.next())
					{
						comboBox_2.addItem(rs.getString(1));
					}
				}catch(Exception e3)
					{
					System.out.println(e3);
					}
			}
		});
		btnNewButton_2.setBounds(367, 226, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setBounds(68, 105, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(258, 102, 96, 19);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Coordinates");
		lblNewLabel_7.setBounds(68, 320, 81, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_Coordinates = new JTextField();
		textField_Coordinates.setBounds(258, 317, 128, 19);
		frame.getContentPane().add(textField_Coordinates);
		textField_Coordinates.setColumns(10);
		
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
