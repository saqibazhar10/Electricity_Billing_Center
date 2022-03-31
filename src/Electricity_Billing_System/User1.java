package Electricity_Billing_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class User1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User1 frame = new User1();
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
	public User1() {
		setTitle("User Profile");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\pics\\Company Logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 502);
		Image backgroundImage;
		try {
			backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\UMER HANIF ADIL\\Desktop\\New folder\\12345.jpg"));
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
		
		JButton btnNewButton = new JButton("Pay Bill");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(255, 255, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayBill a = new PayBill();
				a.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnCalculateBill = new JButton("Calculate Bill");
		btnCalculateBill.setForeground(new Color(0, 0, 128));
		btnCalculateBill.setBackground(new Color(255, 255, 240));
		btnCalculateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalBill a = new CalBill();
				a.setVisible(true);
				dispose();
			}
			
		});
		btnCalculateBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnLastBill = new JButton("Last Bill");
		btnLastBill.setBackground(new Color(255, 255, 255));
		btnLastBill.setForeground(new Color(0, 0, 128));
		btnLastBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LastBills  l= new LastBills();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnLastBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnInstructions = new JButton("Instructions ");
		btnInstructions.setBackground(new Color(255, 255, 240));
		btnInstructions.setForeground(new Color(0, 0, 128));
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
			        String url = "https://www.psebea.org/sites/default/files/ESIM%202017.pdf";
			        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			    } catch (java.io.IOException e) {
			        System.out.println(e.getMessage());
			    }
				
			}
		});
		btnInstructions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalculateBill, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLastBill, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInstructions, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(btnNewButton)
					.addGap(32)
					.addComponent(btnCalculateBill)
					.addGap(32)
					.addComponent(btnLastBill)
					.addGap(35)
					.addComponent(btnInstructions))
		);
		contentPane.setLayout(gl_contentPane);
	}
}