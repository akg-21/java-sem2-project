package projectpkg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Add_place {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add_place window = new Add_place();
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
	public Add_place() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Place");
		frame.setBounds(100, 100, 454, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Place");
		lblNewLabel.setBounds(177, 57, 72, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("District");
		lblNewLabel_1.setBounds(109, 101, 65, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		String s1[] = { "Select","Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod" , "Kollam", "Kottayam", "	Kozhikode", "Malappuram", "	Palakkad", "Pathanamthitta", "Thiruvananthapuram", "Thrissur", "Wayanad"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(255, 97, 96, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Place");
		lblNewLabel_2.setBounds(109, 141, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(255, 135, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(255, 171, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project","project");
					String query="insert into place values('"+textField.getText()+"','"+comboBox.getSelectedItem().toString()+"')";
					Statement stmt=con.createStatement();
					int result=stmt.executeUpdate(query);
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
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(109, 171, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Home_admin ha=new Home_admin();
				ha.setVisible(true);
				
			}
		});
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
