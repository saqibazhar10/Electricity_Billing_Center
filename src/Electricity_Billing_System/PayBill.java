package Electricity_Billing_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class PayBill extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JLabel lblMon;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	static public String ComboBox;
	private JLabel lblNewLabel_1;
	public JTextField txtAmount;
	static public String Amount;
	static public int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayBill frame = new PayBill();
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
	public PayBill() {
		setTitle("Electricity Billing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblNewLabel = new JLabel("Enter ID :");
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User1 a = new User1();
				a.setVisible(true);
				dispose();
			}
		});
		
		textid = new JTextField();
		textid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textid.setColumns(10);
		//
		
		lblMon = new JLabel("Select Month :");
		lblMon.setForeground(new Color(255, 255, 224));
		lblMon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 128));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    txtAmount = new JTextField();
	    txtAmount.setEditable(false);
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAmount.setColumns(10);
		btnNewButton_1 = new JButton("Bill Details");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Integer.parseInt(textid.getText());
				ComboBox = comboBox.getSelectedItem().toString();
				table table = new table();
				table.Bill_Details();
				Amount = table.getAmount();
				txtAmount.setText( "Rs"+" "+Amount);
				//System.out.println(Amount);
				
				
			}
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton_2 = new JButton("Pay Bill");
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setBackground(new Color(255, 255, 240));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				table table = new table();
				table.PayAmout();
			}
			catch(Exception o) {
				System.out.println("Error");
			}}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel("Amount :");
		lblNewLabel_1.setForeground(new Color(255, 255, 224));
		lblNewLabel_1.setBackground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textid, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMon)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMon, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public int getid() {
		return id;
	}
	 public String getcomboBox(){
		return ComboBox;
	}
	public String getAmount () {
		return Amount;
	}
	

}
