import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


public class View extends JInternalFrame {

	private Connection con;
	private PreparedStatement ps;
	DefaultTableModel dtm;
	JTable table;
		

	
	public View() {
		setBounds(100, 100, 450, 319);
		getContentPane().setLayout(null);
		dtm=new DefaultTableModel();
		dtm.addColumn("DEPARTMENT");
		dtm.addColumn("PRODUCT ID");
		dtm.addColumn("PRODUCT NAME");
		dtm.addColumn("PRICE");
		dtm.addColumn("QUANTITY");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 0));
		panel.setBounds(0, 0, 434, 289);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table=new  JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 92, 414, 152);
		panel.add(scrollPane);
		
		JLabel lblInventoryInformation = new JLabel("Inventory Information");
		lblInventoryInformation.setForeground(new Color(255, 255, 51));
		lblInventoryInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryInformation.setFont(new Font("SansSerif", Font.ITALIC, 18));
		lblInventoryInformation.setBounds(95, 25, 239, 39);
		panel.add(lblInventoryInformation);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(301, 255, 89, 23);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\conventional-warehouse11.jpeg"));
		lblNewLabel.setBounds(0, 0, 434, 289);
		panel.add(lblNewLabel);
		setVisible(true);
		getDbConnection();
	}
	public void getDbConnection()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
			ps=con.prepareStatement("select *  from VASU.RETAIL");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			dtm.addRow(new Object[]{String.valueOf(rs.getString(1)),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5)});	
			}
			table.setModel(dtm);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	}
