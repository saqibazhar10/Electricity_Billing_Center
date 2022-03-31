package Electricity_Billing_System;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Generate_Bill extends JFrame {

	private JPanel contentPane;
	private JFrame JFrame;
	private JTextField textConsI;
	private JTextField textCU;
	private JTextField textRWDD;
	private JTextField textRADD;
	static public int ConsI;
	static public int Receivable_WDD;
	static public int Receivable_ADD;
	static public int TotalUnits;
	static public String ComboBox;
	private JTextField textdate;
	static public int DueDate;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generate_Bill frame = new Generate_Bill();
					
					frame.getcomboBox();
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
	//public int ConsI,PU,CU,PWDD,PADD;

	public Generate_Bill() {
		setTitle("Electricity Billing System");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Desktop\\pics\\Company Logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 691);
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
		
		JLabel lblNewLabel = new JLabel("Bill Generator");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblConsI = new JLabel("Consumer ID : ");
		lblConsI.setForeground(new Color(255, 255, 255));
		lblConsI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblBillingM = new JLabel("Billing Month : ");
		lblBillingM.setForeground(new Color(255, 255, 255));
		lblBillingM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCU = new JLabel("Total Units: ");
		lblCU.setForeground(new Color(255, 255, 255));
		lblCU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblPWDD = new JLabel("Payable Within Due Date : ");
		lblPWDD.setForeground(new Color(255, 255, 255));
		lblPWDD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPADD = new JLabel("Payable After Due Date : ");
		lblPADD.setForeground(new Color(255, 255, 255));
		lblPADD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textConsI = new JTextField();
		textConsI.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textConsI.setColumns(10);
		
		textCU = new JTextField();
		textCU.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textCU.setColumns(10);
		
		textRWDD = new JTextField();
		textRWDD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textRWDD.setEditable(false);



		textRWDD.setColumns(10);
		
		textRADD = new JTextField();
		textRADD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textRADD.setEditable(false);
		textRADD.setColumns(10);
		
		JButton btnPrint = new JButton("Print Bill");
		btnPrint.setForeground(new Color(0, 0, 128));
		btnPrint.setBackground(new Color(255, 255, 255));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 128));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		JButton btnGenerateNew = new JButton("Generate New");
		btnGenerateNew.setForeground(new Color(0, 0, 128));
		btnGenerateNew.setBackground(new Color(255, 255, 255));
		btnGenerateNew.setEnabled(false);
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(new Color(0, 0, 128));
		btnNext.setBackground(new Color(255, 255, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				ConsI = Integer.parseInt(textConsI.getText());
				int CU = Integer.parseInt(textCU.getText());
				int date = Integer.parseInt(textdate.getText());
				int RWDD,Units;
				double Late =1.05;
				Units = CU;
				//1-100 Units= Rs 5
				//100-300 Units= Rs 6
				//300-500 Units= Rs 7
				//500-<1000 Units= Rs 8
				//Greater than 1000 Units= Rs 9
				//PWDD= Units*6;
				if (Units >=1 || Units <= 100) {
					RWDD= Units*5;
				}
				else if (Units > 100 || Units <= 300) {
					RWDD= Units*6;
				}
				else if (Units >300 || Units <= 500) {
					RWDD= Units*7;
				}
				else if (Units >500 || Units <= 100) {
					RWDD= Units*8;
				}
				else {
					RWDD= Units*9;
				}
				ComboBox =comboBox.getSelectedItem().toString();
				comboBox.setEnabled(true);
				int RADD =(int)Math.round(RWDD*Late) ;
				textRWDD.setText(Integer.toString(RWDD));
				textRADD.setText(Integer.toString(RADD));
				textCU.setEnabled(false);
				textConsI.setEnabled(false);
				comboBox.setEnabled(false);
				btnNext.setEnabled(false);
				
				btnGenerateNew.setEnabled(true);
				Receivable_WDD=RWDD;
				Receivable_ADD = RADD;
				DueDate = date;
				TotalUnits = Units;
				try {
				table table = new table();
				table.BillData();
				}
				catch(Exception r) {
					System.out.println("None");
				}
				}
				catch(Exception t) {
					JOptionPane.showMessageDialog(contentPane,"Please fill all the required information");
				}

			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));

	
		
		btnGenerateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCU.setText("");
	
				textConsI.setText("");
				textRWDD.setText("");
				textRADD.setText("");
				textCU.setEnabled(true);

				textConsI.setEnabled(true);
				comboBox.setEnabled(true); 
				comboBox.setVisible(true);
				btnNext.setEnabled(true);
			}
		});
		btnGenerateNew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adm d = new Adm();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textdate = new JTextField();
		textdate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Date:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(102)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConsI, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBillingM, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCU, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
									.addGap(51)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textdate, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
										.addComponent(textConsI, Alignment.TRAILING)
										.addComponent(comboBox, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNext, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCU, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
									.addGap(32))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblPADD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblPWDD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(40)
											.addComponent(btnGenerateNew)))
									.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textRWDD, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(textRADD, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnPrint, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
									.addGap(33))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textConsI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConsI, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBillingM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCU, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCU, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textdate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPWDD, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRWDD, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPADD, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRADD, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGenerateNew, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public int getId() {
		return ConsI;
	}
	 public int getReceivable_WDD(){
		return Receivable_WDD;
	}
	 public int getReceivable_ADD(){
		return Receivable_ADD;
	}
	 public String getcomboBox(){
		return ComboBox;
	}
	 public int getUnits(){
		return TotalUnits;
	}
	 public int getDueDate() {
		 return DueDate;
	 }
}