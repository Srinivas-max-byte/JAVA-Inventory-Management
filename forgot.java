import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class forgot extends JFrame {
	private JTextField textField;
	private Connection con;
	private PreparedStatement ps;
	private JTextField textField_1;

	public forgot() {
		setBounds(100, 100, 232, 260);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 216, 230);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUsername.setBounds(10, 41, 196, 14);
		panel.add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(66, 99, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGetPassword = new JButton("Get Password");
		btnGetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					ps=con.prepareStatement("select *  from  VASU.Login where USERNAME=?");
					ps.setString(1,textField.getText());
					ResultSet res=ps.executeQuery();
					if(res.next())
					{
						textField_1.setText(String.valueOf(res.getString(2)));
					}
				
				}
				catch(Exception e1){e1.printStackTrace();}
			}

			
		});
		btnGetPassword.setBounds(58, 145, 105, 23);
		panel.add(btnGetPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 185, 86, 20);
		panel.add(textField_1);
		setVisible(true);
		getDbConnection();

	}
	public void getDbConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
			
			
		} catch (Exception e) {	
			
			e.printStackTrace();
		}
		
	}
}
