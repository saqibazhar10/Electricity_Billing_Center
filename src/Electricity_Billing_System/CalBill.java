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

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalBill extends JFrame {

	private JPanel contentPane;
	private JTextField textEU;
	private JLabel lblBA;
	private JTextField textBA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalBill frame = new CalBill();
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
	public CalBill() {
		setTitle("Electricity Bill Calculator");
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
		
		JLabel lblEU = new JLabel("Enter Units:");
		lblEU.setForeground(new Color(255, 255, 240));
		lblEU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textEU = new JTextField();

		textEU.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textEU.setColumns(10);
		
		JButton btnNewButton = new JButton("Amount");
		btnNewButton.setBackground(new Color(255, 255, 240));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int EU = Integer.parseInt(textEU.getText());
				if (EU >=1 || EU <= 100) {
					int RWDD= EU*5;
					String RDD =String.valueOf(RWDD);
					textBA.setText(RDD);
				}
				 if (EU > 100 || EU <= 300) {
					int RWDD= EU*6;
					String RDD =String.valueOf(RWDD);
					textBA.setText(RDD);
				}
				if (EU >300 || EU <= 500) {
					int RWDD= EU*7;
					String RDD =String.valueOf(RWDD);
					textBA.setText(RDD);
				}
				 if (EU >500 || EU <= 100) {
					int RWDD= EU*8;
					String RDD =String.valueOf(RWDD);
					textBA.setText(RDD);
				}
				else {
					int RWDD= EU*9;
					String RDD =String.valueOf(RWDD);
					textBA.setText(RDD);
			}
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblBA = new JLabel("Bill Amount:");
		lblBA.setForeground(new Color(255, 255, 224));
		lblBA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textBA = new JTextField();
		textBA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textBA.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User1 a = new User1();
				a.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblBA, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textBA, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEU, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(textEU, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
					.addGap(84))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEU, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEU, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBA, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textBA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
