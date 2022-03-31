package Electricity_Billing_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;
public class Login_Bill {
	

	public JFrame frmLoginPage;
	private JTextField textID;
	private JPasswordField textpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Bill window = new Login_Bill();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Bill() {
		initialize();
		frmLoginPage.setVisible(true);
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	       // handle exception
	    }
		frmLoginPage = new JFrame();
		try {
			final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\UMER HANIF ADIL\\Desktop\\New folder\\qwe.png"));
			frmLoginPage.setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, null);
		        }
		    });
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frmLoginPage.setForeground(Color.GREEN);
		frmLoginPage.setBackground(new Color(240, 240, 240));
		frmLoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logo.jpg"));
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.getContentPane().setForeground(Color.YELLOW);
		frmLoginPage.setBounds(300, 150, 700, 353);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		textID = new JTextField();
		textID.setColumns(10);
		
		textpass = new JPasswordField();
		JButton Button = new JButton("Login");
		Button.setForeground(new Color(0, 0, 139));
		Button.setBackground(new Color(255, 255, 255));
		Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//String[] messageStrings= {"Admin","User"};
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 139));
		comboBox.setBackground(new Color(148, 0, 211));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("User")) {
//					System.out.println("Working!");
					textID.setEnabled(false);
					textpass.setEnabled(false);
				} else {
					textID.setEnabled(true);
					textpass.setEnabled(true);
				}
			}
		});
		comboBox.addItem("Admin");
		comboBox.addItem("User");

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setMaximumRowCount(2);
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("Admin")){

					try {
					int AdminID =Integer.parseInt(textID.getText());                                        //Taking Admin Id and Pass for Admin Login
					int Pass =Integer.parseInt(textpass.getText());
					if((AdminID == 201921 && Pass == 2002) ||( AdminID ==201922 && Pass == 2000)) {
//						JOptionPane.showMessageDialog(frmLoginPage, "You have Successfully logged in");
						frmLoginPage.setVisible(false);
						Adm frame =new Adm();
						frame.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(frmLoginPage, "Invalid user name or Password");
						
					}}
					catch(Exception e) {
						JOptionPane.showMessageDialog(frmLoginPage, "Please enter the required fields");
					}}
				if (comboBox.getSelectedItem().equals("User")) {
					
					try {                                                 // User have to only select User Combo Box No need for id and password.                                   
					frmLoginPage.setVisible(false);
					User1 frame =new User1();
					frame.setVisible(true);
//					JOptionPane.showMessageDialog(frmLoginPage, "You have successfully Login as User");
					

					}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frmLoginPage, "Something Went Wrong");
				}
				}
			}
		});
		
		JButton Button_1 = new JButton("Cancel");
		Button_1.setForeground(new Color(0, 0, 128));
		Button_1.setBackground(new Color(255, 255, 255));
		Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginPage.setVisible(false);
			}
		});
		Button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Logging in as : ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));

		
		JLabel pic = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		pic.setIcon(new ImageIcon(img));
		
		
//		JLabel lblNewLabel_1 = new JLabel("");
//		Image img2 = new ImageIcon(this.getClass().getResource("/login background.jpg")).getImage();
//		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		GroupLayout groupLayout = new GroupLayout(frmLoginPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(pic, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(Button, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textpass)
								.addComponent(comboBox, 0, 134, Short.MAX_VALUE)
								.addComponent(textID, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(Button_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textpass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPassword)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Button, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addComponent(pic, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		frmLoginPage.getContentPane().setLayout(groupLayout);
	}
}