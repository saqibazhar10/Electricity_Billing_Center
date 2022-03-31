package Electricity_Billing_System;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.email.durgesh.Email;

//import Package.Admin;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddConsu extends JFrame {
	public JFrame frame;
	public JPanel contentPane;
	public JTextField textConsN;
	public JTextField textMeterN;
	public JTextField textPhoneN;
	public JTextField textAddress;
	public JTextField textEmail;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConsu frame = new AddConsu();
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
	String ConsN;
	//int ConsI;
	int MeterN;
	long PhoneN;
	String Email;
	String Address;
	public AddConsu(String ConsN,int MeterN,long PhoneN,String Email,String Address) {
		this.ConsN = ConsN;
		//this.ConsI= ConsI;
		this.MeterN = MeterN;
		this.Email = Email;
		this.PhoneN = PhoneN;
		this.Address = Address;
		
	}
	
    

	static public ArrayList<AddConsu> list = new ArrayList<AddConsu>(); 

	public AddConsu() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\pics\\Company Logo.jpg"));
		setForeground(Color.PINK);
		setTitle("New Consumer Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 601);
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
		
		JLabel lblConsN = new JLabel("Consumers Name :");
		lblConsN.setForeground(new Color(255, 255, 240));
		lblConsN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMeterN = new JLabel("Meter Number :");
		lblMeterN.setForeground(new Color(255, 255, 224));
		lblMeterN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPhoneN = new JLabel("Phone Number :");
		lblPhoneN.setForeground(new Color(255, 255, 224));
		lblPhoneN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(255, 255, 240));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		         //		public ArrayList<AddConsu> getList(){	return ;}

		
		JButton btnNewButton = new JButton("Add New");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}

			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(new Color(255, 255, 240));
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textConsN = new JTextField();
		textConsN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textConsN.setColumns(10);
		
		textMeterN = new JTextField();
		textMeterN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMeterN.setColumns(10);
		
		textPhoneN = new JTextField();
		textPhoneN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPhoneN.setColumns(10);
		
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setColumns(10);
		
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAddress.setColumns(10);

		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 240));
		btnSave.setForeground(new Color(0, 0, 128));
		
			btnSave.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					try {
					
					ConsN = textConsN.getText();
					//ConsI = Integer.parseInt(textConsI.getText());
					MeterN = Integer.parseInt(textMeterN.getText());
					PhoneN = Long.parseLong(textPhoneN.getText());
					Email = textEmail.getText();
					Address = textAddress.getText();

					list.add(new AddConsu(ConsN,MeterN,PhoneN,Email,Address));
					try {
						table t= new table();
						t.post();	
						
					}
					catch(Exception u) {
						System.out.println(u);
						System.out.println("hi");
						
					}
					
					//int len = list.size();
					//System.out.println(len);
					//AddConsu c = new AddConsu();
					//c= list.get(len-1);
					//System.out.println(c.ConsN);
					//showResultBox(list);
					
										



					btnNewButton.setEnabled(true);
				//	textConsI.setText("");
					textConsN.setText("");
					textPhoneN.setText("");
					textAddress.setText("");
					textMeterN.setText("");
					textEmail.setText("");
					}
					catch(Exception s) {
						
						JOptionPane.showMessageDialog(frame,"Please fill correct and all reqiuired Information");
					}
					
					
				}
			
			});


		
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBackground(new Color(255, 255, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Adm b = new Adm();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Consumer Record");
		btnNewButton_2.setBackground(new Color(255, 255, 240));
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.addActionListener(new ActionListener() {
//			
			public void actionPerformed(ActionEvent e) {
//				try {
//				ArrayList<AddConsu> list = AddConsu.getlist();
//				AddConsu Q = new AddConsu();
//				Q= list.get(list.size()-1);
//				//System.out.println(list.size());
//	            JFrame f = new JFrame("Table Example"); 
//	            String Id = String.valueOf(Q.ConsI) ;
//	            String MeterN = String.valueOf(Q.MeterN) ;
//	            String PhoneN = String.valueOf(Q.PhoneN) ;
//	            String data[][]={ {Q.ConsN,Id,MeterN,PhoneN,Q.Email,Q.Address}};
//	            
//	            String column[]={"Consumer Name","Consumer ID","Meter No.","Phone No.","Email","Address"};         
//	            final JTable jt=new JTable(data,column);      
//	            JScrollPane sp=new JScrollPane(jt);    
//	            f.getContentPane().add(sp);  
//	            f.setSize(498, 406);  
//	            f.setVisible(true);  
//	            }
//				catch (Exception S){
//					
//					JOptionPane.showMessageDialog(frame,"Please first save any Consumer");
//					
//					
//				}
//
			}

	});
//		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblPhoneN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMeterN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnNewButton)
											.addComponent(lblConsN, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(9))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textAddress, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(textPhoneN, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(textMeterN, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
										.addComponent(textConsN, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
							.addGap(135))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsN)
						.addComponent(textConsN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeterN)
						.addComponent(textMeterN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneN)
						.addComponent(textPhoneN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//System.out.println(list.size());
	}
	static public ArrayList<AddConsu> getlist() {
		return list;
		}
}