import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;


public class remove extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private Connection con;
	private PreparedStatement ps;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remove frame = new remove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public remove() {
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 222, 173));
		panel.setBounds(0, 0, 484, 470);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRemove = new JLabel("Remove Item");
		lblRemove.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lblRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove.setBounds(143, 24, 178, 23);
		panel.add(lblRemove);
		
		JLabel lblEnterProductId = new JLabel("Enter Product ID");
		lblEnterProductId.setBounds(48, 137, 122, 14);
		panel.add(lblEnterProductId);
		
		JButton btnUndo = new JButton("Close");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnUndo.setBounds(48, 366, 89, 23);
		panel.add(btnUndo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(263, 134, 153, 20);
		panel.add(textField_6);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						ps=con.prepareStatement("delete from VASU.RETAIL  where PRODUCT_ID=?");						
						ps.setInt(1,Integer.parseInt(textField_6.getText()));
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Data Deleted");
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			
		});
		btnRemove.setBounds(197, 366, 89, 23);
		panel.add(btnRemove);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.setBounds(342, 366, 104, 23);
		panel.add(btnClearFields);
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
