import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;


public class MDI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDesktopPane desktopPane;


	public MDI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 598);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("AddItem");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new update());
			}
		});
		
		JMenuItem mntmUpdateItem = new JMenuItem("update Item");
		mntmUpdateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new update_1());
			}
		});
		mnNewMenu.add(mntmUpdateItem);
		
		JMenuItem mntmRemoveItem = new JMenuItem("Remove Item");
		mntmRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new remove());	
			}
		});
		mnNewMenu.add(mntmRemoveItem);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmFindItem = new JMenuItem("Find Item");
		mntmFindItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new Find_Item());	
			}
		});
		mnNewMenu.add(mntmFindItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnView = new JMenu("View");
		mnView.setForeground(Color.BLACK);
		menuBar.add(mnView);
		
		JMenuItem mntmInventory = new JMenuItem("Inventory");
		mntmInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new View());
			}
		});
		mnView.add(mntmInventory);
		
		JMenuItem mntmCreateBill = new JMenuItem("Create Bill");
		mntmCreateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new bill());
			}
		});
		mnView.add(mntmCreateBill);
		
		JMenu mnLogin = new JMenu("User");
		mnLogin.setForeground(Color.BLACK);
		menuBar.add(mnLogin);
		
		JMenuItem mntmNewuser = new JMenuItem("Create new User");
		mntmNewuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new newUser());
			}
		});
		
		JMenuItem mntmUpdatePassword = new JMenuItem("Update Password");
		mntmUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.add(new passwordUpdate());
			}
		});
		mnLogin.add(mntmUpdatePassword);
		mnLogin.add(mntmNewuser);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    desktopPane = new JDesktopPane();
	    desktopPane.setLayout(null);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\retail.png"));
		lblNewLabel.setBounds(0, 0, 624, 465);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rtail Store Management Software");
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(0, 473, 624, 55);
		desktopPane.add(lblNewLabel_1);
		setVisible(true);
	}
}
