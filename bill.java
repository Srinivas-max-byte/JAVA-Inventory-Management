import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class bill extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private Connection con;
	private PreparedStatement ps;
	private JTextField textField_9;
	private JTable table;
	DefaultTableModel dtm;
	public bill() {
		setBackground(new Color(153, 255, 153));
		setBounds(100, 100, 868, 422);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		panel.setBounds(0, 0, 852, 392);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterProductId = new JLabel("Enter Product ID");
		lblEnterProductId.setForeground(SystemColor.text);
		lblEnterProductId.setBounds(48, 60, 134, 14);
		panel.add(lblEnterProductId);
		
		JLabel lblEnterProductName = new JLabel("Enter Product Name");
		lblEnterProductName.setForeground(SystemColor.text);
		lblEnterProductName.setBounds(48, 98, 134, 14);
		panel.add(lblEnterProductName);
		
		JLabel lblEnterPrice = new JLabel("Enter Price");
		lblEnterPrice.setForeground(SystemColor.text);
		lblEnterPrice.setBounds(48, 137, 85, 14);
		panel.add(lblEnterPrice);
		
		JLabel lblEnterQuantity = new JLabel("Enter Quantity");
		lblEnterQuantity.setForeground(SystemColor.text);
		lblEnterQuantity.setBounds(48, 177, 85, 14);
		panel.add(lblEnterQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 50, 127, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(182, 88, 127, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(182, 127, 127, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(182, 167, 127, 20);
		panel.add(textField_4);
		
		JButton btnCreateBill = new JButton("Insert into Bill");
		btnCreateBill.setForeground(SystemColor.desktop);
		btnCreateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int  quantity;
					float discount=0,amount=0;
					for(int i=0;i<table.getRowCount();i++)
					{
					//insert
					ps=con.prepareStatement("insert into VASU.BILL values(?,?,?,?,?)");
					ps.setInt(1,Integer.parseInt(table.getValueAt(i,0).toString()));
					ps.setString(2,table.getValueAt(i,1).toString());
					ps.setInt(3,Integer.parseInt(table.getValueAt(i,2).toString()));
					ps.setInt(4,Integer.parseInt(table.getValueAt(i,3).toString()));
					ps.setInt(5,Integer.parseInt(table.getValueAt(i,4).toString()));
					ps.executeUpdate();
					quantity=Integer.parseInt(textField_4.getText());
					//update
					ps=con.prepareStatement("update VASU.RETAIL set QUANTITY=QUANTITY-? where PRODUCT_ID=?");
					ps.setInt(1,Integer.parseInt(textField_4.getText()));
					ps.setInt(2,Integer.parseInt(textField_1.getText()));
					ps.executeUpdate();
					discount = (Integer.parseInt(textField_3.getText())*Integer.parseInt(textField_9.getText()))/100;
					if(discount>0){
					amount = amount+(Integer.parseInt(textField_4.getText())*(Integer.parseInt(textField_3.getText())-discount));}
					else{
					amount=amount+(Integer.parseInt(textField_4.getText())* Integer.parseInt(textField_3.getText()));}
					textField_7.setText(String.valueOf(amount));
					}
					
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnCreateBill.setBounds(46, 253, 134, 23);
		panel.add(btnCreateBill);
		
		JLabel lblFinalAmount = new JLabel("Final Amount   =");
		lblFinalAmount.setForeground(SystemColor.text);
		lblFinalAmount.setBounds(56, 295, 105, 14);
		panel.add(lblFinalAmount);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(182, 292, 127, 20);
		panel.add(textField_7);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.setForeground(SystemColor.desktop);
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFields();
			}
		});
		btnClearFields.setBounds(220, 253, 89, 23);
		panel.add(btnClearFields);
		
		JLabel lblEnterShopName = new JLabel("Billing");
		lblEnterShopName.setForeground(SystemColor.text);
		lblEnterShopName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEnterShopName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterShopName.setBounds(48, 9, 230, 30);
		panel.add(lblEnterShopName);
		
		JLabel lblEnterDiscount = new JLabel("Enter Discount");
		lblEnterDiscount.setForeground(SystemColor.text);
		lblEnterDiscount.setBounds(48, 212, 113, 14);
		panel.add(lblEnterDiscount);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(182, 206, 127, 20);
		panel.add(textField_9);
		
		JButton btnFind = new JButton("Find Product");
		btnFind.setBackground(Color.WHITE);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			try{
				ps=con.prepareStatement("select *  from  VASU.RETAIL where PRODUCT_ID=?");
				ps.setString(1,textField_1.getText());
				ResultSet res=ps.executeQuery();
				if(res.next())
				{
					textField_2.setText(res.getString(3));
					textField_3.setText(String.valueOf(res.getInt(4)));			
				}
			}
			catch(Exception e1){e1.printStackTrace();}
			}
			});
		btnFind.setBounds(319, 49, 101, 23);
		panel.add(btnFind);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(SystemColor.desktop);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(32, 349, 89, 23);
		panel.add(btnClose);
		dtm=new DefaultTableModel();
		dtm.addColumn("PRODUCT ID");
		dtm.addColumn("NAME");
		dtm.addColumn("PRICE");
		dtm.addColumn("QUANTITY");
		dtm.addColumn("DISCOUNT");
		table=new  JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(430, 10, 422, 249);
		panel.add(scrollPane);
		
		JButton btnprint = new JButton("PRINT");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal= new GregorianCalendar();
				int day=cal.get(Calendar.DAY_OF_MONTH);
				int month=cal.get(Calendar.MONTH);
				int year=cal.get(Calendar.YEAR);
				
				int second=cal.get(Calendar.SECOND);
				int min=cal.get(Calendar.MINUTE);
				int hour=cal.get(Calendar.HOUR);
				
				MessageFormat header=new MessageFormat("BILL INVOICE    	"+day+"/"+month+"/"+year+"     	 "+hour+":"+min+":"+second);
				MessageFormat footer=new MessageFormat("Amount = " + textField_7.getText());
				try
				{
					table.print(JTable.PrintMode.NORMAL,header,footer);
				}
				catch(java.awt.print.PrinterException e1){e1.printStackTrace();}
				
			}
		});
		btnprint.setBounds(214, 349, 89, 23);
		panel.add(btnprint);
		
		JButton btnAdd = new JButton("Add To Table");
		btnAdd.setForeground(UIManager.getColor("Button.focus"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.addRow(new Object[]{textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField_9.getText()});
				table.setModel(dtm);
			}
		});
		btnAdd.setBounds(566, 270, 119, 23);
		panel.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\13128.jpg"));
		lblNewLabel.setBounds(0, 0, 852, 392);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(566, 314, 99, 23);
		panel.add(btnNewButton);
		
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
		textField_9.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
	}
}
