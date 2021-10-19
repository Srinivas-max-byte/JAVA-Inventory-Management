import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

import javax.swing.JFrame;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;


public class login extends JFrame {
	private JTextField textField;
	private Connection con;
	private PreparedStatement ps;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 434, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblLogin.setBackground(new Color(250, 250, 210));
		lblLogin.setBounds(110, 10, 200, 50);
		panel.add(lblLogin);
		
		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setBounds(16, 97, 103, 50);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(16, 158, 80, 50);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(137, 106, 133, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ps=con.prepareStatement("select *  from  VASU.LOGIN where USERNAME=? and pwd=?");
					ps.setString(1,textField.getText());
					ps.setString(2,passwordField.getText());
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
					
						setVisible(false);
						new MDI();
					}
						else
					{
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(151, 238, 89, 23);
		panel.add(btnLogin);
		
		JButton btnCreateNewAccount = new JButton("Create new Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new createacct();
			}
		});
		btnCreateNewAccount.setBounds(123, 284, 150, 23);
		panel.add(btnCreateNewAccount);
		
		JButton btnForgotPwd = new JButton("Forgot pwd");
		btnForgotPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new forgot();
			}
		});
		btnForgotPwd.setBounds(303, 172, 89, 23);
		panel.add(btnForgotPwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 158, 133, 35);
		panel.add(passwordField);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(346, 116, 32, -92);
		panel.add(desktopPane);
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
