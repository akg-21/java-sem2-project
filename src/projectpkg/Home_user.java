package projectpkg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

public class Home_user extends JFrame implements MouseListener
{  
	JLabel lblNewLabel_7,lblNewLabel_8,lblNewLabel_9,lblNewLabel_10,lblNewLabel_11,lblNewLabel_12,lblNewLabel_13;
	private JFrame frame;
	int uid;
	JLabel lblNewLabel_1,lblNewLabel;
	private JLabel lblNewLabel_2;
	String name,types,namess;
	String dist;
	JComboBox comboBox_place;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox_NAMES;
	private JLabel lblNewLabel_14;

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
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("User Home");
		frame.setBounds(100, 100, 537, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(34, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		 lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(101, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(173, 31, 89, 13);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		
		String s2[] = { "Select","Accommodations", "Airport", "Restaurants", "Police station", "Hospital" };
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
			JLabel lblNewLabel_3 = new JLabel("Select District");
			lblNewLabel_3.setBounds(34, 76, 89, 13);
			frame.getContentPane().add(lblNewLabel_3);
			
			String s1[] = { "Select","Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod" , "Kollam", "Kottayam", "	Kozhikode", "Malappuram", "	Palakkad", "Pathanamthitta", "Thiruvananthapuram", "Thrissur", "Wayanad"};
			JComboBox comboBox = new JComboBox(s1);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					 dist=comboBox.getSelectedItem().toString();
				}
			});
			comboBox.setBounds(160, 76, 102, 21);
			frame.getContentPane().add(comboBox);
			comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					types=comboBox.getSelectedItem().toString();
					try
					{
						comboBox_place.removeAllItems();
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
						Statement stmt=con.createStatement();
						String query2="select *from place where DISTRICT='"+dist+"'";
						ResultSet rs=stmt.executeQuery(query2);
						while(rs.next())
						{
							comboBox_place.addItem(rs.getString(1));
						}
					}catch(Exception e3)
					{
						System.out.println(e3);
					}
			
					
				}
			});
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(34, 135, 89, 13);
			frame.getContentPane().add(lblNewLabel_4);
			
			comboBox_place = new JComboBox();
			comboBox_place.setBounds(160, 135, 102, 21);
			frame.getContentPane().add(comboBox_place);
			
			JButton btnNewButton_1 = new JButton("Find");
			btnNewButton_1.setBounds(160, 273, 102, 21);
			frame.getContentPane().add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
						Statement stmt=con.createStatement();
						ResultSet rst=stmt.executeQuery("select * from services where PLACE='"+comboBox_place.getSelectedItem().toString()+"' and NAME='"+comboBox_NAMES.getSelectedItem().toString()+"'");
						if(rst.next())
						{
							lblNewLabel_7.setVisible(true);
							lblNewLabel_8.setVisible(true);
							lblNewLabel_9.setVisible(true);
							lblNewLabel_10.setVisible(true);
							lblNewLabel_11.setVisible(true);
							lblNewLabel_12.setVisible(true);
							lblNewLabel_13.setVisible(true);
							lblNewLabel_8.setText(rst.getString("PHONENO"));
							lblNewLabel_11.setText(rst.getString("MAIL"));
							lblNewLabel_13.setText(rst.getString("Coordinates"));
						}
						
					}catch(Exception e1)
					{
						System.out.println(e1);
					}
					
				}
			});
			
			JLabel lblNewLabel_5 = new JLabel("Select Service Type");
			lblNewLabel_5.setBounds(34, 184, 102, 13);
			frame.getContentPane().add(lblNewLabel_5);
			
			JComboBox comboBox_types = new JComboBox(s2);
			comboBox_types.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try
					{
					
						comboBox_NAMES.removeAllItems();
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
						Statement stmt=con.createStatement();
						String query2="select *from services where type='"+comboBox_types.getSelectedItem().toString()+"' and place='"+comboBox_place.getSelectedItem().toString()+"'";
						System.out.println(query2);
						ResultSet rs=stmt.executeQuery(query2);
						while(rs.next())
						{
							comboBox_NAMES.addItem(rs.getString("NAME"));
						}
					}catch(Exception e3)
					{
						System.out.println(e3);
					}
				}
			});
			
			comboBox_types.setBounds(160, 180, 102, 21);
			frame.getContentPane().add(comboBox_types);
			
			 lblNewLabel_7 = new JLabel("Phone No");
			lblNewLabel_7.setBounds(34, 347, 69, 13);
			frame.getContentPane().add(lblNewLabel_7);
			lblNewLabel_7.setVisible(false);
			
			 lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setBounds(160, 347, 102, 13);
			frame.getContentPane().add(lblNewLabel_8);
			lblNewLabel_8.setVisible(false);
			
			 lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setBounds(160, 347, 129, 13);
			frame.getContentPane().add(lblNewLabel_9);
			lblNewLabel_9.setVisible(false);
			
			 lblNewLabel_10 = new JLabel("Mail");
			lblNewLabel_10.setBounds(34, 391, 69, 13);
			frame.getContentPane().add(lblNewLabel_10);
			lblNewLabel_10.setVisible(false);
			 lblNewLabel_11 = new JLabel("New label");
			lblNewLabel_11.setBounds(160, 391, 89, 13);
			frame.getContentPane().add(lblNewLabel_11);
			lblNewLabel_11.setVisible(false);
			 lblNewLabel_12 = new JLabel("Coordinates");
			lblNewLabel_12.setBounds(34, 433, 89, 13);
			frame.getContentPane().add(lblNewLabel_12);
			lblNewLabel_12.setVisible(false);
			 lblNewLabel_13 = new JLabel("New label");
			lblNewLabel_13.setBounds(160, 433, 89, 13);
			frame.getContentPane().add(lblNewLabel_13);
			
			comboBox_NAMES = new JComboBox();
			comboBox_NAMES.setBounds(160, 225, 102, 21);
			frame.getContentPane().add(comboBox_NAMES);
			
			lblNewLabel_14 = new JLabel("Name");
			lblNewLabel_14.setBounds(34, 229, 45, 13);
			frame.getContentPane().add(lblNewLabel_14);
			lblNewLabel_13.setVisible(false);
			
			
		
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JButton btnNewButton = new JButton("Reset password");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton.setBackground(Color.cyan);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnNewButton.setBackground(getBackground());
				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Resetpwd(uid).setVisible(true);
				}
			});
			menuBar.add(btnNewButton);
			
			
		
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
