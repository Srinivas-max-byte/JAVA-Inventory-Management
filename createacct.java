import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;


public class createacct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Connection con;
	private PreparedStatement ps;
	
	public createacct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 0, 484, 320);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(87, 94, 93, 14);
		panel.add(lblUserName);
		
		JLabel lblNewUser = new JLabel("NEW USER");
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 14));
		lblNewUser.setBounds(142, 11, 162, 38);
		panel.add(lblNewUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 134, 93, 14);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(87, 176, 93, 14);
		panel.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(288, 91, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(288, 131, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(288, 173, 86, 20);
		panel.add(textField_2);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ps=con.prepareStatement("insert into VASU.LOGIN values(?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Inserted");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreateAccount.setBounds(167, 229, 137, 23);
		panel.add(btnCreateAccount);
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
