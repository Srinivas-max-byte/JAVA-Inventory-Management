import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class update_1 extends JInternalFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Connection con;
	private PreparedStatement ps;
		
		
		public update_1() {
			setBounds(10, 10, 455, 412);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(204, 255, 102));
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			panel.setBounds(0, 0, 439, 382);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Modify Item");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(144, 30, 144, 23);
			panel.add(lblNewLabel);
			
			JLabel lblEnterProductId = new JLabel("Enter Product ID to Modify");
			lblEnterProductId.setBounds(48, 95, 160, 14);
			panel.add(lblEnterProductId);
			
			JLabel lblEnterProductName = new JLabel("Enter Product Name");
			lblEnterProductName.setBounds(48, 175, 134, 14);
			panel.add(lblEnterProductName);
			
			JLabel lblEnterPrice = new JLabel("Enter Price");
			lblEnterPrice.setBounds(48, 214, 85, 14);
			panel.add(lblEnterPrice);  
			
			JLabel lblEnterQuantity = new JLabel("Enter Quantity");
			lblEnterQuantity.setBounds(48, 254, 85, 14);
			panel.add(lblEnterQuantity);
			
			JLabel lblEnterDepartment = new JLabel("Enter Department");
			lblEnterDepartment.setBounds(48, 137, 107, 14);
			panel.add(lblEnterDepartment);
			
			textField = new JTextField();
			textField.setBounds(284, 134, 134, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(284, 92, 134, 20);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(284, 172, 134, 20);
			panel.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(284, 211, 134, 20);
			panel.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(284, 251, 134, 20);
			panel.add(textField_4);
			
			JButton btnNewButton = new JButton("Modify Inventory");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					{
						try {
							
							ps=con.prepareStatement("update VASU.RETAIL set DEPARTMENT=?,PRODUCT_NAME=?,PRICE=?,QUANTITY=? where PRODUCT_ID=?");
							ps.setString(1,textField.getText());
							ps.setString(3,textField_2.getText());
							ps.setInt(4,Integer.parseInt(textField_3.getText()));
							ps.setInt(5,Integer.parseInt(textField_4.getText()));
							ps.setInt(2,Integer.parseInt(textField_1.getText()));
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"Data modified");
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btnNewButton.setBounds(10, 331, 126, 23);
			panel.add(btnNewButton);
			
			JButton btnClearFields = new JButton("Clear Fields");
			btnClearFields.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setFields();
				}
			});
			btnClearFields.setBounds(162, 331, 126, 23);
			panel.add(btnClearFields);
			
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnClose.setBounds(303, 331, 126, 23);
			panel.add(btnClose);
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
		}

	}

