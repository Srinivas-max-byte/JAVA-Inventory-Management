import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;


public class passwordUpdate extends JInternalFrame {

	private JTextField textField;
	private JTextField textField_1;
	private Connection con;
	private PreparedStatement ps;

	public passwordUpdate() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(0, 0, 434, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter UserName");
		lblEnterUsername.setBounds(46, 88, 103, 14);
		panel.add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(219, 85, 128, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setBounds(46, 138, 128, 14);
		panel.add(lblEnterNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 135, 128, 20);
		panel.add(textField_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ps=con.prepareStatement("update VASU.LOGIN set PWD=? where USERNAME=?");
					ps.setString(1,textField_1.getText());
					ps.setString(2,textField.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Password modified");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(145, 207, 89, 23);
		panel.add(btnOk);
		 getDbConnection();
		setVisible(true);
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
