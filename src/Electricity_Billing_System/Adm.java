package Electricity_Billing_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;

public class Adm extends JFrame {

	private JPanel contentPane;
	private JTextField txtS;
	public static String Name;
	private JTextField txtId;
	public static String Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Adm frame = new Adm();
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
	public Adm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\pics\\Company Logo.jpg"));
		setTitle("Electricity Billing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 578);
		Image backgroundImage;
		try {
			backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\UMER HANIF ADIL\\Desktop\\New folder\\login background.jpg"));
			contentPane = new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, null);
		            
		        }
		    };
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//setLayout(null);
		
		JButton btnNewButton = new JButton("Add Consumers");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConsu AddConsu = new AddConsu();
				AddConsu.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Delete Consumers");
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelCons a = new DelCons();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Generate Bill");
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setBackground(new Color(255, 255, 224));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generate_Bill a = new Generate_Bill();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("Consumers Record");
		btnNewButton_3.setBackground(new Color(255, 255, 224));
		btnNewButton_3.setForeground(new Color(0, 0, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table table = new table();
				try {
				table.ShowData_Cons();
				table.setVisible(true);
				}
				catch(Exception y) {
					System.out.println("No table exists");
				}
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_4 = new JButton(" Log out");
		btnNewButton_4.setBackground(new Color(255, 255, 224));
		btnNewButton_4.setForeground(new Color(0, 0, 128));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				//Login_Bill.frmLoginPage.setVisible(true);
				Login_Bill a = new Login_Bill();
			}
		});
		
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_3_1 = new JButton("Consumers Deposits");
		btnNewButton_3_1.setForeground(new Color(0, 0, 128));
		btnNewButton_3_1.setBackground(new Color(255, 255, 240));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table table = new table();
				try {
				table.ShowData_Billrec();
				table.setVisible(true);
				}
				catch(Exception y) {
					System.out.println("No table exists");
				}
			
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnEdit = new JButton("Edit Consumers");
		btnEdit.setForeground(new Color(0, 0, 128));
		btnEdit.setBackground(new Color(255, 255, 224));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Id = txtId.getText();				
				table t = new table();
				t.search();
				boolean bo =t.getbo();
				if(bo ==true) {
					dispose();
				}
				
				
				
				
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSearchConsumers = new JButton("Search Consumers");
		btnSearchConsumers.setForeground(new Color(0, 0, 128));
		btnSearchConsumers.setBackground(new Color(255, 255, 240));
		btnSearchConsumers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name =txtS.getText(); 
				table t = new table();
				t.searchName();
				boolean q= t.getboolean();
				if(q==true) {
				t.setVisible(true);
				}
				
			}
		});
		btnSearchConsumers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtS = new JTextField();
		txtS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		JLabel lblEnterConsId = new JLabel("Enter ID:");
		lblEnterConsId.setForeground(new Color(255, 255, 255));
		lblEnterConsId.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		contentPane.add(lblNewLabel_2, BorderLayout.NORTH);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_3_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addGap(116)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterConsId, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtS, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnSearchConsumers, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGap(86))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1)
								.addComponent(txtS, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton_2)
									.addGap(18)
									.addComponent(btnNewButton_3)
									.addGap(18)
									.addComponent(btnNewButton_3_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addComponent(btnSearchConsumers, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEnterConsId, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(90)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public String getName() {
		return Name;
	}
	public String getId() {
		return Id;
	}
	
	
}