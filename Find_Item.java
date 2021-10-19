import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Find_Item extends JInternalFrame {
	private JTextField textField;
	private Connection con;
	private PreparedStatement ps;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public Find_Item() {
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		panel.setBounds(0, 0, 534, 370);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFindItemIn = new JLabel("Find Item In Inventory");
		lblFindItemIn.setForeground(new Color(255, 255, 0));
		lblFindItemIn.setFont(new Font("Rockwell", Font.BOLD, 19));
		lblFindItemIn.setBounds(152, 0, 231, 36);
		panel.add(lblFindItemIn);
		
		JLabel lblEnterItemName = new JLabel("Enter Item Name");
		lblEnterItemName.setForeground(new Color(255, 255, 0));
		lblEnterItemName.setBounds(70, 82, 103, 14);
		panel.add(lblEnterItemName);
		
		textField = new JTextField();
		textField.setBounds(195, 79, 127, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\Saved Pictures\\search.png"));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					ps=con.prepareStatement("select *  from  VASU.RETAIL where PRODUCT_NAME=?");
					ps.setString(1,textField.getText());
					ResultSet res=ps.executeQuery();
					if(res.next())
					{
						textField_1.setText(res.getString(1));
						textField_2.setText(String.valueOf(res.getInt(2)));
						textField_3.setText(res.getString(3));
						textField_4.setText(String.valueOf(res.getInt(4)));
						textField_5.setText(String.valueOf(res.getInt(5)));
					}
				
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnFind.setBounds(420, 78, 46, 23);
		panel.add(btnFind);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(255, 255, 0));
		lblDepartment.setBounds(10, 144, 86, 14);
		panel.add(lblDepartment);
		
		JLabel lblProductId = new JLabel("PRODUCT ID");
		lblProductId.setForeground(new Color(255, 255, 0));
		lblProductId.setBounds(137, 144, 86, 14);
		panel.add(lblProductId);
		
		JLabel lblProductName = new JLabel("PRODUCT NAME");
		lblProductName.setForeground(new Color(255, 255, 0));
		lblProductName.setBounds(236, 144, 86, 14);
		panel.add(lblProductName);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(255, 255, 0));
		lblPrice.setBounds(374, 144, 56, 14);
		panel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setForeground(new Color(255, 255, 0));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(448, 144, 86, 14);
		panel.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 169, 103, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 169, 67, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(230, 169, 117, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(374, 169, 67, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(471, 169, 53, 20);
		panel.add(textField_5);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFields();
			}
		});
		btnClear.setBounds(319, 276, 89, 36);
		panel.add(btnClear);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(135, 276, 89, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Joshy-1119-Boxes.jpg"));
		lblNewLabel.setBounds(0, 0, 534, 370);
		panel.add(lblNewLabel);
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
	public void setFields()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
	}
}
